package all_class;

import java.io.Serializable;

public class Account implements Serializable  {
	private String ID;//À˘”–’À∫≈
	private String Code;
	private int flag;//
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
