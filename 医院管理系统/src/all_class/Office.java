package all_class;

import java.io.Serializable;
import java.util.ArrayList;

public class Office implements Serializable {
	private String Office_name;
	private ArrayList<String> Doctor;
	float Charge;
	
	
	public Office(String name,ArrayList<String>Docter,float Charge){
		this.Office_name=name;
		this.Doctor=Docter;
		this.Charge=Charge;
		
	}
	
	public float getCharge() {
		return Charge;
	}

	public void setCharge(float charge) {
		Charge = charge;
	}

	public ArrayList<String> getDoctor() {
		return Doctor;
	}

	public void setDoctor(ArrayList<String> doctor) {
		Doctor = doctor;
	}
	public String getOffice_name() {
		return Office_name;
	}
	public void setOffice_name(String office_name) {
		Office_name = office_name;
	}
	public ArrayList<String> getDocter_name() {
		return Doctor;
	}
	
}
