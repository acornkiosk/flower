package com.acorn.flower.menu.option_details;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("optionDetailsDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OptionDetailsDto {
	private int option_id;
	private int id;
	private String name;
	private int price;
	private String img_url;
}
