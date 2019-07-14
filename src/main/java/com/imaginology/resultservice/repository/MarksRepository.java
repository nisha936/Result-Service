package com.imaginology.resultservice.repository;

import java.util.List;

import org.slf4j.Marker;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.Query;
import org.springframework.data.repository.query.Param;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import com.imaginology.resultservice.model.Marks;


@Repository
@Transactional(readOnly = true)
public interface MarksRepository extends JpaRepository<Marks, Long> {

	@Query("select r from Marks r where r.semester =:semester and r.studentId =:studentId and r.examType =:examType")
	List<Marks> findMarks(@Param(value = "semester") Integer semester, @Param(value = "studentId") Long studentId,
			@Param(value = "examType") Integer examType);

	}