package Check;
/*可以查询统计每个科室的挂号量和总金额（可以选择生成饼图统计）；
 * 查询药房各个药品的库存量；
 */
//从服务器端要得到ArrayList<Office>，ArrayList<Drug_info> 不需要向服务器传递信息
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
import all_class.ipconfig;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.List;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Label;

public class yuanzhangchaxun {

	private JFrame frame;
	//static Global_info global_info=new Global_info();
	static Account account;//院长的账号信息
	static ArrayList<Office> office_list;
	static ArrayList<Drug_info> drug_list;
	 static String host="127.0.0.1";
	 static int port=5000;
    

public yuanzhangchaxun (Account account) {
	this.account=account;
	check_up();
}
	public static void check_up() {
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
			try{ipconfig ip=new ipconfig();
			server=new Socket(ip.getHost(),ip.getPort());
			
					
				ObjectInputStream in=new ObjectInputStream(server.getInputStream());//由套接对象输入
				ObjectOutputStream out=new ObjectOutputStream(server.getOutputStream());//由套接对象输出
				
				account.setFlag(6);
				out.writeObject(account.getFlag());//向服务器发送标志
				out.flush();
				try{
					//从服务器接收科室数组和药品信息数组
					office_list=(ArrayList<Office>) in.readObject();
					drug_list=(ArrayList<Drug_info>) in.readObject();
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
		
		 String officename[]=new String[office_list.size()];//存放所有科室的名字
			for(int i=0;i<office_list.size();i++)
			{
			officename[i]=office_list.get(i).getOffice_name();
			}
		
		String [] s={"每个科室的挂号量和总金额","药房各个药品的库存量"};
		JComboBox comboBox = new JComboBox(s);//可供院长选择功能
		comboBox.setSelectedIndex(-1);
		panel.add(comboBox);
		int key=comboBox.getSelectedIndex();//记录院长所选择的功能
		
		String drugname[]=new String[drug_list.size()];//存放所有药的名字
		for(int i=0;i<drug_list.size();i++)
		{
		drugname[i]=drug_list.get(i).getDrug_name();
		}

		switch(key)//根据院长所选的功能呈现不同的页面
		{
		case 0:{//每个科室的挂号量和总金额
			Label label_1 = new Label("\u9009\u62E9\u6240\u8981\u67E5\u8BE2\u7684\u79D1\u5BA4\uFF1A");//选择科室标签
			panel.add(label_1);
			//JRadioButton radioButton = new JRadioButton("\u751F\u6210\u997C\u72B6\u56FE");//是否生成饼状图的button
			//panel.add(radioButton);
			JComboBox comboBox_1 = new JComboBox(officename);//选择科室的下拉框
			panel.add(comboBox_1);
			comboBox_1.setSelectedIndex(-1);
			int key1=comboBox_1.getSelectedIndex();//记录所要查询的科室
			
			//if(radioButton.isSelected())//每个科室的挂号量和总金额（选择生成饼图统计）
			//{
				
			//}
			//else
			//{//显示所选中科室的总金额
				JTextPane textPane = new JTextPane();
				textPane.setText("总金额为："+office_list.get(key1).getCharge());
				panel.add(textPane);
				
				//for(int i=0;i<office_list.size();i++)//每个科室挂号量和总金额
					  //System.out.println(officename[i]+"的挂号量为：总金额为："+office_list.get(i).getCharge());
			//}
		}
		case 1://查询药房各个药品的库存量；
		{
			JLabel lblNewLabel = new JLabel("\u9009\u62E9\u6240\u8981\u67E5\u8BE2\u7684\u836F\u54C1\u7684\u540D\u79F0\uFF1A");
			panel.add(lblNewLabel);
			JComboBox comboBox_2 = new JComboBox(drugname);//存放药名的下拉框
			panel.add(comboBox_2);
			comboBox.setSelectedIndex(-1);
	        int key2=comboBox.getSelectedIndex();//记录所选择的药品名
	        JTextPane textPane_1 = new JTextPane();
			textPane_1.setText("总金额为："+drug_list.get(key2).getDrug_count());//显示对应的金额
			panel.add(textPane_1);
	        
			//for(int i=0;i<drug_list.size();i++)//药的库存为
				  //System.out.println(drug_list.get(i).getDrug_name() +"的库存为："+drug_list.get(i).getDrug_count());
		}
		}
	}

}
