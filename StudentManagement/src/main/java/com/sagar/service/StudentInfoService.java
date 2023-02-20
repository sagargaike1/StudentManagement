package com.sagar.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sagar.DAO.StudentInfoRepository;
import com.sagar.model.StudentInfo;

@Service
public class StudentInfoService {
	
	     @Autowired
	    private StudentInfoRepository studentInfoRepository;

	    public List<StudentInfo> getAllStudents() {
	        return studentInfoRepository.findAll();
	    }

	    public StudentInfo addStudent(StudentInfo studentInfo) {
	        return studentInfoRepository.save(studentInfo);
	    }

	    public Optional<StudentInfo> getStudentById(Long id) {
	        return studentInfoRepository.findById(id);
	    }

	    public void deleteStudent(Long id) {
	        studentInfoRepository.deleteById(id);
	    }

	    public StudentInfo updateStudent(Long id, StudentInfo studentInfo) {
	        Optional<StudentInfo> optionalStudentInfo = studentInfoRepository.findById(id);
	        if (optionalStudentInfo.isPresent()) {
	            studentInfo.setId(id);
	            return studentInfoRepository.save(studentInfo);
	        } else {
	            return null;
	        }
	    }
	}


