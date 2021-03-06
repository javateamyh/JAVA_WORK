package XWJ;
import java.util.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.*;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Res extends JFrame {

	static int i=0;
	static int j=0;
	static int a=0;
	static int b=0;
	static int c=0;
	static int d=0;
	private static Case case1;//病例
	private static ArrayList<Case> Register1;//接收给挂号人员的病人信息
	private static Global_info info;//接收全局信息
	private static ArrayList<Office> officelist;//接收全局信息中的科室
	//private static ArrayList<Case> WaitDoctor;//记录每个医生排队
	private static ArrayList<WaitOffice> waitOfficelist;//存放一个科室的所有医生排队情况
	private static WaitOffice waitOffice;//一个科室的排队情况
	private static Waiter wait1;//一个医生后面的队初始化
	private static Waiter wait2;//在循环里标志找出医生后面病人最少的队
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static JFrame frm;
	private static JLabel lblApp;
	private static JLabel lblNoApp;
	private static JLabel lb1;
	private static JLabel lb2;
	private static JLabel lb3;
	private static JLabel lb4;
	private static JLabel lb6;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	
	/**
	 * Create the frame.
	 */
	public void run() {
		// TODO Auto-generated method stub
		try {
			Register1=(ArrayList<Case>)in.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		
		try {
			info=(Global_info)in.readObject();//从服务器接受科室的所有信息
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		officelist=info.getCount_office();
	}
	
	public void makewait()//初始化所有科室和医生队列
	{
		for(int j=0;j<officelist.size();j++)
		{	waitOffice.setOffice_name(officelist.get(j).getOffice_name());
			for(int a=0;a<officelist.get(j).getDocter_name().size();a++)
			{
				wait1.setDoctor_name(officelist.get(j).getDocter_name().get(a));
				waitOffice.getWait_Doc().add(wait1);	
			}
			waitOfficelist.add(waitOffice);
		}
	}
	
	
	public void write(){
	new Thread(new Runnable() {
		
		@Override
		public void run() {
			// TODO Auto-generated method stub
			try {
				Socket socket=new Socket("127.0.0",8000);
				ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
				os.writeObject(Register1);
				os.flush();
				os.close();
				socket.close();
					
			} catch (IOException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
			
			
		}
	}).start();}

	
	
	public Res() {
		boolean g=false;
		if(!g)//第一次获取服务器信息
		{
			run();
			makewait();
		    g=true;
		}
		
		boolean f=false;
		if(f)//一次接收到的病例已经全部处理完，接收下一次
		{   write();//回写之前获取的全部病例信息
			run();//重新接收新的病人病历
			makewait();
		}
		case1=Register1.get(i);
		if(case1.getApp().isAppoint()==true)
		 {
			lblApp.setText("此病人已经预约成功!");
			lb1.setText("病人姓名 " +case1.getPi().getName());
			lb2.setText("病人预约科室 " +case1.getApp().getApp_office().getOffice_name());
		    lb3.setText("病人预约医生 " +case1.getApp().getDocter_name());
		       
		for(int b=0;b<waitOfficelist.size();b++)//将病人加入相应科室相应医生的后面排队
	   {
		if(case1.getApp().getApp_office().getOffice_name().equals(waitOfficelist.get(b).getOffice_name()))
		  {   
			for(int c=0;c<waitOfficelist.get(b).getWait_Doc().size();c++)
			 if(case1.getApp().getDocter_name().equals(waitOfficelist.get(b).getWait_Doc().get(c).getDoctor_name()))
				//找到和病人预约医生名字一致的医生队列
			  {
				 if( waitOfficelist.get(b).getWait_Doc().get(c).getWaiting().size()<=10)//设置每个医生的最大预约人数为10
				 {   int max=10;
						if( waitOfficelist.get(b).getWait_Doc().get(c).getWaiting().size()<=5)
						  //如果某个医生预约人数已经没超过五人，直接按照原来信息添加  	
					    { waitOfficelist.get(b).getWait_Doc().get(c).getWaiting().add(case1);}
						  //如果某个医生预约人数已经超过五人，必须遍历所有该科室医生队列，找到排队人数最少的
						else{  	
						   for(int d=0;d<waitOfficelist.get(b).getWait_Doc().size();d++)//找到最短的队
						 {   
						   if(max>waitOfficelist.get(b).getWait_Doc().get(d).getWaiting().size())
							 {
							  max=waitOfficelist.get(b).getWait_Doc().get(d).getWaiting().size();
							  wait2.setDoctor_name(waitOfficelist.get(b).getWait_Doc().get(d).getDoctor_name());	//记录队最短的医生	  
							 }
						}
							        
						for(int e=0;e<waitOfficelist.get(b).getWait_Doc().size();e++)
						 {   
	                        if(waitOfficelist.get(b).getWait_Doc().get(e).getDoctor_name().equals(wait2.getDoctor_name()))
	                         {
	                            waitOfficelist.get(b).getWait_Doc().get(e).getWaiting().add(case1);  //找到病人选择的科室选择 
	                            //注意遇到这种情况时还要考虑修改原先的预约信息  
	                            case1.getApp().setDocter_name(wait2.getDoctor_name());//备注类的定义要统一
	                            //并且在lb3中显示更新后的医生
	                            lb4.setText("病人预约医生 " +case1.getApp().getDocter_name());
	                            lb6.setText("挂号费 " +case1.getCharge().getRegistration_fee());
	                            
	                           }  }	  }    }
						    else{
						     lb4.setText(case1.getApp().getDocter_name()+"已经超过最大预约人数"); 
						    }}}}
		}
		else{
		   lblApp.setText("此病人没有预约成功!");
		   //调用 预约的类填写预约信息   
		   }
		if(i<Register1.size())
		{
			f=true;
		}
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 424, 35);
		contentPane.add(panel);
		
		JLabel label = new JLabel("--------\u6302\u53F7-------");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 39, 424, 34);
		contentPane.add(panel_1);
		
		JLabel lblApp = new JLabel("New label");
		panel_1.add(lblApp);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 77, 424, 19);
		contentPane.add(panel_2);
		
		JLabel lb1 = new JLabel("New label");
		panel_2.add(lb1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 155, 424, 24);
		contentPane.add(panel_3);
		
		JLabel lb4 = new JLabel("New label");
		panel_3.add(lb4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 183, 424, 35);
		contentPane.add(panel_4);
		
		JLabel lb6 = new JLabel("New label");
		panel_4.add(lb6);
		
		JButton btnSub = new JButton("\u63D0\u4EA4\u75C5\u4EBA\u4FE1\u606F");
		btnSub.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				Res frame = new Res();
				frame.setVisible(true);
			}
		});
		panel_4.add(btnSub);
		
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 222, 424, 29);
		contentPane.add(panel_5);
		
		JButton btnUP = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		btnUP.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register();
				frame.setVisible(true);
			}
		});
		panel_5.add(btnUP);
		
		JPanel panel_7 = new JPanel();
		panel_7.setBounds(0, 106, 424, 19);
		contentPane.add(panel_7);
		
		JLabel lb2 = new JLabel("New label");
		panel_7.add(lb2);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 130, 424, 24);
		contentPane.add(panel_6);
		
		JLabel lb3 = new JLabel("New label");
		panel_6.add(lb3);
	
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

}
