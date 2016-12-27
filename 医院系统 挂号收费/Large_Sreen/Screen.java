package Large_Sreen;
import Register_Charge.*;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.net.Socket;
import java.net.UnknownHostException;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import org.omg.CORBA.PRIVATE_MEMBER;

import all_class.Account;
import all_class.Appointment;
import all_class.Case;
import all_class.Global_info;
import all_class.Office;
import all_class.Patient_info;
import all_class.TCP;
import all_class.ipconfig;

import javax.swing.JLabel;
import javax.print.attribute.standard.PrinterMessageFromOperator;
import javax.swing.JButton;
import javax.swing.JComboBox;
//����Ļ��ʾ
public class Screen extends JFrame {
	static int i=0;
	static int j=0;
	static int a=0;
	static int b=0;
	static int c=0;
	static int d=0;
	static int e1=0;
	static int f1=0;
	private JLabel lblN2;
	private JLabel lblN3;
	private JLabel lblN4;
	private JLabel lblN5;
	private static Case case3;
	private static ObjectInputStream in;
	private static ObjectOutputStream out;
	private static Global_info info;//����ȫ����Ϣ
	private static ArrayList<Office> officelist;//����ȫ����Ϣ�еĿ���
	//private static ArrayList<Case> RegisterDocter;//��ҽ������Ϣ
	private static ArrayList<WaitOffice> waitOfficelist;//���һ�����ҵ�����ҽ���Ŷ����
	private static WaitOffice waitOffice;//һ�����ҵ��Ŷ����
	private static Waiter wait1;//һ��ҽ������Ķӳ�ʼ��
	private JPanel contentPane;

	static ObjectInputStream is;
	static ObjectOutputStream os;

	
	
	private static Account account;
	private static Socket socket;
    static int page=0;
    private static Global_info global_info;
    private static  ArrayList<Case> cases;//һϵ�еĲ��� 
    //private static Patient_info pat_info;//������Ϣ
   // private static Appointment app;//ԤԼ��Ϣ
    private JPanel panel_1;
	/**
	 * Launch the application.
	 * @throws IOException 
	 */
	
	
	/*public static void get_global_info(){
	
				// TODO Auto-generated method stub
				try {
				    out.writeObject(account);
				    out.flush();
				    info=(Global_info)in.readObject();//�ӷ��������ܿ��ҵ�������Ϣ     
				    officelist=info.getCount_office();
			        RegisterDocter=(ArrayList<Case>)in.readObject();
				} catch (IOException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				} catch (ClassNotFoundException e) {
					// TODO Auto-generated catch block
					e.printStackTrace();
				}
			}
	 */
		 
	 
	//public static void main(String[] args) throws IOException {
	
	public static void GetData()
	{
		TCP tcp =new TCP();
		global_info=tcp.get_global_info();
		cases=tcp.GetCase_toReg();//��õȴ��б�
	}

