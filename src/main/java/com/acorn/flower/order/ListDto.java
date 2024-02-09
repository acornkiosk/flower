package com.acorn.flower.order;

import org.apache.ibatis.type.Alias;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.NoArgsConstructor;

@Alias("listDto")
@Builder
@AllArgsConstructor
@NoArgsConstructor
@Data
public class ListDto {
	private int order_id;
	private int kiosk_id;
	private String menu_name;
	private int menu_count;
	private String is_completed;
	private String regdate;
}
