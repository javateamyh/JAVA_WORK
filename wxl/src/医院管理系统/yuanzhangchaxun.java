package 医院管理系统;
/*可以查询统计每个科室的挂号量和总金额（可以选择生成饼图统计）；
 * 查询药房各个药品的库存量；
 * 查询统计每个医生的就诊数量和金额；
 */

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import all_class.Account;
import all_class.Drug_info;
import all_class.Global_info;
import all_class.Office;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.List;

public class yuanzhangchaxun {

	private JFrame frame;
	static Global_info global_info=new Global_info();
	static Account account=new Account("","",1);
	static ArrayList<Office> office=global_info.getCount_office();
	static ArrayList<Drug_info> drug=global_info.getDrug_list();
    
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yuanzhangchaxun window = new yuanzhangchaxun();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(true){//向服务器发送请求
			Socket server=null;
			try{
				server =new Socket("127.0.0",2303);
					
				ObjectInputStream in=new ObjectInputStream(server.getInputStream());//由套接对象输入
				ObjectOutputStream out=new ObjectOutputStream(server.getOutputStream());//由套接对象输出
				
				account.setFlag(6);
				out.writeObject(account.getFlag());
				out.flush();
				try{
					account=(Account) in.readObject();
					out.close();
					in.close();
					server.close();
				}catch (ClassNotFoundException e) {
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
			}
		
		String doctorname[]=new String [office.size()];
		String officename[]=new String[office.size()];
		
		for(int i=0;i<office.size();i++)
					{
					officename[i]=office.get(i).getOffice_name();
					doctorname[i]=office.get(i).getDocter_name();
					}
		/****************************还要修改的************************************/
		for(int i=0;i<office.size();i++)//挂号量和总金额
		  System.out.println(officename[i]+"的挂号量为：    总金额为：");
		
		for(int i=0;i<drug.size();i++)//药的库存为
			  System.out.println(drug.get(i).getDrug_name() +"的库存为："+drug.get(i).getDrug_count());
		
		for(int i=0;i<drug.size();i++)//医生的就诊数量和金额
			  System.out.println(doctorname[i]+"的就诊量为：     金额为：");
	}

	/**
	 * Create the application.
	 */
	public yuanzhangchaxun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u6240\u8981\u67E5\u8BE2\u7684\u5185\u5BB9\uFF1A");
		panel.add(label);
		
		String [] s={"每个科室的挂号量和总金额","药房各个药品的库存量","每个医生的就诊数量和金额"};
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		
		
		
		int key=comboBox.getSelectedIndex();
		switch(key)
		{
		case 0:{
			JRadioButton radioButton = new JRadioButton("\u751F\u6210\u997C\u72B6\u56FE");
			panel.add(radioButton);
			if(radioButton.isSelected())//每个科室的挂号量和总金额（选择生成饼图统计）
			{
				
			}
			else
			{
				JTextPane textPane = new JTextPane();
				textPane.setText("");
				panel.add(textPane);
				
			}
		}
		case 1://查询药房各个药品的库存量；
		{
			
		}
		case 2://查询统计每个医生的就诊数量和金额；
		{
			
		}
		}
	}

}
