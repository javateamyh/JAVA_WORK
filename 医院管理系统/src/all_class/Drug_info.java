package all_class;

import java.io.Serializable;


public class Drug_info implements Serializable {
	private String Drug_name;
	private String Drug_pinyin;//ҩƷ��ƴ������
	private float Drug_price;
	private int Drug_count;//��ҩƷ������(�������)
	private int Drug_use;//ҽ������ҩ������
	
	public int getDrug_use() {
		return Drug_use;
	}

	public void setDrug_use(int drug_use) {
		Drug_use = drug_use;
	}

	public Drug_info(String name,String pinyin,float price ,int count) {
	Drug_name=name;
	Drug_pinyin=pinyin;
	Drug_price=price;
	Drug_count=count;
		
	}
	
	public int getDrug_count() {
		return Drug_count;
	}

	public void setDrug_count(int drug_count) {
		Drug_count = drug_count;
	}

	public void setDrug_price(float drug_price) {
		Drug_price = drug_price;
	}

	public String getDrug_name() {
		return Drug_name;
	}
	public void setDrug_name(String drug_name) {
		Drug_name = drug_name;
	}
	public String getDrug_pinyin() {
		return Drug_pinyin;
	}
	public void setDrug_pinyin(String drug_pinyin) {
		Drug_pinyin = drug_pinyin;
	}
	public Float getDrug_price() {
		return Drug_price;
	}
	public void setDrug_price(Float drug_price) {
		Drug_price = drug_price;
	}
}
