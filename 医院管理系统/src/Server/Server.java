package Server;

import java.io.BufferedInputStream;
import java.io.BufferedReader;

import java.io.FileReader;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;


import all_class.*;


public class Server {
	private static Global_info global_info;
	private static  ArrayList<Account> account_list=new ArrayList<Account>();//����˺���Ϣ
	private static  ArrayList<Drug_info> drug_list=new ArrayList<Drug_info>();//ҩƷ����Ϣ
	private static ArrayList<Office> office_list=new ArrayList<Office>();
	static int port=5000;
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
	
	
	//��ʼ���˺�
	public static void Read_Account() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(".//�˺���Ϣ.txt"));
		String str;
		while((str=br.readLine())!=null)//���˺���Ϣ����ArrayList
		{
			 String[] group= str.split(" ");
			 Account account=new Account(group[0],group[1],Integer.parseInt(group[2]));
			 add_Account_list(account);
			
		}
		
		br.close();
	}
	
	
	//��ʼ��ҩƷ��Ϣ
	public static void Read_Drug() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(".//ҩƷ��Ϣ.txt"));
		String values;
		
		while((values=br.readLine())!=null)
		{
			String[]group=values.split(" ");
			Drug_info drug=new Drug_info(group[0],group[1],Float.parseFloat(group[2]),Integer.parseInt(group[3]));
			drug_list.add(drug);
			
		}
		br.close();
	}
	
	//��ʼ��������Ϣ
	public static void Read_Office() throws IOException{
		BufferedReader br=new BufferedReader(new FileReader(".//������Ϣ.txt"));
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
	
	//�����������ṩ�˺ŵļ��
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
						for(int i=0;i<global_info.getAccount_list().size();i++)
						{
							if(account.getID().equals(global_info.getAccount_list().get(i).getID()))
								if(account.getCode().equals(global_info.getAccount_list().get(i).getCode()))
								{
									account.setPass(-1);
									os.writeObject(account);
									os.flush();
									
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
	
	
	//���ݿͻ��˵���Ϣ���б�ģ��
	public static void Select_moduel(){
		
		new Thread(new Runnable() {
			Handel handel=new Handel();
			@SuppressWarnings("deprecation")
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
						if(account.getPass()==-1) 
					Thread.currentThread().stop();
						else //��ʼ��ѡ��ģ��
						{
							switch (account.getFlag()) {
							case 1:
								break;
							case 2:handel.registration_Thread(); break;
							case 3:
								break;
							case 4: break;
							case 5:break;
							case 6: break;
							case 7 :handel.register_Thread();   break;
					
							
							default:
								break;
							}
							
							
						}
						
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
						System.out.println("��Ķ���ת������");
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
		getGlobal();//�������ĳ�ʼ��
		Check_count();//һ���߳�ר�������˺ŵ�������֤
		
	    
		
	}

}
