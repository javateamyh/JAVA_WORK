package all_class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Global_info implements Serializable {
private ArrayList<Office> Count_office;//所有科室的数组
private ArrayList <Account> Account_list;//账号的数组
private ArrayList<Drug_info> Drug_list;//药品的数量
public ArrayList<Office> getCount_office() {
	return Count_office;
}
public void setCount_office(ArrayList<Office> count_office) {
	Count_office = count_office;
}
public ArrayList<Account> getAccount_list() {
	return Account_list;
}
public void setAccount_list(ArrayList<Account> account_list) {
	Account_list = account_list;
}
public ArrayList<Drug_info> getDrug_list() {
	return Drug_list;
}
public void setDrug_list(ArrayList<Drug_info> drug_list) {
	Drug_list = drug_list;
}

}
