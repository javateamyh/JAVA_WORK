package Register_Charge;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pay_Re_Med extends JFrame {
	private static Case case2;
	private static ArrayList<Case> Register_Charged;//用于挂号端的收费
	private JPanel contentPane;
	static int j=0;
	static int i=0;
	private static Socket socket;
	private static Account account;
	 private  static Global_info global_info;
	
	 static int page=0;
	 
	 public static void up_load()
	 {
		 TCP tcp=new TCP();
		 tcp.setCase_toStore(Register_Charged);
	 }
	 public static void GetData()
		{
			TCP tcp =new TCP();
			global_info=tcp.get_global_info();
			Register_Charged=tcp.GetCase_toCharge();	
		}
	public Pay_Re_Med() {
		if(i==0)
		{
			GetData();
		}
		JLabel lblName = new JLabel("New label");
		JLabel lblPay = new JLabel("New label");	
		if(i<Register_Charged.size())
		{
			case2=Register_Charged.get(i);
			lblName.setText("病人: " +case2.getPi().getName());
			lblPay.setText("病人需要缴费 " +case2.getCharge().getSum_fee());
			case2.getCharge().setPay(true);
		}
		
		
		//处理完成的病人都将修改写回服务器
		
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 424, 35);
		contentPane.add(panel);
		
		JLabel label = new JLabel("--------\u6536\u8D39-------");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 34, 424, 25);
		contentPane.add(panel_1);
		
		
		panel_1.add(lblName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 69, 424, 25);
		contentPane.add(panel_2);
		
	
		panel_2.add(lblPay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 104, 424, 35);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 139, 424, 35);
		contentPane.add(panel_4);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVisible(false);
		panel_4.add(lblNewLabel);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 216, 424, 35);
		contentPane.add(panel_5);
		
		JButton button_1 = new JButton("\u9000\u51FA");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				dispose();
			}
		});
		panel_5.add(button_1);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 184, 424, 35);
		contentPane.add(panel_6);
		
		JButton button = new JButton("\u786E\u8BA4\u7F34\u8D39");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				if(i<Register_Charged.size())
				{    i++;
					dispose();
					Pay_Re_Med frame = new Pay_Re_Med();
					frame.setVisible(true);
					
				}
				else 
				{
					lblNewLabel.setVisible(true);
					lblNewLabel.setText("所有人员收费完成");
					up_load();
				}
			
				
			}
		});
		panel_6.add(button);
	}
}
