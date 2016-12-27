package Register_Charge;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Account;
import all_class.Appointment;
import all_class.Case;
import all_class.Global_info;
import all_class.Patient_info;
import all_class.TCP;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Registration extends JFrame {

	private JPanel contentPane;
	private static Account account;
	private static Socket socket;
    static int page=0;
    private static Global_info global_info;
    private static  ArrayList<Case> cases;//一系列的病人 
    private static Patient_info pat_info;//个人信息
    private static Appointment app;//预约信息
    private JPanel panel_1;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private JTextField textField_3;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	
	
	public  static  void upload() {
		TCP tcp =new TCP();
		tcp.SetCase_toDocter(cases);
	}
	public static void GetData()
	{
		TCP tcp =new TCP();
		global_info=tcp.get_global_info();
		cases=tcp.GetCase_toReg();//获得等待列表
		
		
	}
	public Registration() {
		if(page==0)//只有第一次接收数据
		{
			GetData();//获得信息
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u6302\u53F7");
		panel.add(label);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 3, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");//姓名
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setVisible(false);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");//性别
		panel_1.add(lblNewLabel_3);
		
		textField_1 = new JTextField();
		textField_1.setVisible(false);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u5E74\u9F84\uFF1A");
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");//年龄
		panel_1.add(lblNewLabel_5);
		
		textField_2 = new JTextField();
		textField_2.setVisible(false);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_1 = new JLabel("\u9884\u7EA6\u65F6\u95F4\uFF1A");
		panel_1.add(label_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");//预约时间
		panel_1.add(lblNewLabel_6);
		
		textField_3 = new JTextField();
		textField_3.setVisible(false);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel label_2 = new JLabel("\u9884\u7EA6\u79D1\u5BA4\uFF1A");
		panel_1.add(label_2);
		
		JLabel lblNewLabel_7 = new JLabel("New label");//预约科室
		panel_1.add(lblNewLabel_7);
		
		JComboBox comboBox = new JComboBox();
		comboBox.setVisible(false);
		panel_1.add(comboBox);
		
		JLabel label_3 = new JLabel("\u9884\u7EA6\u533B\u751F\uFF1A");
		panel_1.add(label_3);
		
		JLabel lblNewLabel_8 = new JLabel("New label");//预约医生
		panel_1.add(lblNewLabel_8);
		JLabel lblNewLabel_9 = new JLabel("New label");
		if(page>=cases.size())//显示病人的信息
		{
			lblNewLabel_9.setVisible(true);
			if(cases.size()==0)
			{
				lblNewLabel_9.setText("当前没有病人预约");
			}
			else 
			{
				upload();
				lblNewLabel_9.setText("病人的信息已经提交给服务器");
			}
				
		}
		else
		{
			pat_info=cases.get(page).getPi();
			app=cases.get(page).getApp();
			lblNewLabel_1.setText(pat_info.getName());
			if(pat_info.isSex())
			lblNewLabel_3.setText("男");
			else lblNewLabel_3.setText("女");
			lblNewLabel_5.setText(pat_info.getYears()+"岁");
			lblNewLabel_6.setText(String.valueOf(app.getAppoint_time()));
			lblNewLabel_7.setText(app.getApp_office().getOffice_name());
			lblNewLabel_8.setText(app.getDocter_name());
			page++;
		}
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//取消的监听事件
				dispose();
			}
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setVisible(false);
		panel_1.add(comboBox_1);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u4E0B\u4E00\u4E2A\u9884\u7EA6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//预约的监听事件
				if(page<cases.size())
				{
					dispose();
					Registration re=new Registration();
					re.setVisible(true);
				}
				
				
			}
		});
		panel_1.add(button_1);
		
		JButton button_2 = new JButton("\u4FEE\u6539\u4E2A\u4EBA\u4FE1\u606F");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//修改病人的信息
				
				
			}
		});
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
	
		lblNewLabel_9.setVisible(false);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel_2.add(lblNewLabel_9);
	}
	

}
