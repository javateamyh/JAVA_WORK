package all_class;

import java.io.Serializable;

public class Appointment implements Serializable  {
	private int  Appoint_time;
	private Office App_office;
	private boolean Appoint;
	public int  getAppoint_time() {
		return Appoint_time;
	}
	public void setAppoint_time(int  appoint_time) {
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
