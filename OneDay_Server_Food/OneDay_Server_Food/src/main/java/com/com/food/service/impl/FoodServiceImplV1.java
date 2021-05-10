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
	
	public List<MyFoodDTO> select(PreparedStatement pStr) throws SQLException {
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
	
	@Override
	public List<MyFoodDTO> selectAll() {
		String sql = " SELECT * FROM view_섭취정보 ";
		PreparedStatement pStr = null;
		
		try {
			pStr = dbConn.prepareStatement(sql);
			List<MyFoodDTO> mfList = this.select(pStr);
			pStr.close();
			return mfList;
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		return null;
	}

	@Override
	public List<MyFoodDTO> findByDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int update(MyFoodVO myFoodVO) {
		String sql = " INSERT INTO tbl_myfoods ";
		sql += " (mf_seq, mf_date, mf_name, mf_take) ";
		sql += " VALUES(mf_seq.NEXTVAL, ?, ?, ? ) ";
		
		PreparedStatement pStr = null;
		try {
			pStr = dbConn.prepareStatement(sql);
			pStr.setString(1, myFoodVO.getMf_date());
			pStr.setString(2, myFoodVO.getMf_name());
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
	public String inputDate() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public List<FoodDTO> findByName() {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public int takeFood() {
		// TODO Auto-generated method stub
		return 0;
	}



}
