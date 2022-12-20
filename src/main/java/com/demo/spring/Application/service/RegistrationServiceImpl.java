package com.demo.spring.Application.service;

import java.nio.charset.StandardCharsets;
import java.util.Objects;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.thymeleaf.util.StringUtils;
import com.demo.spring.Application.model.Registration;
import com.demo.spring.Application.repository.RegistrationRepository;
import com.demo.spring.Application.util.Crypt;
//https://stackoverflow.com/questions/16351780/where-should-service-annotation-be-kept-interface-or-implementation
//@Service on Concrete Classes for SpringBootApplication
@Service
public class RegistrationServiceImpl implements  RegistrationService{
    
	//@Resource
	//RegistrationService registrationService;
	@Resource
	RegistrationRepository registrationRepository;
	@Override
    public Registration save(Registration registration) {
		/*
		 * // salts are a fundamental principle of password hashing SecureRandom random
		 * = new SecureRandom(); byte[] salt = new byte[16]; random.nextBytes(salt);
		 * registration.setSalt(new String(salt)); KeySpec spec = new
		 * PBEKeySpec(registration.getPassword().toCharArray(), salt, 65536, 128); //
		 * Implementing PBKDF2 in Java StringBuilder sb = new StringBuilder(); try {
		 * SecretKeyFactory factory =
		 * SecretKeyFactory.getInstance("PBKDF2WithHmacSHA1");
		 * 
		 * byte[] hash = factory.generateSecret(spec).getEncoded();
		 * 
		 * for (byte b : hash) { sb.append(String.format("%02d", b)); } } catch
		 * (NoSuchAlgorithmException e) { e.printStackTrace(); } catch
		 * (InvalidKeySpecException e) { // TODO Auto-generated catch block
		 * e.printStackTrace(); }
		 * 
		 * registration.setPassword(sb.toString());
		 */
		byte [] salt = Crypt.generateSalt();
		registration.setSalt(salt);
		registration.setPassword(Crypt.hashWithPBKDF2(registration.getPassword(), salt));
       return registrationRepository.save(registration);
    }
  
    public Registration findByEmail(String email) {
        return registrationRepository.findByEmail(email);
    }
    
    @Override
    public Registration findByEmailAndPassword(String email, String password) {
        return null;
    }
    @Override
    public Boolean isValidUser(String email, String password) {
    	Registration registration = findByEmail(email);
    	if (Objects.isNull(registration))  return false;
        return StringUtils.equalsIgnoreCase(Crypt.hashWithPBKDF2(password, 
        		registration.getSalt()), registration.getPassword());
    }
}
