package XWJ;
import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import XWJ.Register.ButtonHandler1;
import XWJ.Register.ButtonHandler2;

import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JButton;

public class Res extends JFrame {

	private JPanel contentPane;
	private JTextField textName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Res frame = new Res();
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
	public Res() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 424, 35);
		contentPane.add(panel);
		
		JLabel label = new JLabel("--------\u6302\u53F7-------");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 39, 424, 40);
		contentPane.add(panel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 89, 424, 40);
		contentPane.add(panel_2);
		
		JLabel lblName = new JLabel("\u8BF7\u8F93\u5165\u75C5\u4EBA\u59D3\u540D");
		panel_2.add(lblName);
		
		textName = new JTextField();
		panel_2.add(textName);
		textName.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 139, 424, 40);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 183, 424, 35);
		contentPane.add(panel_4);
		
		JButton btnSub = new JButton("\u63D0\u4EA4\u75C5\u4EBA\u4FE1\u606F");
		panel_4.add(btnSub);
		ButtonHandler1 btnHandler1=new ButtonHandler1();
		btnSub.addActionListener(btnHandler1);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 222, 424, 29);
		contentPane.add(panel_5);
		
		JButton btnUP = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		panel_5.add(btnUP);
		ButtonHandler2 btnHandler2=new ButtonHandler2();
		btnUP.addActionListener(btnHandler2);
	}
	
	class ButtonHandler1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub  
			Patient frame = new Patient();
			frame.setVisible(true);
		}	
	}
	
	class ButtonHandler2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub  
			Register frame = new Register();
			frame.setVisible(true);
		}	
	}
}
