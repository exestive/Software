import java.awt.BorderLayout;
import java.awt.Component;
import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import java.awt.Toolkit;
import java.sql.*;
import javax.swing.*;
import javax.swing.border.EmptyBorder;
import javax.swing.table.DefaultTableModel;

import net.proteanit.sql.DbUtils;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class MembershipUI extends JFrame {

	private JPanel contentPane;
	private JTextField surname;
	public static JTable table;

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
					frame.setLocation(dim.width/2-frame.getSize().width/2, dim.height/2-frame.getSize().height/2); // center the screen 
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
	private JTextField contactNumber;
	
	
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
				Scheduling win = new Scheduling(); // if this button is selected create a new instance of the scheduling panel and instantiate it
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
		
		UserSearchController userSearch = new UserSearchController();
		
		JButton btnSearch = new JButton("Search");
		btnSearch.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				table = userSearch.search(table, surname); // call the userSearch controller's search function 
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
		
		selectUserController selectUser = new selectUserController();
		
		JButton btnSelect = new JButton("Select");
		btnSelect.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				Member member = selectUser.selectUser(table); // call the selectUserController's selectUser function
				firstName.setText("" + member.getName());
				surnametf.setText("" + member.getSurname());
				dob.setText("" + member.getDOB());
				JOptionPane.showMessageDialog(null, "Please fill in the text fields marked with an asterix and select which level of membership you wish to upgrade/downgrade to.");
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
		
		contactNumber = new JTextField();
		contactNumber.setBounds(139, 445, 240, 20);
		contentPane.add(contactNumber);
		contactNumber.setColumns(10);
		
		JLabel lblMembershipType = new JLabel("Membership Type:");
		lblMembershipType.setBounds(10, 479, 118, 14);
		contentPane.add(lblMembershipType);
		
		String[] membershipOptions = { "", "Registered", "Basic Membership", "Loyalty Membership" }; 
		JComboBox membershipType = new JComboBox(membershipOptions);
		membershipType.setBounds(139, 476, 240, 20);
		contentPane.add(membershipType);
		
		String[] paymentOptions = { "", "Visa", "Debit", "American Express" };
		JComboBox paymentOption = new JComboBox(paymentOptions);
		paymentOption.setBounds(139, 506, 240, 20);
		contentPane.add(paymentOption);
		
		
		amendMembershipController amend = new amendMembershipController();
		JButton btnAmendMembership = new JButton("Amend Membership");
		btnAmendMembership.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				Member member = selectUser.selectUser(table);
				
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
				if (contactNumber.getText().trim().isEmpty())
				{
					errorMessage += "Enter your Contact Number\n";
					violation += 1;
				}
				if (membershipType.getSelectedItem() == "") {
					errorMessage += "You did not select a membership option\n";
					violation += 1;
				}
				if (membershipType.getSelectedItem().equals(member.getM_Status().toString())) {
					errorMessage += "You are already a member with this membership type. Please review your option.\n";
					violation += 1;
				}
				if (membershipType.getSelectedItem().equals("Loyalty Membership") && paymentOption.getSelectedItem().equals("")) {
					errorMessage += "You did not select a payment option\n";
					violation += 1;
				}
				
				if (membershipType.getSelectedItem().equals("Loyalty Membership") && Integer.parseInt(member.getSessionID()) < 10) {
					errorMessage += "You have not attended enough sessions to qualify for loyalty membership. Please attend atleast 10 sessions to qualify.\n";
					violation += 1;
				}
				
				if (violation > 0) {
					// if any of the above violations were met, the violation variable would increment and this if branch would trigger
					JOptionPane.showMessageDialog(null, errorMessage);
					return;
				}
				if (membershipType.getSelectedItem().equals("Registered") && (member.getM_Status().equals("Member") || member.getM_Status().equals("Loyalty"))) {
					amend.amendMembership(member, membershipType.getSelectedItem().toString(), email.getText(), contactNumber.getText()); // call amendMembership function of the amend controller and upgrade/downgrade to registered
					JOptionPane.showMessageDialog(null, "Your membership has been updated!");
				}
				
				if (membershipType.getSelectedItem().equals("Basic Membership") && (member.getM_Status().equals("Registered") || member.getM_Status().equals("Loyalty"))) {
					amend.amendMembership(member, membershipType.getSelectedItem().toString(), email.getText(), contactNumber.getText());// call amendMembership function of the amend controller and upgrade/downgrade to basic membership
					JOptionPane.showMessageDialog(null, "Your membership has been updated!");
				}
				
				if (membershipType.getSelectedItem().equals("Loyalty Membership") && (member.getM_Status().equals("Registered") || member.getM_Status().equals("Member"))) {
					amend.amendMembership(member, membershipType.getSelectedItem().toString(), email.getText(), contactNumber.getText()); // call amendMembership function of the amend controller and upgrade/downgrade to loyalty membership 
					JOptionPane.showMessageDialog(null, "Your membership has been updated!");
				}
				
				
				
			}
		});
		btnAmendMembership.setBounds(163, 550, 166, 23);
		contentPane.add(btnAmendMembership);
		
		JLabel lblNewLabel_2 = new JLabel("Payment Option:");
		lblNewLabel_2.setBounds(20, 509, 98, 14);
		contentPane.add(lblNewLabel_2);
		
		
	}
}
