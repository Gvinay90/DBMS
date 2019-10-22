import java.sql.*;
import java.util.*;
public class sqlcon {
	Scanner obj=new Scanner(System.in);
	void Fetchdata()
	{
		try{  
		    Class.forName("com.mysql.jdbc.Driver");  
		    Connection con=DriverManager.getConnection(  
		    "jdbc:mysql://localhost:3306/info","vinay","vinay");
		    Statement stmt=con.createStatement();  
		    ResultSet rs=stmt.executeQuery("select * from info");  
		    while(rs.next())  
		    System.out.println(rs.getInt(1)+"  "+rs.getString(2));  
		    con.close();  
		    }catch(Exception e){ System.out.println(e);}  
	}
	void Insertdata()
	{
	int roll;
	int marks;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","vinay","vinay");
			System.out.println("Enter Rollno");
			roll=obj.nextInt();
			System.out.println("Enter Marks");
			marks=obj.nextInt();
			PreparedStatement stmt=con.prepareStatement("insert into info values(?,?)");
			stmt.setInt(1,roll);
			stmt.setInt(2,marks);
			int i=stmt.executeUpdate();
			System.out.println(i+" Record Inserted");
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	void Updatetable()
	{
		int roll;
		int marks;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","vinay","vinay");
			System.out.println("Enter Rollno");
			roll=obj.nextInt();
			System.out.println("Enter Marks");
			marks=obj.nextInt();
			PreparedStatement stmt=con.prepareStatement("update info set marks=? where roll=?");
			stmt.setInt(1,marks);
			stmt.setInt(2,roll);
			int i=stmt.executeUpdate();
			System.out.println(i+" Record Inserted");
			con.close();
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	void deletedata()
	{
		int roll;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/info","vinay","vinay");
			System.out.println("Enter Roll No");
			roll=obj.nextInt();
			PreparedStatement stmt=con.prepareStatement("delete from info where roll=?");
			stmt.setInt(1,roll);
			int i=stmt.executeUpdate();
			System.out.println(i+" Record Deleted");
		}catch(Exception e) {
			System.out.println(e);
		}
	}
	public static void main(String arg[]) {
		int ch;
		int m=1;
		Scanner n=new Scanner(System.in);
		sqlcon s=new sqlcon();
		while(m==1)
		{
			System.out.println("Enter Your Choice");
			System.out.println("1.Show data\n2.Insert Record\n3.Update Record\n4.Delete Record\n5.Exit");
			ch=n.nextInt();
			switch(ch)
			{
			case 1:
				s.Fetchdata();
				break;
			case 2:
				s.Insertdata();
				break;
			case 3:
				s.Updatetable();
				break;
			case 4:
				s.deletedata();
				break;
			case 5:
				m=0;
				break;
			}
		}
	}
}
