package all_class;

import java.io.Serializable;

public class Appointment implements Serializable  {
	private String Appoint_time;//预约的时间
	private Office App_office;//预约的科室
	private boolean Appoint;//是否预约
	public String getAppoint_time() {
		return Appoint_time;
	}
	public void setAppoint_time(String appoint_time) {
		Appoint_time = appoint_time;
	}
	public Office getApp_office() {
		return App_office;
	}
	public void setApp_office(Office app_office) {
		App_office = app_office;
	}
	public boolean isAppoint() {
		return Appoint;
	}
	public void setAppoint(boolean appoint) {
		Appoint = appoint;
	}
}
