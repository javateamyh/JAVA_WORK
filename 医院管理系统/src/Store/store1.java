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
	private static Account account;//该客户端类型
	static int i=0;//表示第几个病人（case病历单clist.get(i)）
	private static Global_info med_info;//(从服务器接受的全局变量  主要接受药库信息）
	private static Global_info med_info1;//要写入服务器的  主要是药库信息 
	private static ArrayList<Drug_info> list;//从服务器接受的全局变量中的药库信息 med_info的成员
	private static ArrayList<Drug_info> list1;//药库的药的队列 global的成员 用list初始化将来用于写入服务器
    private static ObjectInputStream is;
    private static ObjectOutputStream os;
    private static Case cs1;//病人病历单
    private static ArrayList<Case> clist;//病人（病历单）的队列
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
					med_info=(Global_info)is.readObject();//从服务器接受的全局信息
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
						
						lb1=new JLabel("目前无病人病例");  
					
					    j1.add(lb1);
					    frm.setBounds(600, 100, 300, 250);//设置长宽大小
						  frm.setVisible(true);//显示
				}
				else{
		         list=med_info.getDrug_list();//从服务器接受的全局信息的药库信息序列
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
