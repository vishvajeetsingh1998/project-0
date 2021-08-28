package com.instagram.view;

import java.io.BufferedReader;
import java.io.InputStreamReader;

import com.instagram.controller.InstagramControllerInterface;
import com.instagram.utility.ControllerFactory;

public class InstagramView {

	public static void main(String[] args) {
		String s="y";
		
		while(s.equals("y")) {
		System.out.println("**************MAIN MENU***************");
		System.out.println("press 1 to create profile");
		System.out.println("press 2 to login profile");
		System.out.println("press 3 to edit profile");
		System.out.println("press 4 to delete profile");
		System.out.println("press 5 to view profile");
		
		try {
			BufferedReader br=new BufferedReader(new InputStreamReader(System.in));
			System.out.println("enter your choice");
			
			int c=Integer.parseInt(br.readLine());
			
			InstagramControllerInterface ic=ControllerFactory.createObject();
			
			switch(c) {
			case 1: ic.createProfile();
				break;
			case 2: ic.loginProfile();
				break;
			case 3: ic.editProfile();
				break;
			case 4: ic.deleteProfile();
			break;
			case 5:ic.viewProfile();
			break;
				default:System.out.println("wrong choice");
			}
			System.out.println("do you want to continue press y/n");
			s=br.readLine();
		
		}
		catch(Exception e) {
			e.printStackTrace();
		}
		}

	}

}
