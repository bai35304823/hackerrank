package com.demo.spring.Application.model;

import javax.persistence.*;

import lombok.Getter;
import lombok.Setter;

@Entity
@Getter 
@Setter 
@Table(name = "course", schema = "vlsdb")
public class Course {
 
	 @Id
	 @GeneratedValue(strategy = GenerationType.IDENTITY)
	 private Integer courseId;
	 private String courseName;
	 private String authorName;
	 private int durationHours;
	 private boolean availability;
	
	public Integer getCourseId() {
		return courseId;
	}
	public void setCourseId(Integer courseId) {
		this.courseId = courseId;
	}
	public String getCourseName() {
		return courseName;
	}
	public void setCourseName(String courseName) {
		this.courseName = courseName;
	}
	public String getAuthorName() {
		return authorName;
	}
	public void setAuthorName(String authorName) {
		this.authorName = authorName;
	}
	public int getDurationHours() {
		return durationHours;
	}
	public void setDurationHours(int durationHours) {
		this.durationHours = durationHours;
	}
	public boolean isAvailability() {
		return availability;
	}
	public void setAvailability(boolean availability) {
		this.availability = availability;
	}
	@Override
	public String toString() {
		return "Course [courseId=" + courseId + ", courseName=" + courseName + ", authorName=" + authorName
				+ ", durationHours=" + durationHours + ", availability=" + availability + "]";
	}

  
	
}
