package all_class;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.PublicKey;
import java.util.ArrayList;

public class TCP {
  //�ӷ�������ȡȫ�ֵ���Ϣ
	public static Global_info get_global_info(){
		Account account=new Account("tcp", "tcp", 110);
		Global_info global_info = null;
		try {
			Socket socket=new Socket(ipconfig.getHost(),ipconfig.getPort());
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			os.writeObject(account);
			os.flush();		
			os.writeObject(account);
			os.flush();
			//Կ��
			global_info=(Global_info)is.readObject();
			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("�޷���ȡȫ����Ϣ");
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
		ObjectInputStream is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
		os.writeObject(account);
		os.flush();	
		os.writeObject(account);
		os.flush();
		//Կ��
		os.writeObject(global_info);
		os.flush();
		
		os.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("�޷�д��ȫ����Ϣ");
	}
	
		
	}
	
	//��ȡ���б����ҺŶ�
	public static ArrayList<Case> GetCase_toReg(){
		ArrayList<Case> Case_list=null;
		Account account=new Account("tcp", "tcp", 112);
		Socket socket=null;
		try {
			socket = new Socket(ipconfig.getHost(),ipconfig.getPort());
			ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
			ObjectInputStream is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			os.writeObject(account);
			os.flush();
			os.writeObject(account);
			os.flush();
			//Կ��
			Case_list=(ArrayList<Case>)is.readObject();
			os.close();
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
			ObjectInputStream is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			os.writeObject(account);
			os.flush();
			os.writeObject(account);
			os.flush();
			//Կ��
			os.writeObject(cases);
			os.flush();
			os.close();
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
			ObjectInputStream is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			os.writeObject(account);
			os.flush();
		
			os.writeObject(account);
			os.flush();
			//Կ��
			Case_list=(ArrayList<Case>)is.readObject();
			os.close();
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
			ObjectInputStream is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));
			os.writeObject(account);
			os.flush();
			os.writeObject(account);
			os.flush();
			//Կ��
			os.writeObject(cases);
			os.flush();
			os.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		
	}
}
