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
	private JFrame hello;
	private JTextField textField;
	private JTextField textField_1;
	Connection connection=null;
	JDateChooser dateChooser = new JDateChooser();
	String SqlDate;

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
		setTitle("User Registration");
		setType(Type.UTILITY);
		setResizable(false);
		JComboBox<String> comboBox = new JComboBox<String>();
		connection=sqliteConnection.dbConnector();
		setDefaultCloseOperation(JFrame.DISPOSE_ON_CLOSE);
		setBounds(100, 100, 521, 481);
		contentPane = new JPanel();
		contentPane.setBorder(new EmptyBorder(5, 5, 5, 5));
		setContentPane(contentPane);
		contentPane.setLayout(null);
		
		JLabel lblName = new JLabel("Name:");
		lblName.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblName.setBounds(73, 50, 115, 33);
		contentPane.add(lblName);
		
		textField = new JTextField();
		textField.setColumns(10);
		textField.setBounds(204, 50, 172, 33);
		contentPane.add(textField);
		
		textField_1 = new JTextField();
		textField_1.setColumns(10);
		textField_1.setBounds(204, 111, 172, 33);
		contentPane.add(textField_1);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSurname.setBounds(73, 111, 115, 33);
		contentPane.add(lblSurname);
		
		JLabel lblDob = new JLabel("D.O.B:");
		lblDob.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDob.setBounds(73, 168, 80, 33);
		contentPane.add(lblDob);
		
		JLabel lblMembership = new JLabel("Membership:");
		lblMembership.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMembership.setBounds(73, 228, 115, 33);
		contentPane.add(lblMembership);
		
		JButton btnNewButton = new JButton("Clear");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				textField.setText("");
				textField_1.setText("");
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton.setBounds(73, 303, 171, 41);
		contentPane.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Create");
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dateChooser.getDate() != null && !(textField.equals("")) && !(textField_1.equals(""))){
					

				int date=dateChooser.getDate().getDate();
				int month=(dateChooser.getDate().getMonth())+1;
				int year=(dateChooser.getDate().getYear())+1900;
				int day = dateChooser.getDate().getDay();
				
				SqlDate = year + "-" + month + "-" + date;
				try {
					String query4="insert into Scheduling (Name,Surname,DOB,M_Status) values (?,?,?,?)";
					PreparedStatement pst4=connection.prepareStatement(query4);
					pst4.setString(1, textField.getText());
					pst4.setString(2, textField_1.getText());
					pst4.setString(3, SqlDate);
					pst4.setString(4, (String) comboBox.getSelectedItem());
					pst4.execute();
					JOptionPane.showMessageDialog(null, "Successful!");
					//pst.close();
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			  }
				else{
					
					JOptionPane.showMessageDialog(null, "Please fill up all sections!");
				}
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
		
		
		dateChooser.setBounds(204, 162, 172, 33);
		contentPane.add(dateChooser);
	}
}
