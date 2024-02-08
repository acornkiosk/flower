package com.acorn.flower.menu;

import java.io.File;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.UUID;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import com.acorn.flower.menu.category.CategoryDto;

/**
 * Thymeleaf 용 메뉴관리 Controller와 React 리팩토링 대비 API Controller 를 동시에 처리하는 서비스입니다. 
 * <br>
 * 의존하는 Dao 에서 응답받은 데이터를 Model 객체에 위임하는 역할을 맡습니다.
 * <br>
 * @author "이승우", "김대원"
 * @since 2024-02-07
 * @version 0.1 / 프로젝트 버전
 */

@Service
public class MenuServiceImpl implements MenuService {
	@Autowired private MenuDao menuDao;
	
	/** 파일을 저장할 위치 */
	@Value("${file.location}") 
	private String fileLocation;

	/** 메뉴등록 코드 */
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

	/**  메뉴수정 코드 
	 * todo : else 문 작성 필요성 판단하기 
	 * */
	@Override
	public void updateMenu(MenuDto dto) {
		//1. 업로드된 파일 저장
		//저장할 파일의 이름 겹치지 않는 유일한 문자열로 얻어내기
		String saveFileName=UUID.randomUUID().toString();
		//저장할 파일의 전체 경로 구성하기
		String filePath=fileLocation+File.separator+saveFileName;
		try {
	        // MultipartFile이 비어있지 않은 경우에만 파일을 이동시키기
	        if (dto.getImage() != null && !dto.getImage().isEmpty()) {
	            // 업로드된 파일을 이동시킬 목적지 File 객체
	            File f = new File(filePath);
	            // MultipartFile 객체의 메소드를 통해서 실제로 이동시키기(전송하기)
	            dto.getImage().transferTo(f);
	        } else {
	            // todo 파일이 비어있는 경우에는 null 또는 원하는 처리를 수행
	        	
	        }
		}catch(Exception e) {
			e.printStackTrace();
		}
		dto.setImg_url(saveFileName);
		menuDao.update(dto);
	}

	/** 메뉴삭제 코드 */
	@Override
	public void deleteMenu(int id) {
		menuDao.delete(id);
	}
	
	/** 메뉴 가져오기 */
	@Override
	public MenuDto getData(int id) {
		return menuDao.getData(id);
	}

	/** 메뉴 모두 가져오기 */
	@Override
	public List<MenuDto> getList() {
		return menuDao.getList();
	}
	

	

	
	
}
