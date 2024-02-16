package com.acorn.flower.menu.match;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("matchDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatchDto {
	private int id;
	private int category_id;
	private int option_id;
	
}
