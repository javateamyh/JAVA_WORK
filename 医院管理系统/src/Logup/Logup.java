package Logup;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import Administrator.administrator;
import Check.yuanzhangchaxun;
import Large_Sreen.Screen;
import Register_Charge.Pay_Re_Med;
import Register_Charge.Register;
import Store.Store;
import Store.store1;
import Treatment.Treatment;
import Treatment.Treatment1;
import all_class.Account;
import all_class.ipconfig;
import all_class.statistic_info;
import register.kehuyuyueSwing;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.GridBagLayout;
import java.awt.GridBagConstraints;
import javax.swing.JTextField;
import java.awt.Insets;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.BufferedOutputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.NonWritableChannelException;
import java.awt.event.ActionEvent;
import javax.swing.JRadioButton;

public class Logup extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	static String host="127.0.0.1";
	static int port=5000;
	static Account account_back;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Logup frame = new Logup();
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
	public Logup() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u6765\u5230\u533B\u9662\u7BA1\u7406\u7CFB\u7EDF");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u8D26\u53F7\uFF1A");
		label_1.setBounds(116, 35, 36, 15);
		panel_1.add(label_1);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setBounds(116, 95, 36, 15);
		panel_1.add(label_2);
		
		textField = new JTextField();
		textField.setBounds(171, 27, 171, 31);
		panel_1.add(textField);
		textField.setColumns(10);
		
		textField_1 = new JTextField();
		textField_1.setBounds(171, 87, 171, 31);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVisible(false);
		lblNewLabel.setBounds(162, 128, 171, 31);
		panel_1.add(lblNewLabel);
		
		JButton button = new JButton("\u767B\u5F55");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//账号的登录
				String name,code;
				name=textField.getText();
				code=textField_1.getText();
				Account account=new Account(name, code, 100);
				Socket socket=null;
				try {
					ipconfig ip=new ipconfig();
					socket=new Socket(ip.getHost(),ip.getPort());
					ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream is=new ObjectInputStream(socket.getInputStream());
					os.writeObject(account);
					os.flush();
					account_back=(Account)is.readObject();
					if(account_back.getFlag()==-1)
					{
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("对不起，密码错误");
					}
					else 
					{
						switch (account_back.getFlag()-100) {
						case 1:  administrator administrator=new administrator(os,is,account_back,socket);
						administrator.setVisible(true);break;
						case 2:Register register=new Register(os,is,account_back,socket);register.setVisible(true);break;
						case 3:    {
							Treatment1 treatment=new Treatment1(os,is,account_back,socket);
							treatment.setVisible(true);
							break;
							
						}
						case 4:{ store1 store=new store1(os,is,account_back,socket);store.setVisible(true);break; }
						case 5:{yuanzhangchaxun yuanzhangchaxun=new yuanzhangchaxun(os,is,account_back,socket);
						break;
						}
							
						}
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
			
				
			}
		});
		button.setBounds(240, 155, 102, 31);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u53D6\u6D88");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				dispose();
			}
		});
		button_1.setBounds(130, 155, 89, 31);
		panel_1.add(button_1);
		
		JButton btnNewButton = new JButton("\u75C5\u4EBA\u9884\u7EA6");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {  //病人预约
				
				Socket socket=null;
                Account account=new Account("key","key", 6);
				try {
					ipconfig ip=new ipconfig();
					socket = new Socket(ip.getHost(), ip.getPort());
					ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream is=new ObjectInputStream(socket.getInputStream());
					os.writeObject(account);
					os.flush();
					account_back=(Account)is.readObject();
					if(account_back.getFlag()==-1)
					{
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("对不起，密码错误");
					}
					
					else
					{
					
					try {
						kehuyuyueSwing ke=new kehuyuyueSwing(os,is,account_back,socket);
						ke.setVisible(true);
					} catch (IOException e1) {
						// TODO Auto-generated catch block
						e1.printStackTrace();
					}
					}	
					
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
				
			}
		});
		btnNewButton.setBounds(126, 196, 93, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u5927\u5C4F\u5E55\u663E\u793A");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//大屏幕显示
				Socket socket=null;
				Account account=new Account("key","key", 7);
				try {
					ipconfig ip=new ipconfig();
					socket = new Socket(ip.getHost(), ip.getPort());
					ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
					ObjectInputStream is=new ObjectInputStream(socket.getInputStream());
					os.writeObject(account);
					os.flush();
					account_back=(Account)is.readObject();
					if(account_back.getFlag()==-1)
					{
						lblNewLabel.setVisible(true);
						lblNewLabel.setText("对不起，密码错误");
					}
					
					else
					{
						Screen screen=new Screen(os,is,account_back,socket);
					}
				} catch (IOException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				} catch (ClassNotFoundException e1) {
					// TODO Auto-generated catch block
					e1.printStackTrace();
				}
				
			
			}
		});
		btnNewButton_1.setBounds(240, 196, 93, 23);
		panel_1.add(btnNewButton_1);
		
		
	}
}
