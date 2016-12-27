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
	public static Storage storage;
	private static  Socket socket;
	private static ArrayList<Case> Register=new ArrayList<Case>();//���Һ���Ա��
	 private static ArrayList<Case> Register_to_Docter=new ArrayList<Case>();//��ҽ������Ϣ;����Ļ��ʾ
	 private static ArrayList<Case> Register_Charged=new ArrayList<Case>();//���ڹҺŶ˵��շ�
	 private static ArrayList<Case> Register_get_Drug=new ArrayList<Case>();//����ҩ����
	 private static ArrayList<Case> History =new ArrayList<Case>();//���ڼ�¼ȫ�ֵ���Ϣ����ʷ�Ĳ��˼�¼����
	 
	 
	 public  Handel(Storage storage,Socket socket) {
		 this.storage=storage;//���ڴ��ȫ����Ϣ
		global_info=storage.getGlobal_info();
		this.socket=socket;
	} 
	 //���ڲ�������Һ��շ�ģ�飬ͬʱ���մ�������Ϣ
	public static void registration_Thread(ObjectInputStream is,ObjectOutputStream os){
				try {
			        os.writeObject(Register);
			        Register.clear(); 
			      try {
					Register_to_Docter.addAll((ArrayList<Case>) is.readObject());
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			      	      
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	
	}
 //����ҽ��ģ��
	
	public static void docter_hander(ObjectInputStream is,ObjectOutputStream os){//1.����ȫ�ֱ���2.���Ͳ��˵ı�
		
				// TODO Auto-generated method stub
				
				try {     
			        os.writeObject(global_info);
			        os.flush();//��һ�δ���
					os.writeObject(Register_to_Docter);//�͸�ҽ������Ϣ
					os.flush();//�ڶ��η���
					Register_to_Docter.clear();
					try {
					
						Register_Charged.addAll((ArrayList<Case>)is.readObject());//���յ�����
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	
	}
	//����Ļ��ʾ��Ϣ
	public static void Screen_info(ObjectInputStream is,ObjectOutputStream os){
	
				// TODO Auto-generated method stub
				
				try {
					os.writeObject(Register_to_Docter);
					os.flush();
					Register_to_Docter.clear();
							
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				

	}
	 //����ע��ģ��Ĵ���
	public static void register_Thread(ObjectInputStream is,ObjectOutputStream os){
	
				// TODO Auto-generated method stub
			
				try {
					
					try {
						os.writeObject(global_info);
						os.flush();
/*ֱ�ӷ��Ͳ��˲���*/	Register.addAll((ArrayList<Case>)is.readObject());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	
	}
      //�����շ���Ϣ
    public static void Charge_sum(ObjectInputStream is,ObjectOutputStream os){
			try {
				
			
			
		    
		        os.writeObject(Register_Charged);
		        os.flush();
		        Register_Charged.clear();
		        try {
		        	
					Register_get_Drug.addAll((ArrayList<Case>)is.readObject());
					History.addAll(Register_get_Drug);
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
		   
		      
		        
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			

}

	public static void Druger_info(ObjectInputStream is,ObjectOutputStream os) throws ClassNotFoundException{//��ҩ���˵���Ϣ

				// TODO Auto-generated method stub
			
				try {
					
				
			        os.writeObject(global_info);
			        os.flush();
			        os.writeObject(Register_get_Drug);
			        os.flush();
			        global_info=(Global_info)is.readObject();
			        storage.setGlobal_info(global_info);
			        storage.Writer_global_info();//д�ص������ļ�
			     
			   
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	public  static void  statistic_Thread(ObjectInputStream is,ObjectOutputStream os) {  //����ͳ����Ϣ
	
			
			
				try {
					
				
			        statistic_info sa=Statistic_info();
			        os.writeObject(sa);
			        os.flush();
			    
			    
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
	}
	
	public static statistic_info Statistic_info(){//ͳ����Ϣ
		
		ArrayList<Drug_info>Drug_list=new ArrayList<Drug_info>();
        String[] Count_name=new String[global_info.getCount_office().size()];
		int[] Count_office=new int[global_info.getCount_office().size()];//���ҵĲ�����
		float[] Sum_office=new float[global_info.getCount_office().size()];//���ҵ�Ӫҵ��
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
	
	//���ڷ���ȫ�ֵı��� 110(����Э��)
	public static void get_global_Thread(ObjectInputStream is,ObjectOutputStream os) throws IOException{
		
		try {
		
		    os.writeObject(global_info);
	         os.flush();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	//����ȫ�����Ļ�ȡ  Э���111(����Э��)
	public static void set_global_Thread(ObjectInputStream is,ObjectOutputStream os){

	try {
		
		try {
			global_info=(Global_info)is.readObject();
			Storage.setGlobal_info(global_info);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("����Ϊ��");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	// 112(����Э��) ���ҺŶ˵ĹҺ�
    public static void get_Register(ObjectInputStream is,ObjectOutputStream os){

	try {
		
		os.writeObject(Register);
		os.flush();
		Register.clear();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
    //����Э�� ���ڽ��� �Һ�-ҽ����113ͨѶЭ��   �ɹҺŶη��ʹ���ҽ����
    public static void  set_Register_docter(ObjectInputStream is,ObjectOutputStream os){
    
    	try {
			
			Register_to_Docter=(ArrayList<Case>)is.readObject();
		
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
    	
    }

//���ڷ��صȴ�ҽ������Ĳ��� 114(����Э��) ��ҽ�� 
public static void get_Case_to_Docter(ObjectInputStream is,ObjectOutputStream os){

	try {
		
		
		os.writeObject(Register_to_Docter);
		os.flush();
	
		Register_to_Docter.clear();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
//����Э�� �����շ���ɺ󴫸�ҩ���� 115 �շ���ɸ�ҩ����
public static void set_Register_get_Drug(ObjectInputStream is,ObjectOutputStream os){
	
	try {
		
		Register_get_Drug=(ArrayList<Case>)is.readObject();

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
System.out.println("���յ�����Ϣ�쳣");
	}

}

//���ڷ��عҺŶ˵��շ� Э��ţ�116(����Э��) ���ҺŶ˵��շ�
public static void get_Register_Charged(ObjectInputStream is,ObjectOutputStream os){

	try {
		
		os.writeObject(Register_Charged);
		os.flush();
		Register_Charged.clear();
		
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}
 //���ڷ���ҩ���˵���Ϣ Э��ţ�118(����Э��) ��ҩ����
public static void get_Register_get_Drug(ObjectInputStream is,ObjectOutputStream os){

	try {
		os.writeObject(Register_get_Drug);
		os.flush();
		Register_get_Drug.clear();
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
}


}