	/**
	 * Create the frame.
	 */
	public Screen(ObjectOutputStream os,ObjectInputStream is,Account account,Socket socket) {
		if(page==0)//ֻ�е�һ�ν�������
		{
			GetData();//�����Ϣ
		}
		
		//this.account=account;
		//Screen.os=os;
		//Screen.is=is;
		//get_global_info();
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
		
		JLabel lblN1 = new JLabel("New label");
		panel_1.add(lblN1);
		
		JLabel labC1 = new JLabel("New label");
		panel_1.add(labC1);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBounds(10, 72, 414, 37);
		contentPane.add(panel_2);
		
		JLabel labN2 = new JLabel("New label");
		panel_2.add(labN2);
		
		JLabel labC2 = new JLabel("New label");
		panel_2.add(labC2);
		
		JPanel panel_3 = new JPanel();
		panel_3.setBounds(10, 110, 414, 37);
		contentPane.add(panel_3);
		
		JLabel labN3 = new JLabel("New label");
		panel_3.add(labN3);
		
		JLabel labC3 = new JLabel("New label");
		panel_3.add(labC3);
		
		JPanel panel_4 = new JPanel();
		panel_4.setBounds(10, 143, 414, 37);
		contentPane.add(panel_4);
		
		JLabel labN4 = new JLabel("New label");
		panel_4.add(labN4);
		
		JLabel labC4 = new JLabel("New label");
		panel_4.add(labC4);
		
		JPanel panel_5 = new JPanel();
		panel_5.setBounds(10, 179, 414, 42);
		contentPane.add(panel_5);
		
		JLabel labN5 = new JLabel("New label");
		panel_5.add(labN5);
		
		JLabel labC5 = new JLabel("New label");
		panel_5.add(labC5);
		
		JPanel panel_6 = new JPanel();
		panel_6.setBounds(10, 231, 414, 30);
		contentPane.add(panel_6);
		
		JButton button = new JButton("\u5237\u65B0");
		
		String []office_name=new String[global_info.getCount_office().size()];
		
		for(int i=0;i<global_info.getCount_office().size();i++)
		{
			office_name[i]=global_info.getCount_office().get(i).getOffice_name();
		}
		lblN1.setText(office_name[0]); 
		lblN2.setText(office_name[1]); 
		lblN3.setText(office_name[2]); 
		lblN4.setText(office_name[3]); 
		lblN5.setText(office_name[4]); 
		
		
		//JComboBox comboBox = new JComboBox(office_name);
		
		
		/*comboBox.addActionListener(new ActionListener() {
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
		});*/
		
		
		/*button.addActionListener(new ActionListener() {
			

			public void actionPerformed(ActionEvent e) {
				for(int j=0;j<officelist.size();j++)//��ʼ����ǰ���µ����п��Һ�ҽ������
				{	waitOffice.setOffice_name(officelist.get(j).getOffice_name());
					for(int a=0;a<officelist.get(j).getDocter_name().size();a++)
					{
						wait1.setDoctor_name(officelist.get(j).getDocter_name().get(a));
						waitOffice.getWait_Doc().add(wait1);	
					}
					waitOfficelist.add(waitOffice);
				}
				
				for(int a=0;a<RegisterDocter.size();a++)//�������յ��Ĳ��˼�ʱ��Ϣȫ���Ŷ�
				{
					case3=RegisterDocter.get(a);
					for(int b=0;b<waitOfficelist.size();b++)
					{
						 if(case3.getApp().getApp_office().getOffice_name().equals(waitOfficelist.get(b).getOffice_name()))
						   {  
							 for(int c=0;c<waitOfficelist.get(b).getWait_Doc().size();c++)
								   if(case3.getApp().getDocter_name().equals(waitOfficelist.get(b).getWait_Doc().get(c).getDoctor_name()))
									   //�ҵ��Ͳ���ԤԼҽ������һ�µ�ҽ������
									   {
									   waitOfficelist.get(b).getWait_Doc().get(c).getWaiting().add(case3);
								   }}}}
				
				//ͳ�Ƹ���������
				for(int d=0;d<waitOfficelist.size();d++)
				{  float[] Sum_off=new float[waitOfficelist.get(d).getWait_Doc().size()];//���ҵ��Ŷ�����
				   for(int e1=0;e1<waitOfficelist.get(d).getWait_Doc().size();e1++)								   
				  {     
				    Sum_off[e1]+=waitOfficelist.get(d).getWait_Doc().get(e1).getWaiting().size();    
				   }
				   waitOfficelist.get(d).setWaitnumber(Sum_off[e1]);
				}
				
				//��Ļ��ʾ�������Ϳ��ҵ�ǰ����
				
				labC1.setText("��ǰ�Ŷ�����"+waitOfficelist.get(0).getWaitnumber());
				labC2.setText("��ǰ�Ŷ�����"+waitOfficelist.get(1).getWaitnumber());
				labC3.setText("��ǰ�Ŷ�����"+waitOfficelist.get(2).getWaitnumber());
				labC4.setText("��ǰ�Ŷ�����"+waitOfficelist.get(3).getWaitnumber());
				labC5.setText("��ǰ�Ŷ�����"+waitOfficelist.get(4).getWaitnumber());
			}
		});
		panel_6.add(button);*/
	}
}
