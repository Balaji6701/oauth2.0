package com.balaji.shoppingapp.controllers;

import java.util.List;
import java.util.Map;

import org.springframework.http.ResponseEntity;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.security.core.context.SecurityContextHolder;
import org.springframework.security.oauth2.jwt.Jwt;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.balaji.shoppingapp.entity.DummyResponse;

@RestController
@RequestMapping("/products")
public class DummyController {

	@GetMapping
	@PreAuthorize("hasRole('USER')")
	public ResponseEntity<DummyResponse> getUser() {
		Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
		List<String> roles = (List<String>) realmAccess.get("roles");
		String email = jwt.getClaimAsString("email");
		return ResponseEntity.ok(new DummyResponse(jwt.getClaimAsString("name"), "hello from user", roles, email));
	}
	
	@GetMapping("/admin")
	@PreAuthorize("hasRole('ADMIN')")
	public ResponseEntity<DummyResponse> getAdmin() {
		Jwt jwt = (Jwt) SecurityContextHolder.getContext().getAuthentication().getPrincipal();
		Map<String, Object> realmAccess = jwt.getClaimAsMap("realm_access");
		List<String> roles = (List<String>) realmAccess.get("roles");
		String email = jwt.getClaimAsString("email");
		return ResponseEntity.ok(new DummyResponse(jwt.getClaimAsString("name"), "hello from admin", roles, email));
	}

}
