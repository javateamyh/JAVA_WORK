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
import all_class.Case;
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
		
	
		ObjectInputStream is=null;
		ObjectOutputStream os=null;
		try {
			is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			 os=new ObjectOutputStream(socket.getOutputStream());
	        try {
/*第一次接收客户端的内容	*/Account account=(Account) is.readObject();//接收账号 的检测   
                
				if(account.getFlag()>100)
				{
					Select_moduel(is,os,socket);
				}
				else
				{//用于初次的检测
					
					if (account.getFlag()==6||account.getFlag()==7) {
						
					account.setFlag(account.getFlag()+100);
/*第一次向客户端输出信息*/os.writeObject(account);//用于账号的验证
					os.flush();
					 Select_moduel(is,os,socket);
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
							 Select_moduel(is,os,socket);
							
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
	     
		
			
			
			
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
	}
	
	
	public static void Select_moduel( ObjectInputStream is,ObjectOutputStream os,Socket socket){//选择模块
		try {
			
	        try {
	        
				Account account=(Account) is.readObject();
				if(account.getFlag()==-1) 
			Thread.currentThread().stop();
				else //开始来选择模块
				{
					switch (account.getFlag()-100) {
					case 1://服务器发送信息
						break;
					case 2://发送到挂号收费端 (使用了协议)
					      break;
					case 3:handel.docter_hander(is,os);break;//医生划价
					case 4:handel.Druger_info(is,os); break;//药房段
					case 5:handel.statistic_Thread(is,os); break;//统计信息的发送
					case 6:handel.register_Thread(is,os); break;//病人的注册
					case 7 :handel.Screen_info(is,os);  break;		
	                case 10: handel.get_global_Thread(is,os);   break;/*发送通讯协议部分专门用于获取服务器的全局信息*/
	                case 11:handel.set_global_Thread(is,os);    break;//接收全局变量
	                case 12: handel.get_Register(is,os);       break;//发送注册的人员名单
	                case 13:handel.get_Case_to_Docter(is,os); break;//发送等待医生处理表单
	                case 14: handel.set_Register_docter(is,os);  break;//接收等待医生处理的表单
	                case 15:handel.set_Register_get_Drug(is,os); break;//接收等待药方处理的表单
	                case 16:handel.get_Register_Charged(is,os);  break;//发送给挂号端的表单
	                case 18:handel.get_Register_get_Drug(is,os); break;//发送给药房端的表单
					
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
			System.out.println("无法与客户端连接");
		}
		
		
		try {
			os.close();
			is.close();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
			System.out.println("数据关闭异常");
		}
	

}
	

}
