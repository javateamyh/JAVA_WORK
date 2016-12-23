package Register_Charge;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.*;
import java.net.*;
import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.*;

import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class Register extends JFrame {
	static int i=0;
	private static  Account account;
	private static Socket socket;
	private static Global_info global_info;
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
    private static JFrame frame;
	private JPanel contentPane;
	/**
	 * Launch the application.
	 */
	
	
	public static void get_global_info(){
				TCP tcp=new TCP();
				global_info=tcp.get_global_info(); 
	 }
	
	public Register() {
		
		get_global_info();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 47, 434, 34);
		contentPane.add(panel);
		
		JLabel lblNewLabel_1 = new JLabel("");
		panel.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6536\u8D39\u4EBA\u5458");
		panel.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("MissLi");
		panel.add(lblNewLabel_3);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 91, 434, 50);
		contentPane.add(panel_1);
		
		JButton btnReg = new JButton("\u6302\u53F7");
		btnReg.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Res frame = new Res();//นาบล
				frame.setVisible(true);
			}
		});
		panel_1.add(btnReg);
		
		JLabel label = new JLabel("");
		label.setBounds(174, 22, 54, 15);
		contentPane.add(label);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 0, 434, 44);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel = new JLabel("\u6B22\u8FCE\u8FDB\u5165\u6302\u53F7\u6536\u8D39\u7AEF");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 150, 434, 34);
		contentPane.add(panel_3);
		
		JButton btnReg_Pay = new JButton("\u6302\u53F7\u6536\u8D39");
		btnReg_Pay.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Pay_Re_Med frame = new Pay_Re_Med(account,socket);
				frame.setVisible(true);
			}
		});
		panel_3.add(btnReg_Pay);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 203, 434, 58);
		contentPane.add(panel_4);
			
	}
}
