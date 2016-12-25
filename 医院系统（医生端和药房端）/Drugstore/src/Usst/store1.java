package Usst;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class store1 extends JFrame {
	private static Account acc;//�ÿͻ�������
	static int i=0;//��ʾ�ڼ������ˣ�case������clist.get(i)��
	private static Global_info med_info;//(�ӷ��������ܵ�ȫ�ֱ���  ��Ҫ����ҩ����Ϣ��
	private static Global_info med_info1;//Ҫд���������  ��Ҫ��ҩ����Ϣ 
	private static ArrayList<Drug_info> list;//�ӷ��������ܵ�ȫ�ֱ����е�ҩ����Ϣ med_info�ĳ�Ա
	private static ArrayList<Drug_info> list1;//ҩ���ҩ�Ķ��� global�ĳ�Ա ��list��ʼ����������д�������
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static Case cs1;//���˲�����
    private static ArrayList<Case> clist;//���ˣ����������Ķ���
	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					store1 frame = new store1();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the frame.
	 */
	public store1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u836F\u623F\u62FF\u836F\u7AEF");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton button = new JButton("\u5F00\u59CB\u53D6\u836F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cishu=0;
				
				while(cishu<4){
					cishu++;
		        Socket server1=null;
				try {
					server1=new Socket("10.40.255.254",5000);
				} catch (UnknownHostException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				try {
					in=new ObjectInputStream(server1.getInputStream());
				} catch (IOException e3) {
					// TODO Auto-generated catch block
					e3.printStackTrace();
				}
				
				try {
					out=new ObjectOutputStream(server1.getOutputStream());
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
				
			     try {
					out.writeObject(acc);
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			     try {
					out.flush();
				} catch (IOException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}

				try {
					med_info=(Global_info)in.readObject();//�ӷ��������ܵ�ȫ����Ϣ
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(med_info==null){
					JFrame frm=new JFrame();
					   JLabel lb1;
					   JPanel j1;
					    
						j1=new JPanel();
						frm.getContentPane().add(j1, BorderLayout.NORTH);
						
						lb1=new JLabel("Ŀǰ�޲��˲���");  
					
					    j1.add(lb1);
					    frm.setBounds(600, 100, 300, 250);//���ó����С
						  frm.setVisible(true);//��ʾ
				}
				else{
		         list=med_info.getDrug_list();//�ӷ��������ܵ�ȫ����Ϣ��ҩ����Ϣ����
		         list1=list; med_info1= med_info;
				try {
					clist=(ArrayList<Case>) in.readObject();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
				
				while(i+1<clist.size()){cs1=clist.get(i);
				     
				   Store frame=new Store(list,out,clist,cs1,i);
				   frame.setVisible(true);
				
				
				
				}}}
				
				
				
				
				
				
				
				
			}
		});
		panel_1.add(button);
	}

}
