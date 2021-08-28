package com.instagram.controller;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

import com.instagram.dao.InstagramDAOInterface;
import com.instagram.entity.InstagramUser;
import com.instagram.utility.DAOFactory;

public class InstagramController implements InstagramControllerInterface {
	
	private BufferedReader br;
	InstagramDAOInterface id;
	public InstagramController(){
		br=new BufferedReader(new InputStreamReader(System.in));
		id=DAOFactory.myMethod();
	}

	public void createProfile() {
		try {
		System.out.println("enter name");
		String name=br.readLine();
		
		System.out.println("enter password");
		String password=br.readLine();
		
		System.out.println("enter email");
		String email=br.readLine();
		
		System.out.println("enter address");
		String address=br.readLine();
		
		InstagramUser iu=new InstagramUser();
		iu.setName(name);
		iu.setPassword(password);
		iu.setEmail(email);
		iu.setAddress(address);
		
		
		int i=id.createProfileDAO(iu);
		
		if(i>0) {
			System.out.println("profile created successfully");
		}
		else {
			System.out.println("could not create profile");
		}
		}
		catch(IOException e) {
			e.printStackTrace();
		}

	}


	public void editProfile() {
		try {
			System.out.println("enter name");
			String name=br.readLine();
			
			InstagramUser iu=new InstagramUser();
			iu.setName(name);
			
			InstagramUser ii=id.viewProfile(iu);
			if(ii!=null) {
				System.out.println("your name is "+ii.getName());
				System.out.println("your old password is "+ii.getPassword());
				System.out.println("your old email is "+ii.getEmail());
				System.out.println("your old address is "+ii.getAddress());
				
				System.out.println("enter new password");
				String npass=br.readLine();
				System.out.println("enter new email");
				String nemail=br.readLine();
				System.out.println("enter new address");
				String naddress=br.readLine();
				
				InstagramUser iu1=new InstagramUser();
				iu1.setName(name);
				iu1.setPassword(npass);
				iu1.setEmail(nemail);
				iu1.setAddress(naddress);
				
				int i=id.editProfileDAO(iu1);
				if(i>0) {
					System.out.println("profile edited successfully");
				}
				else {
					System.out.println("could not edit profile");
				}
				
			}
			else {
				System.out.println("profile not found");
			}
			
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void deleteProfile() {
		try {
			System.out.println("enter name");
			String name=br.readLine();
			
			InstagramUser iu=new InstagramUser();
			iu.setName(name);
			
			int i=id.deleteProfileDAO(iu);
			if(i>0) {
				System.out.println("profile deleted successfully");
			}
			else {
				System.out.println("could not delete profile");
			}
			
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		
	}

	public void loginProfile() {
		try{
		InstagramUser iu = new InstagramUser();
		System.out.println("Enter the email");
		String email = br.readLine();
		iu.setEmail(email);
		System.out.println("Enter the password");
		String password = br.readLine();
		iu.setPassword(password);
		boolean loginResult = id.loginProfile(iu);
		if (loginResult) {
			System.out.println("login successfully");
		} else {
			System.out.println("provide the correct input");
		}
	}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
		

	public void viewProfile() {
		try {
			System.out.println("enter name");
			String name=br.readLine();
			
			InstagramUser iu=new InstagramUser();
			iu.setName(name);
			
			InstagramUser ii=id.viewProfile(iu);
			if(ii!=null) {
				System.out.println("your name is "+ii.getName());
				System.out.println("your old password is "+ii.getPassword());
				System.out.println("your old email is "+ii.getEmail());
				System.out.println("your old address is "+ii.getAddress());
		
	}

}
		catch(Exception e) {
			e.printStackTrace();
		}
	}
}
