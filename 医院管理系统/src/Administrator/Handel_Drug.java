package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;
import java.util.ArrayList;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Drug_info;
import all_class.Global_info;
import all_class.statistic_info;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JComboBox;
import javax.swing.JTextField;

public class Handel_Drug extends JFrame {

	private JPanel contentPane;
    private static Global_info global_info;
    private static ArrayList<Drug_info> drug_infos;
    private JTextField textField;
    private JTextField textField_1;
    private JTextField textField_2;
    private static int indox=-1;//选择药品的顺序号

	/**
	 * Create the frame.
	 */
	public Handel_Drug(Link link ) {
		global_info=link.getGlobal_info();
		drug_infos=global_info.getDrug_list();
				
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u836F\u54C1\u7BA1\u7406");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(6, 4, 0, 0));
		
		JLabel lblNewLabel = new JLabel("\u836F\u54C1\u540D\u79F0\uFF1A");
		panel_1.add(lblNewLabel);
		
		String [] name=new String[drug_infos.size()];
		for(int i=0;i<drug_infos.size();i++)
		{
			name[i]=drug_infos.get(i).getDrug_name();
		}
		JLabel lblNewLabel_3 = new JLabel("New label");
		JComboBox comboBox = new JComboBox(name);
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
			String name=comboBox.getSelectedItem().toString();
			int i;
			for(i=0;i<drug_infos.size();i++)
			{
				if(name.equals(drug_infos.get(i).getDrug_name())) break;
			}
			indox=i;
			textField.setText(drug_infos.get(i).getDrug_pinyin());
			textField_1.setText(drug_infos.get(i).getDrug_price().toString());
			textField_2.setText(String.valueOf(drug_infos.get(i).getDrug_count()));
			}
		});
		panel_1.add(comboBox);
		
		JLabel lblNewLabel_1 = new JLabel("\u7B80\u7801\uFF1A");
		panel_1.add(lblNewLabel_1);
		
		JButton btnNewButton = new JButton("\u836F\u54C1\u4FE1\u606F\u4FEE\u6539");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {//修改药品信息
			if(indox!=-1)
			{
				drug_infos.get(indox).setDrug_price(Float.parseFloat(textField_1.getText()));
				drug_infos.get(indox).setDrug_count(Integer.parseInt(textField_2.getText()));
				global_info.setDrug_list(drug_infos);
				link.setGlobal_info(global_info);
				lblNewLabel_3.setVisible(true);
				lblNewLabel_3.setText("药品信息修改后成功");
			}
			}
		});
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label_1 = new JLabel("\u4EF7\u683C\uFF1A");
		panel_1.add(label_1);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u5E93\u5B58\uFF1A");
		panel_1.add(lblNewLabel_2);
		
		textField_2 = new JTextField();
		panel_1.add(textField_2);
		textField_2.setColumns(10);
		panel_1.add(btnNewButton);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(button_2);
		
		JPanel panel_2 = new JPanel();
		contentPane.add(panel_2, BorderLayout.SOUTH);
		
		
		lblNewLabel_3.setVisible(false);
		panel_2.add(lblNewLabel_3);
	}

}
