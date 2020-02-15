
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.Statement;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class deleteBook {

	private JFrame frmDeleteBook;
	private JTextField bookISBN;

	/**
	 * Launch the application.
	 */
	public static void deleteBookMeth() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					deleteBook window = new deleteBook();
					window.frmDeleteBook.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public deleteBook() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmDeleteBook = new JFrame();
		frmDeleteBook.getContentPane().setBackground(new Color(240, 248, 255));
		frmDeleteBook.setResizable(false);
		frmDeleteBook.setTitle("Delete Book");
		frmDeleteBook.setBounds(100, 100, 433, 145);
		//frmDeleteBook.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmDeleteBook.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);

		frmDeleteBook.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Enter the book ISBN that you want to delete");
		lblNewLabel.setBounds(6, 25, 287, 16);
		frmDeleteBook.getContentPane().add(lblNewLabel);
		
		bookISBN = new JTextField();
		bookISBN.setBounds(6, 53, 162, 26);
		frmDeleteBook.getContentPane().add(bookISBN);
		bookISBN.setColumns(10);
		
		JButton btnNewButton = new JButton("Delete");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				try {
					Class.forName("com.mysql.jdbc.Driver");
				
		        Connection myConn1=DriverManager.getConnection(  
		        "jdbc:mysql://localhost:3306/LIBRARY","root","");
				
				Statement myStmt6 = myConn1.createStatement();
				String sql2 = "delete from BOOK where ISBN = " +"'"+bookISBN.getText()+"'";
				int rowsAffected = myStmt6.executeUpdate(sql2);
				
				String sql="";
				if(rowsAffected>0)
					JOptionPane.showMessageDialog (btnNewButton, "Deleted successfully");
					else
						JOptionPane.showMessageDialog (btnNewButton, "Invalid",sql, JOptionPane.ERROR_MESSAGE);
	
				myConn1.close();
				
				}catch(Exception E) {
				JOptionPane.showMessageDialog(btnNewButton, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
			}
				
			}
		});
		btnNewButton.setBounds(180, 53, 117, 29);
		frmDeleteBook.getContentPane().add(btnNewButton);
	}

}
