package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Global_info;
import all_class.Office;

import javax.swing.JLabel;
import java.awt.GridLayout;
import javax.swing.JComboBox;
import java.awt.event.ActionListener;
import java.util.ArrayList;
import java.awt.event.ActionEvent;
import javax.swing.JButton;
import javax.swing.SwingConstants;

public class Handel_Office extends JFrame {

	private JPanel contentPane;
    private static ArrayList<Office> offices;
    private static Global_info global_info;

	public Handel_Office(Link link) {
		global_info=link.getGlobal_info();
		offices=global_info.getCount_office();
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u79D1\u5BA4\u4FE1\u606F\u7BA1\u7406");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		
		JLabel lblNewLabel = new JLabel("New label");
		
		JComboBox comboBox = new JComboBox();
		int i;
		for(i=0;i<offices.size();i++)
		{
			comboBox.addItem(offices.get(i).getOffice_name());
		}
		JComboBox comboBox_1 = new JComboBox();
		comboBox.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				String name=comboBox.getSelectedItem().toString();
				int i;
				for(i=0;i<offices.size();i++)
				{
					if(name.equals(offices.get(i).getOffice_name()))break;
				}
				
			lblNewLabel.setText(String.valueOf(offices.get(i).getCharge()));
		
         comboBox_1.removeAllItems();
            for(int j=0;j<offices.get(i).getDoctor().size();j++)
       {
	    comboBox_1.addItem(offices.get(i).getDoctor().get(j));
       }
	
		
			}
		});
		panel_1.setLayout(new GridLayout(0, 2, 0, 0));
		
		JLabel label_1 = new JLabel("\u8BF7\u9009\u62E9\u79D1\u5BA4");
		panel_1.add(label_1);
		panel_1.add(comboBox);
		
		JLabel label_2 = new JLabel("\u79D1\u5BA4\u6536\u8D39\uFF1A");
		panel_1.add(label_2);
		
	
		panel_1.add(lblNewLabel);
		
		JLabel label_3 = new JLabel("\u79D1\u5BA4\u533B\u751F\uFF1A");
		panel_1.add(label_3);
		
		JButton btnNewButton = new JButton("\u9000\u51FA");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				setVisible(false);
			}
		});
		
	
		panel_1.add(comboBox_1);
		panel_1.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("\u4FEE\u6539");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				String name=comboBox.getSelectedItem().toString();
				int i;
				for(i=0;i<offices.size();i++)
				{
					if(name.equals(offices.get(i).getOffice_name())) break;
				}
				Modify_Office frame = new Modify_Office(link,i);
				frame.setVisible(true);	
			}
		});
		panel_1.add(btnNewButton_1);
	}
}
