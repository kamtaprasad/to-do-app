package com.todo.model;

import java.util.Date;
import java.util.Objects;

public class Todo {
	
	private int id;
	private String title;
	private Date createdOn;
	private boolean completed;
	
	public Todo(int id, String title, Date createdOn, boolean completed) {
		this.id = id;
		this.title = title;
		this.createdOn = createdOn;
		this.completed = completed;
	}
	
	public Todo() {
	
	}

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

	public Date getCreatedOn() {
		return createdOn;
	}

	public void setCreatedOn(Date createdOn) {
		this.createdOn = createdOn;
	}

	public boolean isCompleted() {
		return completed;
	}

	public void setCompleted(boolean completed) {
		this.completed = completed;
	}

	@Override
	public String toString() {
		return "Todo [id=" + id + ", title=" + title + ", createdOn=" + createdOn + ", completed=" + completed + "]";
	}

	@Override
	public int hashCode() {
		return Objects.hash(completed, createdOn, id, title);
	}

	@Override
	public boolean equals(Object obj) {
		if (this == obj)
			return true;
		if (obj == null)
			return false;
		if (getClass() != obj.getClass())
			return false;
		Todo other = (Todo) obj;
		return completed == other.completed && Objects.equals(createdOn, other.createdOn) && id == other.id
				&& Objects.equals(title, other.title);
	}

}
