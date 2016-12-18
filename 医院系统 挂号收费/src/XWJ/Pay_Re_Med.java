package XWJ;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.*;
import javax.swing.JLabel;
import javax.swing.JButton;

public class Pay_Re_Med extends JFrame {
	private static Case case2;
	private static ArrayList<Case> Register_Charged;//用于挂号端的收费
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
	private JPanel contentPane;
	static int j=0;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		
		case2.getDrug_list().get(j).getDrug_name()//  药品清单里应该存每个药对应的价钱  还是药品都均价
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Pay_Re_Med frame = new Pay_Re_Med();
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
	public Pay_Re_Med() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBounds(0, 0, 424, 35);
		contentPane.add(panel);
		
		JLabel label = new JLabel("--------\u6536\u8D39-------");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBounds(0, 34, 424, 25);
		contentPane.add(panel_1);
		
		JLabel lblName = new JLabel("New label");
		panel_1.add(lblName);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(0, 69, 424, 25);
		contentPane.add(panel_2);
		
		JLabel lblNewLabel_1 = new JLabel("New label");
		panel_2.add(lblNewLabel_1);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 104, 424, 35);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 139, 424, 35);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 216, 424, 35);
		contentPane.add(panel_5);
		
		JButton btnNewButton = new JButton("\u8FD4\u56DE\u4E0A\u4E00\u7EA7");
		panel_5.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 184, 424, 35);
		contentPane.add(panel_6);
		
		JButton button = new JButton("\u786E\u8BA4\u7F34\u8D39");
		panel_6.add(button);
	}
}
