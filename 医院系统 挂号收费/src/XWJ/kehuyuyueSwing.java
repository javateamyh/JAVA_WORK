package XWJ;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;

import all_class.Appointment;
import all_class.Case;
import all_class.Patient_info;

import javax.swing.JLabel;
import javax.swing.SwingConstants;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.AbstractAction;
import java.awt.event.ActionEvent;
import javax.swing.Action;
import java.awt.event.ActionListener;
import javax.swing.JRadioButton;
import javax.swing.JList;
import java.awt.FlowLayout;
import javax.swing.JComboBox;
import javax.swing.JSpinner;
import java.awt.event.ItemListener;
import java.awt.event.ItemEvent;

public class kehuyuyueSwing extends JFrame {

	private JPanel contentPane;
	private JTextField textField;//姓名
	private JTextField textField_1;//性别
	private JTextField textField_3;//电话
	private JTextField textField_5;//时间
	private final Action action = new SwingAction();

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					kehuyuyueSwing frame = new kehuyuyueSwing();
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
	public kehuyuyueSwing() {
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label_1 = new JLabel("\u5BA2\u6237\u9884\u7EA6\u7AEF");
		panel.add(label_1);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new FlowLayout(FlowLayout.CENTER, 5, 5));
		
		JLabel lblNewLabel = new JLabel("\u8BF7\u8F93\u5165\u75C5\u4EBA\u7684\u57FA\u672C\u60C5\u51B5\uFF1A");
		panel_1.add(lblNewLabel);
		
		JLabel lblNewLabel_1 = new JLabel("\u540D\u5B57\uFF1A");
		panel_1.add(lblNewLabel_1);
		
		textField = new JTextField();
		panel_1.add(textField);
		textField.setColumns(10);
		
		JLabel label = new JLabel("\u5E74\u9F84\uFF1A");
		panel_1.add(label);
		
		textField_1 = new JTextField();
		panel_1.add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblNewLabel_2 = new JLabel("\u6027\u522B\uFF1A");
		panel_1.add(lblNewLabel_2);
		
		JRadioButton radioButton = new JRadioButton("\u7537");//男
		panel_1.add(radioButton);
		
		JRadioButton radioButton_1 = new JRadioButton("\u5973 ");//女
		panel_1.add(radioButton_1);
		
		JLabel lblNewLabel_3 = new JLabel("\u7535\u8BDD\uFF1A");
		panel_1.add(lblNewLabel_3);
		
		textField_3 = new JTextField();
		panel_1.add(textField_3);
		textField_3.setColumns(10);
		
		JLabel lblNewLabel_4 = new JLabel("\u9884\u7EA6\u79D1\u5BA4\uFF1A");
		panel_1.add(lblNewLabel_4);
		
		JComboBox comboBox = new JComboBox();
		comboBox.addItemListener(new ItemListener() {
			public void itemStateChanged(ItemEvent arg0) {
				
			}
		});
		comboBox.setToolTipText("\u9009\u62E9\u79D1\u5BA4");
		panel_1.add(comboBox);
		
		JComboBox comboBox_1 = new JComboBox();
		comboBox_1.setToolTipText("\u9009\u62E9\u533B\u751F");
		panel_1.add(comboBox_1);
		
		JLabel lblNewLabel_5 = new JLabel("\u9884\u7EA6\u65F6\u95F4\uFF1A");
		panel_1.add(lblNewLabel_5);
		
		textField_5 = new JTextField();
		panel_1.add(textField_5);
		textField_5.setColumns(10);
		
		JPanel panel_3 = new JPanel();
		contentPane.add(panel_3, BorderLayout.SOUTH);
		
		JButton btnNewButton = new JButton("\u5B8C\u6210");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Patient_info patient=new Patient_info();
				Appointment appointment=new Appointment();
				Case patient_case=new Case();
				
				
				patient.setName(textField.toString());
				patient.setSex(JRadioButton.isLightweightComponent(radioButton));//true是男
				patient.setYears(Integer.parseInt(textField_1.toString()) );
				patient.setTel(textField_3.toString());
				
				patient_case.setPi(patient);
				
				appointment.setApp_office(app_office);/****************************/
				
				
				appointment.setAppoint_time(textField_5.toString());
				appointment.setAppoint(true);
				
				patient_case.setApp(appointment);
				
			}
			
		});
		btnNewButton.setAction(action);
		panel_3.add(btnNewButton);
	}

	private class SwingAction extends AbstractAction {
		public SwingAction() {
			putValue(NAME, "SwingAction");
			putValue(SHORT_DESCRIPTION, "Some short description");
		}
		public void actionPerformed(ActionEvent e) {
		}
	}
}
