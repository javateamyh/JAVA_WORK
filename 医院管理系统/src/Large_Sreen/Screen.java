package Large_Sreen;
import Register_Charge.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import all_class.Account;
import all_class.Case;
import all_class.Global_info;
import all_class.Office;
import all_class.ipconfig;

import javax.swing.JLabel;
import javax.print.attribute.standard.PrinterMessageFromOperator;
import javax.swing.JButton;
//大屏幕显示
public class Screen extends JFrame {
	static int i=0;
	static int j=0;
	static int a=0;
	static int b=0;
	static int c=0;
	static int d=0;
	static int e1=0;
	static int f1=0;
	private static Case case3;
	private static Account account;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	private static Global_info info;//接收全局信息
	private static ArrayList<Office> officelist;//接收全局信息中的科室
	private static ArrayList<Case> RegisterDocter;//给医生的信息
	private static ArrayList<WaitOffice> waitOfficelist;//存放一个科室的所有医生排队情况
	private static WaitOffice waitOffice;//一个科室的排队情况
	private static Waiter wait1;//一个医生后面的队初始化
	private JPanel contentPane;
	private static Socket socket;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	
	
	public static void get_global_info(){
	
				// TODO Auto-generated method stub
				try {
					
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
					
					out=new ObjectOutputStream(socket.getOutputStream());
				    out.writeObject(account);
				    out.flush();
				    in=new ObjectInputStream(socket.getInputStream());
				    info=(Global_info)in.readObject();//从服务器接受科室的所有信息     
				    officelist=info.getCount_office();
			        RegisterDocter=(ArrayList<Case>)in.readObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	 
		 
	 
	//public static void main(String[] args) throws IOException {
	
	

	/**
	 * Create the frame.
	 */
	public Screen(Account account,Socket socket) {
		this.account=account;
		get_global_info();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 414, 37);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u663E\u793A\u5F53\u524D\u6392\u961F\u60C5\u51B5");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 35, 414, 37);
		contentPane.add(panel_1);
		
		JLabel lblN1 = new JLabel("New label");
		panel_1.add(lblN1);
		
		JLabel labC1 = new JLabel("New label");
		panel_1.add(labC1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 72, 414, 37);
		contentPane.add(panel_2);
		
		JLabel labN2 = new JLabel("New label");
		panel_2.add(labN2);
		
		JLabel labC2 = new JLabel("New label");
		panel_2.add(labC2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 110, 414, 37);
		contentPane.add(panel_3);
		
		JLabel labN3 = new JLabel("New label");
		panel_3.add(labN3);
		
		JLabel labC3 = new JLabel("New label");
		panel_3.add(labC3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 143, 414, 37);
		contentPane.add(panel_4);
		
		JLabel labN4 = new JLabel("New label");
		panel_4.add(labN4);
		
		JLabel labC4 = new JLabel("New label");
		panel_4.add(labC4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 179, 414, 42);
		contentPane.add(panel_5);
		
		JLabel labN5 = new JLabel("New label");
		panel_5.add(labN5);
		
		JLabel labC5 = new JLabel("New label");
		panel_5.add(labC5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 231, 414, 30);
		contentPane.add(panel_6);
		
		JButton button = new JButton("\u5237\u65B0");
		
		button.addActionListener(new ActionListener() {
			private JLabel lblN2;
			private JLabel lblN3;
			private JLabel lblN4;
			private JLabel lblN5;

			public void actionPerformed(ActionEvent e) {
				for(int j=0;j<officelist.size();j++)//初始化当前最新的所有科室和医生队列
				{	waitOffice.setOffice_name(officelist.get(j).getOffice_name());
					for(int a=0;a<officelist.get(j).getDocter_name().size();a++)
					{
						wait1.setDoctor_name(officelist.get(j).getDocter_name().get(a));
						waitOffice.getWait_Doc().add(wait1);	
					}
					waitOfficelist.add(waitOffice);
				}
				
				for(int a=0;a<RegisterDocter.size();a++)//遍历接收到的病人即时信息全部排队
				{
					case3=RegisterDocter.get(a);
					for(int b=0;b<waitOfficelist.size();b++)
					{
						 if(case3.getApp().getApp_office().getOffice_name().equals(waitOfficelist.get(b).getOffice_name()))
						   {  
							 for(int c=0;c<waitOfficelist.get(b).getWait_Doc().size();c++)
								   if(case3.getApp().getDocter_name().equals(waitOfficelist.get(b).getWait_Doc().get(c).getDoctor_name()))
									   //找到和病人预约医生名字一致的医生队列
									   {
									   waitOfficelist.get(b).getWait_Doc().get(c).getWaiting().add(case3);
								   }}}}
				
				//统计各科室人数
				for(int d=0;d<waitOfficelist.size();d++)
				{  float[] Sum_off=new float[waitOfficelist.get(d).getWait_Doc().size()];//科室的排队人数
				   for(int e1=0;e1<waitOfficelist.get(d).getWait_Doc().size();e1++)								   
				  {     
				    Sum_off[e1]+=waitOfficelist.get(d).getWait_Doc().get(e1).getWaiting().size();    
				   }
				   waitOfficelist.get(d).setWaitnumber(Sum_off[e1]);
				}
				
				//屏幕显示科室名和科室当前人数
				lblN1.setText("科室"+waitOfficelist.get(0).getOffice_name()); 
				lblN2.setText("科室"+waitOfficelist.get(1).getOffice_name()); 
				lblN3.setText("科室"+waitOfficelist.get(2).getOffice_name()); 
				lblN4.setText("科室"+waitOfficelist.get(3).getOffice_name()); 
				lblN5.setText("科室"+waitOfficelist.get(4).getOffice_name()); 
				labC1.setText("当前排队人数"+waitOfficelist.get(0).getWaitnumber());
				labC2.setText("当前排队人数"+waitOfficelist.get(1).getWaitnumber());
				labC3.setText("当前排队人数"+waitOfficelist.get(2).getWaitnumber());
				labC4.setText("当前排队人数"+waitOfficelist.get(3).getWaitnumber());
				labC5.setText("当前排队人数"+waitOfficelist.get(4).getWaitnumber());
			}
		});
		panel_6.add(button);
	}
}
