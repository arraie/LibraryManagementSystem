
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import java.awt.BorderLayout;
import javax.swing.JLabel;
import javax.swing.JOptionPane;

import java.awt.FlowLayout;
import javax.swing.JTextField;
import javax.swing.JButton;
import javax.swing.JScrollPane;
import javax.swing.JTable;
import java.awt.event.ActionListener;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.awt.event.ActionEvent;
import java.awt.Color;

public class retAllBooksSpecAuth {

	private JFrame frmLibra;
	private JTextField RetBookISBN;
	private JTable table;

	/**
	 * Launch the application.
	 */
	public static void retriveAllBooksAut() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					retAllBooksSpecAuth window = new retAllBooksSpecAuth();
					window.frmLibra.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public retAllBooksSpecAuth() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmLibra = new JFrame();
		frmLibra.setResizable(false);
		frmLibra.setTitle("Retrieve books for specific author");
		frmLibra.setBounds(100, 100, 450, 300);
		frmLibra.setDefaultCloseOperation(JFrame.HIDE_ON_CLOSE);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(240, 248, 255));
		FlowLayout flowLayout = (FlowLayout) panel.getLayout();
		flowLayout.setAlignment(FlowLayout.LEFT);
		frmLibra.getContentPane().add(panel, BorderLayout.NORTH);
		
		JLabel lblNewLabel = new JLabel("Enter Author ID");
		panel.add(lblNewLabel);
		
		RetBookISBN = new JTextField();
		panel.add(RetBookISBN);
		RetBookISBN.setColumns(10);
		
		JButton retBookISBNButton = new JButton("Search");
		retBookISBNButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				try {
				Connection 	myConn= DriverManager.getConnection("jdbc:mysql://localhost:3306/LIBRARY","root","");
				String AuthorID = "'" + RetBookISBN.getText() +"'";
				String join = "select * from WRITEE , BOOK WHERE WRITEE.BookISBN = BOOK.ISBN AND AuthorID = " + AuthorID;

				PreparedStatement ps = myConn.prepareStatement(join);

				ResultSet rs = ps.executeQuery();

				System.out.println("Title\tAuthorID");

				int counter=0;
				while (rs.next()) {
					String BookTitle = rs.getString("Title");
					String AuthorId = rs.getString("AuthorID");
					System.out.println(BookTitle + "\t" + AuthorId);
					counter++;}

				RetBookTable model = new RetBookTable(counter,AuthorID);
				table.setModel(model);
				
				myConn.close();
				}catch(Exception E) {
					JOptionPane.showMessageDialog(retBookISBNButton, "Invalid, kindly try again", null, JOptionPane.ERROR_MESSAGE);
}
				
			}
		});
		panel.add(retBookISBNButton);
		
		JScrollPane scrollPane = new JScrollPane();
		frmLibra.getContentPane().add(scrollPane, BorderLayout.CENTER);
		
		table = new JTable();
		scrollPane.setViewportView(table);
	}

}

