package service;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.util.ArrayList;
import java.util.List;

import models.student;

public class studentservice {
	private Connection conn;

	public studentservice(Connection conn) {
		super();
		this.conn = conn;
	}
	public boolean addstudent(student stu) {
		boolean b=false;
		try {
			String sql="insert into stu(name,branch,email,phoneno) values(?,?,?,?)";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, stu.getName());
			pmst.setString(2, stu.getBranch());
			pmst.setString(3, stu.getEmail());
			pmst.setLong(4, stu.getPhoneno());
			int i = pmst.executeUpdate();
			if(i>0) {
				b=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;
		
	}
	public List<student> fetchall(){
		List<student> li = new ArrayList<student>();
		student s = null;
		try {
			String sql = "select * from stu";
			PreparedStatement pmst = conn.prepareStatement(sql);
			ResultSet rs = pmst.executeQuery();
			
			while(rs.next()) {
				s = new student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setBranch(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPhoneno(rs.getLong(5));
				li.add(s);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return li;
	}
	public student getbyid(int id) {
		student s = null;
		try {
			String sql = "select * from stu where id=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, id);
			ResultSet rs = pmst.executeQuery();
			while(rs.next()) {
				s = new student();
				s.setId(rs.getInt(1));
				s.setName(rs.getString(2));
				s.setBranch(rs.getString(3));
				s.setEmail(rs.getString(4));
				s.setPhoneno(rs.getLong(5));		
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return s;
	}
	public boolean deletebyid(int id) {
		boolean f = false;
		try {
			String sql= "delete from stu where id=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setInt(1, id);
			int i = pmst.executeUpdate();
			if(i>0) {
				f = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
	public boolean updatestu(student st) {
		boolean f = false;
		try {
			String sql = "update stu set name=?,branch=?,email=?,phoneno=? where id=?";
			PreparedStatement pmst = conn.prepareStatement(sql);
			pmst.setString(1, st.getName());
			pmst.setString(2, st.getBranch());
			pmst.setString(3, st.getEmail());
			pmst.setLong(4, st.getPhoneno());
			pmst.setInt(5, st.getId());
			int i = pmst.executeUpdate();
			if (i>0) {
				f=true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return f;
	}
}
