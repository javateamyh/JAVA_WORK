package XWJ;

import java.util.LinkedList;

public class Appointment {
	private String Appoint_time; //ԤԼʱ��
	private Office App_office;//ԤԼ�Ŀ���
	private Boolean Appoint;   //ԤԼΪtrue û��Ϊfalse
	
	public Appointment(String Appoint_time,Office App_office,Boolean Appoint)
	{   
		this.setAppoint_time(Appoint_time);
		this.setApp_office(App_office);
		this.setAppoint(Appoint);
	}
	
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

	public Boolean getAppoint() {
		return Appoint;
	}

	public void setAppoint(Boolean appoint) {
		Appoint = appoint;
	}
}
