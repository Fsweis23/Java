package com.firas.devdemo;

import com.firas.devdemo.models.BackEndDeveloper;
import com.firas.devdemo.models.Developer;

public class DevDemoApplication {

	public static void main(String[] args) {
		BackEndDeveloper backEndDev1 = new BackEndDeveloper();
		backEndDev1.giveMoreSleep(0.25);
		backEndDev1.displayStatus();
		
		System.out.println(Developer.getDevCount());
	}

}
