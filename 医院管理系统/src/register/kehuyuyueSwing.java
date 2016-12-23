package register;
//输入病人基本信息（如姓名性别年龄联系方式等等），预约科室，时间。
//从服务器端读入ArrayList<Office> office_list
//向服务器送appointment
import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Account;
import all_class.Appointment;
import all_class.Case;
import all_class.Global_info;
import all_class.Office;
import all_class.Patient_info;
import all_class.ipconfig;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import javax.swing.ComboBoxModel;

import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.io.*;
import java.net.ServerSocket;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;
import java.awt.event.ItemEvent;



public class kehuyuyueSwing extends JFrame {

	static ArrayList<Office> office_list;
	private JPanel contentPane;
	private JTextField textField;//姓名
	private JTextField textField_1;//性别
	private JTextField textField_3;//电话
	private JTextField textField_5;//时间
	static Account account;
	 Patient_info patient=new Patient_info();
	Appointment appointment=new Appointment();
	Case patient_case=new Case();
	
	 static String host="127.0.0.1";
	 static int port=5000;
	 static ArrayList<String> doctername=new ArrayList<String>();
	 private static Socket socket;
	 static int flag=0;//用于存放查找到的医生是第几个科室
	int i,j;//i记录所中的科室在数组中的位置，j记录所中的医生在数组中的位置
	
	public static void Register() throws IOException {
		
//				try {
//					kehuyuyueSwing frame = new kehuyuyueSwing(account);
//					frame.setVisible(true);
//				} catch (Exception e) {
//					e.printStackTrace();
//				}
//			
			
			try{
		
				
				ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());//由套接对象输出
				os.writeObject(account);
				os.flush();
			
				try{
					ObjectInputStream in=new ObjectInputStream(socket.getInputStream());//由套接对象输入
	/*获取全局信息量*/	Global_info global_info=(Global_info)in.readObject();
					office_list=global_info.getCount_office();
				
				
				}catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} 
		
			}
		
			
	

	public   kehuyuyueSwing(Account account,Socket socket) throws IOException {
		this.account=account;
		this.socket=socket;
		Register();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("\u5BA2\u6237\u9884\u7EA6\u7AEF");
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u75C5\u4EBA\u7684\u57FA\u672C\u60C5\u51B5\uFF1A");
		lblNewLabel.setBounds(13, 8, 132, 15);
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u5B57\uFF1A");
		lblNewLabel_1.setBounds(109, 44, 36, 15);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(159, 41, 66, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u5E74\u9F84\uFF1A");
		label.setBounds(109, 107, 36, 15);
		panel_1.add(label);
		
		textField_1 = new JTextField();
		textField_1.setBounds(159, 104, 66, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
		lblNewLabel_2.setBounds(109, 132, 36, 15);
		panel_1.add(lblNewLabel_2);
		
		JRadioButton radioButton=new JRadioButton("\u7537");
		radioButton.setBounds(169, 131, 37, 23);
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(radioButton.isSelected())
				{
					patient.setSex(true);
				}
				else {
					patient.setSex(false);
				}
			}
		});
		panel_1.add(radioButton);
		
		JLabel lblNewLabel_3 = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel_3.setBounds(109, 76, 36, 15);
		panel_1.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		textField_3.setBounds(159, 73, 66, 21);
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u9884\u7EA6\u79D1\u5BA4\uFF1A");
		lblNewLabel_4.setBounds(269, 76, 60, 15);
		panel_1.add(lblNewLabel_4);
				
		
		String officename[]=new String[office_list.size()];//存放所有科室的名
		for(i=0;i<office_list.size();i++)
					{
					officename[i]=office_list.get(i).getOffice_name();
					}
		JComboBox comboBox = new JComboBox(officename);
		comboBox.setBounds(269, 104, 60, 21);
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setBounds(352, 104, 49, 21);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				for(i=0;i<office_list.size();i++)
				{
					if(office_list.get(i).getOffice_name().equals(comboBox.getSelectedItem().toString()))
				//office_list.get(i)选定的科室类;
					{
                         flag=i;
						break;
					}
				
				}
				doctername.clear();
				for(i=0;i<office_list.get(flag).getDocter_name().size();i++)
				{
					doctername.add(office_list.get(flag).getDocter_name().get(i));
				}
				String[] docter=(String[])doctername.toArray(new String[doctername.size()]);
				appointment.setApp_office(office_list.get(i));      //预约标识位
				appointment.setAppoint(true);
				comboBox_1.addItem(doctername);
				
				
			}
		});
	                             //这里有问题
		
		//office.setOffice_name(officename[comboBox.getSelectedIndex()]);
		/*JComboBox petList = new JComboBox(petStrings);

            petList.setSelectedIndex(4);

          petList.addActionListener(this);*/
		
		
		//由所选中的科室名字找到相应的科室信息。
		
		comboBox.setToolTipText("\u9009\u62E9\u79D1\u5BA4");
		panel_1.add(comboBox);
		
		
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			for(i=0;i<office_list.get(flag).getDoctor().size();i++)
			{
				if(office_list.get(i).getDocter_name().get(i).equals(comboBox_1.getSelectedItem().toString()))
					break;
			}
		
			}
			
		});
		comboBox_1.setToolTipText("\u9009\u62E9\u533B\u751F");
		panel_1.add(comboBox_1);/*****************************/

       // office.setDocter_name(doctorname[comboBox_1.getSelectedIndex()]);
       //所选的医生的名字为doctorname[comboBox1.getSelectedIndex()
		
		
		
		JLabel lblNewLabel_5 = new JLabel("\u9884\u7EA6\u65F6\u95F4\uFF1A");
		lblNewLabel_5.setBounds(109, 164, 60, 15);
		panel_1.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		textField_5.setBounds(179, 161, 66, 21);
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JButton button = new JButton("\u63D0\u4EA4");
		button.setBounds(109, 192, 57, 23);
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//上传时间
				/*Patient_info patient=new Patient_info();
				Appointment appointment=new Appointment();
				Case patient_case=new Case();*/
				
				
				patient.setName(textField.getText().toString());
				patient.setSex(JRadioButton.isLightweightComponent(radioButton));//true是男
				patient.setYears(Integer.parseInt(textField_1.getText().toString()) );
				patient.setTel(textField_3.getText().toString());
				
		/* 初始化用户信息*/		patient_case.setPi(patient);
				
				//appointment.setApp_office(officename[]);/****************************/
				
				
				appointment.setAppoint_time(Integer.parseInt(textField_5.getText().toString()));
				appointment.setAppoint(true);
/* 初始化预约信息*/	patient_case.setApp(appointment);
				//向服务器发送消息
				
                ObjectOutputStream os=null;
				try {
					os = new ObjectOutputStream(socket.getOutputStream());
					  os.writeObject(patient_case);
		                os.flush();
		              
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
            
				
				
			}
		});
		panel_1.add(button);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.setBounds(189, 192, 57, 23);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);
		
		JLabel label_2 = new JLabel("\u533B\u751F\uFF1A");
		label_2.setBounds(339, 76, 54, 15);
		panel_1.add(label_2);
	
	}
		}
