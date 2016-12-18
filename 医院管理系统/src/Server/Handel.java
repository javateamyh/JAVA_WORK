package Server;

import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

import all_class.Case;
import all_class.Drug_info;
import all_class.Global_info;
import all_class.statistic_info;

public class Handel {
	public static Global_info global_info;
	
	 private static ArrayList<Case> Register=new ArrayList<Case>();//给挂号人员的
	 private static ArrayList<Case> Register_to_Docter=new ArrayList<Case>();//给医生的信息
	 private static ArrayList<Case> Register_Charged=new ArrayList<Case>();//用于挂号端的收费
	 private static ArrayList<Case> Register_get_Drug=new ArrayList<Case>();//用于药房端
	 static int port=5000;
	 
	 
	 public  Handel(Global_info go) {
		global_info=go;
	}
	 
	 //关于病人门诊挂号收费模块，同时接收处理后的信息
	public static void registration_Thread(){
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
			        os.writeObject(Register);
			        Register.clear(); 
			      try {
					Register_to_Docter.addAll((ArrayList<Case>) is.readObject());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      
			        
			        is.close();
			        os.close();
			        socket.close();
			        server.close();
			      
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	   //关于医生模块
	
	public static void docter_hander(){
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
					os.writeObject(Register_to_Docter);
					os.flush();
					Register_to_Docter.clear();
					try {
						Register_Charged.addAll((ArrayList<Case>)is.readObject());
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
	//大屏幕显示信息
	public static void Screen_info(){
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
					os.writeObject(Register_to_Docter);
					os.flush();
					Register_to_Docter.clear();
			is.close();
			os.close();
			socket.close();
			server.close();
					
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
					server=new ServerSocket(port);
					socket=server.accept();
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
					try {
						Case patient=(Case)is.readObject();
						Register.add(patient);	
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
//关于收费信息
public static void Charge_sum(){
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
		        os.writeObject(Register_Charged);
		        os.flush();
		        Register_Charged.clear();
		        try {
					Register_get_Drug.addAll((ArrayList<Case>)is.readObject());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		        is.close();
		        os.close();
		        socket.close();
		        server.close();
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}).start();
}

	public static void Druger_info(){//给药房端的信息
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
			        os.writeObject(Register_get_Drug);
			        os.flush();
			        is.close();
			        os.close();
			        socket.close();
			        server.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
			}
		}).start();
	}
	public  static void  statistic_Thread() {  //返回统计信息
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
			        statistic_info sa=Statistic_info();
			        os.writeObject(sa);
			        os.flush();
			        is.close();
			        os.close();
			        server.close();
			        socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
		}).start();
		
	}
	
	public static statistic_info Statistic_info(){//统计信息
		
		ArrayList<Drug_info>Drug_list=new ArrayList<Drug_info>();
        String[] Count_name=new String[global_info.getCount_office().size()];
		int[] Count_office=new int[global_info.getCount_office().size()];//科室的病人数
		float[] Sum_office=new float[global_info.getCount_office().size()];//科室的营业额
			for(int j=0;j<Register_Charged.size();j++)
			{
				for(int i=0;i<global_info.getCount_office().size();i++)
				{
					if(Register_Charged.get(j).getApp().getApp_office().equals(global_info.getCount_office().get(i).getOffice_name()))
					{
						Count_office[i]++;
						Sum_office[i]+=Register_Charged.get(j).getCharge().getDocter_fee();
						
					}
				}
			}
			
		for( int i=0;i<global_info.getCount_office().size();i++)
		{
			Count_name[i]=global_info.getCount_office().get(i).getOffice_name();
		}
			
		statistic_info sa=new statistic_info(Drug_list, Count_name, Count_office, Sum_office);
		return  sa;
		
	}

}

