package com.acorn.flower.menu.set;

import org.apache.ibatis.type.Alias;
import org.springframework.web.multipart.MultipartFile;

import com.acorn.flower.menu.MenuDto;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("SetMenuDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class SetMenuDto {
	private int id; // 세트번호
	private String name; // 세트이름 
	private int price; // 세트가격 
	private int menu_id; // 단품메뉴 번호 
	private String menu_name; // 단품메뉴 이름 
	private String img_url; // 이미지 링크 
}
