package usst1;



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




public class Treatment1 extends JFrame {

	private static ArrayList<Case> clist;//接受服务器信息的clist
	private static ArrayList<Case> clist1;//发送的用于修改服务器的clist1
    private static Account acc;
     static ObjectOutputStream out;
	private static int i=0;
	private static ArrayList<Drug_info> list;//用于修改clist1的医生开的药
	private static Global_info glo_info;//(从服务器接受的全局变量  主要接受药库信息）
	
	
	
	
	private JPanel contentPane;
	

	public Treatment1() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u533B\u751F\u5C31\u8BCA\u5212\u836F\u63A5\u53E3\u7AEF");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JButton button = new JButton("\u5F00\u59CB\u770B\u75C5");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				int cishu=0;
			    while(cishu<4){
			    	cishu++;
			    	clist=new ArrayList<Case>();
					clist1=new ArrayList<Case>() ;
				Socket server=null;
				try {
					server =new Socket("10.40.255.254",5000);
					
					ObjectInputStream in=new 
							ObjectInputStream(server.getInputStream());
					
			     out =new ObjectOutputStream(server.getOutputStream());
				
			     out.writeObject(acc);//告诉服务器客户端的类型
			     out.flush();
			     
			     try {
					glo_info=(Global_info) in.readObject();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
				}
			     
			     
				    try {
						clist=(ArrayList<Case>) in.readObject();
					} catch (ClassNotFoundException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
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
					while(i+1<=clist.size()){
						
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
				
				Treatment frame = new Treatment(out,glo_info,clist1,i);
				frame.setVisible(true);
				i++;
				
			}if(i+1==clist1.size())
			{
				i=0;}

						
				
			
			}}}
				
				
				
				
				
				
			
		});
		panel_1.add(button);
	}

}
