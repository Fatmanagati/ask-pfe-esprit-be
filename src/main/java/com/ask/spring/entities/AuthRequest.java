package com.ask.spring.entities;

import lombok.AllArgsConstructor;
import lombok.NoArgsConstructor;

@lombok.Data
@AllArgsConstructor
@NoArgsConstructor
public class AuthRequest {

	private String userName;
	private String password;
}