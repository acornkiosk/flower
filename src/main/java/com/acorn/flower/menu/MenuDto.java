package com.acorn.flower.menu;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

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
	private MultipartFile image; //이미지 파일 업로드 처리를 위한 필드
}
