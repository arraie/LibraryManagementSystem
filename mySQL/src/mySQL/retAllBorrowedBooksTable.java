
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class retAllBorrowedBooksTable extends AbstractTableModel {
private String borrowerID;
	private int RowCount;
	
	private static final int BOOKISBN_COL = 0;
	private static final int BORROWERID_COL = 1;

	private static final String[] columnNames = { "borrowerID","Name","PhoneNo", "bookISBN", "Title" ,"PublishDate","DateOfBorrowing","DateOfExpireation","NumberOfCopies" };

	public retAllBorrowedBooksTable(int counter,String borrowerID) {
		this.borrowerID = borrowerID;
		RowCount = counter;
		// TODO Auto-generated constructor stub
	}

	@Override
	public int getColumnCount() {
		return columnNames.length;
	}

	@Override
	public int getRowCount() {
		return RowCount;
	}

	@Override
	public String getColumnName(int col) {
		return columnNames[col];
	}

	@Override
	public Object getValueAt(int row, int col) {
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection myConn=DriverManager.getConnection(  
	        "jdbc:mysql://localhost:3306/LIBRARY","root","");
			
		String join = "select * from BORROW,BOOK,BORROWER where bookISBN = bookISBN AND BORROWER.borrowerID = BORROW.borrowerID AND BORROWER.borrowerID = " + borrowerID;
		PreparedStatement ps = myConn.prepareStatement(join);
		ResultSet rs = ps.executeQuery();
for(int i = 0; i<=row &&rs.next() ; i++) {
if(i==row) {
		switch (col) {
		case 0:
			return rs.getString("borrowerID");
		case 1:
			return rs.getString("Name");	
		case 2:
			return rs.getString("PhoneNo");	
		case 3:
			return rs.getString("bookISBN");	
		case 4:
			return rs.getString("Title");	
		case 5:
			return rs.getString("PublishDate");	
		case 6:
			return rs.getString("DateOfBorrowing");	
		case 7:
			return rs.getString("DateOfExpiration");
		case 8:
			return rs.getString("NumberOfCopies");

		}
}

}
}
		catch(Exception E) {
System.out.println("ERROR" + E);
		}
	return new String();}	

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
