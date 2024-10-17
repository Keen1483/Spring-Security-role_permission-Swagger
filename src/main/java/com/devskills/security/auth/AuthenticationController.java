package com.devskills.security.auth;

import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import lombok.RequiredArgsConstructor;

@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
public class AuthenticationController {
	
	private final AuthenticationService service;
	
	@Operation(
			description = "Create a user with firstname, lastname, email, password and role",
			summary = "Create a user",
			responses = {
					@ApiResponse(
							description = "User created",
							responseCode = "204"
					),
					@ApiResponse(
							description = "some parameters are not include",
							responseCode = "400"
					)
			}
	)
	@ResponseStatus(code = HttpStatus.CREATED)
	@PostMapping("/register")
	public ResponseEntity<AuthenticationResponse> register(
			@RequestBody RegisterRequest request
	) {
		return ResponseEntity.ok(service.register(request));
	}
	
	@PostMapping("/authenticate")
	public ResponseEntity<AuthenticationResponse> authenticate(
			@RequestBody AuthenticationRequest request
	) {
		return ResponseEntity.ok(service.authenticate(request));
	}

}
