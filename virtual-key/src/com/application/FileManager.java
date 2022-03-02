package com.application;

import java.io.File;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class FileManager {
	File file;
	
	public FileManager(String path) {
		// TODO Auto-generated constructor stub
		this.file = new File(path);
		this.file.mkdir();
		
		
	}
	
	String []mainOps = {
			"1. List files in ascending order",
			"2. To perform file operation",
			"3. end program",
	};
	// this will display main option
	public void displayMainOps() {
		for(String opt: mainOps) {
			System.out.println(opt);
		}
	}
	
	// this will list all fill present in specified directory
	public void listFiles() {
		System.out.println("\nList of Files:");
		String []fileList = file.list();
		if (fileList.length ==0) {
			System.out.println("directory is empty!");
		} else {
			
			for(int i=0; i<fileList.length; i++) {
				System.out.println(fileList[i]);
			}
		}
		
	}
	
	// method to add file to the directory
	public void addFile() {
		File fl;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file name: ");
		String fileName = sc.nextLine();
		//geting path to the directory and appendig fileName
		fl = new File(file.getPath() + "/" +fileName);
		try {
			if(fl.createNewFile()) {
				System.out.println("file created!");
			} else {
				System.out.println("there is already a file with same name");
			}
		} catch (IOException e) {
			
			System.out.println("exception occure");
		}
	}
	
	// this method deletes the file from directory
	public void deleteFile() {
		File fl;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file name: ");
		String fileName = sc.nextLine();
		fl = new File(file.getPath() + "/" + fileName);
		if(fl.exists()) {
			if(fl.delete()) {
				System.out.println("file is deleted!");
			}
		} else {
			System.out.println("file not found!");
		}
	}
	
	// method to view file
	public void searchFile() {
		File fl;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file to search: ");
		String fileName = sc.nextLine();
		fl = new File(file.getPath() + "/" + fileName);
		if(fl.exists()) {
			System.out.println(fl.getName()+" is present!");
		}
		
	}
	
	

}
