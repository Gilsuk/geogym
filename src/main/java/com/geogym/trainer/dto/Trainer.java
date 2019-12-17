package com.geogym.trainer.dto;

// 이 부분은 일단 유저 DTO 가 나온 후에 트레이너 DTO에만 필요한 부분을 집어넣어야 할 것 같음
public class Trainer {

	private String name;
	private int no;
	public int tranerno;	// 트레이너 번호
	public int tranerrank;	// 트레이너 근 수율 단위
	public int tranerlevel;	// 트레이너 등급
	@Override
	public String toString() {
		return "Trainer [name=" + name + ", no=" + no + "]";
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public int getNo() {
		return no;
	}
	public void setNo(int no) {
		this.no = no;
	}

}
