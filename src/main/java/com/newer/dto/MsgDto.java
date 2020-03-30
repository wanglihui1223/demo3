package com.newer.dto;

public class MsgDto {
	private boolean tag=false;
	private String message;

	public boolean isTag() {
		return tag;
	}

	public void setTag(boolean tag) {
		this.tag = tag;
	}

	public String getMessage() {
		return message;
	}

	public void setMessage(String message) {
		this.message = message;
	}
	
	public MsgDto() {
		// TODO Auto-generated constructor stub
	}

	public MsgDto(boolean tag, String message) {
		super();
		this.tag = tag;
		this.message = message;
	}
	

}
