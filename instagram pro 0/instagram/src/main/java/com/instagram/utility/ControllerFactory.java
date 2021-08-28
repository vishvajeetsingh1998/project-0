package com.instagram.utility;

import com.instagram.controller.InstagramController;
import com.instagram.controller.InstagramControllerInterface;

public class ControllerFactory {

	public static InstagramControllerInterface createObject() {
		// TODO Auto-generated method stub
		return new InstagramController();
	}

}
