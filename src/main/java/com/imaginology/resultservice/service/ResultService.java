package com.imaginology.resultservice.service;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;

import javax.servlet.http.HttpServletRequest;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpMethod;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Service;
import org.springframework.web.client.RestTemplate;
import com.imaginology.resultservice.model.Status;
import com.imaginology.resultservice.exception.NotFoundException;
import com.imaginology.resultservice.model.ExamType;
import com.imaginology.resultservice.model.Marks;
import com.imaginology.resultservice.model.Semester;
import com.imaginology.resultservice.repository.MarksRepository;
import com.imaginology.resultservice.response.MarksResponse;
import com.imaginology.resultservice.response.ResultResponse;
import com.imaginology.resultservice.response.StudentResultResponse;
import com.imaginology.resultservice.response.SubjectDetailResponse;
import com.imaginology.resultservice.response.SubjectResponse;

import lombok.extern.slf4j.Slf4j;

@Service
@Slf4j
public class ResultService {
	private static final String SUBJECT_API = "/api/v2/subjects";

	@Value("${imaginology.service.auth.server.url}")
	private String baseUrl;

	@Value("${imaginology.service.auth.server.portocol}")
	private String protocol;

	@Value("${imaginology.service.auth.server.basePath}")
	private String basePath;

	@Value("${imaginology.service.auth.server.port}")
	private String port;
	

	@Autowired
	private MarksRepository resultRepository;
	
	private String getRemarks(Integer passMarks, Double obtainedMarks) {
		if (obtainedMarks < passMarks)
			return "FAILLED";
		else
			return "PASSED";
	}
	
	@Autowired
	private HttpServletRequest httpServletRequest;

	

	public ResultResponse getResult(Semester semester, Long studentId, ExamType examType) {
		List<Marks> resultList = resultRepository.findMarks(semester.getValue(), studentId, examType.getValue());

		if (resultList == null || resultList.isEmpty())
			throw new NotFoundException("No result found!");

		List<Long> subjectIds = new ArrayList<>();
		Map<Long, Marks> subjectIdMarksMap = new HashMap<>();//here using hashmap we can fetch the all teh value of marks with the help of subject's ids
		for (Marks mark : resultList) {
			subjectIds.add(mark.getSubjectId());
			subjectIdMarksMap.put(mark.getSubjectId(), mark);
		}
		List<SubjectResponse> subjects = getSubjects(subjectIds);

		List<StudentResultResponse> studentResultResponses = new ArrayList<>();

		if (subjects != null) {
			for (SubjectResponse sdr : subjects) {
				StudentResultResponse response = new StudentResultResponse();
				Marks mark = subjectIdMarksMap.get(sdr.getId());
				response.setSubject(sdr);
				MarksResponse marks = new MarksResponse();
				marks.setObtainedMarks(mark.getObtainedMarks());
				marks.setRemarks(mark.getRemarks());
				response.setMarks(marks);
				studentResultResponses.add(response);
			}
		}
		ResultResponse resultResponse = new ResultResponse();
		resultResponse.setData(studentResultResponses);
		return resultResponse;
	}
	
	private String getBaseUrl() {
		String url = protocol.concat("://").concat(baseUrl).concat(":").concat(port).concat("/").concat(basePath);
		log.debug("Base URL: " + url);
		return url;
	}
	
	

	private List<SubjectResponse> getSubjects(List<Long> subjectIds) {
		RestTemplate restTemplate = new RestTemplate();
		HttpHeaders httpHeaders = new HttpHeaders();

		Set<Long> uniqueIds = new HashSet<>(subjectIds);
		
		StringBuilder ids = new StringBuilder();
		for(Long id: uniqueIds) {
			ids.append(id).append(",");
		}
		
		String sids = ids.toString().substring(0,ids.toString().length()-1);
		
		httpHeaders.set("Content-Type", "application/json");

		String customerId = httpServletRequest.getHeader("customerId");
		String loginId = httpServletRequest.getHeader("loginId");
		String token = httpServletRequest.getHeader("token");
		
		log.debug("CustomerId {} and loginId {} and token {}", customerId, loginId, token);

		httpHeaders.set("loginId", loginId);
		httpHeaders.set("customerId", customerId);
		httpHeaders.set("token", token);

		String url = getBaseUrl().concat(SUBJECT_API).concat("?ids="+sids);
		log.debug("Requesting to auth server to get subjects {}",url);
		
		HttpEntity entity = new HttpEntity(httpHeaders);
		log.debug("Entity {}", entity);
		log.debug("Resttemplate {}", restTemplate);
		ResponseEntity<SubjectDetailResponse> response = restTemplate.exchange(url, HttpMethod.GET, entity,
				SubjectDetailResponse.class);
		log.debug("response {}", response);
		return response.getBody().getData();
	}

}
