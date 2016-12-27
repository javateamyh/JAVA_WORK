package Treatment;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.*;
import all_class.Charge_info;
import all_class.Drug_info;

import javax.swing.JLabel;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;
import javax.swing.JTextField;
import java.awt.FlowLayout;
import java.awt.List;
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
    
    private static ArrayList<Case> clist1;//发送的用于修改服务器的clist1
    static float sum=0;
    static int i=0;
    static ArrayList<Drug_info> list=new ArrayList<Drug_info>() ;//用于修改clist1的医生开的药
    static  private Drug_info d1,d2;//医生开的药
    static  private  Charge_info crg;
 
    private static Account acc;   
	private JPanel contentPane;
	private JTextField med_na1;
	private JTextField med_num1;
	private JTextField fee_num1;
	private JTextField med_na2;
	private JTextField med_num2;

	/**
	 * Launch the application.
	 */
//	public static void Call_Treatment() {
//	
//		
//		int cishu=0;
//	    while(cishu<4){
//	    	cishu++;
//		Socket server=null;
//		try {
//			server =new Socket("10.40.255.254",5000);
//			
//			ObjectInputStream in=new 
//					ObjectInputStream(server.getInputStream());
//			
//	     out =new ObjectOutputStream(server.getOutputStream());
//		 acc.setFlag(3); 
//	     out.writeObject(acc);//告诉服务器客户端的类型
//	     out.flush();
//		    try {
//				clist=(ArrayList<Case>) in.readObject();
//			} catch (ClassNotFoundException e) {
//				// TODO Auto-generated catch block
//				e.printStackTrace();
//			}
//	        
//		} catch (UnknownHostException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		} catch (IOException e1) {
//			// TODO Auto-generated catch block
//			e1.printStackTrace();
//		}
//
//		if(clist==null){
//			JFrame frm=new JFrame();
//			   JLabel lb1;
//			   JPanel j1;
//			    
//				j1=new JPanel();
//				frm.getContentPane().add(j1, BorderLayout.NORTH);
//				
//				lb1=new JLabel("目前无病人病例");  
//			
//			    j1.add(lb1);
//			    frm.setBounds(600, 100, 300, 250);//设置长宽大小
//				  frm.setVisible(true);//显示
//		}
//		
//		else{
//			int j=0;
//			while(i+1<clist.size()){
//				
//			while(clist.get(j).getApp().getAppoint_time()>60&&
//					clist.get(j).getApp().getAppoint_time()==0)
//			{
//				
//				if(j+1==clist.size()){
//					j++;
//					break;
//				}
//				
//				j++;
//			}
//			if(j!=clist.size()){
//				Case c_forchange;
//				c_forchange=clist.get(j);
//				int k1=0;
//				int k2=j;
//				for(k1=0;k1<k2;k1++)
//				{
//				clist.set(j, clist.get(j-1));
//				j--;
//				}
//				
//				clist.set(0, c_forchange);
//			}
//			
//			clist1=clist;
//		list=clist1.get(i).getDrug_list();
//		
//	}
//				
//		
//	
//	}}}
//	
//	
	
	

	/**
	 * Create the frame.
	 */
	public Treatment(ObjectOutputStream os,ObjectInputStream is, Socket socket,Global_info glo_info,ArrayList<Case> clist1,int i) {
		//Call_Treatment();
		sum=0;
		crg=new Charge_info();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

		setBounds(500, 200, 545, 335);
		
		JMenuBar menuBar = new JMenuBar();
		setJMenuBar(menuBar);
		JButton button_2 = new JButton("\u67E5\u770B\u7B2C"+(i+1)+"\u4E2A\u75C5\u4EBA\u60C5\u51B5");
		
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				JFrame frm;
			    frm=new JFrame();
				   JLabel lb1,lb2,lb3,lb4,lb5,lb6,lb7;
				   JPanel j1,j2;
				    
					j1=new JPanel();
					frm.getContentPane().add(j1, BorderLayout.NORTH);
					lb1=new JLabel("该病人信息");
					
					
					j2=new JPanel();
					frm.getContentPane().add(j2, BorderLayout.CENTER);
					lb2=new JLabel("该病人姓名");
					lb3=new JLabel(clist1.get(i).getPi().getName());
					
					lb4=new JLabel("该病人年龄");
					lb5=new JLabel(String.valueOf(clist1.get(i).getPi().getYears()));
					

					lb6=new JLabel("该病人电话");
					lb7=new JLabel(clist1.get(i).getPi().getTel());
					
					
				    j1.add(lb1);
					j2.add(lb2);
					j2.add(lb3);
					j2.add(lb4);
					j2.add(lb5);
					j2.add(lb6);
					j2.add(lb7);
					
				    frm.setBounds(600, 400, 200, 90);//设置长宽大小
					  frm.setVisible(true);//显示
				
				
				
			}
		});

		menuBar.add(button_2);
		
		JLabel lblNewLabel = new JLabel("\u603B\u8D39\u4E3A "+sum);
		
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
		
		
		
	
		
		 
		JLabel label_2 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C11\u7684\u6570\u91CF");
		panel_1.add(label_2);
		
		med_num1 = new JTextField();
		panel_1.add(med_num1);
		med_num1.setColumns(10);
		
		
		JButton button_1 = new JButton("\u786E\u5B9A");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gcount=0;
				for(gcount=0;gcount<glo_info.getDrug_list().size();gcount++)
				{if(med_na1.getText().equals(glo_info.getDrug_list().get(gcount).getDrug_pinyin()))
						{sum=sum+glo_info.getDrug_list().get(gcount).getDrug_price()*
					       Integer.parseInt( med_num1.getText());
						d1=new Drug_info(glo_info.getDrug_list().get(gcount).getDrug_pinyin(),
								glo_info.getDrug_list().get(gcount).getDrug_name(),
								glo_info.getDrug_list().get(gcount).getDrug_price(), 
								glo_info.getDrug_list().get(gcount).getDrug_count()
								);
						d1.setDrug_use(Integer.parseInt( med_num1.getText()));
						list.add(d1);
						break;
						};
						
				}
				lblNewLabel.setText(String.valueOf(sum));
				
			}
		});
		panel_1.add(button_1);
		JLabel label_5 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C12\u62FC\u97F3\u7801");
		panel_1.add(label_5);
		
		med_na2 = new JTextField();
		panel_1.add(med_na2);
		med_na2.setColumns(10);
		
	
		
		JLabel label_6 = new JLabel("\u8BF7\u8F93\u5165\u836F\u54C12\u7684\u6570\u91CF");
		panel_1.add(label_6);
		
		med_num2 = new JTextField();
		panel_1.add(med_num2);
		med_num2.setColumns(10);
		
	
		
		JButton button_3 = new JButton("\u786E\u5B9A");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int gcount=0;
				for(gcount=0;gcount<glo_info.getDrug_list().size();gcount++)
				{if(med_na2.getText().equals(glo_info.getDrug_list().get(gcount).getDrug_pinyin()))
						{sum=sum+glo_info.getDrug_list().get(gcount).getDrug_price()*
					       Integer.parseInt( med_num2.getText());
						d2=new Drug_info(glo_info.getDrug_list().get(gcount).getDrug_pinyin(),
								glo_info.getDrug_list().get(gcount).getDrug_name(),
								glo_info.getDrug_list().get(gcount).getDrug_price(), 
								glo_info.getDrug_list().get(gcount).getDrug_count()
								);
						d2.setDrug_use(Integer.parseInt( med_num2.getText()));
						list.add(d2);break;
					 
						};
				}
				lblNewLabel.setText(String.valueOf(sum));
				crg.setDrug_fee(sum);
				
			}
		});
		panel_1.add(button_3);
		
		JLabel label_3 = new JLabel("\u6536\u8D39\u9879\u76EE1\uFF1A\u533B\u751F\u770B\u75C5\u8D39 ");
		panel_1.add(label_3);
		
		JLabel label_4 = new JLabel("\u8BF7\u8F93\u5165\u533B\u751F\u8D39\u7684\u4EF7\u683C");
		panel_1.add(label_4);
		
		fee_num1 = new JTextField();
		panel_1.add(fee_num1);
		fee_num1.setColumns(10);
		
		
		JButton button_4 = new JButton("\u786E\u5B9A\u8D39\u7528");
		button_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			crg.setDocter_fee(Integer.parseInt(fee_num1.getText()));
			
			clist1.get(i).setCharge(crg);
			clist1.get(i).setDrug_list(list);
			}
		});
		panel_1.add(button_4);
		JLabel label_8 = new JLabel("\u6536\u8D39\u9879\u76EE2\uFF1A\u836F\u54C1\u8D39 ");
		panel_1.add(label_8);
		
		JLabel label_7 = new JLabel("\u836F\u54C1\u603B\u8D39\u4EF7\u683C\uFF1A ");
		panel_1.add(label_7);
		
		panel_1.add(lblNewLabel);
		
		
		
		
		
		
		
		JButton button = new JButton("\u786E\u5B9A\u53D1\u9001\u5F53\u524D\u75C5\u4EBA\u7684\u6240\u6709\u8D39\u7528\u4FE1\u606F");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				JFrame frm2;
			    frm2=new JFrame();
				   JLabel lb1;
				   JPanel j1;
				    
					j1=new JPanel();
					frm2.getContentPane().add(j1, BorderLayout.NORTH);
					lb1=new JLabel("已经发送至收费端和药房端");  
					
				    j1.add(lb1);
					try {
						
						if(i+1==clist1.size()){
							System.out.println(clist1.size());
							os.writeObject(clist1);
							dispose();
							
						}
						else{
							dispose();
						}
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					
				    frm2.setBounds(600, 400, 200, 90);//设置长宽大小
					  frm2.setVisible(true);//显示
			}
		});
		panel_1.add(button);
	     
		
		
		
		
	}
	

}
