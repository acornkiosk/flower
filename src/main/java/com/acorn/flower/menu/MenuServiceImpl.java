package com.acorn.flower.menu;

import java.io.File;
import java.util.List;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired private MenuDao menuDao;
	
	//파일을 저장할 위치 
	@Value("${file.location}") 
	private String fileLocation;

	
	@Override
	public void addMenu(MenuDto dto) {
		//1. 업로드된 파일 저장
		//저장할 파일의 이름 겹치지 않는 유일한 문자열로 얻어내기
		String saveFileName=UUID.randomUUID().toString();
		//저장할 파일의 전체 경로 구성하기
		String filePath=fileLocation+File.separator+saveFileName;
		try {
			//업로드된 파일을 이동시킬 목적지 File 객체
			File f=new File(filePath);
			//MultipartFile 객체의 메소드를 통해서 실제로 이동시키기(전송하기)
			dto.getImage().transferTo(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setImg_url(saveFileName);
		menuDao.insert(dto);
		
	}

	@Override
	public void updateMenu(MenuDto dto) {
		//1. 업로드된 파일 저장
		//저장할 파일의 이름 겹치지 않는 유일한 문자열로 얻어내기
		String saveFileName=UUID.randomUUID().toString();
		//저장할 파일의 전체 경로 구성하기
		String filePath=fileLocation+File.separator+saveFileName;
		try {
			//업로드된 파일을 이동시킬 목적지 File 객체
			File f=new File(filePath);
			//MultipartFile 객체의 메소드를 통해서 실제로 이동시키기(전송하기)
			dto.getImage().transferTo(f);
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setImg_url(saveFileName);
		menuDao.update(dto);
	}

	@Override
	public void deleteMenu(int id) {
		menuDao.delete(id);
		
	}

	@Override
	public void getList(Model model) {
		
		List<MenuDto> list=menuDao.getList();
		model.addAttribute("list",list);
	}
	
	@Override
	public void getData(Model model, int id) {
		MenuDto dto = menuDao.getData(id);
		model.addAttribute("dto", dto); // update_form.html 에서 Thymeleaf 로 불러오기 
	}
	
	
}
