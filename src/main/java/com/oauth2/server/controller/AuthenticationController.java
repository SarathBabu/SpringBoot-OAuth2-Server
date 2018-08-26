package com.oauth2.server.controller;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpSession;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.Authentication;
import org.springframework.security.core.context.SecurityContext;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.web.authentication.logout.SecurityContextLogoutHandler;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class AuthenticationController {
	
	private static final Logger LOGGER = LoggerFactory.getLogger(AuthenticationController.class);

	@Autowired
	@Qualifier("authenticationManagerBean")
	private AuthenticationManager authenticationManager;

	@GetMapping("/login")
	public String login() {
		return "login";
	}

	@PostMapping("/loginPost")
	public void loginPost(HttpServletRequest req, @RequestParam("username") String username,
			@RequestParam("password") String password) {
		


		UsernamePasswordAuthenticationToken authReq = new UsernamePasswordAuthenticationToken(username, password);
		Authentication auth = authenticationManager.authenticate(authReq);
//
//		SecurityContext sc = SecurityContextHolder.getContext();
//		sc.setAuthentication(auth);
//		HttpSession session = req.getSession(true);
//		session.setAttribute("SPRING_SECURITY_CONTEXT_KEY", sc);

	}

	@GetMapping("/homepage")
	public String homePage() {
		return "homepage";
	}
	
	
	
	
//	
//	@GetMapping("/logout")
//	public String logout(Authentication authentication) {
//		
//		SecurityContextHolder contextHolder = new  SecurityContextHolder();
//		contextHolder.getContext().getAuthentication().
//	}

}
