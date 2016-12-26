package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Account;
import all_class.Global_info;
import all_class.TCP;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;

public class delete_Account extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
   private static Global_info global_info;
   

	public delete_Account(Link link) {
		global_info=link.getGlobal_info();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u5220\u9664\u8D26\u53F7");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(8, 2, 0, 0));
		
		JLabel label_1 = new JLabel("\u8D26\u53F7\uFF1A");
		panel_1.add(label_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("New label");
		lblNewLabel.setVisible(false);
		panel_1.add(lblNewLabel);
		
		JButton btnNewButton = new JButton("\u786E\u8BA4");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			ArrayList<Account> accounts=global_info.getAccount_list();
			int i;
			boolean f=false;
			for(i=0;i<accounts.size();i++)
			{
				if(textField.getText().equals(accounts.get(i).getID()))
				{
					f=true;
					break;
				}
			}
			lblNewLabel.setVisible(true);
				if(f)
				{   
					accounts.remove(i);
					global_info.setAccount_list(accounts);
					link.setGlobal_info(global_info);
					lblNewLabel.setVisible(true);
					lblNewLabel.setText("删除成功");
					
				}
				else
				{
					lblNewLabel.setVisible(true);
					lblNewLabel.setText("对不起，系统中不存在该账号");
				}
			}
		});
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u9000\u51FA");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				setVisible(false);
			}
		});
		panel_1.add(btnNewButton_1);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		lblNewLabel_1.setVisible(false);
		panel_1.add(lblNewLabel_1);
	}

}
