import java.sql.*;
import java.awt.event.*;
import java.awt.*;
public class DatabaseSecondTask {
	public static void main(String az[]){
		try {
			Class.forName("com.mysql.cj.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost/QA","root","");
			Statement st = con.createStatement();
			ResultSet Rec = st.executeQuery("select * from school");
	
			while	(Rec.next()) {
				System.out.println(Rec.getInt(1) + " " + Rec.getString(2) + " " + Rec.getInt(3));
	
	
}
}
catch (Exception E) {
	System.out.println(E.toString());
}
		
}
}
