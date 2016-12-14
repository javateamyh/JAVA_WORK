package Server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import all_class.Case;

public class Handel {
	 private static ArrayList<Case> Register=new ArrayList<Case>();
	 
	 static int port=5000;
	 public static void add_register(Case register){
		{ Register.add(register);}
	 }
	 
	 
	 //关于病人门诊挂号收费模块
	public static void registration_Thread(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				ServerSocket server=null;
				Socket socket=null;
				try {
					server=new ServerSocket(5000);
					socket=server.accept();
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
			        os.writeObject(Register);
			        is.close();
			        os.close();
			        socket.close();
			        server.close();
			        Register.clear();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	 
	 //关于注册模块的处理
	public static void register_Thread(){
		new Thread(new Runnable(){

			@Override
			public void run() {
				// TODO Auto-generated method stub
				ServerSocket server=null;
				Socket socket=null;
				try {
					server=new ServerSocket(5000);
					socket=server.accept();
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
					try {
						Case patient=(Case)is.readObject();
						add_register(patient);	
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
			
		}).start();
	}
	

}

