package com.addressbook;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.util.Scanner;

public class AddressBook {
	BookList bookList = new BookList();

	void addContact(File file) throws IOException {
		Contact contact = new Contact();
		contact.addContact();
		String contactDetails = contact.toString();
		Scanner sc = new Scanner(file);
		StringBuffer sb = new StringBuffer();
		BufferedWriter bw = new BufferedWriter(new FileWriter(file));
		while(sc.hasNext()) {
			System.out.println(1);
			sb.append(sc.nextLine());
			sb.append("\n");
		}
		boolean duplicateContact = bookList.duplicateContact(file, contact.firstName);
		if (duplicateContact == true) {
			System.out.println("It is a duplicate contact.");
			bw.close();
			return;
		} else {
			sb.append(contactDetails+"\n");
			bw.write(sb.toString());
			bw.flush();
			bw.close();
			System.out.println("Contact added successfully");
		}

	}

	void deletePerson(String name, String bookName) throws IOException {
		File file = new File("C:\\Users\\SR COMPUTER\\Documents\\BridzeLabs\\RFP\\Day22AddressBook\\src\\com\\bridgelabz\\"+ bookName + ".txt");
		bookList.deleteContact(file, name);
	}

	void editPerson(String name, String bookName) throws IOException {
		File file = new File("C:\\Users\\SR COMPUTER\\Documents\\BridzeLabs\\RFP\\Day22AddressBook\\src\\com\\bridgelabz\\"+ bookName + ".txt");
		bookList.updateContact(file, bookName);
	}
	boolean viewSortedResult(int option, String bookName) throws IOException {
		File file = new File("C:\\Users\\SR COMPUTER\\Documents\\BridzeLabs\\RFP\\Day22AddressBook\\src\\com\\bridgelabz\\"+ bookName + ".txt");
		return bookList.viewSortedResult(file, option);
	}
	public static void main(String[] args) throws IOException {
		BookList shelf = new BookList();
		System.out.println("Welcome to Address Book Program ");
		while (true) {
			AddressBook addressBook = new AddressBook();
			Scanner scan3 = new Scanner(System.in);
			System.out.println("Enter the name of Book you want to  access or add  or type 'city' to search persons by city or type 'state' to search by state or press 'q' to quit");
			String bookName = scan3.nextLine();
			if (bookName.equals("q")) {
				System.out.println("The program is closed");
				break;
			} else if (bookName.equals("city")) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter the name of city  :");
				String placeName = scan.nextLine();
				shelf.showPersonsByCity(placeName);
				continue;
			} else if (bookName.equals("state")) {
				Scanner scan = new Scanner(System.in);
				System.out.println("Enter the name of state  :");
				String placeName = scan.nextLine();
				shelf.showPersonsByState(placeName);
				continue;
			}
			int result = shelf.checkBook(bookName);
			int condition = 0;
			File file = new File("C:\\Users\\SR COMPUTER\\Documents\\BridzeLabs\\RFP\\Day22AddressBook\\src\\com\\bridgelabz\\"+ bookName + ".txt");
			while (true) {
				if (result == 1) {
					break;
				}
				System.out.println("Do you want to add/edit/delete/  the contacts (0/1/2) :Press 3 to Go back to main menu : Press 4 to sort contact");
				Scanner scan = new Scanner(System.in);
				int input = scan.nextInt();
				if (input == 0) {
					addressBook.addContact(file);
				} else if (input == 1) {
					Scanner scan1 = new Scanner(System.in);
					System.out.println("Enter the first name of person you want to edit ");
					String name = scan1.nextLine();
					addressBook.editPerson(name, bookName);

				} else if (input == 2) {
					Scanner scan2 = new Scanner(System.in);
					System.out.println("Enter the first name of the person you want to delete : ");
					String name = scan2.nextLine();
					addressBook.deletePerson(name, bookName);
				}
				else if (input == 3) {
					break;
				} else if (input == 4) {
					Scanner scan4 = new Scanner(System.in);
					boolean value = true;
						System.out.println(
								"Press \n 0 to sort by contact name \n 1 to sort by city \n 2 to sort by state \n 3 to sort by zip");
						int response = scan4.nextInt();
						value = addressBook.viewSortedResult(response, bookName);
					} 
			else {
					System.out.println("Enter the valid command");
				}
			}
		}
	}
}