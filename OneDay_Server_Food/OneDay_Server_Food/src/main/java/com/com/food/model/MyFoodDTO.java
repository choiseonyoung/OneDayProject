package com.com.food.model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
@AllArgsConstructor
@NoArgsConstructor
public class MyFoodDTO {
	
	private int seq;
	private String date;
	private String name;
	private int take;
	private int total;
	private float kcal;
	private float prot;
	private float fat;
	private float carb;
	private float sugar;
	
};