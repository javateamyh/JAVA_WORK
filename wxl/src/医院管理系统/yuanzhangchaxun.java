package ҽԺ����ϵͳ;
/*���Բ�ѯͳ��ÿ�����ҵĹҺ������ܽ�����ѡ�����ɱ�ͼͳ�ƣ���
 * ��ѯҩ������ҩƷ�Ŀ������
 * ��ѯͳ��ÿ��ҽ���ľ��������ͽ�
 */

import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;

import all_class.Account;
import all_class.Global_info;
import all_class.Office;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;

public class yuanzhangchaxun {

	private JFrame frame;
	Global_info global_info=new Global_info();
	static Account account=new Account("","",1);

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					yuanzhangchaxun window = new yuanzhangchaxun();
					window.frame.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
		while(true){//���������������
			Socket server=null;
			try{
				server =new Socket("127.0.0",2303);
					
				ObjectInputStream in=new ObjectInputStream(server.getInputStream());//���׽Ӷ�������
				ObjectOutputStream out=new ObjectOutputStream(server.getOutputStream());//���׽Ӷ������
				
				account.setFlag(6);
				out.writeObject(account.getFlag());
				out.flush();
				try{
					account=(Account) in.readObject();
					out.close();
					in.close();
					server.close();
				}catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			} catch (UnknownHostException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			} catch (IOException e1) {
				// TODO Auto-generated catch block
				e1.printStackTrace();
			}
			}
	}

	/**
	 * Create the application.
	 */
	public yuanzhangchaxun() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frame = new JFrame();
		frame.setBounds(100, 100, 450, 300);
		frame.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JPanel panel = new JPanel();
		frame.getContentPane().add(panel, BorderLayout.CENTER);
		
		JLabel label = new JLabel("\u8BF7\u9009\u62E9\u6240\u8981\u67E5\u8BE2\u7684\u5185\u5BB9\uFF1A");
		panel.add(label);
		
		String [] s={"ÿ�����ҵĹҺ������ܽ��","ҩ������ҩƷ�Ŀ����","ÿ��ҽ���ľ��������ͽ��"};
		JComboBox comboBox = new JComboBox();
		panel.add(comboBox);
		int key=comboBox.getSelectedIndex();
		
	}

}
