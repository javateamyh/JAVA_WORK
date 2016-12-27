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

import javax.swing.plaf.SliderUI;

import all_class.*;


public class Server {
	private static Global_info global_info;
	private static Global_info global_info_ad;
	private static  ArrayList<Account> account_list=new ArrayList<Account>();//存出账号信息
	private static  ArrayList<Drug_info> drug_list=new ArrayList<Drug_info>();//药品的信息
	private static ArrayList<Office> office_list=new ArrayList<Office>();
	static boolean flag=false;
	static int count=0;
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
		String str=null;
		while((str=br.readLine())!=null)//将账号信息读入ArrayList
		{
			 String[] group= str.split(" ");
			 Account account=new Account(group[0],group[1],Integer.parseInt(group[2]));
			 add_Account_list(account);
			
		}
		
		br.close();
	}


	
	//初始化药品信息
	public static void Read_Drug() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(".\\药品信息.txt"));
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
		BufferedReader br=new BufferedReader(new FileReader(".\\科室信息.txt"));
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
	

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		getGlobal();//服务器的初始化
		Storage storage=new Storage(global_info);
		ServerSocket serverSocket=null;
		
		while(true)
		{
			Socket client=null;
			System.out.println("服务器运行成功！");
             try {
				serverSocket =new ServerSocket(ipconfig.getPort());
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
				System.exit(-1);
			}
             try {
				client=serverSocket.accept();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
				System.out.println("客户端接收异常");
			}
          Handel handel=new Handel(storage,client);
          ServerThread serverThread=new ServerThread(client, storage, handel);
          Thread thread=new Thread(serverThread);
          thread.start();
          try {
        	  //Thread.currentThread().sleep(50000);
             serverSocket.close();   	 
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
          System.out.println("服务器关闭");
	
		}	
		
	
		
		
	}

}
