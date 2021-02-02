package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.message.request.SignUpForm;
import com.loizenai.jwtauthentication.scheduler.InvitationService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import javax.validation.Valid;

@RestController
public class TestRestAPIs {

	@Autowired
	private InvitationService invitationService;
	
	@GetMapping("/api/test/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Board Management Project";
	}

	@GetMapping("/api/test/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public String adminAccess() {
		return ">>> Admin Contents";
	}

	//ADDITION URLS FOR SCHEDULER

	//ADMIN INVITE INTERVIWEE
	@PostMapping("/api/admin/invite")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> inviteInterviewee(@Valid @RequestBody SignUpForm signUpRequest) {
		return invitationService.registerUser(signUpRequest);
	}

	//GET ALL SCHEDULES
	@GetMapping("/api/schedule/")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> schedules() {
		return ResponseEntity.ok().body("schedules");
	}

}