package com.poor.ugly.dwarf;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;

@Getter
@Setter
@NoArgsConstructor
@AllArgsConstructor

public class Station {

	 private float id;
	 private String stationName;
	 private float availableDocks;
	 private float totalDocks;
	 private float latitude;
	 private float longitude;
	 private String statusValue;
	 private float statusKey;
	 private float availableBikes;
	 private String stAddress1;
	 private String stAddress2;
	 private String city;
	 private String postalCode;
	 private String location;
	 private String altitude;
	 private boolean testStation;
	 private String lastCommunicationTime;
	 private String landMark;
		 
	 
}
