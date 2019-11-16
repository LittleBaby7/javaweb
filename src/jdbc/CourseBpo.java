package jdbc;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

import pojo.CourseBean;
import pojo.TeacherBean;
import util.DBConnection;

public class CourseBpo {
	static Connection conn = null;
	static ResultSet rs = null;
	static Statement st = null;
	static PreparedStatement ps = null;

	public static CourseBean getByCname(String name) {
		CourseBean course = null;
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from course where cname ='" + name + "'" ;
			st = conn.createStatement();
			rs = st.executeQuery(sql);
			while (rs.next()) {
				String courseid = rs.getString("courseid");
				String cname = rs.getString("cname");
				Float ccredit = rs.getFloat("ccredit");
				String cpre = rs.getString("cpre");
				course = new CourseBean(courseid, cname, ccredit, cpre);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		} finally {
			DBConnection.close(rs, st, conn);
		}

		return course;
	}
	public static  List<CourseBean> getCoursesByname( String name)throws SQLException{
		if(name==null) name="";
		
		List<CourseBean> courses=new ArrayList<CourseBean>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from course where  cname= '"+name+"'";
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()==true){
				CourseBean course=new CourseBean();
				course.setCourseid(rs.getString("courseid"));
				course.setCname(rs.getString("cname"));
				course.setCcredit(rs.getFloat("ccredit"));
				course.setCpre(rs.getString("cpre"));
				courses.add(course);
			
			}
		} finally {
			DBConnection.close(rs, st, conn);
		}
		return courses;
	}
	public static  List<CourseBean> getCoursesByInfo( String name,String cid)throws SQLException{
		List<CourseBean> courses=new ArrayList<CourseBean>();
		try {
			conn = DBConnection.getConnection();
			String sql = "select * from course where  cname= '"+name+"' or courseid='"+cid+"' ";
			st = conn.createStatement();
			rs=st.executeQuery(sql);
			while(rs.next()==true){
				CourseBean course=new CourseBean();
				course.setCourseid(rs.getString("courseid"));
				course.setCname(rs.getString("cname"));
				course.setCcredit(rs.getFloat("ccredit"));
				course.setCpre(rs.getString("cpre"));
				courses.add(course);
			
			}
		} finally {
			DBConnection.close(rs, st, conn);
		}
		return courses;
	}
}
