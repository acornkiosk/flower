package com.acorn.flower.order;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("orderDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class OrderDto {
	private int id; //주문번호
	private int menu_id; //메뉴 번호
	private int menu_count; //메뉴 개수
	private int kiosk_id; //키오스크 번호
	private String is_completed; //주문제조 완료 여부
	private String regdate; //주문 시간
}
