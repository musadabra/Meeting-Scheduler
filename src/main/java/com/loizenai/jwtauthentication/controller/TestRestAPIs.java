package com.loizenai.jwtauthentication.controller;

import com.loizenai.jwtauthentication.message.request.SignUpForm;
import com.loizenai.jwtauthentication.model.TimeSlot;
import com.loizenai.jwtauthentication.scheduler.InvitationService;
import com.loizenai.jwtauthentication.scheduler.TimeslotService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.*;

import javax.validation.Valid;

@RestController
public class TestRestAPIs {

	@Autowired
	private InvitationService invitationService;
	@Autowired
	private TimeslotService timeslotService;
	
	@GetMapping("/api/user")
	@PreAuthorize("hasRole('USER') or hasRole('ADMIN')")
	public String userAccess() {
		return ">>> User Contents!";
	}

	@GetMapping("/api/test/pm")
	@PreAuthorize("hasRole('PM') or hasRole('ADMIN')")
	public String projectManagementAccess() {
		return ">>> Board Management Project";
	}

	@GetMapping("/api/admin")
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
	@GetMapping("/api/schedule")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> schedules(@RequestBody  TimeSlot slot) {
		return ResponseEntity.ok().body(new TimeslotService().timeSlots(slot));
	}

	@GetMapping("/api/schedule/{id}")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> schedules(@PathVariable long id) {
		return ResponseEntity.ok().body(new TimeslotService().timeSlot(id));
	}

	@PostMapping("/api/schedule")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<?> createSlot(@RequestBody TimeSlot timeslot){
		timeslotService.createTimeSlot(timeslot);
		return new ResponseEntity<>(timeslot, HttpStatus.CREATED);
	}


}