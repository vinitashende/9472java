package com.demo.manytomany.entity;

import java.util.List;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.ManyToMany;

@Entity
public class Student {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	private int s_id;
	
	private String s_name;
	@ManyToMany(targetEntity = Library.class)
	private List book_issue;
	
	public Student() {
		super();

	}
	public Student( String s_name, List book_issue) {
		super();
		
		this.s_name = s_name;
		this.book_issue = book_issue;
	}
	public int getS_id() {
		return s_id;
	}
	public void setS_id(int s_id) {
		this.s_id = s_id;
	}
	public String getS_name() {
		return s_name;
	}
	public void setS_name(String s_name) {
		this.s_name = s_name;
	}
	public List getBook_issue() {
		return book_issue;
	}
	public void setBook_issue(List book_issue) {
		this.book_issue = book_issue;
	}
	

}
