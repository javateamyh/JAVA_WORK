package Treatment;



import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.xml.ws.handler.MessageContext.Scope;

import all_class.*;

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

	private static ArrayList<Case> clist;//���ܷ�������Ϣ��clist
	private static ArrayList<Case> clist1;//���͵������޸ķ�������clist1
    private static Account account;
     static ObjectOutputStream out;
	private static int i=0;
	private static ArrayList<Drug_info> list;//�����޸�clist1��ҽ������ҩ
	private static Global_info global_info;//(�ӷ��������ܵ�ȫ�ֱ���  ��Ҫ����ҩ����Ϣ��
	private JPanel contentPane;
	private static Socket socket;
	public Treatment1(Account account,Socket socket) {
		this.socket=socket;
		this.account=account;
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
			    	clist=new ArrayList<Case>();
					clist1=new ArrayList<Case>() ;
		
				try {				
			     out =new ObjectOutputStream(socket.getOutputStream());	
			     out.writeObject(account);//���߷������ͻ��˵�����
			     out.flush();
			     try {
			    	 ObjectInputStream in=new 
								ObjectInputStream(socket.getInputStream());
					global_info=(Global_info) in.readObject();
					clist=(ArrayList<Case>) in.readObject();
				} catch (ClassNotFoundException e2) {
					// TODO Auto-generated catch block
					e2.printStackTrace();
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
						
						lb1=new JLabel("Ŀǰ�޲��˲���");  
					
					    j1.add(lb1);
					    frm.setBounds(600, 100, 300, 250);//���ó����С
						  frm.setVisible(true);//��ʾ
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
				Treatment frame = new Treatment(out,global_info,clist1,i);
				frame.setVisible(true);
				i++;
				
			}if(i+1==clist1.size())
			{
				i=0;
				
			}	
			
			}}		
		});
		panel_1.add(button);
	}

}
