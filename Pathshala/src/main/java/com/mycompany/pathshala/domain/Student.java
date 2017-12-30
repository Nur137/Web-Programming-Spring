/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.mycompany.pathshala.domain;

/**
 *
 * @author Nur137
 */
public class Student {
    private Integer course_id;
    private String student_name;

    public Student() {
    }
    
    public Student(Integer course_id, String student_name) {
        this.course_id = course_id;
        this.student_name = student_name;
    }

    public Integer getCourse_id() {
        return course_id;
    }

    public void setCourse_id(Integer course_id) {
        this.course_id = course_id;
    }

    public String getStudent_name() {
        return student_name;
    }

    public void setStudent_name(String student_name) {
        this.student_name = student_name;
    }
}
