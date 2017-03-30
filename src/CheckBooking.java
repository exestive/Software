import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.Dimension;
import java.awt.EventQueue;
import java.awt.Font;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;

public class CheckBooking extends JFrame {
	private JTextField textField;
	Scheduling s1;
	User_register c1=new User_register();
	public CheckBooking() {
		getContentPane().setLayout(null);
		
		JLabel lblCheckin = new JLabel("Check-in Booking");
		lblCheckin.setFont(new Font("SansSerif", Font.ITALIC, 15));
		lblCheckin.setBounds(153, 11, 119, 39);
		getContentPane().add(lblCheckin);
		
		JLabel lblEnterTheMember = new JLabel("Enter the Member id to check");
		lblEnterTheMember.setFont(new Font("SansSerif", Font.PLAIN, 15));
		lblEnterTheMember.setBounds(115, 61, 209, 39);
		getContentPane().add(lblEnterTheMember);
		
		textField = new JTextField();
		textField.setBounds(125, 111, 176, 29);
		getContentPane().add(textField);
		textField.setColumns(10);
		
		JLabel lblNewLabel = new JLabel("ID:");
		lblNewLabel.setFont(new Font("SansSerif", Font.PLAIN, 16));
		lblNewLabel.setBounds(97, 115, 46, 14);
		getContentPane().add(lblNewLabel);
		
		JButton btnNewButton = new JButton("Check");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent arg0) {
				int num=Integer.parseInt(textField.getText());
				for(int i =0; i<c1.list.length; i++){
				if(num==c1.index){
							 JFrame parent = new JFrame();
							    JOptionPane.showMessageDialog(parent, "This user has a booking");
							    break;
						}else{
							 String message = "This user has not a booking!.";
					            JOptionPane.showMessageDialog(new JFrame(), message, "Dialog",
					                    JOptionPane.ERROR_MESSAGE);
					            break;
						}
				}
		}});
		btnNewButton.setFont(new Font("Tahoma", Font.PLAIN, 14));
		btnNewButton.setBounds(156, 176, 105, 39);
		getContentPane().add(btnNewButton);
	}

	public static void main(String[] args) {
		EventQueue.invokeLater(new Runnable() {
			public void run () {
				try {
			        displayJFrame();
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
			
		});
	}
static void displayJFrame()
  {
    CheckBooking jframe = new CheckBooking();
    jframe.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
    jframe.setPreferredSize(new Dimension(450, 300));
    jframe.pack();
    jframe.setLocationRelativeTo(null);
    jframe.setVisible(true);
  }
}
