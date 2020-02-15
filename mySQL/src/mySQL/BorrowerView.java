
import java.awt.EventQueue;

import javax.swing.JFrame;
import javax.swing.JPanel;
import javax.swing.JLabel;
import javax.swing.JButton;
import java.awt.event.ActionListener;
import java.awt.event.ActionEvent;
import java.awt.Font;
import javax.swing.border.TitledBorder;
import java.awt.Color;

public class BorrowerView {

	private JFrame frmBorrower;

	/**
	 * Launch the application.
	 */
	public static void NewBorrScreen() {
		EventQueue.invokeLater(new Runnable() {
			public void run() {
				try {
					BorrowerView window = new BorrowerView();
					window.frmBorrower.setVisible(true);
				} catch (Exception e) {
					e.printStackTrace();
				}
			}
		});
	}

	/**
	 * Create the application.
	 */
	public BorrowerView() {
		initialize();
	}

	/**
	 * Initialize the contents of the frame.
	 */
	private void initialize() {
		frmBorrower = new JFrame();
		frmBorrower.getContentPane().setBackground(new Color(240, 248, 255));
		frmBorrower.setResizable(false);
		frmBorrower.setTitle("Borrower ");
		frmBorrower.setBounds(100, 100, 384, 200);
		frmBorrower.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);
		frmBorrower.getContentPane().setLayout(null);
		
		JLabel lblNewLabel = new JLabel("Select an operation");
		lblNewLabel.setFont(new Font("PT Mono", Font.BOLD, 14));
		lblNewLabel.setBounds(16, 24, 190, 16);
		frmBorrower.getContentPane().add(lblNewLabel);
		
		JPanel panel = new JPanel();
		panel.setBackground(new Color(255, 255, 255));
		panel.setBorder(new TitledBorder(null, "Books operations", TitledBorder.LEADING, TitledBorder.TOP, null, null));
		panel.setBounds(6, 52, 320, 109);
		frmBorrower.getContentPane().add(panel);
		panel.setLayout(null);
		
		JButton btnNewButton = new JButton("Retrieve All Borrowed Books");
		btnNewButton.setBounds(6, 63, 259, 29);
		panel.add(btnNewButton);
		
		JButton btnRetrieveBookTitle = new JButton("Retrieve Book title by author name");
		btnRetrieveBookTitle.setBounds(6, 28, 260, 29);
		panel.add(btnRetrieveBookTitle);
		btnRetrieveBookTitle.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				
				retBooksForSpecAuthByName b1= new retBooksForSpecAuthByName();
				b1.retBooksForSpecAuthByNameMeth();
				
			}
		});
		btnNewButton.addActionListener(new ActionListener() {
			public void actionPerformed(ActionEvent e) {
				retAllBorrowedBooks ret1 = new retAllBorrowedBooks();
				ret1.retAllBorrowedBooksMeth();
			}
		});
	}
}

