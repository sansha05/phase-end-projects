package com.application;

import java.io.File;

public class Main {
	public static void main(String []args) {
		FileManager flmanage = new FileManager("/home/sandeepsharma1m/directory");
		
		System.out.println("=========================");
		System.out.println(" Application Name\n build by sandeep sharma");
		System.out.println("=========================");
		
	
		flmanage.listFiles();
		flmanage.searchFile();
		
		
		
	}

}
