package com.package1;

public class courses {
	private String CourseName;
	private int TimeDuration;
	private int Price;
	private String certificationavl;
	private int CourseId;
	private String HangleBy;
	
	public int getCourseId() {
		return CourseId;
	}
	public void setCourseId(int courseId) {
		CourseId = courseId;
	}
	public String getHangleBy() {
		return HangleBy;
	}
	public void setHangleBy(String hangleBy) {
		HangleBy = hangleBy;
	}
	public String getCourseName() {
		return CourseName;
	}
	public void setCourseName(String courseName) {
		CourseName = courseName;
	}
	public int getTimeDuration() {
		return TimeDuration;
	}
	public void setTimeDuration(int timeDuration) {
		TimeDuration = timeDuration;
	}
	public int getPrice() {
		return Price;
	}
	public void setPrice(int price) {
		Price = price;
	}
	public String isCertificationavl() {
		return certificationavl;
	}
	public void setCertificationavl(String certificationavl) {
		this.certificationavl = certificationavl;
	}
	
}
