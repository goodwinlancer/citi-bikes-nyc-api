package com.poor.ugly.dwarf;

import java.util.List;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor
public class StationResponse 
{
	private String executionTime;
	private List<Station> stationBeanList;
}
