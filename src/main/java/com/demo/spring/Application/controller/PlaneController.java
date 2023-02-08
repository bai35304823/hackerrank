package com.demo.spring.Application.controller;

import java.util.List;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.demo.spring.Application.model.Plane;
import com.demo.spring.Application.repository.PlaneRepository;

@RestController
@RequestMapping("/api/v2")
public class PlaneController {
//    Interface representing the environment in which the current application is running
    @Autowired
    private Environment environment;
    @Autowired
    private PlaneRepository planeRepository;
    
    @PostMapping("/plane/addOne")
    public Plane addPlane(@RequestBody Plane plane) {
    	return planeRepository.save(plane);
    }
    
    @PostMapping("/plane/delOne")
    public void deleteAirport(@RequestBody Plane plane) {
    	planeRepository.deleteByPlaneRegNo(plane.getPlaneRegNo());
    }
    
    @PostMapping("/plane/getOne/{planeRegNo}")
    public Plane getByPlaneRegNo(@PathVariable(value="planeRegNo") String planeRegNo) {
    	return planeRepository.findByPlaneRegNo(planeRegNo);
    }
    
    @GetMapping("/plane/getAll")
    public List<Plane> getAll() {
    	return planeRepository.findAll();
    }
}
