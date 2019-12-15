package com.geogym.body.dto;

import java.time.LocalDate;

public class BodyInfo {
	
	private int bodyinfo_no;
	private int user_no;
	private LocalDate date;
	private double bodyinfo_height;
	private double bodyinfo_weight;
	private double bodyinfo_fatmass; // 체지방량
	private double bodyinfo_lbm; // Lean Body Mass 골격근량

}
