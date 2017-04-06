import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;

public class DataPersistence {
	Connection conn = null; 
	public Object[] rowData;
	public JTable table = MembershipUI.table; 
	
	public JTable searchResults(JTable table, JTextField surname) {
		try {
			conn = sqliteConnection.dbConnector();
			String query = "SELECT * FROM Scheduling WHERE Surname=?"; // select all records where the surname = the parameter
			PreparedStatement pst = conn.prepareStatement(query);
			pst.setString(1, surname.getText());
			ResultSet rs = pst.executeQuery();
			table.setModel(DbUtils.resultSetToTableModel(rs)); // insert all the records returned by the query into a table
			return table; // return the table
			
		} catch (Exception e1) {
			JOptionPane.showMessageDialog(null, e1);
			return table;
		}
	}
	public String selectUser(JTable table) {
		int row = table.getSelectedRow(); // get the currently selected row from the table 
		rowData = new Object[table.getColumnCount()];
		for (int i = 0; i < table.getColumnCount(); i++) { // iterate through all columns of the table and get each value in the selected row 
			rowData[i] = table.getValueAt(row, i);
		}
		return rowData[5].toString(); // return membership type 
	}
	
	public String read(int column) {
		
		int row = table.getSelectedRow();
		rowData = new Object[table.getColumnCount()];
		for (int i = 0; i < table.getColumnCount(); i++) {
			rowData[i] = table.getValueAt(row, i);
		}
		return rowData[column].toString(); // return value from table that corresponds to the parameter passed
	}
	public void amendMembership(Member member, String newMembership) {
		 {
			try {
				conn = sqliteConnection.dbConnector();
				String query = "UPDATE Scheduling SET M_Status = ? WHERE ID = ?"; 
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, newMembership);
				st.setString(2,  member.getIDNum()); // set new membershipship status where ID = the current member ID
				st.executeUpdate();
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	public void amendEmail(Member member, String newEmail) {
		 {// amend the email of member passed to function 
			try {
				conn = sqliteConnection.dbConnector();
				String query = "UPDATE Scheduling SET email = ? WHERE ID = ?"; 
				PreparedStatement st = conn.prepareStatement(query);
				st.setString(1, newEmail);
				st.setString(2, member.getIDNum());
				st.executeUpdate();
				
				
			} catch (SQLException e) {
				// TODO Auto-generated catch block
				e.printStackTrace();
			}
		}
	}
	
	public void amendContact(Member member, String newContact) {
		try {// amend the contact number of member passed to function 
			conn = sqliteConnection.dbConnector();
			String query = "UPDATE Scheduling SET contactNumber = ? WHERE ID = ?"; 
			PreparedStatement st = conn.prepareStatement(query);
			st.setString(1, newContact);
			st.setString(2, member.getIDNum());
			st.executeUpdate();
			
			
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
	}
}
