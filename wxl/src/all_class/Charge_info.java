package all_class;

import java.io.Serializable;

public class Charge_info implements Serializable {
	private float Registration_fee;//挂号的费用
	private float Docter_fee;
	private float Drug_fee;//药品的费用
	private float Sum_fee;
	boolean Pay;
	public float getRegistration_fee() {
		return Registration_fee;
	}
	public void setRegistration_fee(float registration_fee) {
		Registration_fee = registration_fee;
	}
	public float getDocter_fee() {
		return Docter_fee;
	}
	public void setDocter_fee(float docter_fee) {
		Docter_fee = docter_fee;
	}
	public float getDrug_fee() {
		return Drug_fee;
	}
	public void setDrug_fee(float drug_fee) {
		Drug_fee = drug_fee;
	}
	public float getSum_fee() {
		return Sum_fee;
	}
	public void setSum_fee(float sum_fee) {
		Sum_fee = sum_fee;
	}
	public boolean isPay() {
		return Pay;
	}
	public void setPay(boolean pay) {
		Pay = pay;
	}

}
