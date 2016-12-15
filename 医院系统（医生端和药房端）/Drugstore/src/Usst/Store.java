package Usst;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JList;
import javax.swing.DefaultComboBoxModel;

public class Store extends JFrame {
	static int i=0;
	private static ArrayList<Case> clist;
	private static Case cs1;
	private static Account acc;
	private static Global_info med_info;
	private static ArrayList<Drug_info> list;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static JFrame frm;
	private JPanel contentPane;

	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	public static void main(String[] args) throws IOException {
         Socket server1=null;
		
		try {
			server1=new Socket("127.0.0",1200);
		} catch (UnknownHostException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	
		in=new ObjectInputStream(server1.getInputStream());
		
		out=new ObjectOutputStream(server1.getOutputStream());
		 acc.setFlag(4); 
	     out.writeObject(acc);
	     out.flush();
		
		try {
			med_info=(Global_info)in.readObject();//从服务器接受的全局信息
		} catch (ClassNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
         list=med_info.getDrug_list();//从服务器接受的全局信息的药库信息序列
		try {
			clist=(ArrayList<Case>) in.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}
		cs1=clist.get(i);
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Store frame = new Store();
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
	public Store() {
		int j=0;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u836F\u623F\u7AEF");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_1 = new JLabel("\u836F\u54C11\u540D\u5B57\uFF1A ");
		panel_1.add(label_1);
		
		JLabel Med_na1 = new JLabel(cs1.getDrug_list().get(j).getDrug_name());
		panel_1.add(Med_na1);
		
		JLabel label_2 = new JLabel(" \u836F\u54C11\u6570\u91CF\uFF1A");
		panel_1.add(label_2);
		int n=0;
		JButton button = new JButton("\u68C0\u67E5\u8BE5\u836F\u54C1\u53CA\u5E93\u5B58");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
			}}
		);
		
		JLabel label_4 = new JLabel("New label");
		panel_1.add(label_4);
		panel_1.add(button);
		
		JLabel label_3 = new JLabel("\u836F\u54C12\u540D\u5B57\uFF1A ");
		panel_1.add(label_3);
		
		JLabel Med_na2 = new JLabel("New label");
		panel_1.add(Med_na2);
		
		JLabel label_5 = new JLabel(" \u836F\u54C12\u6570\u91CF\uFF1A");
		panel_1.add(label_5);
		
		JLabel label_7 = new JLabel("New label");
		panel_1.add(label_7);
		
		JButton button_1 = new JButton("\u68C0\u67E5\u8BE5\u836F\u54C1\u53CA\u5E93\u5B58");
		panel_1.add(button_1);
		
		JLabel label_6 = new JLabel("\u836F\u54C13\u540D\u5B57\uFF1A ");
		panel_1.add(label_6);
		
		JLabel Med_na3 = new JLabel("New label");
		panel_1.add(Med_na3);
		
		JLabel label_8 = new JLabel(" \u836F\u54C13\u6570\u91CF\uFF1A");
		panel_1.add(label_8);
		
		JLabel label_10 = new JLabel("New label");
		panel_1.add(label_10);
		
		JButton button_2 = new JButton("\u68C0\u67E5\u8BE5\u836F\u54C1\u53CA\u5E93\u5B58");
		panel_1.add(button_2);
		
		JLabel label_9 = new JLabel("\u836F\u54C14\u540D\u5B57\uFF1A ");
		panel_1.add(label_9);
		
		JLabel Med_na4 = new JLabel("New label");
		panel_1.add(Med_na4);
		
		JLabel label_11 = new JLabel(" \u836F\u54C14\u6570\u91CF\uFF1A");
		panel_1.add(label_11);
		
		JLabel label_12 = new JLabel("New label");
		panel_1.add(label_12);
		
		JButton button_3 = new JButton("\u68C0\u67E5\u8BE5\u836F\u54C1\u53CA\u5E93\u5B58");
		panel_1.add(button_3);
		
		JButton button_5 = new JButton("\u67E5\u770B\u75C5\u4EBA\u4FE1\u606F");
		button_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			    frm=new JFrame();
				   JLabel lb1,lb2,lb22,lb3,lb33,lb4,lb44,lb5,lb55;
				   JPanel j1,j2,j3;
				    
					j1=new JPanel();
					j2=new JPanel();
					j3=new JPanel();
					
					frm.getContentPane().add(j1, BorderLayout.NORTH);
					frm.getContentPane().add(j2, BorderLayout.CENTER);
					j2.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
					lb1=new JLabel("病人的信息：  ");  
					j1.add(lb1);
					
					 lb22=new JLabel("  病人名字：  ");
					    j2.add(lb22);
					
				    lb2=new JLabel(cs1.getPi().getName());
				    j2.add(lb2);
				    
				    
				    lb33=new JLabel(" 病人电话号码： ")	;
				    j2.add(lb33);
				    lb3=new JLabel(cs1.getPi().getTel())	;
				    j2.add(lb3);
				    
				    lb44=new JLabel(" 病人年龄： ");
				    j2.add(lb44);
				    
				    lb4=new JLabel(String.valueOf(cs1.getPi().getYears()));
				    j2.add(lb4);
				    
				    lb55=new JLabel(" 病人的性别： ")	;
				    j2.add(lb55);
				    if(cs1.getPi().isSex()){
				    lb3=new JLabel("男")	;
				    j2.add(lb3);}
				    else {
				    	 lb3=new JLabel("女");
						    j2.add(lb3);
				    }
			
				    frm.setBounds(600, 400, 200, 90);//设置长宽大小
					frm.setVisible(true);//显示
				
				
				
			}
		});
		panel_1.add(button_5);
		
		JButton button_4 = new JButton("\u786E\u5B9A\u63D0\u53D6");
		panel_1.add(button_4);
	}

}
