package com.example.curd.service;

import java.util.List;

import com.example.curd.models.Student;

public interface ServiceInterface {

	public boolean addStudent(Student std);
	public boolean deleteStudent(String stdid);
	public boolean updateStudent(Student std);
	public List<Student> viewAll();
}
