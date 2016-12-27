package Register_Charge;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.ArrayList;
import java.net.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.*;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Pay_Re_Med extends JFrame {
	private static Case case2;
	private static ArrayList<Case> Register_Charged;//用于挂号端的收费
    private static ObjectInputStream in;
    private static ObjectOutputStream out;
	private JPanel contentPane;
	static int j=0;
	private static JLabel lblPay;
	private static JLabel lblName;
	static int i=0;
	/**
	 * Launch the application.
	 */
	public void runing() {
		// TODO Auto-generated method stub
		try {
			Register_Charged=(ArrayList<Case>)in.readObject();
		} catch (ClassNotFoundException e1) {
			// TODO Auto-generated catch block
			e1.printStackTrace();
		} catch (IOException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}

	/**
	 * Create the frame.
	 */
	public void write(){
		new Thread(new Runnable() {
			
			@Override
			public void run() {
				// TODO Auto-generated method stub
				try {
					Socket socket=new Socket("127.0.0",8000);
					ObjectOutputStream os=new ObjectOutputStream(socket.getOutputStream());
					os.writeObject(Register_Charged);
					os.flush();
					os.close();
					socket.close();
						
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
				
				
			}
		}).start();}
	
	public Pay_Re_Med() {
		boolean R=false;
		if(!R)//第一次获取服务器信息
		{
			runing();
		    R=true;
		}
		
		boolean Q=false;
		if(Q)//一次接收到的病例已经全部处理完，接收下一次
		{   
			write();
			runing();
		}
		case2=Register_Charged.get(i);
		case2.getPi().getName();
		case2.getCharge().getSum_fee();
		lblName.setText("病人需要缴费 " +case2.getPi().getName());
		lblPay.setText("病人需要缴费 " +case2.getCharge().getSum_fee());
		case2.getCharge().setPay(true);
		//处理完成的病人都将修改写回服务器
		if(i<Register_Charged.size())
		{
			Q=true;
		}
		
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
		
		JLabel lblPay = new JLabel("New label");
		panel_2.add(lblPay);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(0, 104, 424, 35);
		contentPane.add(panel_3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(0, 139, 424, 35);
		contentPane.add(panel_4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(0, 216, 424, 35);
		contentPane.add(panel_5);
		
		JButton btnNewButton = new JButton("BUTTON");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Register frame = new Register();
				frame.setVisible(true);
			}
		});
		panel_5.add(btnNewButton);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(0, 184, 424, 35);
		contentPane.add(panel_6);
		
		JButton button = new JButton("\u786E\u8BA4\u7F34\u8D39");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				i++;
				Pay_Re_Med frame = new Pay_Re_Med();
				frame.setVisible(true);
			}
		});
		panel_6.add(button);
	}
}
