import java.awt.event.ActionEvent;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import javax.swing.JOptionPane;
import javax.swing.JTable;
import javax.swing.JTextField;

import net.proteanit.sql.DbUtils;



public class UserSearchController {
	DataPersistence data = new DataPersistence(); // create a new datapersistence object 
	
	public JTable search(JTable table, JTextField surname) {
		return data.searchResults(table, surname); // return the results from the database search to the calling function 
	}
	

}