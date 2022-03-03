package com.application;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
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
		if(this.file.mkdir()) {
			System.out.println("folder created!");
		} else {
			System.out.println("folder already exist!");
		}
		
		
	}
	
	
	// this will list all fill present in specified directory
	public void listFiles() {
		System.out.println("\nList of Files:");
		String []fileList = file.list();
		Arrays.sort(fileList);
		if (fileList.length ==0) {
			System.out.println("directory is empty!");
		} else {
			
			for(int i=0; i<fileList.length; i++) {
				System.out.println(" "+fileList[i]);
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
				System.out.println("\nfile created!\n");
				System.out.println("write content to the file: ");
				
				//taking input and adding to the file
				Scanner scan = new Scanner(System.in);
				String content = sc.nextLine();
				FileWriter wrt = new FileWriter(fl);
				wrt.write(content);
				wrt.close();
				
				
			} else {
				System.out.println("\nthere is already a file with same name\n");
			}
		} catch (IOException e) {
			
			System.out.println("exception occure");
		}
	}
	
	// this method deletes the file from directory
	public void deleteFile() {
		File fl;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file to delete: ");
		String fileName = sc.nextLine();
		fl = new File(file.getPath() + "/" + fileName);
		if(fl.exists()) {
			if(fl.delete()) {
				System.out.println("\nfile is deleted!\n");
			}
		} else {
			System.out.println("\nfile not found!\n");
		}
	}
	
	// method to view file
	public void searchFile() throws IOException {
		File fl;
		Scanner sc = new Scanner(System.in);
		System.out.println("Enter file to search: ");
		String fileName = sc.nextLine();
		fl = new File(file.getPath() + "/" + fileName);
		// checking file exist or not
		if(fl.exists()) {
			System.out.println("\n" + fl.getName()+" is present and its content is:\n");
			
			// reding file
			try {
				Scanner re = new Scanner(fl);
				while(re.hasNextLine()) {
					System.out.println(re.nextLine());
				}
				System.out.println();
			} catch (FileNotFoundException e) {
				// TODO Auto-generated catch block
				System.out.println("Exception occur");
				e.printStackTrace();
			}
			
		} else {
			System.out.println("\nfile not found!\n");
		}
		
	}
	
	

}
