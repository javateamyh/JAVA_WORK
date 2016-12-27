package test;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.nio.channels.NonWritableChannelException;
import java.awt.event.ActionEvent;

public class t2 extends JFrame {

	private JPanel contentPane;
    static int page=0;
	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					t2 frame = new t2();
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
	public t2() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("New label");
		panel.add(lblNewLabel);
		lblNewLabel.setText(String.valueOf(page));
		JButton button = new JButton("\u4E0B\u4E00\u4E2A");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				page++;
				dispose();
			t2 t=new t2();
			t.setVisible(true);
			}
		});
		panel.add(button);
	}

}
