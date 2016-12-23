package Server;

import java.io.BufferedInputStream;
import java.io.BufferedWriter;
import java.io.FileWriter;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.util.logging.Handler;

import all_class.Account;
import all_class.Drug_info;
import all_class.Global_info;
import all_class.Office;
import all_class.statistic_info;

public class ServerThread implements Runnable {
    
	private static Socket socket;
	private static Storage storage;
	
	private static Global_info global_info;
   private static Handel handel;
  public ServerThread(Socket client,Storage storage,Handel handel) {
	// TODO Auto-generated constructor stub
	  this.storage=storage;
	 this.socket=client;
	 this.global_info=Storage.getGlobal_info();
	 this.handel=handel;
}
	@Override
	public void run() {
		// TODO Auto-generated method stub
		
             Check_count(socket);
             try {
				socket.close();
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
            
             
	}
	
	public static void Check_count(Socket socket){//检查模块
		
		boolean flag=false;
		ObjectInputStream is=null;
		ObjectOutputStream os=null;
		try {
			is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
	       
	        try {
/*第一次接收客户端的内容	*/Account account=(Account) is.readObject();//接收账号 的检测
              os=new ObjectOutputStream(socket.getOutputStream());
				if(account.getFlag()>100)
				{
					Select_moduel(socket);
				}
				else
				{//用于初次的检测
					
					if (account.getFlag()==6||account.getFlag()==7) {
						
					account.setFlag(account.getFlag()+100);
/*第一次向客户端输出信息*/os.writeObject(account);//用于账号的验证
					os.flush();
					
					 Select_moduel(socket);
					}
					else
					{
						for(int i=0;i<global_info.getAccount_list().size();i++)
						{
							if(account.getID().equals(global_info.getAccount_list().get(i).getID()))
								if(account.getCode().equals(global_info.getAccount_list().get(i).getCode()))
								{
							         
									account.setFlag(global_info.getAccount_list().get(i).getFlag()+100); 
									break;
								}
						}//进行验证
						
						if(account.getFlag()>100)
						{
							os.writeObject(account);//第一次成功验证
							os.flush();
				//进入操作页面			
							 Select_moduel(socket);
							
						}
						else {//验证失败
							account.setFlag(-1);
							os.writeObject(account);
							os.flush();
						}
						
					}
				}
				
				} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        os.close();
			is.close();
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void Select_moduel(Socket socket){//选择模块
		
		ObjectInputStream is=null;
		ObjectOutputStream os=null;
		
		try {
			
			is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
	        
	       
	        try {
				Account account=(Account) is.readObject();
				if(account.getFlag()==-1) 
			Thread.currentThread().stop();
				else //开始来选择模块
				{
					switch (account.getFlag()-100) {
					case 0: Adminstrator_get(socket);break;//服务器获取信息并且写回
					case 1: Administrator_send(socket);//服务器发送信息
						break;
					case 2:handel.registration_Thread();
					       handel.Charge_sum(); break;
					case 3:handel.docter_hander();break;//医生划价
					case 4:handel.Druger_info(); break;
					case 5:handel.statistic_Thread(); break;
					case 6:handel.register_Thread(); break;//病人的注册
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
	public static void  Administrator_send(Socket socket){
		
		try {
			
			ObjectOutputStream os=null;
	        os=new ObjectOutputStream(socket.getOutputStream());
	        os.writeObject(global_info);
	        os.flush();
	
	    
	      
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		

}

	 public static void Adminstrator_get(Socket socket){//获得新的数据

			
			try {
	
	ObjectInputStream is=null;
	ObjectOutputStream os=null;
	is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
global_info=(Global_info)is.readObject();
		
		storage.setGlobal_info(global_info);
		storage.Writer_global_info();
	


} catch (IOException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
} catch (ClassNotFoundException e) {
	// TODO Auto-generated catch block
	e.printStackTrace();
}


}

}
