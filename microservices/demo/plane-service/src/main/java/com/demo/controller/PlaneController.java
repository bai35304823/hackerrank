package com.demo.controller;

import java.util.List;
import java.util.Objects;
import java.util.stream.Stream;

import org.apache.commons.lang3.StringUtils;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.core.env.Environment;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.demo.entity.Plane;
import com.demo.repository.PlaneRepository;

@RestController
@RequestMapping("/api/v2")
public class PlaneController {
	private static final Log logger = LogFactory.getLog(PlaneController.class);
//    Interface representing the environment in which the current application is running
	@Autowired
	private Environment environment;
	@Autowired
	private PlaneRepository planeRepository;

	@PostMapping("/plane/addOne")
	public Plane addPlane(@RequestBody Plane plane) {
		logger.info("Plane :  " + plane);
		validateParams(plane.getPlaneCapacity(), plane.getPlaneModel(), plane.getPlaneMaker());
		Plane plane_db = planeRepository.save(plane);
		plane_db.setPlaneRegNo(new StringBuffer(environment.getProperty("plane.prefix"))
				.append(StringUtils.leftPad(String.valueOf(plane_db.getId()), 4, "0")).toString());
		logger.info("New generated plane registration numbers -> " + plane.getPlaneRegNo());
		return planeRepository.save(plane_db);
	}

	@PostMapping("/plane/delOne")
	@Transactional
	public ResponseEntity<String> deletePlane(@RequestBody Plane plane) {
		validateParams(plane.getPlaneRegNo());

		planeRepository.deleteByPlaneRegNo(plane.getPlaneRegNo());

		return ResponseEntity.status(HttpStatus.OK).body("Delete success for Plane " + plane.getPlaneRegNo());
	}

	@PostMapping("/plane/getOne/{planeRegNo}")
	public Plane getByPlaneRegNo(@PathVariable(value = "planeRegNo") String planeRegNo) {
		return planeRepository.findByPlaneRegNo(planeRegNo);
	}

	@GetMapping("/plane/getAll")
	public List<Plane> getAll() {
		return planeRepository.findAll();
	}

	private void validateParams(String planeCapacity, String maker, String model) {
		if (StringUtils.isEmpty(planeCapacity) || StringUtils.isEmpty(maker) || StringUtils.isEmpty(model)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The plane maker, model, and seating capacity" + " must be provided");
		}

		if (!Stream.of("50", "100", "150", "500").anyMatch(str -> StringUtils.equalsIgnoreCase(str, planeCapacity))) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The seating capacity should be 50,100,150 or 500.");
		}

		logger.debug("Plane -> Valid params given");
	}

	private void validateParams(String planeRegNo) {
		if (StringUtils.isEmpty(planeRegNo)) {
			throw new ResponseStatusException(HttpStatus.BAD_REQUEST,
					"The plane registration number" + " must be provided");
		}

		if (Objects.isNull(planeRepository.findByPlaneRegNo(planeRegNo))) {
			throw new ResponseStatusException(HttpStatus.NOT_FOUND, "The plane cannot be found!");
		}
		logger.debug("Plane -> Valid params given");
	}
}
