package com.application;

import java.io.File;
import java.io.IOException;
import java.util.Scanner;

public class Main {
	public static void main(String []args) {
		
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		System.out.println(" File Manager Application");
		System.out.println("===========================");
		System.out.println("Developed by Sandeep Sharma");
		
		System.out.println("*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*-*");
		
		Scanner sc = new Scanner(System.in);
		
		System.out.print("Enter the name of folder to create: ");
		String folderName = sc.nextLine();
		FileManager flmanage = new FileManager("/home/sandeepsharma1m/" + folderName);
		

//		flmanage.listFiles();
//		flmanage.searchFile();
		
		
		int option;
		int subOption;
		
		
		do {
			Main.displayMainOpt();
			option = sc.nextInt();
			
			switch(option) {
			case 1:
				flmanage.listFiles();
				break;
					
			case 2:
				do {
					Main.displaySubOpt();
					subOption = sc.nextInt();
						
					switch(subOption) {
					case 1:
						flmanage.addFile();
						break;
					case 2:
						flmanage.deleteFile();
						break;
					case 3:
						try {
							flmanage.searchFile();
						} catch (IOException e) {
							// TODO Auto-generated catch block
							e.printStackTrace();
						}
						break;
					case 4:
						break;
					}
				} while(subOption!=4);
					
				break;
					
			case 3: 
				break;
				
			
			}

		} while(option !=3);
		
	}
		

	
	
	// this will display mainmenu option
	public static void displayMainOpt() {
		String []mainOps = {
				"1. List files in ascending order",
				"2. To perform file operation",
				"3. end program",
		};
		System.out.println("\nSelect any one option:-");
		System.out.println("----------------------");
		for(String opt: mainOps) {
			System.out.println(" "+opt);
		}
		System.out.println("\nEnter your option: ");
	}
	
	// sub section menu
	public static void displaySubOpt() {
		String []subopt = {
				"1. Add file",
				"2. Delete file",
				"3. Search file",
				"4. Back to main menu",
		};
		System.out.println("select any option:-");
		System.out.println("------------------");
		for(int i=0; i<subopt.length; i++) {
			System.out.println(" "+subopt[i]);
			
		}
		System.out.println("\nEnter any option: ");
	}

}
