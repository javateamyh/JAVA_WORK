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
import javax.swing.JButton;

public class Res_Pay extends JFrame {

	private JPanel contentPane;
	private JTextField textName;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Res_Pay frame = new Res_Pay();
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
	public Res_Pay() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(10, 10, 424, 31);
		contentPane.add(panel);
		
		JLabel label = new JLabel("\u6B63\u5728\u6302\u53F7\u6536\u8D39");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(10, 51, 424, 31);
		contentPane.add(panel_1);
		
		JLabel label_1 = new JLabel("\u8BF7\u8F93\u5165\u75C5\u4EBA\u59D3\u540D");
		panel_1.add(label_1);
		
		textName = new JTextField();
		panel_1.add(textName);
		textName.setColumns(10);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 92, 424, 37);
		contentPane.add(panel_2);
		
		JLabel label_2 = new JLabel("\u5E94\u652F\u4ED8\u6302\u53F7\u8D39\u7528");
		panel_2.add(label_2);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel_2.add(lblNewLabel);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 139, 424, 37);
		contentPane.add(panel_3);
		
		JLabel label_3 = new JLabel("\u8BF7\u53CA\u65F6\u7F34\u8D39\u5C31\u8BCA");
		panel_3.add(label_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 175, 424, 51);
		contentPane.add(panel_4);
		
		class ButtonHandler5 implements ActionListener{

			@Override
			public void actionPerformed(ActionEvent e) {
				// TODO Auto-generated method stub  
				Register frame = new Register();
				frame.setVisible(true);
			}	
		}
		JButton buttonGood = new JButton("\u786E\u8BA4\u7F34\u8D39");
		panel_4.add(buttonGood);
		ButtonHandler5 btnHandler5=new ButtonHandler5();
		buttonGood.addActionListener(btnHandler5);
	}
}
