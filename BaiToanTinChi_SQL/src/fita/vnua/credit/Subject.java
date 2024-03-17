package fita.vnua.credit;

public class Subject{
	private String subjectCode;
	private String subjectName;
	private int credit;
	private float attendanceMark;
	private float midExamMark;
	private float finalExamMark;
	
	public Subject() {}
	
	public Subject(String subjectCode, String subjectName, int credit) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}
	
	public float calSubjectMark() {
		return (attendanceMark + midExamMark*4 + finalExamMark*5)/10;
	}
	
	public String calGrade() {
		float subjectMark = calSubjectMark();
		String grade = null;
		if(subjectMark<=3.9) {
			grade = "F";
		}else if(subjectMark <= 4.9) {
			grade = "D";
		}else if(subjectMark <= 5.4) {
			grade = "D+";
		}else if(subjectMark <= 6.4) {
			grade = "C";
		}else if(subjectMark <= 6.9) {
			grade = "C+";
		}else if(subjectMark <= 7.4) {
			grade = "B";
		}else if(subjectMark <= 8.4) {
			grade = "B+";
		}else if(subjectMark <= 10) {
			grade = "A";
		}
		
		return grade;
	}
	
	public float calConversionMark() {
		float subjectMark = calSubjectMark();
		float conversionMark = -1;
		
		if(subjectMark <= 3.9) {
			conversionMark = 0;
		}else if(subjectMark <= 4.9) {
			conversionMark = 1;
		}else if(subjectMark <= 5.4) {
			conversionMark = 1.5f;
		}else if(subjectMark <= 6.4) {
			conversionMark = 2;
		}else if(subjectMark <= 6.9) {
			conversionMark = 2.5f;
		}else if(subjectMark <= 7.4) {
			conversionMark = 3;
		}else if(subjectMark <= 8.4) {
			conversionMark = 3.5f;
		}else if(subjectMark <= 10) {
			conversionMark = 4;
		}
		
		return conversionMark;		
	}

	public String getSubjectCode() {
		return subjectCode;
	}

	public void setSubjectCode(String subjectCode) {
		this.subjectCode = subjectCode;
	}

	public String getSubjectName() {
		return subjectName;
	}

	public void setSubjectName(String subjectName) {
		this.subjectName = subjectName;
	}

	public int getCredit() {
		return credit;
	}

	public void setCredit(int credit) {
		this.credit = credit;
	}

	public float getAttendanceMark() {
		return attendanceMark;
	}

	public void setAttendanceMark(float attendanceMark) {
		this.attendanceMark = attendanceMark;
	}

	public float getMidExamMark() {
		return midExamMark;
	}

	public void setMidExamMark(float midExamMark) {
		this.midExamMark = midExamMark;
	}

	public float getFinalExamMark() {
		return finalExamMark;
	}

	public void setFinalExamMark(float finalExamMark) {
		this.finalExamMark = finalExamMark;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return subjectCode + "-" + subjectName + "-" + credit + "-" + attendanceMark + "-" + midExamMark + "-" + finalExamMark 
		+ "\n- subject mark: " + calSubjectMark() + "- conversion mark: " + calConversionMark();
		
	}
	
	public static void main(String[] args) {
		Subject sub1 = new Subject("TH03111", "Lập trình Java", 3);
		//sub1.setSubjectCode("TH03111");
		//sub1.setSubjectName("Lập trình Java");
		//sub1.setCredit(3);
		sub1.setAttendanceMark(9);
		sub1.setMidExamMark(8.5f);
		sub1.setFinalExamMark(6.3f);
		System.out.println(sub1.toString());
		
		
	}
	
}
