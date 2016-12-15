package XWJ;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTextPane;
import javax.swing.JButton;

public class Med_Pay extends JFrame {

	private JPanel contentPane;
	private JTextField textField;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Med_Pay frame = new Med_Pay();
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
	public Med_Pay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 424, 32);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u6B63\u5728\u53D6\u836F\u6536\u8D39");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 43, 424, 50);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u75C5\u4EBA\u59D3\u540D");
		panel_1.add(label_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 103, 424, 42);
		contentPane.add(panel_2);
		
		JLabel label_3 = new JLabel("\u8BE5\u75C5\u4EBA\u9700\u8981\u652F\u4ED8\u836F\u54C1\u8D39\u7528");
		panel_2.add(label_3);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_2.add(lblNewLabel);
		
		JLabel label_2 = new JLabel("");
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 103, 424, 51);
		contentPane.add(panel_3);
		
		JLabel label_4 = new JLabel("");
		panel_3.add(label_4);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 153, 424, 51);
		contentPane.add(panel_4);
		
		JLabel label_5 = new JLabel("\u8BF7\u5C3D\u5FEB\u7F34\u8D39");
		panel_4.add(label_5);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 211, 424, 50);
		contentPane.add(panel_5);
		
		JLabel label_6 = new JLabel("");
		panel_5.add(label_6);
		
		class ButtonHandler5 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub  
				Register frame = new Register();
				frame.setVisible(true);
			}	
		}
		JButton buttonMed = new JButton("\u786E\u8BA4\u7F34\u8D39");
		panel_5.add(buttonMed);
		ButtonHandler5 btnHandler5=new ButtonHandler5();
		buttonMed.addActionListener(btnHandler5);
	}
}
