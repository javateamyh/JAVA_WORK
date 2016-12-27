package Store;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.*;


import javax.swing.JLabel;
import javax.naming.event.NamespaceChangeListener;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.GridLayout;
import javax.swing.SwingConstants;

public class store1 extends JFrame {
	private static Account account;//�ÿͻ�������
	static int i=0;//��ʾ�ڼ������ˣ�case������clist.get(i)��
	private static Global_info med_info;//(�ӷ��������ܵ�ȫ�ֱ���  ��Ҫ����ҩ����Ϣ��
	private static Global_info med_info1;//Ҫд���������  ��Ҫ��ҩ����Ϣ 
	private static ArrayList<Drug_info> list;//�ӷ��������ܵ�ȫ�ֱ����е�ҩ����Ϣ med_info�ĳ�Ա
	private static ArrayList<Drug_info> list1;//ҩ���ҩ�Ķ��� global�ĳ�Ա ��list��ʼ����������д�������
    private static ObjectInputStream is;
    private static ObjectOutputStream os;
    private static Case cs1;//���˲�����
    private static ArrayList<Case> clist;//���ˣ����������Ķ���
	private JPanel contentPane;
	private static Socket socket;

	public store1(ObjectOutputStream os,ObjectInputStream is,Account account,Socket socket) {
		this.account=account;
		this.socket=socket;
		this.os=os;
		this.is=is;
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
				try {

					os.writeObject(account);
					os.flush();
				} catch (IOException e4) {
					// TODO Auto-generated catch block
					e4.printStackTrace();
				}
				try {
					med_info=(Global_info)is.readObject();//�ӷ��������ܵ�ȫ����Ϣ
					clist=(ArrayList<Case>) is.readObject();
					
				
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				if(clist.size()==0){
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
				while(i+1<clist.size()){cs1=clist.get(i);
				     
				   Store frame=new Store(socket,list,clist,cs1,i);
				   frame.setVisible(true);
				   i++;
				}}				
			}
		});
		panel_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		JPanel panel_2 = new JPanel();
		panel_1.add(panel_2);
		
		JLabel label_1 = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u836F\u623F\u7AEF");
		panel_2.add(label_1);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel_1.add(button_1);
	}

}
