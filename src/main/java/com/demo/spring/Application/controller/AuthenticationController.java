
  package com.demo.spring.Application.controller;
  
  
  import java.util.Objects;
  
  import javax.annotation.Resource;
  
  import org.springframework.beans.factory.annotation.Autowired; import
  org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import
  org.springframework.security.authentication.AuthenticationManager; import
  org.springframework.security.authentication.
  UsernamePasswordAuthenticationToken; import
  org.springframework.web.bind.annotation.CrossOrigin; import
  org.springframework.web.bind.annotation.PostMapping; import
  org.springframework.web.bind.annotation.RequestBody; import
  org.springframework.web.bind.annotation.RestController; import
  org.springframework.web.server.ResponseStatusException; import
  org.thymeleaf.util.StringUtils;
  
  import com.demo.spring.Application.model.AuthRequest; import
  com.demo.spring.Application.model.Login; import
  com.demo.spring.Application.model.Registration; import
  com.demo.spring.Application.repository.RegistrationRepository; import
  com.demo.spring.Application.util.Crypt; import
  com.demo.spring.Application.util.JwtUtil;
  
  @RestController
  
  @CrossOrigin(origins = "http://localhost:4200") public class
  AuthenticationController {
  
  @Autowired private JwtUtil jwtUtil;
  
  @Resource RegistrationRepository registrationRepository;
  
  @Autowired private AuthenticationManager authenticationManager;
  
  @PostMapping("/authenticate") public  ResponseEntity<String> generateToken(@RequestBody Login
  l) throws Exception { try { Registration registration =
  registrationRepository.findByEmail(l.getLoginid()); if
  (Objects.isNull(registration)) { throw new
  ResponseStatusException(HttpStatus.NOT_FOUND,
  "Email address cannot be found"); }
  
  authenticationManager.authenticate( new
  UsernamePasswordAuthenticationToken(l.getLoginid(),
  Crypt.hashWithPBKDF2(l.getPassword(), registration.getSalt()) )); } catch
  (Exception ex) {
	  ex.printStackTrace();
	  throw new ResponseStatusException(HttpStatus.UNAUTHORIZED,
  "Invalid Credentails"); } 
  //return jwtUtil.generateToken(l.getLoginid()); 
	return new ResponseEntity<>("{\"status\" : \""+  jwtUtil.generateToken(l.getLoginid()) +"\"}", HttpStatus.OK);
  } }
 