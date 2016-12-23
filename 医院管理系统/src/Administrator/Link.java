package Administrator;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.sql.Connection;

import all_class.Account;
import all_class.Global_info;

public class Link {
	
	private static Account account;//´æ´¢±¾»úµÄÕËºÅ
	private static Global_info global_info;
	static int port=5000;
	public   Link(Account account) {
		// TODO Auto-generated constructor stub
	this.account=account;
	}

	public static Account getAccount() {
		return account;
	}

	public static void setAccount(Account account) {
		Link.account = account;
	}

	public static void Connection(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Socket socket=null;
				try {
					socket=new Socket("127.0.0.1",port);
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
					os.writeObject(account);
					os.flush();
					global_info=(Global_info)is.readObject();
					os.writeObject(global_info);
					os.flush();
					is.close();
					os.close();
					socket.close();
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

	public static Global_info getGlobal_info() {
		return global_info;
	}

	public static void setGlobal_info(Global_info global_info) {
		Link.global_info = global_info;
	}
	

}
