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
	private static ArrayList<Case> Register=new ArrayList<Case>();//给挂号人员的
	 private static ArrayList<Case> Register_to_Docter=new ArrayList<Case>();//给医生的信息;大屏幕显示
	 private static ArrayList<Case> Register_Charged=new ArrayList<Case>();//用于挂号端的收费
	 private static ArrayList<Case> Register_get_Drug=new ArrayList<Case>();//用于药房端
	 private static ArrayList<Case> History =new ArrayList<Case>();//用于记录全局的信息（历史的病人记录单）
	 
	 
	 public  Handel(Storage storage,Socket socket) {
		 this.storage=storage;//用于存放全局信息
		global_info=storage.getGlobal_info();
		this.socket=socket;
	} 
	 //关于病人门诊挂号收费模块，同时接收处理后的信息
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
 //关于医生模块
	
	public static void docter_hander(ObjectInputStream is,ObjectOutputStream os){//1.发送全局变量2.发送病人的表单
		
				// TODO Auto-generated method stub
				
				try {     
			        os.writeObject(global_info);
			        os.flush();//第一次传送
					os.writeObject(Register_to_Docter);//送给医生的信息
					os.flush();//第二次发送
					Register_to_Docter.clear();
					try {
					
						Register_Charged.addAll((ArrayList<Case>)is.readObject());//接收的序列
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	
	}
	//大屏幕显示信息
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
	 //关于注册模块的处理
	public static void register_Thread(ObjectInputStream is,ObjectOutputStream os){
	
				// TODO Auto-generated method stub
			
				try {
					
					try {
						os.writeObject(global_info);
						os.flush();
/*直接发送病人病例*/	Register.addAll((ArrayList<Case>)is.readObject());
					} catch (ClassNotFoundException e) {
						// TODO Auto-generated catch block
						e.printStackTrace();
					}
					
			
					
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
	
	}
      //关于收费信息
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

	public static void Druger_info(ObjectInputStream is,ObjectOutputStream os) throws ClassNotFoundException{//给药房端的信息

				// TODO Auto-generated method stub
			
				try {
					
				
			        os.writeObject(global_info);
			        os.flush();
			        os.writeObject(Register_get_Drug);
			        os.flush();
			        global_info=(Global_info)is.readObject();
			        storage.setGlobal_info(global_info);
			        storage.Writer_global_info();//写回到本地文件
			     
			   
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

	}
	public  static void  statistic_Thread(ObjectInputStream is,ObjectOutputStream os) {  //返回统计信息
	
			
			
				try {
					
				
			        statistic_info sa=Statistic_info();
			        os.writeObject(sa);
			        os.flush();
			    
			    
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}

		
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
	
	//用于返回全局的变量 110(发送协议)
	public static void get_global_Thread(ObjectInputStream is,ObjectOutputStream os) throws IOException{
		
		try {
		
		    os.writeObject(global_info);
	         os.flush();
		    
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		
	}
	//用于全局量的获取  协议号111(接受协议)
	public static void set_global_Thread(ObjectInputStream is,ObjectOutputStream os){

	try {
		
		try {
			global_info=(Global_info)is.readObject();
			Storage.setGlobal_info(global_info);
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			System.out.println("对象为空");
		}
	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	}
	}
	// 112(发送协议) 给挂号端的挂号
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
    //接受协议 用于接收 挂号-医生的113通讯协议   由挂号段发送传给医生端
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

//用于返回等待医生处理的病人 114(发送协议) 给医生 
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
//接收协议 用于收费完成后传给药房端 115 收费完成给药房端
public static void set_Register_get_Drug(ObjectInputStream is,ObjectOutputStream os){
	
	try {
		
		Register_get_Drug=(ArrayList<Case>)is.readObject();

	} catch (IOException e) {
		// TODO Auto-generated catch block
		e.printStackTrace();
	} catch (ClassNotFoundException e) {
		// TODO Auto-generated catch block
System.out.println("接收到的信息异常");
	}

}

//用于返回挂号端的收费 协议号：116(发送协议) 给挂号端的收费
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
 //用于返回药房端的信息 协议号：118(发送协议) 给药房端
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

