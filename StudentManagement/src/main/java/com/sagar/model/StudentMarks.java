package com.sagar.model;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;



@Entity
@Data
@NoArgsConstructor
@AllArgsConstructor
@Table(name = "student_marks")
public class StudentMarks {

	@Id
    @Column(name = "std_id")
    private Long id;

    @Column(name = "session")
    private String session;

    @Column(name = "semester")
    private String semester;

    @Column(name = "total_subject")
    private int totalSubject;

    @Column(name = "total_marks")
    private int totalMarks;
}
