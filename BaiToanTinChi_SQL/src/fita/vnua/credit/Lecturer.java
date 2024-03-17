package fita.vnua.credit;

import java.util.Scanner;

//Lop Giang vien
public class Lecturer extends Human{
	private String password;
	
	public Lecturer() {}
	
	public Lecturer(String code, String password) {
		super(code);
		this.password = password;
	}



	public Lecturer(String code, String fullname, String address) {
		super(code, fullname, address);
	}
	
	/*
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return code + "-" + fullname + "-" + password;
	}*/
	
	@Override
	public void enterInfo(Scanner sc) {
		super.enterInfo(sc);
		System.out.println("Nhap mat khau: ");
		password = sc.nextLine();
	}
}