package XWJ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

	public class Case  {
	   private Patient_info Pi;//个人的信息
	   private Appointment App;//预约的信息
	   private ArrayList<Drug_info> Drug_list;//药品的类以及数量
	   private Charge_info Charge;//收费信息
	   public Patient_info getPi() {
	   return Pi;
	}
	   
	public void setPi(Patient_info pi) {
		Pi = pi;
	}
	public Appointment getApp() {
		return App;
	}
	public void setApp(Appointment app) {
		App = app;
	}

	public ArrayList<Drug_info> getDrug_list() {
		return Drug_list;
	}

	public void setDrug_list(ArrayList<Drug_info> drug_list) {
		Drug_list = drug_list;
	}

	public Charge_info getCharge() {
		return Charge;
	}
	public void setCharge(Charge_info charge) {
		Charge = charge;
	}

	}

