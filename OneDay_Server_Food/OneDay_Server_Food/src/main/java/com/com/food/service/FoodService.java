package com.com.food.service;

import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.MyFoodDTO;
import com.com.food.model.MyFoodVO;

public interface FoodService {
	
	public List<MyFoodDTO> selectAll(); // 첫화면에서 섭취한 칼로리 정보 리스트로 보여줌
	// public float calculate(); // 총내용량, 에너지, 단백질, 지방, 탄수화물, 총당류 계산
	public List<MyFoodDTO> findByDate(String date); // 시작화면에서 날짜 입력해 조회
	
	public int update(MyFoodVO myFoodVO); // 섭취정보 등록
	public String inputDate(); // 섭취정보 등록 클릭 후 날짜 입력
	public List<FoodDTO> findByName(); // 섭취정보 등록 클릭 후 식품명 검색
	public int takeFood(); // 섭취정보 등록 클릭 후 섭취량 입력
	
}
