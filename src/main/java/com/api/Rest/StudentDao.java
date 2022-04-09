package com.api.Rest;

import java.util.ArrayList;
import java.util.List;

import com.mysql.cj.protocol.Resultset;

import java.sql.*;
public class StudentDao 
{
		
		
		Connection con =null;
		
		public StudentDao()
		{
			String url = "jdbc:mysql://localhost:3306/apidb";
			String username = "root";
			String password = "@!palaskar123";
			try
			{
				Class.forName("com.mysql.cj.jdbc.Driver");
				con=DriverManager.getConnection(url,username,password);
			}
			catch(Exception e)
			{
				System.out.println(e);
			}
		}
		
		public List<Students> getstud() 
		{
			List<Students> student =new ArrayList<Students>();
			String sql = "Select * from student";
			try 
			{
				Statement st =con.createStatement();
				Resultset rs= (Resultset) st.executeQuery(sql);
				while(((ResultSet) rs).next()) 
				{
					Students s = new Students();
					s.setId(((ResultSet) rs).getInt(1));
					s.setName(((ResultSet) rs).getString(2));
					s.setPoints( ((ResultSet) rs).getInt(3));
					student.add(s);
				}
			}
				
			catch (SQLException e) 
			{
				System.out.println(e);
			
			}
			
		
			return student;
		}
		
		public Students getstuds(int id)
		{
			
			String sql = "Select * from student where id ="+id;
			Students s = new Students();
			try 
			{
				Statement st =con.createStatement();
				Resultset rs= (Resultset) st.executeQuery(sql);
				if(((ResultSet) rs).next()) 
				{					
					s.setId(((ResultSet) rs).getInt(1));
					s.setName(((ResultSet) rs).getString(2));
					s.setPoints( ((ResultSet) rs).getInt(3));				
				}
			}
				
			catch (SQLException e) 
			{
				System.out.println(e);			
			}
			return s;
			
		}

		public void create(Students s1) {
			  

			String sql = "insert into student values(?,?,?)";
		
			try 
			{
				PreparedStatement st =(PreparedStatement) con.prepareStatement(sql);
				st.setInt(1,s1.getId());
				st.setString(2,s1.getName());
				st.setInt(3,s1.getPoints());
				st.executeUpdate();
				
			}
				
			catch (SQLException e) 
			{
				System.out.println(e);			
			}
			
		}

		public void updatestudent(int id,Students s1) {
			String sql = "update student set name =? ,points =? where id ="+id;
			
			try 
			{
				PreparedStatement st =(PreparedStatement) con.prepareStatement(sql);
				
				st.setString(1,s1.getName());
				st.setInt(2,s1.getPoints());
				st.executeUpdate();
				
			}
				
			catch (SQLException e) 
			{
				System.out.println(e);			
			}
			
		}

		public void deleteStudent(int id) {
			String sql = "delete from student where id ="+id+"";
			Students s = new Students();
			try 
			{
				Statement st =con.createStatement();
				 st.execute(sql);													
			}
				
			catch (SQLException e) 
			{
				System.out.println(e);			
			}
		
		}

		
		
}
