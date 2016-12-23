package Server;

import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;

import all_class.Account;
import all_class.Drug_info;
import all_class.Global_info;
import all_class.Office;
import all_class.statistic_info;

public class Storage {
	private static Global_info global_info;

	public Storage(Global_info global_info){
		this.global_info=global_info;
	}

	public static Global_info getGlobal_info() {
		return global_info;
	}

	public static void setGlobal_info(Global_info global_info) {
		Storage.global_info = global_info;
	}

	
	public static void Writer_global_info() throws IOException{
		ArrayList<Account>accounts=global_info.getAccount_list();
		ArrayList<Office>offices=global_info.getCount_office();
		ArrayList<Drug_info>drug=global_info.getDrug_list();
		BufferedWriter bu_account=new BufferedWriter(new FileWriter(".//账号信息.txt"));
		int i;
		String values;
		for(i=0;i<accounts.size();i++)
		{
			values=accounts.get(i).getID();
			values+=" "+accounts.get(i).getCode();
			values+=" "+accounts.get(i).getFlag()+"\r\n";
			bu_account.write(values);
		}
		BufferedWriter bu_drug=new BufferedWriter(new FileWriter(".//药品信息.txt"));
		for(i=0;i<drug.size();i++)
		{
			values=drug.get(i).getDrug_name();
			values+=" "+drug.get(i).getDrug_pinyin();
			values+=" "+drug.get(i).getDrug_price();
			values+=" "+drug.get(i).getDrug_count()+"\r\n";
			bu_drug.write(values);
		}
		int j;
		BufferedWriter bu_office=new BufferedWriter(new FileWriter(".//科室信息.txt"));
		
		for(i=0;i<offices.size();i++)
		{
			values=offices.get(i).getOffice_name();
			values+=" "+String.valueOf(offices.get(i).getCharge()) ;
			for(j=0;j<offices.get(i).getDoctor().size();j++)
			{
				values+=" "+offices.get(i).getDoctor().get(j)+"\r\n";
				
			}
			bu_office.write(values);
		}
		
	}

}
