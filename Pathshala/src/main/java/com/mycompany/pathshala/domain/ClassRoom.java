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

public class ClassRoom {
    private Integer id;
    private String course_name;
    private String course_no;
    private String instructor;

    public ClassRoom() {
    }

    public ClassRoom(Integer id, String course_name, String course_no, String instructor) {
        this.id = id;
        this.course_name = course_name;
        this.course_no = course_no;
        this.instructor = instructor;
    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getCourse_name() {
        return course_name;
    }

    public void setCourse_name(String course_name) {
        this.course_name = course_name;
    }

    public String getCourse_no() {
        return course_no;
    }

    public void setCourse_no(String course_no) {
        this.course_no = course_no;
    }

    public String getInstructor() {
        return instructor;
    }

    public void setInstructor(String instructor) {
        this.instructor = instructor;
    }
    
}
