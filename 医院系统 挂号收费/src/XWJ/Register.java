package XWJ;
import java.util.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.BorderLayout;
import java.awt.EventQueue;


import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import javax.swing.JSplitPane;
import javax.swing.JScrollPane;

public class Register extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Register frame = new Register();
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
	public Register() {
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
		
		JButton button = new JButton("\u9884\u7EA6\u6D4B\u8BD5\u7248");
		panel_1.add(button);
		ButtonHandler4 btnHandler4=new ButtonHandler4();
		button.addActionListener(btnHandler4);
		
		JButton btnReg = new JButton("\u6302\u53F7");
		panel_1.add(btnReg);
		ButtonHandler1 btnHandler1=new ButtonHandler1();
		btnReg .addActionListener(btnHandler1);
		
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
		panel_3.add(btnReg_Pay);
		ButtonHandler2 btnHandler2=new ButtonHandler2();
		btnReg_Pay .addActionListener(btnHandler2);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 203, 434, 58);
		contentPane.add(panel_4);
		
		JButton btnMed_Pay = new JButton("\u53D6\u836F\u7F34\u8D39");
		panel_4.add(btnMed_Pay);
		ButtonHandler3 btnHandler3=new ButtonHandler3();
		btnMed_Pay .addActionListener(btnHandler3);
	    
	}
	
	class ButtonHandler1 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub  
			Res frame = new Res();
			frame.setVisible(true);
		}	
	}
	class ButtonHandler2 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub  
			Res_Pay frame = new Res_Pay();
			frame.setVisible(true);
		}	
	}
	
	class ButtonHandler3 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub  
			Med_Pay frame = new Med_Pay();
			frame.setVisible(true);
		}	
	}
	
	class ButtonHandler4 implements ActionListener{

		@Override
		public void actionPerformed(ActionEvent e) {
			// TODO Auto-generated method stub  
			Concol concol =new Concol();
        	concol.produce();
        	Res frame = new Res();
			frame.setVisible(true);
		}	
	}
}
