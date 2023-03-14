package com.toursandtravels.dto;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@AllArgsConstructor
@Setter
@Getter
@ToString
public class LoginResponse {
	private final String jwt;
	private final String role;
}
