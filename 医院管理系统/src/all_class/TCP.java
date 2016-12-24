package all_class;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.PublicKey;
import java.util.ArrayList;

public class TCP {
	private static Global_info global_info;
	private static Socket socket;
	private static Account account;//��ͷ
	
  //�ӷ�������ȡȫ�ֵ���Ϣ
	public static Global_info get_global_info(){
		Account account=new Account("tcp", "tcp", 110);
		try {
			Socket socket=new Socket(ipconfig.getHost(),ipconfig.getPort());
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(account);
			os.flush();
			ObjectOutputStream os1=new ObjectOutputStream(socket.getOutputStream());
			os1.writeObject(account);
			os1.flush();
			//Կ��
			ObjectInputStream is=null;
			is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			global_info=(Global_info)is.readObject();
			is.close();
			os.close();
			os1.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("û�з�����");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("global_info��ȡʧ��");
		}
		
		return global_info;
	}
	
//д��ȫ����Ϣ
	public static void set_global_info(Global_info global_info){
	Account account=new Account("tcp", "tcp", 111);
	Socket socket=null;
	try {
		socket = new Socket(ipconfig.getHost(),ipconfig.getPort());
		ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
		os.writeObject(account);
		os.flush();
		ObjectOutputStream os1=new ObjectOutputStream(socket.getOutputStream());
		os1.writeObject(account);
		os1.flush();
		//Կ��
		ObjectOutputStream os2=new ObjectOutputStream(socket.getOutputStream());
		os2.writeObject(global_info);
		os2.flush();
		os.close();
		os1.close();
		os2.close();
		socket.close();
		
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	
		
	}
	
	//��ȡ���б����ҺŶ�
	public static ArrayList<Case> GetCase_toReg(){
		ArrayList<Case> Case_list=new ArrayList<Case>();
		Account account=new Account("tcp", "tcp", 112);
		Socket socket=null;
		try {
			socket = new Socket(ipconfig.getHost(),ipconfig.getPort());
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(account);
			os.flush();
			ObjectOutputStream os1=new ObjectOutputStream(socket.getOutputStream());
			os1.writeObject(account);
			os1.flush();
			//Կ��
			ObjectInputStream is=null;
			is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			Case_list=(ArrayList<Case>)is.readObject();
			os.close();
			os1.close();
			is.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�޷���ȡ�б���Ϣ");
		}
		return Case_list;
	}
	//���ҺŶε��б��ϴ���������
	public static void SetCase_toDocter(ArrayList<Case> cases){
		Account account=new Account("tcp", "tcp", 113);
		Socket socket=null;
		try {
			socket = new Socket(ipconfig.getHost(),ipconfig.getPort());
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(account);
			os.flush();
			ObjectOutputStream os1=new ObjectOutputStream(socket.getOutputStream());
			os1.writeObject(account);
			os1.flush();
			//Կ��
			ObjectOutputStream os2=new ObjectOutputStream(socket.getOutputStream());
			os2.writeObject(cases);
			os2.flush();
			os.close();
			os1.close();
			os2.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//��ҽ���˻���۵ĵ��Ÿ��շѶ�
	public static ArrayList<Case> GetCase_toCharge(){
		ArrayList<Case> Case_list=new ArrayList<Case>();
		Account account=new Account("tcp", "tcp", 116);
		Socket socket=null;
		
		try {
			socket = new Socket(ipconfig.getHost(),ipconfig.getPort());
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(account);
			os.flush();
			ObjectOutputStream os1=new ObjectOutputStream(socket.getOutputStream());
			os1.writeObject(account);
			os1.flush();
			//Կ��
			ObjectInputStream is=null;
			is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			Case_list=(ArrayList<Case>)is.readObject();
			os.close();
			os1.close();
			is.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("�޷���ȡ�б���Ϣ");
		}
		return Case_list;
	
		
	}
	
	//���շ���ɵı���ҩ��
	public static void setCase_toStore(ArrayList<Case> cases){
		Account account=new Account("tcp", "tcp", 118);
		Socket socket=null;
		try {
			socket = new Socket(ipconfig.getHost(),ipconfig.getPort());
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			os.writeObject(account);
			os.flush();
			ObjectOutputStream os1=new ObjectOutputStream(socket.getOutputStream());
			os1.writeObject(account);
			os1.flush();
			//Կ��
			
			ObjectOutputStream os2=new ObjectOutputStream(socket.getOutputStream());
			os2.writeObject(cases);
			os2.flush();
			os.close();
			os1.close();
			os2.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
