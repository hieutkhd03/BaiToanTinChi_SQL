package fita.vnua.credit;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Scanner;

public class Student extends Human {
	private String class_;
	// private List<Subject> subjectList = new ArrayList<Subject>();
	private Map<String, Term> termList = new HashMap<String, Term>();

	public Student() {

	}

	public Student(String code, String fullname, String address, String class_) {
		super(code, fullname, address);
		this.class_ = class_;
	}

	public void addTerm(Term term) {
		termList.put(term.getTermCode(), term);
	}

	public void addSubject(String termCode, iCreditSubject subject) {
		Term term = termList.get(termCode);
		term.addSubject(subject);
	}

	public boolean removeSubject(String termCode, String subjectCode) {
		return termList.get(termCode).removeSubject(subjectCode);
	}

	// Tinh tổng số tín chỉ tích lũy qua các kỳ
	public int getSumOfCredit() {
		int sum = 0;
		// Duyệt qua map
		for (Term term : termList.values()) {
			sum += term.getSumOfCredit();
		}
		return sum;
	}

	// Không được sửa mã môn học
	public void editSubject(String termCode, iCreditSubject subject) {
		termList.get(termCode).editSubject(subject);
	}

	@Override
	public void enterInfo(Scanner sc) {
		// Goi lai phuong thuc nay trong lop cha de nhap ma code va fullname
		super.enterInfo(sc);

		// Nhap them thong tin lớp họchọc
		System.out.print("Nhap lop hoc: ");
		class_ = sc.nextLine();
	}

	@Override
	public String toString() {
		return super.toString() + "-" + class_;
	}

	public String getClass_() {
		return class_;
	}

	public void setClass_(String class_) {
		this.class_ = class_;
	}

	public static void main(String[] args) {
		Student std = new Student("669030", "Nguyen Duc Nam", "Ha Noi", "K66CNTTA");
		// Tạo kỳ 1
		// Tạo một số môn học để add vàovào
		// Tạo kỳ 2
		// Tạo một số môn học để add vào kỳ 2

		// Thêm các kỳ vào cho đối tượng sinh viên
		// In thông tin các kỳ học, môn học trong mỗi kỳ

		// Thử thêm các phương thức xóa môn học, sửa môn học
		/*
		 * Term t1 = new Term("1"); // Tạo một số môn học để add vàovào Subject sj1 =
		 * new Subject("SJ1", "Subject 1", 2); sj1.setAttendanceMark(9);
		 * sj1.setMidExamMark(9); sj1.setFinalExamMark(10);
		 * 
		 * Subject sj2 = new Subject("SJ2", "Subject 2", 3); sj2.setAttendanceMark(9);
		 * sj2.setMidExamMark(8); sj2.setFinalExamMark(10);
		 * 
		 * Subject sj3 = new Subject("SJ3", "Subject 3", 2); sj3.setAttendanceMark(10);
		 * sj3.setMidExamMark(7); sj3.setFinalExamMark(10); t1.addSubject(sj1);
		 * t1.addSubject(sj2); t1.addSubject(sj3);
		 * 
		 * Subject sj3_1 = new Subject("SJ31", "Subject 3.1", 4);
		 * sj3_1.setAttendanceMark(7); sj3_1.setMidExamMark(9);
		 * sj3_1.setFinalExamMark(10);
		 * 
		 * // Tạo kỳ 2 Term t2 = new Term("2"); // Tạo một số môn học để add vàovào
		 * Subject sj4 = new Subject("SJ4", "Subject 4", 2); sj4.setAttendanceMark(7);
		 * sj4.setMidExamMark(6); sj4.setFinalExamMark(10);
		 * 
		 * Subject sj5 = new Subject("SJ5", "Subject 5", 2); sj5.setAttendanceMark(8);
		 * sj5.setMidExamMark(8); sj5.setFinalExamMark(8.5f);
		 * 
		 * Subject sj6 = new Subject("SJ6", "Subject 6", 3); sj6.setAttendanceMark(9);
		 * sj6.setMidExamMark(9); sj6.setFinalExamMark(10); t2.addSubject(sj4);
		 * t2.addSubject(sj5); t2.addSubject(sj6);
		 * 
		 * // Thêm các kỳ vào cho đối tượng sinh viên std.addTerm(t1); std.addTerm(t2);
		 * 
		 * System.out.println(std.getSumOfCredit()); std.removeSubject("2", "SJ5"); //
		 * Xoa môn SJ5 của kỳ 2 System.out.println(std.getSumOfCredit());
		 * std.addSubject("1", sj3_1); // Thêm môn học vào kỳ 1
		 * System.out.println(std.getSumOfCredit());
		 * 
		 * // Sửa một môn thành 5 tín chỉ sj3_1.setCredit(5); std.editSubject("1",
		 * sj3_1); System.out.println(std.getSumOfCredit());
		 * 
		 */
		iCreditSubject JV1 = new JavaSubject("JV1", "Lap trinh Java", 3);
		JV1.setAttendanceMark(9);
		JV1.setMidExamMark(9);
		JV1.setPracticeMark(8);
		JV1.setFinalExamMark(10);
		System.out.println(JV1);

		iCreditSubject OOP1 = new OOPSubject("OOP1", "Lap Trinh Huong Doi Tuong", 4);
		OOP1.setAttendanceMark(9);
		OOP1.setMidExamMark(2);
		OOP1.setPracticeMark(5);
		OOP1.setFinalExamMark(5);
		System.out.println(OOP1);
	}
}
