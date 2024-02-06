package com.acorn.flower.user;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("userDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class UserDto {
	private String id;
	private String password;
	private String newPassword; 
	private String role;
	private String regdate;
}
