package com.com.food.service.impl;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.com.food.model.FoodDTO;
import com.com.food.model.MyFoodDTO;
import com.com.food.model.MyFoodVO;
import com.com.food.persistence.DBContract;
import com.com.food.service.FoodService;

public class FoodServiceImplV1 implements FoodService {

	protected Connection dbConn;
	public FoodServiceImplV1() {
		dbConn = DBContract.getDBConnection();
	}
	
	
	public List<MyFoodDTO> select_mf(PreparedStatement pStr) throws SQLException {
		//TODO 1개의 MyFood 정보
		List<MyFoodDTO> mfList = new ArrayList<MyFoodDTO>();
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			MyFoodDTO mfDTO = new MyFoodDTO();
			mfDTO.setSeq(rSet.getInt("번호"));
			mfDTO.setDate(rSet.getString("날짜"));
			
			mfDTO.setName(rSet.getString("식품명"));
			mfDTO.setTake(rSet.getInt("섭취량"));
			mfDTO.setTotal(rSet.getInt("총내용량"));
			
			mfDTO.setKcal(rSet.getFloat("에너지"));
			mfDTO.setProt(rSet.getFloat("단백질"));	
			mfDTO.setFat(rSet.getFloat("지방"));
			mfDTO.setCarb(rSet.getFloat("탄수화물"));
			mfDTO.setSugar(rSet.getFloat("총당류"));
			
			mfList.add(mfDTO);
		}
		return mfList;
	}
	
	
	public List<FoodDTO> select_f(PreparedStatement pStr) throws SQLException {
		//TODO 1개의 Food 정보
		List<FoodDTO> fdList = new ArrayList<FoodDTO>();
		ResultSet rSet = pStr.executeQuery();
		while(rSet.next()) {
			FoodDTO fdDTO = new FoodDTO();
			fdDTO.setFd_fcode(rSet.getString("식품코드"));
			fdDTO.setFd_name(rSet.getString("식품명"));
			
			fdDTO.setFd_year(rSet.getInt("출시연도"));
			fdDTO.setCp_name(rSet.getString("제조사코드"));
			fdDTO.setFd_mcode(rSet.getString("제조사명"));
			fdDTO.setFd_ccode(rSet.getString("분류코드"));
			fdDTO.setIt_name(rSet.getString("분류명"));
			
			fdDTO.setFd_size(rSet.getInt("1회제공량"));
			fdDTO.setFd_total(rSet.getInt("총내용량"));	
			fdDTO.setFd_kcal(rSet.getFloat("에너지"));
			fdDTO.setFd_prot(rSet.getFloat("단백질"));
			fdDTO.setFd_fat(rSet.getFloat("지방"));
			fdDTO.setFd_carb(rSet.getFloat("탄수화물"));
			fdDTO.setFd_sugar(rSet.getFloat("총당류"));
			
			fdList.add(fdDTO);
		}
		return fdList;
	}
	
	@Override
	public List<MyFoodDTO> selectAll_mf() {
		//TODO 전체 MyFood 리스트
		String sql = " SELECT * FROM view_섭취정보 ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodDTO> mfList = this.select_mf(pStr);
			pStr.close();
			return mfList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}
	
	public List<FoodDTO> selectAll_f() {
		//TODO 전체 MyFood 리스트
		String sql = " SELECT * FROM view_식품정보 ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<FoodDTO> fdList = this.select_f(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}


	@Override
	public int insert(MyFoodVO myFoodVO) {
		//TODO 섭취정보 등록하기
		String sql = " INSERT INTO tbl_myfoods ";
		sql += " (mf_seq, mf_date, mf_code, mf_take) ";
		sql += " VALUES(mf_seq.NEXTVAL, ?, ?, ? ) ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myFoodVO.getMf_date());
			pStr.setString(2, myFoodVO.getMf_code());
			pStr.setInt(3, myFoodVO.getMf_take());
			
			int result = pStr.executeUpdate();
			pStr.close(); 
			return result;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return 0;
	}

	@Override
	public List<FoodDTO> findByName(String name) {
		//TODO 식품명 입력해서 검색하여 선택
		String sql = " SELECT * FROM view_식품정보 ";
		sql += " WHERE 식품명 LIKE '%' || ? || '%' ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, name);
			
			List<FoodDTO> fdList = this.select_f(pStr);
			pStr.close();
			return fdList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}
	
	@Override
	public String inputDate() {
		// TODO (섭취정보등록) 날짜 입력
		
		return null;
	}

	@Override
	public int takeFood() {
		//TODO (섭취정보등록) 섭취량 입력
		return 0;
	}


	@Override
	public List<MyFoodDTO> findByDate(String date) {
		// TODO 날짜 입력해 날짜별 리스트 조회
		String sql = " SELECT * FROM view_섭취정보 ";
		sql += " WHERE 날짜 = ? ";
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, date);
			
			List<MyFoodDTO> mfList = this.select_mf(pStr);
			pStr.close();
			return mfList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return null;
	}

}
