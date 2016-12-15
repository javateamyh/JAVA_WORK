package XWJ;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Patient_Now extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Patient_Now frame = new Patient_Now();
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
	public Patient_Now() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 424, 34);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u6B64\u75C5\u4EBA\u6700\u65B0\u9884\u7EA6\u60C5\u51B5");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 44, 424, 34);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u9884\u7EA6\u79D1\u5BA4");
		panel_1.add(label_1);
		
		JLabel lblNewLabel = new JLabel("\u663E\u793A\u533B\u751F\u4E8B\u4EF6");
		panel_1.add(lblNewLabel);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 98, 424, 34);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("\u9884\u7EA6\u533B\u751F");
		panel_2.add(lblNewLabel_1);
		
		JLabel label_2 = new JLabel("\u663E\u793A\u533B\u751F\u59D3\u540D");
		panel_2.add(label_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 152, 424, 34);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 184, 424, 67);
		contentPane.add(panel_4);
		class ButtonHandler5 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub  
				Res_Pay frame = new Res_Pay();
				frame.setVisible(true);
			}	
		}
		JButton buttonPay = new JButton("\u6302\u53F7\u6536\u8D39");
		panel_4.add(buttonPay);
		ButtonHandler5 btnHandler5=new ButtonHandler5();
		buttonPay.addActionListener(btnHandler5);	
	}
}
