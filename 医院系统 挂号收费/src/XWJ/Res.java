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

import XWJ.Register.ButtonHandler1;
import XWJ.Register.ButtonHandler2;
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
	private static Case case1;
	private static ArrayList<Case> Register1;//���ո��Һ���Ա�Ĳ�����Ϣ
	private static Global_info info;//����ȫ����Ϣ
	private static ArrayList<Office> officelist;//����ȫ����Ϣ�еĿ���
	//private static ArrayList<Office> office_li;
	//private static ArrayList<Case> WaitDoctor;//��¼ÿ��ҽ���Ŷ�
	private static ArrayList<WaitOffice> waitOfficelist;//���һ�����ҵ�����ҽ���Ŷ����
	private static WaitOffice waitOffice;//һ�����ҵĶ�
	private static ArrayList<Waiter> waitDoctor;//һ�����Һ���Ķ�
	private static Waiter wait1;//һ��ҽ������Ķӳ�ʼ��
	private static Waiter wait2;//��ѭ�����־�ҳ�ҽ�����没�����ٵĶ�
	//private static Waiter wait3;//�ҵ����������ĶӲ���
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
	public Res() {
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
		panel_4.add(btnSub);
		ButtonHandler1 btnHandler1=new ButtonHandler1();
		btnSub.addActionListener(btnHandler1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 222, 424, 29);
		contentPane.add(panel_5);
		
		JButton btnUP = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
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
		ButtonHandler2 btnHandler2=new ButtonHandler2();
		btnUP.addActionListener(btnHandler2);
	}
	
	class ButtonHandler1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
			i++;
			Res frame = new Res();
			frame.setVisible(true);
		}	
	}
	
	class ButtonHandler2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub  
			Register frame = new Register();
			frame.setVisible(true);
		}	
	}
	
	public static void main(String[] args) throws IOException{
		
		try {
			Register1=(ArrayList<Case>)in.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		
		try {
			info=(Global_info)in.readObject();//�ӷ��������ܿ��ҵ�������Ϣ
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		officelist=info.getCount_office();

		for(int j=0;j<officelist.size();j++)//��ʼ�����п��Һ�ҽ������
		{	
			for(int a=0;a<officelist.get(j).getDocter_name().size();a++)
			{
				waitOffice.setOffice_name(officelist.get(j).getOffice_name());
				wait1.setDoctor_name(officelist.get(a).getDocter_name().get(a));
				waitDoctor.add(wait1);
				waitOffice.setWait_Doc(waitDoctor);
			}
			waitOfficelist.add(waitOffice);
		}
		
		do {
			case1=Register1.get(i);
			   if(case1.getApp().isAppoint()==true)
			   {
				   lblApp.setText("�˲����Ѿ�ԤԼ�ɹ�!");
				   //WaitDoctor.add(case1);
				   lb1.setText("�������� " +case1.getPi().getName());
				   lb2.setText("����ԤԼ���� " +case1.getApp().getApp_office().getOffice_name());
				   lb3.setText("����ԤԼҽ�� " +case1.getApp().getApp_office().getDocter_name());
				   
				   for(int b=0;b<waitOfficelist.size();b++)//�����˼�����Ӧ������Ӧҽ���ĺ����Ŷ�
				   {
					   if(case1.getApp().getApp_office().getOffice_name().equals(waitOfficelist.get(b).getOffice_name()))
					   {   
						   for(int c=0;c<waitOfficelist.get(b).getWait_Doc().size();c++)
						   if(case1.getApp().getApp_office().getDocter_name().equals(waitOfficelist.get(b).getWait_Doc().get(c).getDoctor_name()))
							   //�ҵ��Ͳ���ԤԼҽ������һ�µ�ҽ������
						   {
							   if( waitOfficelist.get(b).getWait_Doc().get(c).getWaiting().size()<=10)//����ÿ��ҽ�������ԤԼ����Ϊ10
							    {   int max=10;
							    if( waitOfficelist.get(b).getWait_Doc().get(c).getWaiting().size()<=5)
							  //���ĳ��ҽ��ԤԼ�����Ѿ�û�������ˣ�ֱ�Ӱ���ԭ����Ϣ���  	
							       { wait3.getWaiting().add(case1);}
							  //���ĳ��ҽ��ԤԼ�����Ѿ��������ˣ�����������иÿ���ҽ�����У��ҵ��Ŷ��������ٵ�
							    else{
							    	for(int d=0;d<waitOfficelist.get(b).getWait_Doc().size();d++)//�ҵ���̵Ķ�
							    	{   
										  if(max<waitOfficelist.get(b).getWait_Doc().get(d).getWaiting().size())
										  {
											  max=waitOfficelist.get(b).getWait_Doc().get(d).getWaiting().size();
										      wait2.setDoctor_name(waitOfficelist.get(b).getWait_Doc().get(d).getDoctor_name());		  
										  }
									}
								        
								        for(int e=0;e<waitOfficelist.get(b).getWait_Doc().size();e++)
										  {   
		                                   if(waitOfficelist.get(b).getWait_Doc().get(e).getDoctor_name().equals(wait2.getDoctor_name()))
		                                   {
		                                	  waitOfficelist.get(b).getWait_Doc().get(e).getWaiting().add(case1);  //�ҵ�����ѡ��Ŀ���ѡ�� 
		                                	   //ע�������������ʱ��Ҫ�����޸�ԭ�ȵ�ԤԼ��Ϣ  
		                                	  //case1.getApp().getApp_office().setDoctor(waitOfficelist.get(b).getWait_Doc().get(e).getDoctor_name());
		                                	  //������lb3����ʾ���º��ҽ��
		                                	  lb3.setText("����ԤԼҽ�� " +case1.getApp().getApp_office().getDocter_name());
		                                	  lb6.setText("�Һŷ� " +case1.getCharge().getRegistration_fee());
		                                   } 
										  }	
							         }
								   
							       }
							   else{
							    	  lb4.setText(case1.getApp().getApp_office().getDocter_name()+"�Ѿ��������ԤԼ����");
							    	  
							    }
							   
						   }//////����˳�����������ѭ��?  �ҵ���Ӧ��ҽ������ִ����ѭ������ͣȫ��ѭ��
					   }
					   
				   }
				   
			   }
			   else{
				   lblApp.setText("�˲���û��ԤԼ�ɹ�!");
				   //���� ԤԼ������дԤԼ��Ϣ   
			   }
			   
			   
		} while (i<Register1.size());
		
	EventQueue.invokeLater(new Runnable() {
		public void run() {
			try {
				Res frame = new Res();
				frame.setVisible(true);
			} catch (Exception e) {
				e.printStackTrace();
			}
		}
	});
}
}
