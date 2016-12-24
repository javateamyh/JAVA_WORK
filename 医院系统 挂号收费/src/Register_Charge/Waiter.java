package Register_Charge;
import java.util.ArrayList;

import all_class.*;
public class Waiter {
	private String Doctor_name;
	private ArrayList<Case> waiting;//相应医生后面的排队
	
	public String getDoctor_name() {
		return Doctor_name;
	}
	public void setDoctor_name(String doctor_name) {
		Doctor_name = doctor_name;
	}
	public ArrayList<Case> getWaiting() {
		return waiting;
	}
	public void setWaiting(ArrayList<Case> waiting) {
		this.waiting = waiting;
	}
	
}
