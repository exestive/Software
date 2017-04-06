import java.awt.EventQueue;
import java.awt.BorderLayout;


import net.proteanit.sql.DbUtils;

import java.awt.Choice;
import java.awt.TextField;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import java.awt.EventQueue;

import javax.swing.border.EmptyBorder;

import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import java.awt.Window.Type;

public class User_register extends JFrame {

	private JPanel contentPane;
	private JTextField textField;
	private JTextField textField_1;
	private JTextField textField_2;
	
	JLabel lblSurname = new JLabel("Surname:");
	JLabel lblName = new JLabel("Name:");
	JLabel lblMembership = new JLabel("Membership:");
	JButton btnNewButton_1 = new JButton("Create");
	JButton btnNewButton = new JButton("Clear");
	JLabel lblDob = new JLabel("D.O.B:");
	JLabel lblLevel = new JLabel("Level:");
	JComboBox<String> comboBox = new JComboBox<String>();
	JComboBox<String> comboBox_1 = new JComboBox<String>();
	JButton btnNewButton_4 = new JButton("Create");
	JLabel lblRepassword = new JLabel("Repassword:");
	JLabel lblPassword = new JLabel("Password:");
	
	Connection connection=null;
	JDateChooser dateChooser = new JDateChooser();
	String SqlDate;
	public final JButton btnNewButton_2 = new JButton("Staff");
	public final JButton btnNewButton_3 = new JButton("User");
	private final JButton btnNewButton_5 = new JButton("Clear");
	private final JPasswordField passwordField = new JPasswordField();
	private final JPasswordField passwordField_1 = new JPasswordField();
	private final JLabel lblUsername = new JLabel("Username:");

	
	
	
	

