package com.example.curd.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.curd.models.Student;
import com.example.curd.repository.StudentRepo;

@Service
public class ServiceImpl implements ServiceInterface{

	@Autowired
	StudentRepo srepo;
	
	@Override
	public boolean addStudent(Student std) {
		boolean msg;
		try
		{
			srepo.save(std);
			msg=false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			msg=true;
		}
		return msg;
	}

	@Override
	public boolean deleteStudent(String stdid) {
		boolean msg;
		try
		{
			srepo.delete(srepo.findById(getId(stdid)).get());
			msg=false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			msg=true;
		}
		return msg;
	}

	public long getId(String stdid)
	{
		return srepo.findByStdid(stdid);
	}

	@Override
	public boolean updateStudent(Student std) {
		long id=srepo.findByStdid(std.getStdid());
		Student s=srepo.findById(id).get();
		if(std.getCity()!=null)
		s.setCity(std.getCity());
		if(std.getEmail()!=null)
		s.setEmail(std.getEmail());
		if(std.getName()!=null)
		s.setName(std.getName());
		if(std.getStdid()!=null)
		s.setStdid(std.getStdid());
		boolean b;
		try
		{
			srepo.save(s);
			b=false;
		}
		catch(Exception e)
		{
			System.out.println(e);
			b=true;
		}
		return b;
	}

	@Override
	public List<Student> viewAll() {
		return srepo.findAll();
	}

}
