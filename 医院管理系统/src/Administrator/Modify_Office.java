package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Global_info;
import all_class.Office;
import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Modify_Office extends JFrame {
    private static ArrayList<Office> offices;
    private static Global_info global_info;
	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	
	public Modify_Office(Link link,int flag) {
		global_info=link.getGlobal_info();
		offices=global_info.getCount_office();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u79D1\u5BA4\u4FE1\u606F\u4FEE\u6539");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(null);
		
		JLabel label_1 = new JLabel("\u79D1\u5BA4\u540D\u79F0\uFF1A");
		label_1.setBounds(0, 0, 60, 36);
		panel_1.add(label_1);
		
		textField = new JTextField();
		textField.setVisible(false);
		textField.setBounds(61, 8, 180, 21);
		panel_1.add(textField);
		textField.setColumns(10);
		textField.setText(offices.get(flag).getOffice_name());
		
		JButton button = new JButton("\u4FEE\u6539");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setVisible(true);
				
			}
		});
		button.setBounds(255, 7, 93, 23);
		panel_1.add(button);
		
		JLabel label_2 = new JLabel("\u533B\u751F\uFF1A");
		label_2.setBounds(0, 46, 54, 21);
		panel_1.add(label_2);
		
		textField_1 = new JTextField();
		textField_1.setVisible(false);
		textField_1.setBounds(61, 46, 180, 21);
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		String name=null;
		int i;
		for(i=0;i<offices.get(flag).getDocter_name().size()-1;i++)
		{
			name+=offices.get(flag).getDocter_name().get(i)+" ";
		}
		name+=offices.get(flag).getDocter_name().get(i-1);
		
		textField_1.setText(name);
		JButton button_1 = new JButton("\u4FEE\u6539");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_1.setVisible(true);
			
			}
		});
		button_1.setBounds(255, 45, 93, 23);
		panel_1.add(button_1);
		
		JLabel label_3 = new JLabel("\u6536\u8D39\uFF1A");
		label_3.setBounds(0, 88, 54, 28);
		panel_1.add(label_3);
		
		textField_2 = new JTextField();
		textField_2.setVisible(false);
		textField_2.setBounds(63, 91, 178, 24);
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		textField_2.setText(String.valueOf(offices.get(flag).getCharge()));
		
		JButton button_2 = new JButton("\u4FEE\u6539");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField_2.setVisible(true);
			}
		});
		button_2.setBounds(255, 90, 93, 23);
		panel_1.add(button_2);
		
		JButton btnNewButton = new JButton("\u53D6\u6D88");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		btnNewButton.setBounds(61, 151, 93, 23);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u786E\u8BA4");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				offices.get(flag).setOffice_name(textField.getText());
				offices.get(flag).getDocter_name().clear();
				String []group=textField_1.getText().split(" ");
				int i,j;
				for(i=0;i<group.length;i++)
				{
					offices.get(flag).getDocter_name().add(group[i]);
				}
				offices.get(flag).setCharge(Float.parseFloat(textField_2.getText()));
				
				//»áÐ´µ½linkÔÝÊ±´æ´¢
				global_info.setCount_office(offices);
				link.setGlobal_info(global_info);
				
			}
		});
		btnNewButton_1.setBounds(199, 151, 93, 23);
		panel_1.add(btnNewButton_1);
	}
}
