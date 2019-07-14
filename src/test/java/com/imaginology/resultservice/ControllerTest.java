package com.imaginology.resultservice;

import static org.junit.Assert.assertEquals;

import org.junit.Test;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.test.web.servlet.request.MockMvcRequestBuilders;
import org.springframework.test.web.servlet.result.MockMvcResultMatchers;

import com.imaginology.examservice.request.ResultCreationRequest;
import com.imaginology.examservice.request.StudentMarks;
import com.imaginology.examservice.util.ExamType;
import com.imaginology.examservice.util.Semester;
import com.imaginology.resultservice.request.ResultGetRequest;

public class ControllerTest {

	@Test
	public void getTest() {
		 HttpHeaders httpHeaders = new HttpHeaders();
	        httpHeaders.add("loginId", "1557");
	        httpHeaders.add("customerId", "1");
	        httpHeaders.add("token", "P4oNqGNMQA2ln96OMCkGQJE6kG4pYA9swOWl8AXbTS7Uu0Leja");
	        
	        ResultGetRequest request = new ResultGetRequest();
	        request.setStudentId(studentId);
	        request.setSemester(semester);
	        request.setExamType(examType);
	      
	        
	        //ObjectMapper objectMapper = new ObjectMapper();
	        String requestJson = objectMapper.writeValueAsString(marks);
	        mockMvc.perform(
	                MockMvcRequestBuilders.get("/api/v1/exams/marks")
	                .headers(httpHeaders)
	                .param("semester", "FIFTH")
	                
	                .param("studentId", "123")
	                .param("examType","MID_TERM")
	                .contentType(MediaType.APPLICATION_JSON)
	                .content(requestJson))
	        		
	                .andExpect(MockMvcResultMatchers.status().isOk());
	                assertEquals(Semester.FIFTH, request.getSemester());//because this is abstract or enum so
	                assertEquals(new Long(76),request.getCourseId());
	                assertEquals(new Long(123),request.getSubjectId());
	                assertEquals(ExamType.MID_TERM,request.getExamType());
	                
	        
	    }
		
	}


}
