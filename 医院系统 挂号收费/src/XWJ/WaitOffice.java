package XWJ;

import java.util.ArrayList;

import all_class.Account;

public class WaitOffice {
	private String Office_name;//��������
	private ArrayList <Waiter> Wait_Doc;//�������Ŷӵ�ҽ������
	private int waitnumber;//�������Ŷ�����

	public String getOffice_name() {
		return Office_name;
	}

	public void setOffice_name(String office_name) {
		Office_name = office_name;
	}

	public ArrayList <Waiter> getWait_Doc() {
		return Wait_Doc;
	}

	public void setWait_Doc(ArrayList <Waiter> wait_Doc) {
		Wait_Doc = wait_Doc;
	}

	public int getWaitnumber() {
		return waitnumber;
	}

	public void setWaitnumber(float sum_off) {
		this.waitnumber = (int) sum_off;
	}
}
