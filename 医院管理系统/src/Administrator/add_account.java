package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Account;
import all_class.Global_info;

import javax.swing.JLabel;
import java.awt.GridLayout;
import java.awt.RenderingHints.Key;

import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;
import javax.swing.JRadioButton;

public class add_account extends JFrame {
    private Account account;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
private  static Global_info global_info;
static int key=1;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public add_account(Link link) {
		this.global_info=link.getGlobal_info();
		this.account=link.getAccount();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u6DFB\u52A0\u8D26\u53F7");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel lblNewLabel_1 = new JLabel("\u7535\u8BDD\uFF1A");
		lblNewLabel_1.setBounds(105, 10, 36, 40);
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		textField.setBounds(135, 10, 201, 40);
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label_2 = new JLabel("\u5BC6\u7801\uFF1A");
		label_2.setBounds(105, 50, 36, 40);
		panel_1.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setBounds(135, 50, 201, 40);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		lblNewLabel_2 = new JLabel("New label");
		lblNewLabel_2.setVisible(false);
		lblNewLabel_2.setForeground(Color.RED);
		lblNewLabel_2.setBounds(135, 201, 191, 15);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBounds(0, 126, 212, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setBounds(212, 126, 212, 50);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Account> account_list=global_info.getAccount_list();
				int i;
				boolean f=true;
				
				for(i=0;i<account_list.size();i++)
				{
					if(account_list.get(i).getID().equals(textField.getText()));
					{f=false ;break;}
				}
				if(f)
					{
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setText("对不起，该账号已经被注册，无法再一次被注册！");
					}
				else 
				{
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setText("账号注册成功");
					Account account2=new Account(lblNewLabel_1.getText(), lblNewLabel_2.getText(), key);
					account_list.add(account2);
					global_info.setAccount_list(account_list);
					link.setGlobal_info(global_info);//     记录
				}
					
				
				
				
			}
		});
		panel_1.add(btnNewButton_1);
		
		JRadioButton rdbtnNewRadioButton = new JRadioButton("\u7BA1\u7406\u5458");
		rdbtnNewRadioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//管理员
				key=1;
			}
		});
		rdbtnNewRadioButton.setBounds(50, 96, 61, 23);
		panel_1.add(rdbtnNewRadioButton);
		
		JRadioButton rdbtnNewRadioButton_1 = new JRadioButton("\u533B\u751F");
		rdbtnNewRadioButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//医生
				key=3;
			}
		});
		rdbtnNewRadioButton_1.setBounds(115, 96, 49, 23);
		panel_1.add(rdbtnNewRadioButton_1);
		
		JRadioButton rdbtnNewRadioButton_2 = new JRadioButton("\u836F\u623F");
		rdbtnNewRadioButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//药房
				key=4;
			}
		});
		rdbtnNewRadioButton_2.setBounds(176, 97, 49, 23);
		panel_1.add(rdbtnNewRadioButton_2);
		
		JRadioButton radioButton = new JRadioButton("\u9662\u957F");
		radioButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//院长
				key=5;
			}
		});
		radioButton.setBounds(247, 96, 49, 23);
		panel_1.add(radioButton);
		
		JRadioButton rdbtnNewRadioButton_3 = new JRadioButton("\u6302\u53F7\u7AEF");
		rdbtnNewRadioButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//挂号端
				key=2;
			}
		});
		rdbtnNewRadioButton_3.setBounds(303, 97, 67, 23);
		panel_1.add(rdbtnNewRadioButton_3);
		
	
		
		
	}
}
