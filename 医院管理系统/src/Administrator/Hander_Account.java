package Administrator;

import java.awt.BorderLayout;
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JTable;
import org.eclipse.wb.swing.FocusTraversalOnArray;

import all_class.Account;
import all_class.Global_info;
import all_class.statistic_info;

import java.awt.Component;
import java.awt.Font;
import java.awt.Color;
import javax.swing.table.DefaultTableModel;
import javax.swing.ListSelectionModel;
import java.awt.GridLayout;
import javax.swing.JList;
import java.awt.GridBagLayout;
import javax.swing.JSpinner;
import javax.swing.JPopupMenu;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;
import javax.swing.JInternalFrame;
import javax.swing.JButton;
import javax.swing.JLayeredPane;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class Hander_Account extends JFrame {
   private static Global_info global_info;
   private static Account account;
	private JPanel contentPane;
	public Hander_Account(Account account) {
		this.global_info=global_info;
		this.account=account;
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		setBounds(100, 100, 450, 300);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		contentPane.setLayout(new BorderLayout(0, 0));
		setContentPane(contentPane);
		
		JPanel panel = new JPanel();
		contentPane.add(panel, BorderLayout.NORTH);
		
		JLabel label = new JLabel("\u8D26\u53F7\u7BA1\u7406");
		panel.add(label);
		
		JPanel panel_1 = new JPanel();
		contentPane.add(panel_1, BorderLayout.CENTER);
		panel_1.setLayout(new GridLayout(0, 1, 0, 0));
		
		JButton button = new JButton("\u589E\u6DFB\u8D26\u53F7");
		button.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				add_account frame = new add_account(account);
				frame.setVisible(true);
			}
		});
		panel_1.add(button);
		
		JButton button_1 = new JButton("\u5220\u9664\u8D26\u53F7");
		button_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				delete_Account frame = new delete_Account(account);
				frame.setVisible(true);
			}
		});
		panel_1.add(button_1);
		
		JButton btnNewButton = new JButton("\u8D26\u53F7\u67E5\u8BE2");
		panel_1.add(btnNewButton);
		
		JButton button_2 = new JButton("\u9000\u51FA");
		button_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				setVisible(false);
			}
		});
		panel_1.add(button_2);
		
		JLabel label_1 = new JLabel("");
		panel_1.add(label_1);
		
	}

	private static void addPopup(Component component, final JPopupMenu popup) {
		component.addMouseListener(new MouseAdapter() {
			public void mousePressed(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			public void mouseReleased(MouseEvent e) {
				if (e.isPopupTrigger()) {
					showMenu(e);
				}
			}
			private void showMenu(MouseEvent e) {
				popup.show(e.getComponent(), e.getX(), e.getY());
			}
		});
	}
}
