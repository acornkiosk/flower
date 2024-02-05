package com.acorn.kiosk.menu;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;
@Alias("menuDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class MenuDto {
	private int id;
	private String name;
	private int price;
	private String description;
	private String img_url;
	private String is_sold;
	private String category;
}
