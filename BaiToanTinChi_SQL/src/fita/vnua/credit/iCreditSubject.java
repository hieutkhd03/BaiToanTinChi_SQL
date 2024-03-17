package fita.vnua.credit;

public interface  iCreditSubject {
	float LEVEL_F = 3.9f;
	float LEVEL_D = 4.9f;
	float LEVEL_DPLUS = 5.4f;
	float LEVEL_C = 6.4f;
	float LEVEL_CPLUS =6.9f;
	float LEVEL_B = 7.4f;
	float LEVEL_BPLUS = 8.4f;
	float LEVEL_A = 10;
	
	float calSubjectMark();
	String calGrade();
	float calConversionMark();
	String getSubjectCode();
	int getCredit();
	void setAttendanceMark(float attendanceMark);
	void setMidExamMark(float practiceMark);
	void setPracticeMark(float midExamMark);
	void setFinalExamMark(float finalExamMark);
	
}
