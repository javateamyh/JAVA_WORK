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
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class add_account extends JFrame {
    private Account account;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JLabel lblNewLabel_2;
private  static Global_info global_info;
	/**
	 * Launch the application.
	 */

	/**
	 * Create the frame.
	 */
	public add_account(Account account) {
		this.global_info=global_info;
		this.account=account;
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
		lblNewLabel_2.setBounds(187, 176, 54, 15);
		panel_1.add(lblNewLabel_2);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.setBounds(0, 100, 212, 50);
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.setBounds(212, 100, 212, 50);
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				ArrayList<Account> account_list=global_info.getAccount_list();
				int i;
				boolean f=true;
				
				for(i=0;i<account_list.size();i++)
				{
					if(account_list.get(i).getID().equals(textField.getText()));
					f=false;
				}
				if(!f)
					{
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setText("�Բ��𣬸��˺��Ѿ���ע�ᣬ�޷���һ�α�ע�ᣡ");
					}
				else 
				{
					lblNewLabel_2.setVisible(true);
					lblNewLabel_2.setText("�˺�ע��ɹ�");
					Account account2=new Account(lblNewLabel_1.getText(), lblNewLabel_2.getText(), 1);
					account_list.add(account2);
					global_info.setAccount_list(account_list);
					Link link=new Link(account.getID(),account.getCode(),account.getFlag());
					link.setGlobal_info(global_info);
					link.Connection();
					
					
				}
					
				
				
				
			}
		});
		panel_1.add(btnNewButton_1);
		
	
		
		
	}
}
