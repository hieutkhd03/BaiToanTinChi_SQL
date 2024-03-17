package fita.vnua.credit;

import java.util.ArrayList;
import java.util.List;

public class Term {
	private String termCode;
	private List<iCreditSubject> subjectList;
	
	public Term(String termCode) {
		this.termCode = termCode;
		subjectList = new ArrayList<iCreditSubject>();
	}
	
	public int getSumOfCredit() {
		int sum = 0;
		for(iCreditSubject sub: subjectList) {
			sum += sub.getCredit();
		}
		return sum;
	}
	
	public void addSubject(iCreditSubject subject) {
		subjectList.add((iCreditSubject) subject);
	}
	
	public void editSubject(iCreditSubject subject) {
		for(iCreditSubject sub: subjectList) {
			if(subject.getSubjectCode().equals(sub.getSubjectCode())) {
				sub = subject;
			}
		}
	}
	
	public boolean removeSubject(String subjectCode) {
		for(iCreditSubject sub: subjectList) {
			if(subjectCode.equals(sub.getSubjectCode())) {
				subjectList.remove(sub);
				return true;
			}
		}
		return false;
	}
	
	public float calTermAverageMark() {
		float tu = 0;
		float mau = 0;
		// Duyet qua danh sach mon hoc
		for(iCreditSubject sub: subjectList) {
			tu = tu + sub.getCredit()*sub.calConversionMark();
			mau += sub.getCredit();
		}
		return tu/mau;
	}

	public String getTermCode() {
		return termCode;
	}

	public void setTermCode(String termCode) {
		this.termCode = termCode;
	}
}
