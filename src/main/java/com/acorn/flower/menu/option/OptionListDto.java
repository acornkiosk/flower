package com.acorn.flower.menu.option;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("optionListDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OptionListDto {
	private int option_id;
	private String option_name;
	private int option_details_id;
	private String option_details_name;
	private int price;
	private String img_url;
}
