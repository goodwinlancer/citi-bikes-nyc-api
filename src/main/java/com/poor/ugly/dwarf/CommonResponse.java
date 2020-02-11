package com.poor.ugly.dwarf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class CommonResponse {


	private Object data;
	private MessageResponse message;
	private boolean hasNext;
	private boolean hasPrevious;
	
	public CommonResponse(MessageResponse message) {
		this.message = message;
		this.data=null;
		this.hasNext = false;
		this.hasPrevious = false;
	}
	
	public CommonResponse(Object data, MessageResponse message) {
		this.message = message;
		this.data=data;
		this.hasNext = false;
		this.hasPrevious = false;
	}
	
	
	
}

