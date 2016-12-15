package all_class;

import java.io.Serializable;
import java.util.HashMap;

public class Case implements Serializable {
   private Patient_info Pi;//个人的信息
   
   
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
public HashMap getDrug_ha() {
	return Drug_ha;
}
public void setDrug_ha(HashMap drug_ha) {
	Drug_ha = drug_ha;
}
public Charge_info getCharge() {
	return Charge;
}
public void setCharge(Charge_info charge) {
	Charge = charge;
}
private Appointment App;//预约的信息
   private HashMap Drug_ha;//药品的类以及数量
   private Charge_info Charge;//收费信息
}
