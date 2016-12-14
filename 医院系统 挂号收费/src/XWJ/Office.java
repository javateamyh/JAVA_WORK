package XWJ;

import java.util.ArrayList;
import java.util.Scanner;

public class Office {
	private  String Office_name;
	private  String Doctor;
	private  float Charge;
	
	public Office(String office_name,String Doctor,float charge)
	{   
		this.setOffice_name(Office_name);
		//this.Doctor(Doctor);
		this.setDoctor(Doctor);
		this.setCharge(Charge);
	}
	
	public void setDoctor(String doctor) {
		Doctor = doctor;
	}
	public String getOffice_name() {
		return Office_name;
	}
	public  void setOffice_name(String office_name) {
		Office_name = office_name;
	}
	public String getDocter_name() {
		return Doctor;
	}
	public float getCharge() {
		return Charge;
	}
	public void setCharge(float charge) {
		Charge = charge;
	}

}
