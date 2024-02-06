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
	private int id; // 메뉴번호 
	private String name; // 메뉴이름 
	private int price; ; // 메뉴가격 
	private String one_sentence; // 메뉴 간략설명(꽃말)
	private String description; // 메뉴 상세설명(긴글) 
	private String img_url; // 이미지 링크 
	private String is_sold; // 판매가능여부 
	private String category; // 카테고리 
	private MultipartFile image; //이미지 파일 업로드 처리를 위한 필드
}
