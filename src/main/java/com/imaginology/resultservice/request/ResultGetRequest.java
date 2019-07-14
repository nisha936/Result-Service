package com.imaginology.resultservice.request;

import java.io.Serializable;

import com.imaginology.resultservice.model.ExamType;
import com.imaginology.resultservice.model.Semester;

import lombok.Getter;
import lombok.Setter;
@Getter
@Setter
public class ResultGetRequest implements Serializable{
	private Long studentId;
	private Semester semester;
	private ExamType examType;

	

}
