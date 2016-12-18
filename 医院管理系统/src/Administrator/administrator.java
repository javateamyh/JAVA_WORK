package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Account;
import all_class.Global_info;
import all_class.statistic_info;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.BufferedInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.ServerSocket;
import java.net.Socket;
import java.awt.event.ActionEvent;

import javax.management.loading.PrivateClassLoader;
import javax.swing.AbstractAction;
import javax.swing.Action;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import org.eclipse.wb.swing.FocusTraversalOnArray;
import java.awt.Component;

public class administrator extends JFrame {
     private static Global_info global_info;
	 private static Account account;
	 private static Link link;
	 private JPanel contentPane;
	 private final Action action = new SwingAction();
	 static int port=5000;
	 private JButton button_1;
	 static String host="127.0.0.1";

	/**
	 * Launch the application.
	 * @return 
	 */
	 public static void get_global_info(){
		 new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				
				Socket socket=null;
				try {
					socket=new Socket(host,port);
					
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
					is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        os=new ObjectOutputStream(socket.getOutputStream());
			        os.writeObject(account);
			        os.flush();
			        global_info=(Global_info)is.readObject();
			        os.close();
			        is.close();
			        server.close();
			        socket.close();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
			}
		}).start();
		 
		 
		 
	 }
	
	 
	public static void main(String[] args) {
		
		
		get_global_info();//获取服务器的全局信息
		
		
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					administrator frame = new administrator(account);
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
	public administrator(Account account) {
		this.account=account;
		Link link=new Link(account);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u6B22\u8FCE\u6765\u5230\u7BA1\u7406\u5458\u7CFB\u7EDF");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 1, 0, 0));
		
		button_1 = new JButton("\u8D26\u53F7\u7BA1\u7406");
		button_1.addActionListener(new ActionListener() {
			
			public void actionPerformed(ActionEvent e) {
				EventQueue.invokeLater(new Runnable() {
					public void run() {
						try {
							Hander_Account frame = new Hander_Account(global_info,account);
							frame.setVisible(true);
						} catch (Exception e) {
							e.printStackTrace();
						}
					}
				});

				
				
				
				
				
			}
		});
		panel_1.add(button_1);
		
		JButton button = new JButton("\u79D1\u5BA4\u7BA1\u7406");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			}
		});
		panel_1.add(button);
		
		JButton button_2 = new JButton("\u836F\u54C1\u7BA1\u7406");
		panel_1.add(button_2);
		
		JButton button_3 = new JButton("\u4FE1\u606F\u67E5\u8BE2");
		panel_1.add(button_3);
		
		JButton btnTu = new JButton("\u9000\u51FA");
		panel_1.add(btnTu);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel_1, label, button_1, panel, button, button_2, button_3}));
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
	public JButton getButton_1() {
		return button_1;
	}
}
