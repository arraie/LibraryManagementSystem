

import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;
import javax.swing.JTextField;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class retBooksForSpecAuthByName {

	private JFrame frmRetriveBooksFor;
	private JTextField authFname;
	private JTextField authLastName;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void retBooksForSpecAuthByNameMeth() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retBooksForSpecAuthByName window = new retBooksForSpecAuthByName();
					window.frmRetriveBooksFor.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public retBooksForSpecAuthByName() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmRetriveBooksFor = new JFrame();
		frmRetriveBooksFor.setResizable(false);
		frmRetriveBooksFor.setTitle("Retrive Books for specific author");
		frmRetriveBooksFor.setBounds(100, 100, 685, 255);
		frmRetriveBooksFor.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		frmRetriveBooksFor.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enter Author first name");
		panel.add(lblNewLabel);
		
		authFname = new JTextField();
		panel.add(authFname);
		authFname.setColumns(10);
		
		JLabel lblNewLabel_1 = new JLabel("last name");
		panel.add(lblNewLabel_1);
		
		authLastName = new JTextField();
		panel.add(authLastName);
		authLastName.setColumns(10);
		
		JButton btnNewButton = new JButton("Retrieve");
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {

				try {
					Class.forName("com.mysql.jdbc.Driver");
					Connection myConn1=DriverManager.getConnection(  
			        "jdbc:mysql://localhost:3306/LIBRARY","root","");
					
					String authfname = "'" + authFname.getText() +"'";
					String authlname = "'" + authLastName.getText() +"'";

					String join = "select BOOK.Title from BOOK , AUTHOR , WRITEE where AUTHOR.Fname =" + authfname + " AND AUTHOR.Lname =" + authlname + " AND WRITEE.AuthorID=Author.AuthorID AND WRITEE.BookISBN=BOOK.ISBN";

					PreparedStatement ps = myConn1.prepareStatement(join);

					ResultSet rs = ps.executeQuery();

					System.out.println("Title");

					int counter=0;
					while (rs.next()) {
						String title = rs.getString("Title");
						System.out.println(title);
						counter++;}

					retBooksForSpecAuthByNameTable model = new retBooksForSpecAuthByNameTable(counter,authfname,authlname);
					table.setModel(model);
					
					myConn1.close();
					
					}catch(Exception E) {
						JOptionPane.showMessageDialog(btnNewButton, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
	}
				
			}
		});
		panel.add(btnNewButton);
		
		JScrollPane scrollPane = new JScrollPane();
		frmRetriveBooksFor.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}
