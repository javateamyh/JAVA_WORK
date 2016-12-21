package XWJ;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.util.ArrayList;

import all_class.Account;
import all_class.Case;
import all_class.Global_info;

public class Linking {
	private static Account account;
	private static Global_info info;
	private static ArrayList<Case> RegisterDocter;//给医生的信息
	public   Linking(Account account) {
		// TODO Auto-generated constructor stub
	this.account=account;
	}

	public static void Connection(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Socket socket=null;
				try {
					socket=new Socket("127.0.0.1",5000);
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
					os.writeObject(account);
					os.flush();
					info=(Global_info)is.readObject();
					RegisterDocter=((ArrayList<Case>)is.readObject());
					os.writeObject(info);
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

	public static Account getAccount() {
		return account;
	}

	public static void setAccount(Account account) {
		Linking.account = account;
	}

	public static Global_info getInfo() {
		return info;
	}

	public static void setInfo(Global_info info) {
		Linking.info = info;
	}

	public static ArrayList<Case> getRegisterDocter() {
		return RegisterDocter;
	}

	public static void setRegisterDocter(ArrayList<Case> registerDocter) {
		RegisterDocter = registerDocter;
	}

}
