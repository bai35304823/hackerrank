package com.demo.spring.Application.controller;



import javax.annotation.Resource;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Application.model.Course;
import com.demo.spring.Application.repository.CourseRepository;

@RestController
public class JpaController {

	@Resource
	CourseRepository courseRepository;
   @GetMapping("/")
   public String hello(){
       return "hello world" ;
  }
   @GetMapping("/e")
   public String e(){
       return "hello" ;
  }
   
   @GetMapping("/test")
   public String test(){
       return "hello world test" ;
  }
   
   @GetMapping("/getAll")
   public Object getAll(){
       return  courseRepository.findAll() ;
  }
   
   
   @PostMapping("/findByName/{name}")
   public Course findByName(@PathVariable String name){
       return courseRepository.findByName(name) ;
  }
   
   
   @GetMapping("/findById/{id}")
   public Course findById(@PathVariable Integer id){
       return courseRepository.findById(id).get() ;
  }
   
   @GetMapping("/deleteById/{id}")
   public void deleteById(@PathVariable Integer id){
      courseRepository.deleteById(id);;
  }
   
   
   @PostMapping("/addCourse")
   public Course addCourse(@RequestBody Course course){
     return courseRepository.save(course);
  }
}