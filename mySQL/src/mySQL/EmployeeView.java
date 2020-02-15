
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import javax.swing.JLabel;
import javax.swing.JPanel;
import java.awt.Font;
import java.awt.Color;
import java.awt.SystemColor;
import javax.swing.border.BevelBorder;
import javax.swing.border.TitledBorder;

public class EmployeeView {

	private JFrame frmEmployee;

	/**
	 * Launch the application.
	 */
	public static void NewEmpScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					EmployeeView window = new EmployeeView();
					window.frmEmployee.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public EmployeeView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmEmployee = new JFrame();
		frmEmployee.getContentPane().setBackground(new Color(240, 248, 255));
		frmEmployee.setResizable(false);
		frmEmployee.setTitle("Employee");
		frmEmployee.setBounds(100, 100, 514, 308);
		frmEmployee.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmEmployee.getContentPane().setLayout(null);
		
		JPanel panel = new JPanel();
		panel.setBorder(new TitledBorder(null, "Book operations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBackground(new Color(255, 255, 255));
		panel.setToolTipText("Book operations");
		panel.setBounds(6, 60, 253, 202);
		frmEmployee.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Retrieve title");
		btnNewButton.setBounds(6, 60, 117, 29);
		panel.add(btnNewButton);
		
		JButton btnNewButton_1 = new JButton("Insert book");
		btnNewButton_1.setBounds(6, 30, 117, 29);
		panel.add(btnNewButton_1);
		
		JButton btnNewButton_2 = new JButton("Delete book");
		btnNewButton_2.setBounds(6, 90, 117, 29);
		panel.add(btnNewButton_2);
		btnNewButton_2.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteBook dBook = new deleteBook();
				dBook.deleteBookMeth();
				
				
			}
		});
		btnNewButton_2.setToolTipText("");
		
		JButton btnNewButton_3 = new JButton("Update No of copies");
		btnNewButton_3.setBounds(6, 162, 190, 29);
		panel.add(btnNewButton_3);
		
		JButton btnNewButton_6 = new JButton("Retrieve book by category");
		btnNewButton_6.setBounds(6, 131, 190, 29);
		panel.add(btnNewButton_6);
		btnNewButton_6.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
		    retBookByCat retByCat = new retBookByCat();
		    retByCat.retBookByCat();	
				
			}
		});
		btnNewButton_3.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				updateNoOfCop uNo = new updateNoOfCop();
				uNo.updateNoOfCopMet();
			}
		});
		btnNewButton_1.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertBook b1 = new insertBook();
                b1.insertbook();
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				retAllBooksSpecAuth retFrame = new retAllBooksSpecAuth();
				retFrame.retriveAllBooksAut();
				
			}
		});
		
		JLabel lblNewLabel = new JLabel("Select an operation");
		lblNewLabel.setFont(new Font("PT Mono", Font.BOLD, 15));
		lblNewLabel.setBounds(18, 19, 198, 29);
		frmEmployee.getContentPane().add(lblNewLabel);
		
		JPanel panel_1 = new JPanel();
		panel_1.setBorder(new TitledBorder(null, "Borrower operations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_1.setForeground(SystemColor.activeCaptionText);
		panel_1.setBackground(new Color(255, 255, 255));
		panel_1.setBounds(265, 60, 198, 102);
		frmEmployee.getContentPane().add(panel_1);
		panel_1.setLayout(null);
		
		JButton btnNewButton_4 = new JButton("Insert borrower");
		btnNewButton_4.setBounds(6, 29, 134, 29);
		panel_1.add(btnNewButton_4);
		
		JButton btnNewButton_5 = new JButton("Delete borrower");
		btnNewButton_5.setBounds(6, 59, 134, 29);
		panel_1.add(btnNewButton_5);
		
		JPanel panel_2 = new JPanel();
		panel_2.setBorder(new TitledBorder(null, "Author operations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel_2.setBackground(new Color(255, 255, 255));
		panel_2.setBounds(265, 171, 198, 91);
		frmEmployee.getContentPane().add(panel_2);
		panel_2.setLayout(null);
		
		JButton btnNewButton_7 = new JButton("Insert Author");
		btnNewButton_7.setBounds(6, 35, 134, 29);
		panel_2.add(btnNewButton_7);
		btnNewButton_7.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertAuthor auth = new insertAuthor();
				auth.insertAuthorMeth();
			}
		});
		btnNewButton_5.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				deleteBorrower dBorr = new deleteBorrower();
				dBorr.deleteBorrowerMeth();
			}
		});
		btnNewButton_4.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				insertBorrower bor = new insertBorrower();
				bor.insertBorrowerMethod();
				
			}
		});
	}
}

