package all_class;

import java.io.Serializable;

public class Account implements Serializable  {
	private String ID;//�����˺�
	private String Code;
	private int flag;//  0������Աд��  1������Ա��ȡ��Ϣ  2���շ���Ա 3��ҽ�� 4��ҩʦ 5�� Ժ��  6������ע�� 7:����Ļ��ʾ 
	private int pass;//-1��ʾ��֤ʧ�ܣ�����Ϊ��֤�ɹ�
	
	
	public int getPass() {
		return pass;
	}
	public void setPass(int pass) {
		this.pass = pass;
	}
	public Account(String ID,String Code,int flag){
		this.ID=ID;
		this.Code=Code;
		this.flag=flag;
		
	}
	public String getID() {
		return ID;
	}
	public void setID(String iD) {
		ID = iD;
	}
	public String getCode() {
		return Code;
	}
	public void setCode(String code) {
		Code = code;
	}
	public int getFlag() {
		return flag;
	}
	public void setFlag(int flag) {
		this.flag = flag;
	}
}
