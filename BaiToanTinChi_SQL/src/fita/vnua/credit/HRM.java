package fita.vnua.credit;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;

public class HRM {
	private List<Human> hrList;
	
	public HRM() {
		hrList = new ArrayList<Human>();
	}
	
	public void addHR(Human human) {
		hrList.add(human);
		}
	
	public void addHR(Scanner sc) {
		int loai;
		System.out.println("Chon loai nha su (sv: 0,gv: 1): ");
		loai = sc.nextInt(); sc.nextLine();
		
		Human human = null;
		if(loai == 0) {
			human = new Human();
		}else if(loai == 1) {
			human = new Lecturer();
		}
		
		human.enterInfo(sc);
		
		addHR(human);
		
	}
	
	public void printHRList() {
		for(Human human: hrList) {
			System.out.println(human.toString());
		}
	}
	
	public void initDemoData() {
		Human h1 = new Student("6667537", "Duong Minh Hieu", "K66CNTTA","Hai Duong");
		Human h2 = new Lecturer("cnp09", "Tran Trung Hieu", "Hung Yen");
		
		addHR(h1);
		addHR(h2);
	}
	
	public void initDemoData(Scanner sc) {
		String chon;
		do {
			//Nhap thong tin nhan su
			addHR(sc);
			
			//Hoi muon tiep tuc khong
			System.out.println("Ban co muon tiep tuc nhap (c/k): ");
			chon = sc.nextLine();
		}while ("c".equalsIgnoreCase(chon));
	}
	
	public List<Human> searchHuman(String code){
		List<Human> humanList = new ArrayList<Human>();
		for(Human human: hrList) {
			if(human.code.contains(code)) {
				humanList.add(human);
			}
		}
		
		return humanList;
	}
	
	public static void main(String[] args) {
		HRM hrm = new HRM();
		hrm.initDemoData();
		hrm.printHRList();
		hrm.searchHuman("cnp");
	}
}


