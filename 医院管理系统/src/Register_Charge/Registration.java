package Register_Charge;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Account;
import all_class.Appointment;
import all_class.Case;
import all_class.Global_info;
import all_class.Office;
import all_class.Patient_info;
import all_class.TCP;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.nio.channels.NonWritableChannelException;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;

public class Registration extends JFrame {

	private JPanel contentPane;
	private static Account account;
	private static Socket socket;
    static int page=0;
    private static Global_info global_info;
    private static  ArrayList<Case> cases;//һϵ�еĲ��� 
    private static Patient_info pat_info;//������Ϣ
    private static Appointment app;//ԤԼ��Ϣ
    private JPanel panel_1;

	/**
	 * Launch the application.
	 */
	/**
	 * Create the frame.
	 */
	
	
	public  static  void upload() {
		TCP tcp =new TCP();
		tcp.SetCase_toDocter(cases);
	}
	public static void GetData()
	{
		TCP tcp =new TCP();
		global_info=tcp.get_global_info();
		cases=tcp.GetCase_toReg();//��õȴ��б�
		
		
	}
	public Registration() {
		if(page==0)//ֻ�е�һ�ν�������
		{
			GetData();//�����Ϣ
		}
	
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 461, 332);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u6302\u53F7");
		panel.add(label);
		
		panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\u59D3\u540D\uFF1A");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("New label");//����
		panel_1.add(lblNewLabel_1);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
		panel_1.add(lblNewLabel_2);
		
		JLabel lblNewLabel_3 = new JLabel("New label");//�Ա�
		panel_1.add(lblNewLabel_3);
		
		JLabel lblNewLabel_4 = new JLabel("\u5E74\u9F84\uFF1A");
		panel_1.add(lblNewLabel_4);
		
		JLabel lblNewLabel_5 = new JLabel("New label");//����
		panel_1.add(lblNewLabel_5);
		
		JLabel label_1 = new JLabel("\u9884\u7EA6\u65F6\u95F4\uFF1A");
		panel_1.add(label_1);
		
		JLabel lblNewLabel_6 = new JLabel("New label");//ԤԼʱ��
		panel_1.add(lblNewLabel_6);
		
		JLabel label_2 = new JLabel("\u9884\u7EA6\u79D1\u5BA4\uFF1A");
		panel_1.add(label_2);
		String []office_name=new String[global_info.getCount_office().size()];
		for(int i=0;i<global_info.getCount_office().size();i++)
		{
			office_name[i]=global_info.getCount_office().get(i).getOffice_name();
		}
		JComboBox comboBox = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//�޸Ŀ���
				String name=comboBox.getSelectedItem().toString();
				Office office = null;
				for(int i=0;i<global_info.getCount_office().size();i++)
				{
					if(name.equals(global_info.getCount_office().get(i).getOffice_name()))
					{
						office=global_info.getCount_office().get(i);
						break;
					}
				}
				cases.get(page).getApp().setApp_office(office);
				
				
			}
		});
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//�޸�ҽ��
				String name=comboBox_1.getSelectedItem().toString();
				cases.get(page).getApp().setDocter_name(name);
			}
		});
	
		panel_1.add(comboBox);
		
		JLabel label_3 = new JLabel("\u9884\u7EA6\u533B\u751F\uFF1A");
		panel_1.add(label_3);
		JLabel lblNewLabel_9 = new JLabel("New label");
		if(page>=cases.size())//��ʾ���˵���Ϣ
		{
			lblNewLabel_9.setVisible(true);
			if(cases.size()==0)
			{
				lblNewLabel_9.setVisible(true);
				lblNewLabel_9.setText("��ǰû�в���ԤԼ");
			}
			else 
			{
				upload();
				lblNewLabel_9.setText("���˵���Ϣ�Ѿ��ύ��������");
			}
				
		}
		else
		{
			pat_info=cases.get(page).getPi();
			app=cases.get(page).getApp();
			lblNewLabel_1.setText(pat_info.getName());
			if(pat_info.isSex())
			lblNewLabel_3.setText("��");
			else lblNewLabel_3.setText("Ů");
			lblNewLabel_5.setText(pat_info.getYears()+"��");
			lblNewLabel_6.setText(String.valueOf(app.getAppoint_time()));
			comboBox.setSelectedItem(cases.get(page).getApp().getApp_office().getOffice_name());
			 
			String []doc_name=new String[global_info.getCount_office().get(page).getDoctor().size()];
			doc_name=(String[])global_info.getCount_office().get(page).getDoctor().toArray();
			comboBox_1.addItem(doc_name);
			comboBox_1.setSelectedItem(cases.get(page).getApp().getDocter_name());
			page++;
		}
		JButton button = new JButton("\u8FD4\u56DE");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ȡ���ļ����¼�
				dispose();
			}
		});
		
		
		panel_1.add(comboBox_1);
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u4E0B\u4E00\u4E2A\u9884\u7EA6");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {//ԤԼ�ļ����¼�
				if(page<cases.size())
				{
					dispose();
					Registration re=new Registration();
					re.setVisible(true);
				}
				
				
			}
		});
		panel_1.add(button_1);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
	
		lblNewLabel_9.setVisible(false);
		panel_2.setLayout(new GridLayout(0, 1, 0, 0));
		panel_2.add(lblNewLabel_9);
	}
	

}
