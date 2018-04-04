package com.vansec.location.domain;

/**
 * Gps坐标.
 * @author zhousd
 */
public class Gps {

	private String latitude = "";  // 纬度
	private String longitude = ""; // 经度
	
	public Gps() {
		super();
	}

	public String getLatitude() {
		return latitude;
	}

	public void setLatitude(String latitude) {
		this.latitude = latitude;
	}

	public String getLongitude() {
		return longitude;
	}

	public void setLongitude(String longitude) {
		this.longitude = longitude;
	}
}
