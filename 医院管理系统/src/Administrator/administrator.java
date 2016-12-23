package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Account;
import all_class.Global_info;
import all_class.ipconfig;
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
	 private static Socket socket;
	 private final Action action = new SwingAction();
	 static int port=5000;
	 private JButton button_1;
	 static String host="127.0.0.1";

	/**
	 * Launch the application.
	 * @return 
	 */
	 public static void get_global_info(){


				try {
					ObjectInputStream is=null;
					ObjectOutputStream os=null;
			        os=new ObjectOutputStream(socket.getOutputStream());
			        os.writeObject(account);//报头
			        os.flush();
			 
			        is=new ObjectInputStream(new  BufferedInputStream(socket.getInputStream()));
			        global_info=(Global_info)is.readObject();//获取信息
			  
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
				
		
		 
		 
		 
	 }
	public administrator(Account account,Socket socket) {
		this.socket=socket;
		this.account=account;
		get_global_info();
		Link link=new Link(account);//link的起源
		link.setAccount(account);
		link.setGlobal_info(global_info);//客户端的初始化
		
		
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
							Handel_Account frame = new Handel_Account(link);
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
				
				Handel_Office frame = new Handel_Office(link);
				frame.setVisible(true);
			}
		});
		panel_1.add(button);
		
		JButton button_2 = new JButton("\u836F\u54C1\u7BA1\u7406");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//药品的管理
				
				Handel_Drug frame = new Handel_Drug(link);
				frame.setVisible(true);
			}
		});
		panel_1.add(button_2);
		
		JButton btnTu = new JButton("\u9000\u51FA");
		panel_1.add(btnTu);
		
		JButton button_3 = new JButton("\u540C\u6B65");
		button_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				            account.setFlag(100);
						try {
							Socket socket_write=new Socket(ipconfig.getHost(), ipconfig.getPort());
							ObjectOutputStream os=new ObjectOutputStream(socket_write.getOutputStream());
							os.writeObject(account);
							os.flush();
							global_info=link.getGlobal_info();//部分更新全局信息
							os.writeObject(global_info);
							os.flush();
							os.close();
							socket_write.close();
							 
						} catch (IOException e1) {
							// TODO Auto-generated catch block
							e1.printStackTrace();
						}
						
			
				link.getAccount().setFlag(101);//回复为起始状态
				
			}
		});
		panel_1.add(button_3);
		contentPane.setFocusTraversalPolicy(new FocusTraversalOnArray(new Component[]{panel_1, label, button_1, panel, button, button_2}));
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


	public void adm() {
		// TODO Auto-generated method stub
		
	}
}
