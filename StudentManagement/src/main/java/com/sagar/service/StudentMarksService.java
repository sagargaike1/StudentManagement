package com.sagar.service;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.DAO.StudentInfoRepository;
import com.sagar.DAO.StudentMarksRepository;
import com.sagar.model.StudentInfo;
import com.sagar.model.StudentMarks;

@Service
public class StudentMarksService {

	  @Autowired
	    private StudentMarksRepository studentMarksRepository;

	    @Autowired
	    private StudentInfoRepository studentInfoRepository;

	    public boolean addStudentMarks(StudentMarks studentMarks) {
	        Optional<StudentInfo> optionalStudentInfo = studentInfoRepository.findById(studentMarks.getId());
	        if (optionalStudentInfo.isPresent()) {
	            studentMarksRepository.save(studentMarks);
	            return true;
	        } else {
	            return false;
	        }
	    }

	    public Optional<StudentMarks> getStudentMarksById(Long id) {
	        return studentMarksRepository.findById(id);
	    }
}
