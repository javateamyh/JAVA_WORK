package Server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


import all_class.*;


public class Server {
	private static Global_info global_info;
	private static Global_info global_info_ad;
	private static  ArrayList<Account> account_list=new ArrayList<Account>();//存出账号信息
	private static  ArrayList<Drug_info> drug_list=new ArrayList<Drug_info>();//药品的信息
	private static ArrayList<Office> office_list=new ArrayList<Office>();
	static int port=5001;
	public static Global_info getGlobal_info() {
		return global_info;
	}
	public static void add_Account_list(Account account){
		account_list.add(account);
	}
	public ArrayList<Account> get_Account_list(){
		return account_list;
	}
	
	public static void add_Drug_list(Drug_info drug_info)
	{
		drug_list.add(drug_info);
	}
	
	public ArrayList<Drug_info> get_Drug_list(){
		return drug_list;
	}
	
	public static void add_Office_list(Office office)
	{
		office_list.add(office);
	}
	public ArrayList<Office> get_Office_list(){
		return office_list;
	}
	
	
	//初始化账号
	public static void Read_Account() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(".//账号信息.txt"));
		String str;
		while((str=br.readLine())!=null)//将账号信息读入ArrayList
		{
			 String[] group= str.split(" ");
			 Account account=new Account(group[0],group[1],Integer.parseInt(group[2]));
			 add_Account_list(account);
			
		}
		
		br.close();
	}
public static void Writer_global_info(Global_info global_info) throws IOException{
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
	public static void  Administrator(){
	
		new Thread(new Runnable() {
			
			@Override
			public void run() {
			
				// TODO Auto-generated method stub
				ServerSocket server=null;
				Socket socket=null;
				try {
					server=new ServerSocket(port);
					socket=server.accept();
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
			        os.writeObject(global_info);
			        os.flush();
			        global_info_ad=(Global_info) is.readObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}
	//初始化药品信息
	public static void Read_Drug() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(".//药品信息.txt"));
		String values;
		
		while((values=br.readLine())!=null)
		{
			String[]group=values.split(" ");
			Drug_info drug=new Drug_info(group[0],group[1],Float.parseFloat(group[2]),Integer.parseInt(group[3]));
			drug_list.add(drug);
			
		}
		br.close();
	}
	
	//初始化科室信息
	public static void Read_Office() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(".//科室信息.txt"));
		String values;
		
		while((values=br.readLine())!=null)
		{
			ArrayList<String> docter=new ArrayList<String>();
			String []group=values.split(" ");
			String name=group[0];
			float charge=Float.parseFloat(group[1]);
			for(int i=2;i<group.length;i++)
			{
				docter.add(group[i]);
			}
			Office office=new Office(name,docter,charge);
			add_Office_list(office);
		}
		
		
	}
	public static void getGlobal(){
		try {
			Read_Account();
			Read_Drug();
			Read_Office();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		 global_info=new Global_info(office_list, account_list, drug_list);
		
	}
	
	//服务器在线提供账号的检测
	public static void Check_count(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ServerSocket serverSocket=null;
				Socket socket=null;
				ObjectInputStream is=null;
				ObjectOutputStream os=null;
				try {
					serverSocket=new ServerSocket(port);
					socket=serverSocket.accept();
				
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
			        try {
						Account account=(Account) is.readObject();
						if (account.getFlag()==6||account.getFlag()==7) {
							Select_moduel();
						}
						else 
						{
							for(int i=0;i<global_info.getAccount_list().size();i++)
							{
								if(account.getID().equals(global_info.getAccount_list().get(i).getID()))
									if(account.getCode().equals(global_info.getAccount_list().get(i).getCode()))
									{
										
										Select_moduel();
									}
							}
						}
					
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
			        os.close();
					is.close();
					socket.close();
					serverSocket.close();
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	
	//根据客户端的信息来判别模块
	public static void Select_moduel(){
		
		new Thread(new Runnable() {
			Handel handel=new Handel(global_info);
		     
			public void run() {
				// TODO Auto-generated method stub
				
				ServerSocket serverSocket=null;
				Socket socket=null;
				ObjectInputStream is=null;
				ObjectOutputStream os=null;
				
				try {
					serverSocket=new ServerSocket(port);
					socket=serverSocket.accept();
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
			        try {
						Account account=(Account) is.readObject();
						if(account.getPass()==-1) 
					Thread.currentThread().stop();
						else //开始来选择模块
						{
							switch (account.getFlag()) {
							case 1: Administrator(); if(global_info_ad.equals(global_info)){
								global_info=global_info_ad;
								Writer_global_info(global_info);
							}
								break;
							case 2:handel.registration_Thread();handel.Charge_sum(); break;
							case 3:handel.docter_hander();break;
							case 4:handel.Druger_info(); break;
							case 5:  handel.statistic_Thread(); break;
							case 6:handel.register_Thread(); break;
							case 7 :handel.Screen_info();;   break;
							default:
								break;
							}
							
							
						}
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("类的对象转换错误");
					}
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}).start();
	}

	public static void main(String[] args) throws IOException {
		// TODO Auto-generated method stub
		getGlobal();//服务器的初始化
		Check_count();//一个线程专门用于账号的在线验证
		
		
	}

}
