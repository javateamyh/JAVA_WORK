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

public class Screen extends JFrame {

	private JPanel contentPane;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Screen frame = new Screen();
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
	public Screen() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 0, 414, 37);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u663E\u793A\u5F53\u524D\u6392\u961F\u60C5\u51B5");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 35, 414, 37);
		contentPane.add(panel_1);
		
		JLabel lblNewLabel = new JLabel("\u79D1\u5BA4");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u6392\u961F\u4EBA\u6570");
		panel_1.add(lblNewLabel_1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 72, 414, 37);
		contentPane.add(panel_2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 110, 414, 37);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 143, 414, 37);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 179, 414, 42);
		contentPane.add(panel_5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 231, 414, 30);
		contentPane.add(panel_6);
		class ButtonHandler5 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub  
				Screen frame = new Screen();
				frame.setVisible(true);
			}	
		}
		JButton button = new JButton("\u5237\u65B0");
		panel_6.add(button);
		ButtonHandler5 btnHandler5=new ButtonHandler5();
		button.addActionListener(btnHandler5);	
	}
}
