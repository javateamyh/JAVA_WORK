package all_class;

import java.util.ArrayList;

public class statistic_info {
	ArrayList<Drug_info>Drug_list;  //系统的药品库存
	  String[] Count_name;//科室的名字
		int[] Count_office;//科室的挂号数
		float[] Sum_office;//科室的收费总数
	public statistic_info(ArrayList<Drug_info>Drug_list, String[] Count_name,int[] Count_office	,float[] Sum_office){
		this.Drug_list=Drug_list;
		this.Count_name=Count_name;
		this.Count_office=Count_office;
		this.Sum_office=Sum_office;
	}
	public ArrayList<Drug_info> getDrug_list() {
		return Drug_list;
	}
	public void setDrug_list(ArrayList<Drug_info> drug_list) {
		Drug_list = drug_list;
	}
	public String[] getCount_name() {
		return Count_name;
	}
	public void setCount_name(String[] count_name) {
		Count_name = count_name;
	}
	public int[] getCount_office() {
		return Count_office;
	}
	public void setCount_office(int[] count_office) {
		Count_office = count_office;
	}
	public float[] getSum_office() {
		return Sum_office;
	}
	public void setSum_office(float[] sum_office) {
		Sum_office = sum_office;
	}
}
