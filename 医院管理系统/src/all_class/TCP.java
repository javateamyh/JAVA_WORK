package all_class;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.security.PublicKey;
import java.util.ArrayList;

public class TCP {
  //从服务器获取全局的信息
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
			//钥匙
			global_info=(Global_info)is.readObject();
			is.close();
			os.close();
			socket.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			System.out.println("无法获取全局信息");
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("global_info获取失败");
		}
		
		return global_info;
	}
	
//写入全局信息
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
		//钥匙
		os.writeObject(global_info);
		os.flush();
		
		os.close();
		socket.close();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
		System.out.println("无法写入全局信息");
	}
	
		
	}
	
	//获取到列表单给挂号端
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
			//钥匙
			Case_list=(ArrayList<Case>)is.readObject();
			os.close();
			is.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("无法获取列表信息");
		}
		return Case_list;
	}
	//将挂号段的列表上传到服务器
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
			//钥匙
			os.writeObject(cases);
			os.flush();
			os.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	//将医生端划完价的单号给收费端
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
			//钥匙
			Case_list=(ArrayList<Case>)is.readObject();
			os.close();
			is.close();
			socket.close();
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("无法获取列表信息");
		}
		return Case_list;
	
		
	}
	
	//将收费完成的表单给药房
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
			//钥匙
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
