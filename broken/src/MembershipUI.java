import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JSeparator;
import javax.swing.JLabel;
import javax.swing.JTextField;
import javax.swing.JTable;
import javax.swing.JScrollPane;

public class MembershipUI extends JFrame {

	private JPanel contentPane;
	private JTextField surname;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					MembershipUI frame = new MembershipUI();
					frame.setBounds(250, 250, 500, 700);
					Dimension dim = Toolkit.getDefaultToolkit().getScreenSize();
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection conn = null; 
	private JTextField firstName;
	private JTextField surnametf;
	private JTextField dob;
	private JTextField email;
	private JTextField contactnumber;
	private Object[] rowData; 
	
	/**
	 * Create the frame.
	 */
	public MembershipUI() {
		conn = sqliteConnection.dbConnector();
		setBounds(100, 100, 500, 715);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		setTitle("Membership Panel");
		setResizable(false);
		setBounds(250, 250, 500, 700);
		setVisible(true);
		setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		
		JLabel lblSelectAMember = new JLabel("Select A Member For Upgrade:");
		lblSelectAMember.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSelectAMember.setBounds(10, 0, 292, 48);
		contentPane.add(lblSelectAMember);
		
		JButton btnSchedulingPanel = new JButton("Return to Scheduling Panel");
		btnSchedulingPanel.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				Scheduling win = new Scheduling();
				win.frmSchedulingPanel.setVisible(true);
			}
		});
		btnSchedulingPanel.setBounds(252, 637, 232, 23);
		contentPane.add(btnSchedulingPanel);
		
		JLabel lblFirstName = new JLabel("Search by surname:");
		lblFirstName.setBounds(38, 68, 141, 14);
		contentPane.add(lblFirstName);
		
		surname = new JTextField();
		surname.setBounds(163, 65, 166, 20);
		contentPane.add(surname);
		surname.setColumns(10);
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
					String query = "SELECT * FROM Scheduling WHERE Surname=?";
					PreparedStatement pst = conn.prepareStatement(query);
					pst.setString(1, surname.getText());
					ResultSet rs=pst.executeQuery();
					table.setModel(DbUtils.resultSetToTableModel(rs));
					
				} catch (Exception e1) {
					JOptionPane.showMessageDialog(null, e1);
				}
			}
			
		});
		btnSearch.setBounds(348, 64, 89, 23);
		contentPane.add(btnSearch);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(38, 116, 341, 86);
		contentPane.add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JSeparator separator = new JSeparator();
		separator.setBounds(10, 241, 474, 2);
		contentPane.add(separator);
		
		firstName = new JTextField();
		firstName.setBounds(139, 295, 240, 20);
		contentPane.add(firstName);
		firstName.setColumns(10);
		firstName.setEditable(false);
		
		JLabel lblFirstName_1 = new JLabel("First Name:");
		lblFirstName_1.setBounds(49, 298, 69, 14);
		contentPane.add(lblFirstName_1);
		
		surnametf = new JTextField();
		surnametf.setBounds(139, 337, 240, 20);
		contentPane.add(surnametf);
		surnametf.setColumns(10);
		surnametf.setEditable(false);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setBounds(59, 340, 69, 14);
		contentPane.add(lblSurname);
		
		JLabel lblNewLabel = new JLabel("Date of Birth:");
		lblNewLabel.setBounds(38, 377, 80, 14);
		contentPane.add(lblNewLabel);
		
		dob = new JTextField();
		dob.setBounds(139, 374, 240, 20);
		contentPane.add(dob);
		dob.setColumns(10);
		dob.setEditable(false);
		
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int row = table.getSelectedRow();
				rowData = new Object[table.getColumnCount()];
				for (int i = 0; i < table.getColumnCount(); i++) {
					rowData[i] = table.getValueAt(row, i);
				}
				firstName.setText("" + rowData[2]);
				surnametf.setText("" + rowData[3]);
				dob.setText("" + rowData[4]);
				JOptionPane.showMessageDialog(null, "Please fill in the text fields marked with an asterix and select which level of membership you wish to upgrade/downgrade to.");
				JOptionPane.showMessageDialog(null, rowData);
				
			}
		});
		btnSelect.setBounds(389, 141, 89, 23);
		contentPane.add(btnSelect);
		
		JLabel lblEmail = new JLabel("Email:");
		lblEmail.setBounds(75, 410, 46, 14);
		contentPane.add(lblEmail);
		
		JLabel lblNewLabel_1 = new JLabel("Contact Number:");
		lblNewLabel_1.setBounds(21, 448, 97, 14);
		contentPane.add(lblNewLabel_1);
		
		email = new JTextField();
		email.setBounds(139, 407, 240, 20);
		contentPane.add(email);
		email.setColumns(10);
		
		contactnumber = new JTextField();
		contactnumber.setBounds(139, 445, 240, 20);
		contentPane.add(contactnumber);
		contactnumber.setColumns(10);
		
		JLabel lblMembershipType = new JLabel("Membership Type:");
		lblMembershipType.setBounds(10, 479, 118, 14);
		contentPane.add(lblMembershipType);
		
		String[] membershipOptions = { "", "Registered", "Basic Membership", "Loyalty Membership" }; 
		JComboBox membershipType = new JComboBox(membershipOptions);
		membershipType.setBounds(139, 476, 240, 20);
		contentPane.add(membershipType);
		
		JButton btnAmendMembership = new JButton("Amend Membership");
		btnAmendMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				String errorMessage = "The following things need to be amended before we can complete this task:\n\n";
				if (firstName.getText().trim().isEmpty()) {
					errorMessage = "No member selected for upgrade.";
					JOptionPane.showMessageDialog(null, errorMessage);
					return;
				}
				int violation = 0;
				if (email.getText().trim().isEmpty()) {
					errorMessage += "Enter your email\n";
					violation += 1;
				}
				if (contactnumber.getText().trim().isEmpty())
				{
					errorMessage += "Enter your Contact Number\n";
					violation += 1;
				}
				
				if (membershipType.getSelectedItem() == "") {
					errorMessage += "You did not select a membership option\n";
					violation += 1;
				}
				
				if (membershipType.getSelectedItem().toString().equals(rowData[5].toString()))  {
					errorMessage += "You are already a registered member and have chosen registered as your upgrade option\n";
					violation += 1;
				}
				// else if (membershipType.getSelectedItem().toString().equals("Registered") && rowData[5].toString().equals("Member"))
					
				if (violation > 0) {
					JOptionPane.showMessageDialog(null, errorMessage);
					return;
				}
				
				
				
			}
		});
		btnAmendMembership.setBounds(163, 550, 166, 23);
		contentPane.add(btnAmendMembership);
		
		String[] paymentOptions = { "", "Visa", "Debit", "American Express" };
		JComboBox paymentOption = new JComboBox(paymentOptions);
		paymentOption.setBounds(139, 506, 240, 20);
		contentPane.add(paymentOption);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Option:");
		lblNewLabel_2.setBounds(20, 509, 98, 14);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
