package com.acorn.flower.menu.category;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("categoryDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class CategoryDto {
	private int id;
	private String name; // 카테고리
}
