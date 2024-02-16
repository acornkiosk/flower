package com.acorn.flower.menu.option;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Alias("optionDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OptionDto {
	private int category_id;
	private int id;
	private String name;
	
	//category의 id를 구하기 위한 필드
	private String category_name;
	
}
