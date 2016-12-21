package Usst;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.io.Serializable;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JButton;
import javax.swing.JMenuBar;

public class Treatment extends JFrame {
    static ArrayList<Case> clist;//接受服务器信息的clist
    static ArrayList<Case> clist1;//发送的用于修改服务器的clist1
    static int sum;
    static int i=0;
    static ArrayList<Drug_info> list;//用于修改clist1的医生开的药
    static  private Drug_info d1,d2,d3,d4;//医生开的药
    static Charge_info crg1;//医生的看病费
    private static ObjectOutputStream out;
    private static Account acc;
	private JPanel contentPane;
	private JTextField med_na1;
	private JTextField med_num1;
	private JTextField fee_num1;
	private JTextField med_na2;
	private JTextField med_num2;
	private JTextField med_num3;
	private JTextField med_na3;
	private JTextField med_na4;
	private JTextField med_num4;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
	
		
		int cishu=0;
	    while(cishu<4){
	    	cishu++;i=0;
		Socket server=null;
		try {
			server =new Socket("192.168.75.1",5001);
			
			ObjectInputStream in=new 
					ObjectInputStream(server.getInputStream());
			
	     out =new ObjectOutputStream(server.getOutputStream());
		 acc.setFlag(3); 
	     out.writeObject(acc);//告诉服务器客户端的类型
	     out.flush();
		    try {
				clist=(ArrayList<Case>) in.readObject();
			} catch (ClassNotFoundException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
	        
		} catch (UnknownHostException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		}

		if(clist==null){
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
			int j=0;
			while(i+1<clist.size()){
				
			while(clist.get(j).getApp().getAppoint_time()>60&&
					clist.get(j).getApp().getAppoint_time()==0)
			{
				
				if(j+1==clist.size()){
					j++;
					break;
				}
				
				j++;
			}
			if(j!=clist.size()){
				Case c_forchange;
				c_forchange=clist.get(j);
				int k1=0;
				int k2=j;
				for(k1=0;k1<k2;k1++)
				{
				clist.set(j, clist.get(j-1));
				j--;
				}
				
				clist.set(0, c_forchange);
			}
			
			clist1=clist;
		list=clist1.get(i).getDrug_list();
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Treatment frame = new Treatment();
					frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});}
				
		
	
	}}}
	
	
	
	

	/**
	 * Create the frame.
	 */
	public Treatment() {
		
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(500, 200, 545, 335);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		
		JButton button_2 = new JButton("\u67E5\u770B\u75C5\u4EBA\u60C5\u51B5");
	    ButtonHandler1 btnHandler=new ButtonHandler1();
			button_2.addActionListener(btnHandler);
		menuBar.add(button_2);
		
		
		
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u533B\u751F\u5C31\u8BCA\u5212\u4EF7\u7AEF");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C11\u62FC\u97F3\u7801");
		panel_1.add(label_1);
		
		med_na1 = new JTextField();
		panel_1.add(med_na1);
		med_na1.setColumns(10);
		d1.setDrug_pinyin(med_na1.getText());
		
		 
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C11\u7684\u6570\u91CF");
		panel_1.add(label_2);
		
		med_num1 = new JTextField();
		panel_1.add(med_num1);
		med_num1.setColumns(10);
		d1.setDrug_count(Integer.parseInt( med_num1.getText()));
		list.add(d1);
		JLabel label_5 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C12\u62FC\u97F3\u7801");
		panel_1.add(label_5);
		
		med_na2 = new JTextField();
		panel_1.add(med_na2);
		med_na2.setColumns(10);
		d2.setDrug_pinyin(med_na2.getText());
	
		
		JLabel label_6 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C12\u7684\u6570\u91CF");
		panel_1.add(label_6);
		
		med_num2 = new JTextField();
		panel_1.add(med_num2);
		med_num2.setColumns(10);
		d2.setDrug_count(Integer.parseInt(med_num2.getText()) );
		list.add(d2);
		
		JLabel label_10 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C13\u62FC\u97F3\u7801");
		panel_1.add(label_10);
		
		med_na3 = new JTextField();
		med_na3.setColumns(10);
		panel_1.add(med_na3);
		d3.setDrug_pinyin(med_na3.getText());
		
		
		JLabel label_9 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C13\u7684\u6570\u91CF");
		panel_1.add(label_9);
		
		med_num3 = new JTextField();
		med_num3.setColumns(10);
		panel_1.add(med_num3);
		d3.setDrug_count(Integer.parseInt(med_num3.getText()) );
		list.add(d3);
		
		JLabel label_11 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C14\u62FC\u97F3\u7801");
		panel_1.add(label_11);
		
		med_na4 = new JTextField();
		med_na4.setColumns(10);
		panel_1.add(med_na4);
		d4.setDrug_pinyin(med_na4.getText());
		
		
		JLabel label_12 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C14\u7684\u6570\u91CF");
		panel_1.add(label_12);
		
		med_num4 = new JTextField();
		med_num4.setColumns(10);
		panel_1.add(med_num4);
		d4.setDrug_count(Integer.parseInt(med_num4.getText()) );
		list.add(d4);clist1.get(i).setDrug_list(list);
		
		JLabel label_3 = new JLabel("\u6536\u8D39\u9879\u76EE1\uFF1A\u533B\u751F\u770B\u75C5\u8D39 ");
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u533B\u751F\u8D39\u7684\u4EF7\u683C");
		panel_1.add(label_4);
		
		fee_num1 = new JTextField();
		panel_1.add(fee_num1);
		fee_num1.setColumns(10);
		crg1.setDocter_fee(Integer.parseInt(fee_num1.getText()));
		
		
		JLabel label_8 = new JLabel("\u6536\u8D39\u9879\u76EE2\uFF1A\u836F\u54C1\u603B\u8D39 ");
		panel_1.add(label_8);
		
		JLabel label_7 = new JLabel("\u836F\u54C1\u603B\u8D39\u4EF7\u683C\uFF1A ");
		panel_1.add(label_7);
		
		sum=Integer.parseInt( med_num1.getText())+
				Integer.parseInt( med_num2.getText())+
				Integer.parseInt( med_num3.getText())+
				Integer.parseInt( med_num4.getText());
		JLabel lblNewLabel = new JLabel("\u603B\u8D39\u4E3A "+sum);
		panel_1.add(lblNewLabel);
		crg1.setDrug_fee(sum);
		clist1.get(i).setCharge(crg1);
		
		
		
		
		
		JButton button = new JButton("\u786E\u5B9A\u53D1\u9001");
		panel_1.add(button);
	
		
		
		
		
	}
	
	
	
	
	
	class ButtonHandler1 implements ActionListener{
    //发送按钮的事件监听器
		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub
		
			JFrame frm2;
		    frm2=new JFrame();
			   JLabel lb1;
			   JPanel j1;
			    
				j1=new JPanel();
				frm2.getContentPane().add(j1, BorderLayout.NORTH);
				try {
					
					if(i+1==clist1.size()){
						out.writeObject(clist1);
						i=0;
					}
					else{
						i++;
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				lb1=new JLabel("已经发送至收费端和药房端");  
			
			    j1.add(lb1);
			    frm2.setBounds(600, 400, 200, 90);//设置长宽大小
				  frm2.setVisible(true);//显示
		}
		
	}
	
	


}
