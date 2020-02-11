package com.poor.ugly.dwarf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class MessageResponse
{
	private int statusCode;
	private String messageText;
}
