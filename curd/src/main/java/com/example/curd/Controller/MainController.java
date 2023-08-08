package com.example.curd.Controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.example.curd.dto.Response;
import com.example.curd.models.Student;
import com.example.curd.service.ServiceInterface;

@RestController
public class MainController {

	@Autowired
	ServiceInterface sinter;
	
	
	@PostMapping("/add")
	public ResponseEntity<Response> addStudent(@RequestBody Student std)
	{
		boolean b=sinter.addStudent(std);
		Response response;
		if(b)
		response=new Response(b,"Something Went Wrong");
		else
			response=new Response(b,"Record added Successfully");
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@DeleteMapping("/delete/{id}")
	public ResponseEntity<Response> deleteStudent(@PathVariable String id)
	{
		Response response;
		boolean b=sinter.deleteStudent(id);
		if(b)
			response=new Response(b,"Something Went Wrong");
		else
			response=new Response(b,"Record deleted Successfully");
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	
	@PutMapping("/update")
	public ResponseEntity<Response> updateStudent(@RequestBody Student std)
	{
		Response response;
		boolean b=sinter.updateStudent(std);
		if(b)
			response=new Response(b,"Something Went Wrong");
		else
			response=new Response(b,"Record Updated Successfully");
		return new ResponseEntity<Response>(response,HttpStatus.OK);
	}
	@GetMapping("/viewall")
	public List<Student> viewAll()
	{
		List<Student> list=sinter.viewAll();
		return list;
	}
}
