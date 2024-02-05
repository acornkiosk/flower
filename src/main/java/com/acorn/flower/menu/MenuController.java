package com.acorn.flower.menu;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;

@Controller
public class MenuController {
	@Autowired private MenuService service; 
}
