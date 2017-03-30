import java.awt.EventQueue;

import java.awt.BorderLayout;


import net.proteanit.sql.DbUtils;

import java.awt.Choice;
import java.awt.TextField;
import java.awt.Font;
import java.sql.*;
import javax.swing.*;
import javax.swing.table.AbstractTableModel;

import java.awt.event.ActionListener;
import java.awt.print.PrinterException;
import java.awt.event.ActionEvent;
import com.toedter.calendar.JDateChooser;
import com.toedter.components.JSpinField;

public class Scheduling{
	private JFrame frmSchedulingPanel;
	private JTextField textField_1;
	TextField textField_5 = new TextField();
	
	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					Scheduling window = new Scheduling();
					window.frmSchedulingPanel.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}
	Connection connection=null;
	private JTable table;
	private JTable table_1;
	private JTable table_2;
	private JTable table_3;
	private JTable table_4;
	private JTable table_5;
	
	private JTextField textField_4;
	private JTextField textField;
	private JTextField textField_2;
	
	String Var, Day_Str,Time_Str, SqlDate, SqlDate1,SqlDate2;
	int Hr,Min;
	JComboBox<String> comboBox = new JComboBox<String>();
	JDateChooser dateChooser = new JDateChooser();
	JDateChooser dateChooser_1 = new JDateChooser();
	JSpinField spinField = new JSpinField();
	JSpinField spinField_1 = new JSpinField();
	JLabel lblNewLabel_4 = new JLabel("Username:");
	JLabel lblNewLabel_5 = new JLabel("Password:");
	TextField textField_3 = new TextField();
	private final JPasswordField
	passwordField = new JPasswordField();
	JButton btnNewButton_3 = new JButton("User");
	JButton btnNewButton_4 = new JButton("Members");
	JButton btnNewButton_7 = new JButton("U.Delete");
	JButton btnNewButton = new JButton("Check");
	JButton btnNewButton_2 = new JButton("Book");
	JButton btnNewButton_8 = new JButton("S.Delete");
	JButton btnNewButton_9 = new JButton("Management");
	JButton btnClear = new JButton("Clear");
	JButton btnNewButton_1 = new JButton("Print");
	JButton btnNewButton_5 = new JButton("Sessions");
	JButton btnNewButton_6 = new JButton("Session");
	JButton btnNewButton_10 = new JButton("Staff Menu");
	JButton btnNewButton_11 = new JButton("Login");
	JButton btnNewButton_12 = new JButton("Cancel");
	private final JButton btnNewButton_13 = new JButton("Slope Operator");
	
	


	/**
	 * Create the application.
	 */
	
	public void refreshTable(){
		
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Monday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Tuesday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Wednesday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Thursday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_4.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Friday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_5.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			String query="select * from Scheduling where Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"'";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_1.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
	
	}
	
	public Scheduling() {
		initialize();
		connection=sqliteConnection.dbConnector();
		
			
		
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Monday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Tuesday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_2.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Wednesday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_3.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Thursday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_4.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		try {
			String query="select sc.ID, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and se.Day = 'Friday' order by se.Time";
			PreparedStatement pst=connection.prepareStatement(query);
			ResultSet rs=pst.executeQuery();
			table_5.setModel(DbUtils.resultSetToTableModel(rs));
		} catch (Exception e1) {
			e1.printStackTrace();
		}
		
		
		btnNewButton.setVisible(false);
		btnNewButton_1.setVisible(false);
		btnNewButton_2.setVisible(false);
		btnNewButton_3.setVisible(false);
		btnNewButton_6.setVisible(false);
		btnNewButton_7.setVisible(false);
		btnNewButton_8.setVisible(false);
		btnNewButton_10.setVisible(false);
		btnNewButton_9.setFont(new Font("Tahoma", Font.PLAIN, 15));
		btnNewButton_9.setVisible(true);
		btnClear.setVisible(false);
		btnNewButton_11.setVisible(false);
		lblNewLabel_4.setVisible(false);
		lblNewLabel_5.setVisible(false);
		textField_3.setVisible(false);
		passwordField.setVisible(false);
		btnNewButton_12.setFont(new Font("Tahoma", Font.PLAIN, 19));
		btnNewButton_12.setVisible(false);
		btnNewButton_13.setVisible(true);
		
			
			btnNewButton_3.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					User_register win = new User_register();
					if ("1".equals(textField_5.getText())){
						
						win.btnNewButton_2.setVisible(true);
					}
					else{
						
						win.btnNewButton_2.setVisible(false);
						
					}
					win.setVisible(true);
					refreshTable();
				}
			});
			btnNewButton_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_3.setBounds(90, 378, 115, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_3);
			dateChooser.setDateFormatString("dd-MMM-yyyy");
			
			
			dateChooser.setBounds(156, 130, 172, 33);
			frmSchedulingPanel.getContentPane().add(dateChooser);
			

			spinField.setBounds(156, 168, 38, 39);
			frmSchedulingPanel.getContentPane().add(spinField);
			spinField.setMaximum(23);
			spinField.setMinimum(0);
			
			
			spinField_1.setMaximum(59);
			spinField_1.setMinimum(0);
			spinField_1.setBounds(240, 168, 38, 39);
			frmSchedulingPanel.getContentPane().add(spinField_1);
			
			JLabel lblNewLabel_2 = new JLabel("Hr.");
			lblNewLabel_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_2.setBounds(198, 175, 27, 33);
			frmSchedulingPanel.getContentPane().add(lblNewLabel_2);
			
			JLabel lblNewLabel_3 = new JLabel("Min.");
			lblNewLabel_3.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_3.setBounds(282, 175, 38, 33);
			frmSchedulingPanel.getContentPane().add(lblNewLabel_3);
			
			
			dateChooser_1.setBounds(156, 94, 172, 33);
			frmSchedulingPanel.getContentPane().add(dateChooser_1);
			
			
			btnNewButton_4.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						String query="select * from Scheduling";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_4.setBounds(42, 638, 171, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_4);
			
			
			btnNewButton_5.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						String query="select * from Session";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
				}
			});
			btnNewButton_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_5.setBounds(240, 638, 171, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_5);
			
			
			btnNewButton_6.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						String query="select sc.ID, sc.Name, sc.Surname, se.Date, se.Time, Se.Instructor from Scheduling sc, Session se Where sc.Session_ID = se.Session_ID and (sc.Surname = '"+textField_1.getText()+"' and  sc.DOB = '"+textField.getText()+"') ";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					//refreshTable();
				}
			});
			btnNewButton_6.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_6.setBounds(90, 293, 116, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_6);
			
			
			btnNewButton_7.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						String query="delete from Session where Session_ID IN (select Session_ID from Scheduling where  Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"')";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					try {
						String query="delete from Scheduling where Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					refreshTable();
					JOptionPane.showMessageDialog(null, "Successful!");
				}
			});
			btnNewButton_7.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_7.setBounds(90, 335, 115, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_7);
			
			
			btnNewButton_8.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					try {
						String query="delete from Session where Session_ID IN (select Session_ID from Scheduling where  Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"')";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					try {
						String query="update Scheduling set Session_ID = null where Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						pst.execute();
						
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					refreshTable();
					JOptionPane.showMessageDialog(null, "Successful!");
				}
			});
			btnNewButton_8.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_8.setBounds(208, 335, 120, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_8);
			
			
			btnNewButton_9.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {


					
					
					btnNewButton_11.setVisible(true);
					btnNewButton_12.setVisible(true);
					lblNewLabel_4.setVisible(true);
					lblNewLabel_5.setVisible(true);
					textField_3.setVisible(true);
					passwordField.setVisible(true);
					
					
					
					
				}
			});
			btnNewButton_9.setBounds(201, 249, 127, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_9);
			
			
			btnNewButton_10.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent e) {
					
					btnNewButton_9.setVisible(true);
					btnNewButton.setVisible(false);
					btnNewButton_1.setVisible(false);
					btnNewButton_2.setVisible(false);
					btnNewButton_3.setVisible(false);
					btnNewButton_6.setVisible(false);
					btnNewButton_7.setVisible(false);
					btnNewButton_8.setVisible(false);
					btnNewButton_10.setVisible(false);
					btnClear.setVisible(false);
					btnNewButton_13.setVisible(true);

				}
			});
			btnNewButton_10.setFont(new Font("Tahoma", Font.PLAIN, 11));
			btnNewButton_10.setBounds(327, 255, 102, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_10);
			
			
			textField_3.setBounds(156, 312, 172, 33);
			frmSchedulingPanel.getContentPane().add(textField_3);
			
			
			lblNewLabel_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_4.setBounds(37, 308, 115, 33);
			frmSchedulingPanel.getContentPane().add(lblNewLabel_4);
			
			
			lblNewLabel_5.setFont(new Font("Tahoma", Font.PLAIN, 20));
			lblNewLabel_5.setBounds(37, 347, 115, 33);
			frmSchedulingPanel.getContentPane().add(lblNewLabel_5);
			
			
			btnNewButton_11.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					
					
					try {
						String query="select * from Login where Username = '"+textField_3.getText()+"' and  Password = '"+passwordField.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						
						int count = 0;
						while(rs.next()){
							
							count = count + 1;
							
						}
						
						if (count == 1){
							
							
							
							
							
							String query0="select Access from Login where Username = '"+textField_3.getText()+"' and  Password = '"+passwordField.getText()+"'";
							PreparedStatement pst0=connection.prepareStatement(query0);
							ResultSet rs0=pst0.executeQuery();
							String ACC = rs0.getString("Access");
							pst0.close();
							if("Manager".equals(ACC)){
								
								btnNewButton_11.setVisible(false);
								btnNewButton_12.setVisible(false);
								lblNewLabel_4.setVisible(false);
								lblNewLabel_5.setVisible(false);
								textField_3.setVisible(false);
								passwordField.setVisible(false);
								btnNewButton_9.setVisible(false);
								btnNewButton_13.setVisible(false);

								
								
								btnNewButton.setVisible(true);
								btnNewButton_1.setVisible(true);
								btnNewButton_2.setVisible(true);
								btnNewButton_3.setVisible(true);
								btnNewButton_6.setVisible(true);
								btnNewButton_7.setVisible(true);
								btnNewButton_8.setVisible(true);
								btnNewButton_10.setVisible(true);
								btnClear.setVisible(true);
								textField_5.setText("1");
								textField_3.setText("");
								passwordField.setText("");
								
								
							}
							else if("Operator".equals(ACC)){
								
								btnNewButton_11.setVisible(false);
								lblNewLabel_4.setVisible(false);
								lblNewLabel_5.setVisible(false);
								textField_3.setVisible(false);
								passwordField.setVisible(false);
								btnNewButton_9.setVisible(false);
								btnNewButton_12.setVisible(false);

								
								
								btnNewButton.setVisible(true);
								btnNewButton_1.setVisible(true);
								btnNewButton_2.setVisible(true);
								btnNewButton_3.setVisible(true);
								btnNewButton_6.setVisible(true);
								btnNewButton_7.setVisible(true);
								btnNewButton_8.setVisible(true);
								btnNewButton_10.setVisible(true);
								btnClear.setVisible(true);
								textField_5.setText("0");
								textField_3.setText("");
								passwordField.setText("");
								
							}
							else{
								
								btnNewButton_11.setVisible(false);
								btnNewButton_12.setVisible(false);
								lblNewLabel_4.setVisible(false);
								lblNewLabel_5.setVisible(false);
								textField_3.setVisible(false);
								passwordField.setVisible(false);
								btnNewButton_9.setVisible(false);
								
								
								btnNewButton.setVisible(true);
								btnNewButton_1.setVisible(true);
								btnNewButton_2.setVisible(false);
								btnNewButton_3.setVisible(false);
								btnNewButton_6.setVisible(true);
								btnNewButton_7.setVisible(false);
								btnNewButton_8.setVisible(false);
								btnNewButton_10.setVisible(true);
								btnClear.setVisible(true);
								textField_5.setText("0");
								textField_3.setText("");
								passwordField.setText("");
							}
							

							
						}
						else{
							
							JOptionPane.showMessageDialog(null, "Wrong Username or Password!");
							textField_3.setText("");
							passwordField.setText("");
						}
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
					
					
					
					
				}
			});
			btnNewButton_11.setFont(new Font("Tahoma", Font.PLAIN, 20));
			btnNewButton_11.setBounds(243, 383, 82, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_11);
			
			
			passwordField.setEchoChar('*');
			passwordField.setBounds(156, 348, 172, 33);
			frmSchedulingPanel.getContentPane().add(passwordField);
			
			
			btnNewButton_12.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					
					btnNewButton_11.setVisible(false);
					btnNewButton_12.setVisible(false);
					lblNewLabel_4.setVisible(false);
					lblNewLabel_5.setVisible(false);
					textField_3.setVisible(false);
					passwordField.setVisible(false);
				}
			});
			btnNewButton_12.setBounds(153, 383, 91, 41);
			frmSchedulingPanel.getContentPane().add(btnNewButton_12);
			btnNewButton_13.addActionListener(new ActionListener() {
				public void actionPerformed(ActionEvent arg0) {
					CheckBooking c1=new CheckBooking();
					c1.setVisible(true);
				}
			});
			btnNewButton_13.setFont(new Font("Tahoma", Font.PLAIN, 15));
			btnNewButton_13.setBounds(58, 249, 139, 41);
			
			frmSchedulingPanel.getContentPane().add(btnNewButton_13);

	}

	private void initialize() {
		frmSchedulingPanel = new JFrame();
		frmSchedulingPanel.setTitle("Scheduling Panel");
		frmSchedulingPanel.setResizable(false);
		frmSchedulingPanel.setBounds(100, 100, 1173, 782);
		frmSchedulingPanel.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmSchedulingPanel.getContentPane().setLayout(null);
		
		textField_1 = new JTextField();
		textField_1.setBounds(156, 57, 172, 33);
		frmSchedulingPanel.getContentPane().add(textField_1);
		textField_1.setColumns(10);
		
		JLabel lblInstructor = new JLabel("Instructor:");
		lblInstructor.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblInstructor.setBounds(37, 211, 101, 33);
		frmSchedulingPanel.getContentPane().add(lblInstructor);
		
		JLabel lblDate = new JLabel("Date:");
		lblDate.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblDate.setBounds(37, 135, 115, 33);
		frmSchedulingPanel.getContentPane().add(lblDate);
		
		JLabel lblTime = new JLabel("Time:");
		lblTime.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTime.setBounds(37, 174, 115, 33);
		frmSchedulingPanel.getContentPane().add(lblTime);
		
		
		btnClear.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				refreshTable();
				textField_1.setText("");
				spinField.setValue(0);
				spinField_1.setValue(0);

				try {
					String query="select seq from sqlite_sequence where name='Session'";
					PreparedStatement pst=connection.prepareStatement(query);
					ResultSet rs=pst.executeQuery();
					table_1.setModel(DbUtils.resultSetToTableModel(rs));
				} catch (Exception e1) {
					e1.printStackTrace();
				}

			}
		});
		btnClear.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnClear.setBounds(208, 292, 120, 41);
		frmSchedulingPanel.getContentPane().add(btnClear);
		
		
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				if(dateChooser_1.getDate() != null){
					
					int date1=dateChooser_1.getDate().getDate();
					int month1=(dateChooser_1.getDate().getMonth())+1;
					int year1=(dateChooser_1.getDate().getYear())+1900;
					
					SqlDate1 = year1 + "-" + month1 + "-" + date1;
					
					textField.setText(SqlDate1);
					
					try {
						String query="select * from Scheduling where Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"'";
						PreparedStatement pst=connection.prepareStatement(query);
						ResultSet rs=pst.executeQuery();
						table_1.setModel(DbUtils.resultSetToTableModel(rs));
					} catch (Exception e1) {
						e1.printStackTrace();
					}
					
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Please fill up all sections!");
				}
				
			}
		});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton.setBounds(208, 255, 120, 41);
		frmSchedulingPanel.getContentPane().add(btnNewButton);
		
		
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
				    boolean complete = table_1.print();
				    if (complete) {
				    	JOptionPane.showMessageDialog(null, "Printing Completed!");
				        
				    } else {
				    	JOptionPane.showMessageDialog(null, "Printing Cancelled!");
				        
				    }
				} catch (PrinterException pe) {
					JOptionPane.showMessageDialog(null, "Printing Error!");
				    
				}
				
				
			}
		});
		btnNewButton_1.setFont(new Font("Tahoma", Font.PLAIN, 22));
		btnNewButton_1.setBounds(90, 255, 115, 41);
		frmSchedulingPanel.getContentPane().add(btnNewButton_1);
		
		JLabel lblNewLabel = new JLabel("Info:");
		lblNewLabel.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel.setBounds(13, 395, 53, 33);
		frmSchedulingPanel.getContentPane().add(lblNewLabel);
		
		JLabel lblMonday = new JLabel("Mon");
		lblMonday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblMonday.setBounds(782, 28, 80, 33);
		frmSchedulingPanel.getContentPane().add(lblMonday);
		
		JLabel lblTuesday = new JLabel("Tue");
		lblTuesday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblTuesday.setBounds(782, 151, 115, 33);
		frmSchedulingPanel.getContentPane().add(lblTuesday);
		
		JLabel lblWednesday = new JLabel("Wed");
		lblWednesday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblWednesday.setBounds(782, 271, 115, 33);
		frmSchedulingPanel.getContentPane().add(lblWednesday);
		
		JLabel lblThursday = new JLabel("Thu");
		lblThursday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblThursday.setBounds(782, 395, 115, 33);
		frmSchedulingPanel.getContentPane().add(lblThursday);
		
		JLabel lblFriday = new JLabel("Fri");
		lblFriday.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblFriday.setBounds(782, 525, 115, 33);
		frmSchedulingPanel.getContentPane().add(lblFriday);
		
		JLabel lblSurname = new JLabel("Surname:");
		lblSurname.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblSurname.setBounds(37, 57, 115, 33);
		frmSchedulingPanel.getContentPane().add(lblSurname);
		
		JLabel lblNewLabel_1 = new JLabel("D.O.B:");
		lblNewLabel_1.setFont(new Font("Tahoma", Font.PLAIN, 20));
		lblNewLabel_1.setBounds(37, 94, 115, 33);
		frmSchedulingPanel.getContentPane().add(lblNewLabel_1);
		
		JScrollPane scrollPane = new JScrollPane();
		scrollPane.setBounds(453, 57, 680, 91);
		frmSchedulingPanel.getContentPane().add(scrollPane);
		
		table = new JTable();
		scrollPane.setViewportView(table);
		
		JScrollPane scrollPane_1 = new JScrollPane();
		scrollPane_1.setBounds(13, 435, 422, 193);
		frmSchedulingPanel.getContentPane().add(scrollPane_1);
		
		table_1 = new JTable();
		scrollPane_1.setViewportView(table_1);
		
		textField_4 = new JTextField();
		scrollPane_1.setColumnHeaderView(textField_4);
		textField_4.setFont(new Font("Tahoma", Font.PLAIN, 20));
		textField_4.setEnabled(false);
		textField_4.setEditable(false);
		textField_4.setColumns(10);
		
		textField = new JTextField();
		scrollPane_1.setColumnHeaderView(textField);
		textField.setEnabled(false);
		textField.setEditable(false);
		textField.setColumns(10);
		
		textField_2 = new JTextField();
		textField_2.setEnabled(false);
		textField_2.setEditable(false);
		scrollPane_1.setColumnHeaderView(textField_2);
		textField_2.setColumns(10);
		
		
		scrollPane_1.setColumnHeaderView(textField_5);
		textField_5.setEnabled(false);
		textField_5.setEditable(false);
		
		JScrollPane scrollPane_2 = new JScrollPane();
		scrollPane_2.setBounds(453, 184, 680, 91);
		frmSchedulingPanel.getContentPane().add(scrollPane_2);
		
		table_2 = new JTable();
		scrollPane_2.setViewportView(table_2);
		
		JScrollPane scrollPane_3 = new JScrollPane();
		scrollPane_3.setBounds(453, 306, 680, 91);
		frmSchedulingPanel.getContentPane().add(scrollPane_3);
		
		table_3 = new JTable();
		scrollPane_3.setViewportView(table_3);
		
		JScrollPane scrollPane_4 = new JScrollPane();
		scrollPane_4.setBounds(453, 435, 680, 91);
		frmSchedulingPanel.getContentPane().add(scrollPane_4);
		
		table_4 = new JTable();
		scrollPane_4.setViewportView(table_4);
		
		JScrollPane scrollPane_5 = new JScrollPane();
		scrollPane_5.setBounds(453, 559, 680, 91);
		frmSchedulingPanel.getContentPane().add(scrollPane_5);
		
		table_5 = new JTable();
		scrollPane_5.setViewportView(table_5);
		
		
		
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				
				
				if(dateChooser.getDate() != null && dateChooser_1.getDate() != null && !(textField_1.equals(""))){
					
				int date=dateChooser.getDate().getDate();
				int month=(dateChooser.getDate().getMonth())+1;
				int year=(dateChooser.getDate().getYear())+1900;
				int day = dateChooser.getDate().getDay();
				
				SqlDate2 = year + "-" + month + "-" + date;

			      switch(day) {
			         case 1 :
			            Day_Str="Monday";  
			            break;
			         case 2 :
			        	 Day_Str="Tuesday";
			            break;
			         case 3 :
			        	 Day_Str="Wednesday"; 
			        	 break;
			         case 4 :
			        	 Day_Str="Thursday"; 
			            break;
			         case 5 :
			        	 Day_Str="Friday"; 
				        break;
			         case 6 :
			        	 Day_Str="Saturday"; 
				        break;
			         case 0 :
			        	 Day_Str="Sunday"; 
				        break;

			      }
			      
				
				Hr = spinField.getValue();
				Min = spinField_1.getValue();
				if (Hr<10 && Min>10){
					
					Time_Str = "0" + Hr + ":" + Min;
				}
				else if(Hr >10 && Min<10){
					Time_Str = Hr + ":" + "0" + Min;
				}
				else if(Hr<10 && Min<10){
					Time_Str = "0" + Hr + ":" + "0" + Min;
				}
				else{
					
					Time_Str = Hr + ":" + Min;
				}
				
				
				try {
					String query0="select M_Status from Scheduling where Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"'";
					PreparedStatement pst0=connection.prepareStatement(query0);
					ResultSet rs0=pst0.executeQuery();
					int count = 0;
					while(rs0.next()){
						
						count = count + 1;
					}
					
					if (count >= 1){
						
						String query00="select M_Status from Scheduling where Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"'";
						PreparedStatement pst00=connection.prepareStatement(query00);
						ResultSet rs00=pst00.executeQuery();
						String Mem_St = rs00.getString("M_Status");

						if (count > 1){
							
							JOptionPane.showMessageDialog(null, "Multiple User found!");
						} else if (count == 0){
							
							JOptionPane.showMessageDialog(null, "No User found!");
						}else{
							

							if ("Member".equals(Mem_St) || "Loyalty".equals(Mem_St)){
							
								
								try {
									
									
									String query="insert into Session (Date,Day,Time,Instructor) values (?,?,?,?)";
									PreparedStatement pst=connection.prepareStatement(query);
									pst.setString(1, SqlDate2);
									pst.setString(2, Day_Str);
									pst.setString(3, Time_Str);
									pst.setString(4, (String) comboBox.getSelectedItem());
									pst.execute();
									pst.close();
									
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								try {
									String query="select seq from sqlite_sequence where name='Session'";
									PreparedStatement pst=connection.prepareStatement(query);
									pst.execute();
									ResultSet rs=pst.executeQuery();
									Var = rs.getString(1);
									textField_4.setText(Var);
									pst.close();

								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, "First Error!");
									e.printStackTrace();
									
								}
								
								
								try {
									String query="update Scheduling set Session_ID='"+textField_4.getText()+"' where Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"'";
									PreparedStatement pst=connection.prepareStatement(query);
									pst.execute();
									pst.close();
								} catch (Exception e) {
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, "Second Error!");
								}
								
								JOptionPane.showMessageDialog(null, "Successful!");
							}
							else if ("Registered".equals(Mem_St) && "No Selection".equals(comboBox.getSelectedItem())){
								
								
								try {
									
									String query="insert into Session (Date,Day,Time,Instructor) values (?,?,?,?)";
									PreparedStatement pst=connection.prepareStatement(query);
									pst.setString(1, SqlDate2);
									pst.setString(2, Day_Str);
									pst.setString(3, Time_Str);
									pst.setString(4, (String) comboBox.getSelectedItem());
									pst.execute();
									pst.close();
									
								} catch (Exception e1) {
									e1.printStackTrace();
								}
								try {
									String query="select seq from sqlite_sequence where name='Session'";
									PreparedStatement pst=connection.prepareStatement(query);
									pst.execute();
									ResultSet rs=pst.executeQuery();
									Var = rs.getString(1);
									textField_4.setText(Var);
									pst.close();

								} catch (Exception e) {
									JOptionPane.showMessageDialog(null, "First Error!");
									e.printStackTrace();
									
								}
								
								
								try {
									String query="update Scheduling set Session_ID='"+textField_4.getText()+"' where Surname = '"+textField_1.getText()+"' and  DOB = '"+textField.getText()+"'";
									PreparedStatement pst=connection.prepareStatement(query);
									pst.execute();
									pst.close();
									
								} catch (Exception e) {
									e.printStackTrace();
									JOptionPane.showMessageDialog(null, "Second Error!");
								}
								
								
								JOptionPane.showMessageDialog(null, "Successful!");
								
							}else{
								
								JOptionPane.showMessageDialog(null, "No instructor for 'Registered' User!");
								
							}

							
							
						}
						
					}
					else{
						
						
						JOptionPane.showMessageDialog(null, "No User foundz!");
						
					}

					
					
				} catch (Exception e1) {
					e1.printStackTrace();
				}
			
				
				}
				else{
					
					JOptionPane.showMessageDialog(null, "Please fill up all sections!");
				}
				
	
				refreshTable();
			}
		});
		btnNewButton_2.setFont(new Font("Tahoma", Font.PLAIN, 20));
		btnNewButton_2.setBounds(208, 378, 120, 41);
		frmSchedulingPanel.getContentPane().add(btnNewButton_2);
		
		comboBox.addItem("No Selection");
	    comboBox.addItem("Johnathan");
	    comboBox.addItem("Kalie");
	    comboBox.addItem("Daniel");
	    comboBox.addItem("Rosie");
	    comboBox.addItem("Michael");
		comboBox.setBounds(156, 213, 172, 33);
		frmSchedulingPanel.getContentPane().add(comboBox);
		
		
	}
}
