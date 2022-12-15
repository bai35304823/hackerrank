package com.demo.spring.Application.controller;



import javax.annotation.Resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Lazy;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Application.model.Course;
import com.demo.spring.Application.model.Registration;
import com.demo.spring.Application.repository.CourseRepository;
import com.demo.spring.Application.service.RegistrationService;


@RestController
public class JpaController {
	@Autowired
    private Environment environment;
	@Resource
	CourseRepository courseRepository;
	@Autowired
	@Lazy
	RegistrationService registrationService;
	
	 @GetMapping("/instance")
	    public String getInstancePort() {
	      String microservicePort =   environment.getProperty("local.server.port");
	      return "Microservie running on port : " + microservicePort;
	    }
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
   
   @PostMapping("/register")
   public Registration register(@RequestBody Registration registration){
     return registrationService.save(registration);
  }
   
	
	  @PostMapping("/authenticate") 
	public boolean authenticate(@RequestBody Registration registration){ 
		  return
	  registrationService.isValidUser(registration.getEmail(),
	  registration.getPassword()); }
	 
}