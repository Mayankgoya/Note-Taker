package com.note.entities;

import java.util.*;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;



@Entity
public class Note
{
	@Id
	private int id;
	private String title;
	@Column(length=1500)
	private String context;
	private Date addDate;
	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	public String getContext() {
		return context;
	}
	public void setContent(String context) {
		this.context = context;
	}
	public Date getAddDate() {
		return addDate;
	}
	public void setAddDate(Date addDate) {
		this.addDate = addDate;
	}
	public Note(String title, String content, Date addDate) {
		super();
		this.id = new Random().nextInt(1000);
		this.title = title;
		this.context = content;
		this.addDate = addDate;
	}
	public Note() {
		super();
		// TODO Auto-generated constructor stub
	}
	
	
}