	/**
	 * Launch the application.
	 */
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					User_register frame = new User_register();
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
	public User_register() {
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblSurname.setVisible(true);
				lblName.setVisible(true);
				lblMembership.setVisible(true);
				btnNewButton_1.setVisible(true);
				btnNewButton.setVisible(true);
				lblDob.setVisible(true);
				comboBox.setVisible(true);
				btnNewButton_2.setVisible(true);
				dateChooser.setVisible(true);
				textField.setVisible(true);
				textField_1.setVisible(true);
				
				
				
				btnNewButton_3.setVisible(false);
				lblLevel.setVisible(false);
				comboBox_1.setVisible(false);
				btnNewButton_4.setVisible(false);
				btnNewButton_5.setVisible(false);
				textField_2.setVisible(false);
				passwordField.setVisible(false);
				passwordField_1.setVisible(false);
				lblRepassword.setVisible(false);
				lblUsername.setVisible(false);
				lblPassword.setVisible(false);
			}
		});

		

		
		
		btnNewButton_3.setVisible(false);
		lblLevel.setVisible(false);
		comboBox_1.setVisible(false);
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				textField_2.setText("");
				passwordField.setText("");
				
			}
		});
		btnNewButton_5.setVisible(false);
		passwordField.setVisible(false);
		lblUsername.setVisible(false);
		lblPassword.setVisible(false);
		passwordField_1.setVisible(false);
		lblRepassword.setVisible(false);

		
		setTitle("User Registration");
		setType(Type.UTILITY);
		setResizable(false);
		
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 521, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(73, 50, 115, 33);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(204, 50, 172, 33);
		contentPane.add(textField);
		

		passwordField_1.setBounds(204, 172, 172, 33);
		contentPane.add(passwordField_1);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 111, 172, 33);
		contentPane.add(textField_1);
		
		textField_2 = new JTextField();
		textField_2.setColumns(10);
		textField_2.setBounds(204, 50, 172, 33);
		contentPane.add(textField_2);
		
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSurname.setBounds(73, 111, 115, 33);
		contentPane.add(lblSurname);
		
		
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDob.setBounds(73, 168, 80, 33);
		contentPane.add(lblDob);
		
		
		lblMembership.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMembership.setBounds(73, 228, 115, 33);
		contentPane.add(lblMembership);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(73, 303, 171, 41);
		contentPane.add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dateChooser.getDate() != null && !(textField.equals("")) && !(textField_1.equals(""))){
					

				int date=dateChooser.getDate().getDate();
				int month=(dateChooser.getDate().getMonth())+1;
				int year=(dateChooser.getDate().getYear())+1900;
				int day = dateChooser.getDate().getDay();
				
				SqlDate = year + "-" + month + "-" + date;
				try {
					String query="insert into Scheduling (Name,Surname,DOB,M_Status) values (?,?,?,?)";
					PreparedStatement pst=connection.prepareStatement(query);
					pst.setString(1, textField.getText());
					pst.setString(2, textField_1.getText());
					pst.setString(3, SqlDate);
					pst.setString(4, (String) comboBox.getSelectedItem());
					pst.execute();
					JOptionPane.showMessageDialog(null, "Successful!");
					pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			  }
				else{
					
					JOptionPane.showMessageDialog(null, "Please fill up all sections!");
				}
				
				textField.setText("");
				textField_1.setText("");
			}
			
			
		});
		

		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_1.setBounds(249, 303, 171, 41);
		contentPane.add(btnNewButton_1);

	    comboBox.addItem("Registered");
	    comboBox.addItem("Member");
	    comboBox.addItem("Loyalty");
		comboBox.setBounds(204, 222, 172, 39);
		contentPane.add(comboBox);
		
		
		dateChooser.setBounds(204, 172, 172, 33);
		contentPane.add(dateChooser);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				lblSurname.setVisible(false);
				lblName.setVisible(false);
				lblMembership.setVisible(false);
				btnNewButton_1.setVisible(false);
				btnNewButton.setVisible(false);
				lblDob.setVisible(false);
				comboBox.setVisible(false);
				btnNewButton_2.setVisible(false);
				dateChooser.setVisible(false);
				textField.setVisible(false);
				textField_1.setVisible(false);
				
				
				
				btnNewButton_3.setVisible(true);
				lblLevel.setVisible(true);
				comboBox_1.setVisible(true);
				btnNewButton_4.setVisible(true);
				btnNewButton_5.setVisible(true);
				textField_2.setVisible(true);
				passwordField.setVisible(true);
				lblUsername.setVisible(true);
				lblPassword.setVisible(true);
				passwordField_1.setVisible(true);
				lblRepassword.setVisible(true);
				
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(415, 13, 87, 65);
		
		contentPane.add(btnNewButton_2);
		btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_3.setBounds(415, 13, 87, 65);
		
		contentPane.add(btnNewButton_3);
		btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_5.setBounds(73, 303, 171, 41);
		
		contentPane.add(btnNewButton_5);
		passwordField.setBounds(204, 111, 172, 33);
		
		contentPane.add(passwordField);
		lblUsername.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblUsername.setBounds(73, 50, 115, 33);
		
		contentPane.add(lblUsername);
		
		
		comboBox_1.setBounds(204, 222, 172, 39);
		contentPane.add(comboBox_1);
	    comboBox_1.addItem("Manager");
	    comboBox_1.addItem("Operator");
	    comboBox_1.addItem("Instructor");
		
		lblLevel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblLevel.setBounds(73, 229, 115, 33);
		contentPane.add(lblLevel);
		
		
		lblPassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblPassword.setBounds(73, 111, 115, 33);
		contentPane.add(lblPassword);
		
		
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				try {
					
					
					String query1="select * from Login where Username = '"+textField_2.getText()+"'";
					PreparedStatement pst1=connection.prepareStatement(query1);
					ResultSet rs1=pst1.executeQuery();
					
					int count = 0;
					while(rs1.next()){
						
						count = count + 1;
						
					}
					
					if(count==0)
					{
						
						if(passwordField.getText().equals(passwordField_1.getText())){
							
							
							try {
								String query="insert into Login (Username,Password,Access) values (?,?,?)";
								PreparedStatement pst=connection.prepareStatement(query);
								pst.setString(1, textField_2.getText());
								pst.setString(2, passwordField.getText());
								pst.setString(3, (String) comboBox_1.getSelectedItem());
								pst.execute();
								JOptionPane.showMessageDialog(null, "Successful!");
								pst.close();
								
							} catch (Exception e1) {
								e1.printStackTrace();
							}
							
							
							
						}else{
							
							JOptionPane.showMessageDialog(null, "Password does not match!");
						}
						

					}
					else{
						
						JOptionPane.showMessageDialog(null, "Username already in use!");
					}
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
				textField_2.setText("");
				passwordField.setText("");
				passwordField_1.setText("");
				

				
			}
		});
		btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_4.setBounds(249, 303, 171, 41);
		contentPane.add(btnNewButton_4);
		
		
		lblRepassword.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblRepassword.setBounds(73, 168, 115, 33);
		contentPane.add(lblRepassword);
		

		

	}
}
