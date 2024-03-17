package fita.vnua.credit;

public abstract class AbstractSubject {
	private String subjectCode;
	private String subjectName;
	private int credit;
	
	public abstract float calSubjectMark();
	
	public AbstractSubject(String subjectCode, String subjectName, int credit) {
		this.subjectCode = subjectCode;
		this.subjectName = subjectName;
		this.credit = credit;
	}

	public String calGrade() {
		float subjectMark = calSubjectMark();
		String grade = null;
		if(subjectMark<=iCreditSubject.LEVEL_F) {
			grade = "F";
		}else if(subjectMark <= iCreditSubject.LEVEL_D) {
			grade = "D";
		}else if(subjectMark <= iCreditSubject.LEVEL_DPLUS) {
			grade = "D+";
		}else if(subjectMark <= iCreditSubject.LEVEL_C) {
			grade = "C";
		}else if(subjectMark <= iCreditSubject.LEVEL_CPLUS) {
			grade = "C+";
		}else if(subjectMark <= iCreditSubject.LEVEL_B) {
			grade = "B";
		}else if(subjectMark <= iCreditSubject.LEVEL_BPLUS) {
			grade = "B+";
		}else if(subjectMark <= iCreditSubject.LEVEL_A) {
			grade = "A";
		}
		return grade;
	}
	
	public float calConversionMark() {
		float subjectMark = calSubjectMark();
		float conversionMark = -1;
		
		if(subjectMark <= iCreditSubject.LEVEL_F) {
			conversionMark = 0;
		}else if(subjectMark <= iCreditSubject.LEVEL_D) {
			conversionMark = 1;
		}else if(subjectMark <= iCreditSubject.LEVEL_DPLUS) {
			conversionMark = 1.5f;
		}else if(subjectMark <= iCreditSubject.LEVEL_C) {
			conversionMark = 2;
		}else if(subjectMark <= iCreditSubject.LEVEL_CPLUS) {
			conversionMark = 2.5f;
		}else if(subjectMark <= iCreditSubject.LEVEL_B) {
			conversionMark = 3;
		}else if(subjectMark <= iCreditSubject.LEVEL_BPLUS) {
			conversionMark = 3.5f;
		}else if(subjectMark <= iCreditSubject.LEVEL_A) {
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

	@Override
	public String toString() {
		return subjectCode + "-" + subjectName + "-" + credit ;
	}
}
