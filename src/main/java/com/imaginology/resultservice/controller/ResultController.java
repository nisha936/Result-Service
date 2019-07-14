package com.imaginology.resultservice.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import com.imaginology.resultservice.model.ExamType;
import com.imaginology.resultservice.model.Semester;
import com.imaginology.resultservice.response.ResultResponse;
import com.imaginology.resultservice.service.ResultService;

import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiImplicitParams;
import io.swagger.annotations.ApiOperation;

@RestController
@RequestMapping(value = "/api/v2/results")
public class ResultController {
	@Autowired
	private ResultService resultService;

	@GetMapping("/result")
	@ApiOperation(response = ResultResponse.class, value = "Get result for specific student")
	@ApiImplicitParams({ @ApiImplicitParam(name = "token", required = true, dataType = "string", paramType = "header"),
			@ApiImplicitParam(name = "loginId", required = true, dataType = "number", paramType = "header"),
			@ApiImplicitParam(name = "customerId", required = true, dataType = "number", paramType = "header") })
	public ResponseEntity<Object> getAllResult(@RequestParam Semester semester, @RequestParam(required = false) Long studentId,
			@RequestParam ExamType examType) {
		ResultResponse response = resultService.getResult(semester, studentId, examType);
		return new ResponseEntity<Object>(response, HttpStatus.OK);
	}
}
