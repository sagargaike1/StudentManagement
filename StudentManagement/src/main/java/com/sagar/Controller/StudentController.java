package com.sagar.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestHeader;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;


import com.sagar.model.StudentInfo;
import com.sagar.model.StudentMarks;
import com.sagar.service.StudentInfoService;
import com.sagar.service.StudentMarksService;


@RestController
@RequestMapping(value = "/student")
public class StudentController {
	
	  @Autowired
	  private StudentInfoService studentinfoService;
	  
	  @Autowired
	  private StudentMarksService studentmarksService;
	  
	  @PostMapping(value = "/details")
	  public ResponseEntity<String> insertStudentInfo(@RequestBody List<StudentInfo> students, @RequestHeader("operation") String operation){
	      if(operation.equals("insert")) {
	          int count = studentinfoService.addStudent(StudentInfo);
	          if(count > 0){
	              return ResponseEntity.status(HttpStatus.OK).body("Successfully inserted "+count+" records");
	          }else {
	              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to insert records");
	          }
	      } else {
	          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Operation");
	      }
	  }

	  @org.springframework.web.bind.annotation.GetMapping(value = "/details")
	  public ResponseEntity<List<StudentInfo>> getStudentInfo(@RequestHeader("operation") String operation){
	      if(operation.equals("read")) {
	          List<StudentInfo> students = studentinfoService.getAllStudents();
	          if(students != null){
	              return ResponseEntity.status(HttpStatus.OK).body(students);
	          }else {
	              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	          }
	      } else {
	          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	      }
	  }
	  
	  @org.springframework.web.bind.annotation.GetMapping(value = "/details/{id}")
	  public ResponseEntity<StudentInfo> getStudentDetailsById(@PathVariable("id") int id, @RequestHeader("operation") String operation){
	      if(operation.equals("read")) {
	          StudentInfo studentDetails = studentinfoService.getStudentById(id);
	          if(studentDetails != null){
	              return ResponseEntity.status(HttpStatus.OK).body(studentDetails);
	          }else {
	              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	          }
	      } else {
	          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null);
	      }
	  }
	  
	  @PostMapping(value = "/marks/detail")
	  public ResponseEntity<String> insertStudentMarks(@RequestBody StudentMarks studentMark, @RequestHeader("operation") String operation){
	      if(operation.equals("insert")) {
	          boolean isInserted = studentmarksService.addStudentMarks(studentMark);
	          if(isInserted){
	              return ResponseEntity.status(HttpStatus.OK).body("Successfully inserted record");
	          }else {
	              return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Failed to insert record");
	          }
	      } else {
	          return ResponseEntity.status(HttpStatus.BAD_REQUEST).body("Invalid Operation");
	      }
	  }
}
