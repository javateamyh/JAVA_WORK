package XWJ;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import XWJ.Res.ButtonHandler2;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Patient extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient frame = new Patient();
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
	public Patient() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel label_Name = new JLabel("");
		label_Name.setBounds(89, 37, 54, 15);
		contentPane.add(label_Name);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 92, 414, 31);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
		JLabel label = new JLabel("\u9884\u7EA6\u79D1\u5BA4");
		panel_1.add(label);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 133, 414, 39);
		contentPane.add(panel_2);
		
		JLabel label_3 = new JLabel("\u9884\u7EA6\u533B\u751F");
		panel_2.add(label_3);
		
		textField_1 = new JTextField();
		panel_2.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel label_2 = new JLabel("");
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 170, 414, 31);
		contentPane.add(panel_3);
		
		JLabel lblNewLabel = new JLabel("\u9884\u7EA6\u65F6\u95F4");
		panel_3.add(lblNewLabel);
		
		textField_2 = new JTextField();
		panel_3.add(textField_2);
		textField_2.setColumns(10);
		
		JLabel label_4 = new JLabel("");
		panel_3.add(label_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 200, 414, 31);
		contentPane.add(panel_4);
		class ButtonHandler5 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub  
				Patient_Now frame = new Patient_Now();
				frame.setVisible(true);
			}	
		}
		
		JButton btnIn = new JButton("\u70B9\u51FB\u67E5\u770B\u6700\u65B0\u6392\u961F\u60C5\u51B5");
		panel_4.add(btnIn);
		ButtonHandler5 btnHandler5=new ButtonHandler5();
		btnIn.addActionListener(btnHandler5);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 37, 414, 45);
		contentPane.add(panel);
		
		JLabel label_5 = new JLabel("\u6B64\u75C5\u4EBA\u5DF2\u7ECF\u9884\u7EA6");
		panel.add(label_5);
		
		
	}
}
