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
public class FoodDTO {

	private String fd_fcode;
    private String fd_name;
    private Integer fd_year;
    private String fd_mcode;
    private String cp_name;
    private String fd_ccode;
    private String it_name;
    private Integer fd_size;
    private Integer fd_total;
    private Float fd_kcal;
    private Float fd_prot;
    private Float fd_fat;
    private Float fd_carb;
    private Float fd_sugar;
}
