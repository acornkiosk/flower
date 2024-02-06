package com.acorn.flower.menu;

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
	private String category; // 카테고리
}
