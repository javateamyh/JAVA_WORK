package XWJ;
import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

	public class Case  {
	   private Patient_info Pi;//���˵���Ϣ
	   private Appointment App;//ԤԼ����Ϣ
	   private ArrayList<Drug_info> Drug_list;//ҩƷ�����Լ�����
	   private Charge_info Charge;//�շ���Ϣ
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

