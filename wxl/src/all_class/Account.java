package all_class;

import java.io.Serializable;

public class Account implements Serializable  {
	private String ID;//所有账号
	private String Code;
	private int flag;//  0：管理员写回  1：管理员获取信息  2：收费人员 3：医生 4：药师 5： 院长  6：病人注册 7:大屏幕显示 
	private int pass;//-1表示验证失败，否则为验证成功
	
	
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
