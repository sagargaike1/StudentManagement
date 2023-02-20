package com.sagar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_info")
public class StudentInfo {
	
	@Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name = "std_id")
    private Long id;

    @Column(name = "std_name")
    private String name;

    @Column(name = "std_address")
    private String address;

    @Column(name = "std_email")
    private String email;

    @Column(name = "std_phoneno")
    private String phoneNo;

    @Column(name = "std_section")
    private String section;

    @Column(name = "std_grade")
    private String grade;

}
