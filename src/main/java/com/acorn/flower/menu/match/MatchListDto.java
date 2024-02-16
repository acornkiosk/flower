package com.acorn.flower.menu.match;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("matchListDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MatchListDto {
	private int option_id;
	private String option_name;
	private int match_id;
	private int category_id;
	private String category_name;
}
