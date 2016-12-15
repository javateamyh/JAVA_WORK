package all_class;

import java.io.Serializable;

public class Office implements Serializable {
	private String Office_name;
	private String Docter_name;
	public String getOffice_name() {
		return Office_name;
	}
	public void setOffice_name(String office_name) {
		Office_name = office_name;
	}
	public String getDocter_name() {
		return Docter_name;
	}
	public void setDocter_name(String docter_name) {
		Docter_name = docter_name;
	}
}
