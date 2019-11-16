package jdbc;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.ArrayList;
import java.util.List;
import pojo.Student;
import util.DBConnection;
import util.Date_String;
public class StudentCRUD {
	private static Connection conn = null;
	private static Statement st = null;
	private static ResultSet rs = null;
	PreparedStatement pss=null;
	static PreparedStatement ps=null;
	public static List<Student> getAllStudent(){
			List<Student> students=new ArrayList<Student>();
			try {
				conn = DBConnection.getConnection();
				String sql = "select * from student";
				st = conn.createStatement();
				rs=st.executeQuery(sql);
				while(rs.next()==true){
					String studentid=rs.getString("stuid");
					String name=rs.getString("sname");
					String sex=rs.getString("sex");
					int age=rs.getInt("age");
					String classname=rs.getString("classname");
					String birthday=Date_String.getStringDate1(rs.getDate("birthday"));
					Student tmp=new Student(studentid,name,sex,age,classname,birthday);
					students.add(tmp);
				}
			}
			catch (SQLException e) {
				e.printStackTrace();
			} 
			finally {
				DBConnection.close(rs, st, conn);
			}
			return students;
		}
	public static Student get(String StuID) {
		Student stu = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from student where Stuid='"+StuID+"'";
			st = conn.createStatement();
			rs=st.executeQuery(sql);
//			if(rs.next())
//				System.out.println("鏌ヨ鎴愬姛");
//			else
//				System.out.println("鏌ユ棤姝や汉");
//			rs.previous();
			while(rs.next()) {
				String id=rs.getString("stuid");
				String name=rs.getString("sname");
				String Sex=rs.getString("sex");
				int age=rs.getInt("age");
				String ClassName=rs.getString("classname");
				String birthday=Date_String.getStringDate1(rs.getDate("birthday"));
				stu=new Student(id,name,Sex,age,ClassName,birthday);
				
				//System.out.println("StuID="+id+"  Sname="+name+"  sex="+Sex+"  age="+age+"  ClassName="+ClassName+"  BirthDay="+BirthDay);
			}
		} catch (SQLException e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, st, conn);	
		}
		return stu;
	}
	public static void update(Student stu) {
		try {
			conn = DBConnection.getConnection();
			String sql = "update  student set Sname=?,Sex=?,age=?,ClassName=?,Birthday=? where Stuid="+stu.getStuID();
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getSname());
			ps.setString(2, stu.getSex());
			ps.setInt(3, stu.getAge());
			ps.setString(4, stu.getClassName());
			ps.setTimestamp(5, Date_String.toTimestamp(stu.getBirthDay()));
			int number=ps.executeUpdate();
			if(number>0) 
				System.out.println("成功");
			else
				System.out.println("失败");
			
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("失败");
		} catch (Exception e) {
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, st, conn);
			
		}
		
		
	}
	//
	public static void delete(String StuID) {
		try {
			conn = DBConnection.getConnection();
			String sql = "delete  from student where Stuid='"+StuID+"'";
			st = conn.createStatement();
			int number=st.executeUpdate(sql);
			if(number>0)
				System.out.println("删除成功");
			else
				System.out.println("删除失败");
		} catch (SQLException e) {
			e.printStackTrace();
			System.out.println("shanchushibai");
		} finally {
			DBConnection.close(rs, st, conn);
			
		}
		
	}
	public static void addStudent(Student stu) {
		try {
			conn=DBConnection.getConnection();
			String sql="insert student values(?,?,?,?,?,?)";
			ps = conn.prepareStatement(sql);
			ps.setString(1, stu.getStuID());
			ps.setString(2, stu.getSname());
			ps.setString(3, stu.getSex());
			ps.setInt(4, stu.getAge());
			ps.setString(6, stu.getClassName());
			ps.setTimestamp(5, Date_String.toTimestamp(stu.getBirthDay()));
			int number=ps.executeUpdate();	
			if(number>0)
				System.out.println("成功");
			else
				System.out.println("失败");
		} catch (SQLException e) {
			e.printStackTrace();
		} catch (Exception e) {
			e.printStackTrace();
		}finally {
			DBConnection.close(rs, ps, conn);
		}		
}
	
	//
	public static void add(String StuID,String Sname,String Sex, int age,String ClassName,Timestamp BirthDay) {
			
			try {
				conn=DBConnection.getConnection();
				String sql="insert student values(?,?,?,?,?,?)";
				ps = conn.prepareStatement(sql);
				ps.setString(1, StuID);
				ps.setString(2, Sname);
				ps.setString(3, Sex);
				ps.setInt(4, age);
				ps.setString(6, ClassName);
				ps.setTimestamp(5, BirthDay);
				int number=ps.executeUpdate();	
				if(number>0)
					System.out.println("成功");
				else
					System.out.println("失败");
			} catch (SQLException e) {
				e.printStackTrace();
				System.out.println("");
			}finally {
				DBConnection.close(rs, ps, conn);
			}		
	}
	//
	/*public void addwithtrans() throws SQLException {
		try{
			conn = DBConnection.getConnection();
			conn.setAutoCommit(false);
			
			String sql1 = "insert into user1 values(?,?,?,?,?)";
		    String sql2="insert into student values(?,?,?,?,?,?)";
			
		    ps = conn.prepareStatement(sql1);
		    ps.setString(1,"yh");
		    ps.setString(3, "鐢�");
			ps.setInt(4, 20);
			ps.setString(2, "17");
			ps.setTimestamp(5, new Timestamp(99,07,01,11,11,11,0));
			ps.executeUpdate();
			
			pss = conn.prepareStatement(sql2);
			pss.setString(1, "007");
			pss.setString(2, "yh");
			pss.setString(3, "鐢�");
			pss.setInt(4, 20);
			pss.setString(6, "17");
			pss.setTimestamp(5, new Timestamp(99,07,01,11,11,11,0));
			pss.executeUpdate();
			
			conn.commit();
		}catch(SQLException e){
			e.printStackTrace();
			//鎿嶄綔鍑虹幇寮傚父锛屾挙閿�浜嬪姟  
			conn.rollback();
		}finally{
			conn.setAutoCommit(true);
			DBConnection.close(null, ps, null);
			DBConnection.close(rs, pss, conn);
		}
	}*/
}
