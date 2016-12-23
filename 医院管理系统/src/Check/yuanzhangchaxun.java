package Check;
/*���Բ�ѯͳ��ÿ�����ҵĹҺ������ܽ�����ѡ�����ɱ�ͼͳ�ƣ���
 * ��ѯҩ������ҩƷ�Ŀ������
 */
//�ӷ�������Ҫ�õ�ArrayList<Office>��ArrayList<Drug_info> ����Ҫ�������������Ϣ
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
import all_class.Drug_info;
import all_class.Global_info;
import all_class.Office;
import all_class.ipconfig;

import java.awt.BorderLayout;
import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JComboBox;
import javax.swing.JRadioButton;
import javax.swing.JToggleButton;
import javax.swing.JTextPane;
import java.awt.List;
import javax.swing.JTextArea;
import javax.swing.JTable;
import java.awt.Label;

public class yuanzhangchaxun {

	private JFrame frame;
	//static Global_info global_info=new Global_info();
	static Account account;//Ժ�����˺���Ϣ
	static ArrayList<Office> office_list;
	static ArrayList<Drug_info> drug_list;
	 static String host="127.0.0.1";
	 static int port=5000;
    

public yuanzhangchaxun (Account account) {
	this.account=account;
	check_up();
}
	public static void check_up() {
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
			try{ipconfig ip=new ipconfig();
			server=new Socket(ip.getHost(),ip.getPort());
			
					
				ObjectInputStream in=new ObjectInputStream(server.getInputStream());//���׽Ӷ�������
				ObjectOutputStream out=new ObjectOutputStream(server.getOutputStream());//���׽Ӷ������
				
				account.setFlag(6);
				out.writeObject(account.getFlag());//����������ͱ�־
				out.flush();
				try{
					//�ӷ��������տ��������ҩƷ��Ϣ����
					office_list=(ArrayList<Office>) in.readObject();
					drug_list=(ArrayList<Drug_info>) in.readObject();
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
		
		 String officename[]=new String[office_list.size()];//������п��ҵ�����
			for(int i=0;i<office_list.size();i++)
			{
			officename[i]=office_list.get(i).getOffice_name();
			}
		
		String [] s={"ÿ�����ҵĹҺ������ܽ��","ҩ������ҩƷ�Ŀ����"};
		JComboBox comboBox = new JComboBox(s);//�ɹ�Ժ��ѡ����
		comboBox.setSelectedIndex(-1);
		panel.add(comboBox);
		int key=comboBox.getSelectedIndex();//��¼Ժ����ѡ��Ĺ���
		
		String drugname[]=new String[drug_list.size()];//�������ҩ������
		for(int i=0;i<drug_list.size();i++)
		{
		drugname[i]=drug_list.get(i).getDrug_name();
		}

		switch(key)//����Ժ����ѡ�Ĺ��ܳ��ֲ�ͬ��ҳ��
		{
		case 0:{//ÿ�����ҵĹҺ������ܽ��
			Label label_1 = new Label("\u9009\u62E9\u6240\u8981\u67E5\u8BE2\u7684\u79D1\u5BA4\uFF1A");//ѡ����ұ�ǩ
			panel.add(label_1);
			//JRadioButton radioButton = new JRadioButton("\u751F\u6210\u997C\u72B6\u56FE");//�Ƿ����ɱ�״ͼ��button
			//panel.add(radioButton);
			JComboBox comboBox_1 = new JComboBox(officename);//ѡ����ҵ�������
			panel.add(comboBox_1);
			comboBox_1.setSelectedIndex(-1);
			int key1=comboBox_1.getSelectedIndex();//��¼��Ҫ��ѯ�Ŀ���
			
			//if(radioButton.isSelected())//ÿ�����ҵĹҺ������ܽ�ѡ�����ɱ�ͼͳ�ƣ�
			//{
				
			//}
			//else
			//{//��ʾ��ѡ�п��ҵ��ܽ��
				JTextPane textPane = new JTextPane();
				textPane.setText("�ܽ��Ϊ��"+office_list.get(key1).getCharge());
				panel.add(textPane);
				
				//for(int i=0;i<office_list.size();i++)//ÿ�����ҹҺ������ܽ��
					  //System.out.println(officename[i]+"�ĹҺ���Ϊ���ܽ��Ϊ��"+office_list.get(i).getCharge());
			//}
		}
		case 1://��ѯҩ������ҩƷ�Ŀ������
		{
			JLabel lblNewLabel = new JLabel("\u9009\u62E9\u6240\u8981\u67E5\u8BE2\u7684\u836F\u54C1\u7684\u540D\u79F0\uFF1A");
			panel.add(lblNewLabel);
			JComboBox comboBox_2 = new JComboBox(drugname);//���ҩ����������
			panel.add(comboBox_2);
			comboBox.setSelectedIndex(-1);
	        int key2=comboBox.getSelectedIndex();//��¼��ѡ���ҩƷ��
	        JTextPane textPane_1 = new JTextPane();
			textPane_1.setText("�ܽ��Ϊ��"+drug_list.get(key2).getDrug_count());//��ʾ��Ӧ�Ľ��
			panel.add(textPane_1);
	        
			//for(int i=0;i<drug_list.size();i++)//ҩ�Ŀ��Ϊ
				  //System.out.println(drug_list.get(i).getDrug_name() +"�Ŀ��Ϊ��"+drug_list.get(i).getDrug_count());
		}
		}
	}

}
