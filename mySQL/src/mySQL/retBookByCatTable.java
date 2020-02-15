
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.List;

import javax.swing.JOptionPane;
import javax.swing.table.AbstractTableModel;

public class retBookByCatTable extends AbstractTableModel {
    
	private String Category;
	private int RowCount;
	
	private static final int BOOK_ISBN_COL = 0;
	private static final int CATEGORY_COL = 1;

	private static final String[] columnNames = { "BISBN", "Category" };

	public retBookByCatTable(int counter,String category) {
		this.Category = category;
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
			
			String join = "select * from BOOK_CATEGORY , BOOK WHERE BOOK_CATEGORY.BISBN = BOOK.ISBN AND Category = " + Category;
		    PreparedStatement ps = myConn.prepareStatement(join);
		    ResultSet rs = ps.executeQuery();
for(int i = 0; i<=row &&rs.next() ; i++) {
if(i==row) {
		switch (col) {
		case 0:
			return rs.getString("BISBN");
		default:
			return rs.getString("Category");
		}
}

}
}
		catch(Exception E) {
System.out.println("ERROR");
		}
	return new String();}	

	@Override
	public Class getColumnClass(int c) {
		return getValueAt(0, c).getClass();
	}
}
