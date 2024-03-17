package fita.vnua.credit;

public class OOPSubject extends AbstractSubject implements iCreditSubject {

	private float attendanceMark;
	private float practiceMark;
	private float midExamMark;
	private float finalExamMark;
	
	public OOPSubject(String subjectCode, String subjectName, int credit) {
		super(subjectCode,subjectName,credit);
	}
	
	public float getAttendanceMark() {
		return attendanceMark;
	}

	public void setAttendanceMark(float attendanceMark) {
		this.attendanceMark = attendanceMark;
	}
	
	public float getPracticeMark() {
		return practiceMark;
	}

	public void setPracticeMark(float practiceMark) {
		this.practiceMark = practiceMark;
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
	public float calSubjectMark() {
		return (attendanceMark + practiceMark*2 + midExamMark*2 + finalExamMark*5)/10;
	}
	
	@Override
	public String toString() {
		// TODO Auto-generated method stub
		return super.toString() + "\n" + "Điểm:" +  attendanceMark + "-" + practiceMark + "-" + midExamMark + "-" + finalExamMark + "\n- subject mark: " + calSubjectMark() ;
		
	}
}
