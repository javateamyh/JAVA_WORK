package all_class;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.HashMap;

public class Global_info implements Serializable {
private ArrayList<Office> Count_office;//���п��ҵ�����
private ArrayList <Account> Account_list;//�˺ŵ�����
private ArrayList<Drug_info> Drug_list;//ҩƷ������
public Global_info( ArrayList<Office> Count_office,ArrayList<Account> Account_list,ArrayList<Drug_info>Drug_list){
	this.Count_office=Count_office;
	this.Account_list=Account_list;
	this.Drug_list=Drug_list;
}
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
