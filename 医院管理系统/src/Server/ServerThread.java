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
	
	public static void Check_count(Socket socket){//���ģ��
		
	
		ObjectInputStream is=null;
		ObjectOutputStream os=null;
		try {
			is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
	       
	        try {
/*��һ�ν��տͻ��˵�����	*/Account account=(Account) is.readObject();//�����˺� �ļ��   
                     
				if(account.getFlag()>100)
				{
					Select_moduel(socket);
				}
				else
				{//���ڳ��εļ��
					 os=new ObjectOutputStream(socket.getOutputStream());
					if (account.getFlag()==6||account.getFlag()==7) {
						
					account.setFlag(account.getFlag()+100);
/*��һ����ͻ��������Ϣ*/os.writeObject(account);//�����˺ŵ���֤
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
						}//������֤
						
						if(account.getFlag()>100)
						{
							os.writeObject(account);//��һ�γɹ���֤
							os.flush();
				//�������ҳ��			
							 Select_moduel(socket);
							
						}
						else {//��֤ʧ��
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
	
	
	public static void Select_moduel(Socket socket){//ѡ��ģ��
		ObjectInputStream os=null;
		ObjectInputStream is=null;	
		try {
			is=new ObjectInputStream(new BufferedInputStream(socket.getInputStream()));  
	        try {
				Account account=(Account) is.readObject();
				if(account.getFlag()==-1) 
			Thread.currentThread().stop();
				else //��ʼ��ѡ��ģ��
				{
					switch (account.getFlag()-100) {
					case 0: Adminstrator_get(socket);break;//��������ȡ��Ϣ����д��
					case 1: Administrator_send(socket);//������������Ϣ
						break;
					case 2:handel.registration_Thread();//���͵��Һ��շѶ�
					       handel.Charge_sum(); break;
					case 3:handel.docter_hander();break;//ҽ������
					case 4:handel.Druger_info(); break;//ҩ����
					case 5:handel.statistic_Thread(); break;
					case 6:handel.register_Thread(); break;//���˵�ע��
					case 7 :handel.Screen_info();  break;
					
	                case 10: handel.get_global_Thread();   break;/*����ͨѶЭ�鲿��ר�����ڻ�ȡ��������ȫ����Ϣ*/
	                case 11:handel.set_global_Thread();    break;//����ȫ�ֱ���
	                case 12: handel.get_Register();       break;//����ע�����Ա����
	                case 13:handel.get_Case_to_Docter(); break;//���͵ȴ�ҽ�������
	                case 14: handel.set_Register_docter();  break;//���յȴ�ҽ������ı�
	                case 15:handel.set_Register_get_Drug(); break;//���յȴ�ҩ������ı�
	                case 16:handel.get_Register_Charged();  break;//���͸��ҺŶ˵ı�
	                case 18:handel.get_Register_get_Drug(); break;//���͸�ҩ���˵ı�
					
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

	 public static void Adminstrator_get(Socket socket){//����µ�����

			
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
