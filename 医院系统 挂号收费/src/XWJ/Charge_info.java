package XWJ;

public class Charge_info {
	private Float registration;//�Һŵķ���
	private Float Doctor_fee;//ҽ���Ļ���
	private Float Drug_fee;//ҩƷ�ķ���
	private Float Drug_sum;//�ܹ��ķ���
	private Boolean Pay ;//     �Ƿ�֧�����Ѿ�֧��Ϊtrue ����Ϊfalse;
	
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
