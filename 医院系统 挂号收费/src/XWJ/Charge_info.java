package XWJ;

public class Charge_info {
	private Float registration;//挂号的费用
	private Float Doctor_fee;//医生的划价
	private Float Drug_fee;//药品的费用
	private Float Drug_sum;//总共的费用
	private Boolean Pay ;//     是否支付，已经支付为true 否则为false;
	
	public Charge_info(Float registration,Float Doctor_fee,Boolean Appoint)
	{   
		this.setAppoint_time(Appoint_time);
		this.setApp_office(App_office);
		this.setAppoint(Appoint);
	}
	
	public Float getRegistration() {
		return registration;
	}
	public void setRegistration(Float registration) {
		this.registration = registration;
	}
	public Float getDoctor_fee() {
		return Doctor_fee;
	}
	public void setDoctor_fee(Float doctor_fee) {
		Doctor_fee = doctor_fee;
	}
	public Float getDrug_fee() {
		return Drug_fee;
	}
	public void setDrug_fee(Float drug_fee) {
		Drug_fee = drug_fee;
	}
	public Float getDrug_sum() {
		return Drug_sum;
	}
	public void setDrug_sum(Float drug_sum) {
		Drug_sum = drug_sum;
	}
	public Boolean getPay() {
		return Pay;
	}
	public void setPay(Boolean pay) {
		Pay = pay;
	}

}
