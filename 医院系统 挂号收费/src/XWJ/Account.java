package XWJ;

public abstract class Account {
	String ID;
	String Code;
	int flag;  //代表权限的控制 1：管理员 2：收费人员 3：医生 4：药师 5： 院长
}
