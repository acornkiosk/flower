package com.acorn.flower.login;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("loginDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class LoginDto {
	private String user_id;
	private String user_pwd;
	private String rank;
}
