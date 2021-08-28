package com.instagram.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;

import com.instagram.entity.InstagramUser;

public class InstagramDAO implements InstagramDAOInterface {

	public int createProfileDAO(InstagramUser iu) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram_db","root","vishvajeet");
			
			PreparedStatement ps=con.prepareStatement("insert into instagramuser values(?,?,?,?)");
			ps.setString(1, iu.getName());
			ps.setString(2, iu.getPassword());
			ps.setString(3, iu.getEmail());
			ps.setString(4, iu.getAddress());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public InstagramUser viewProfile(InstagramUser iu1) {
		InstagramUser iu=null;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram_db","root","vishvajeet");
			
			PreparedStatement ps=con.prepareStatement("select * from instagramuser where name=?");
			ps.setString(1, iu1.getName());
						
			ResultSet res=ps.executeQuery();
			if(res.next()) {
				iu=new InstagramUser();
				iu.setName(res.getString(1));
				iu.setPassword(res.getString(2));
				iu.setEmail(res.getString(3));
				iu.setAddress(res.getString(4));
			}
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return iu;
	}

	public int editProfileDAO(InstagramUser iu) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram_db","root","vishvajeet");
			
			PreparedStatement ps=con.prepareStatement("update instagramuser set password=?,email=?,address=? where name=?");
			
			ps.setString(1, iu.getPassword());
			ps.setString(2, iu.getEmail());
			ps.setString(3, iu.getAddress());
			ps.setString(4, iu.getName());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}

	public int deleteProfileDAO(InstagramUser iu) {
		int i=0;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con=DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram_db","root","vishvajeet");
			
			PreparedStatement ps=con.prepareStatement("delete from instagramuser where name=?");
			
			
			ps.setString(1, iu.getName());
			
			i=ps.executeUpdate();
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		return i;
	}
	public boolean loginProfile(InstagramUser iu) {
		boolean b = false;
		try {
			Class.forName("com.mysql.jdbc.Driver");
			Connection con = DriverManager.getConnection("jdbc:mysql://localhost:3306/instagram_db", "root",
					"vishvajeet");
			PreparedStatement ps = con.prepareStatement("Select * from instagramuser where Email=? and password=?");
			ps.setString(1, iu.getEmail());
			ps.setString(2, iu.getPassword());
			ResultSet res = ps.executeQuery();
			if (res.next()) {
				b = true;
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return b;

}
}
