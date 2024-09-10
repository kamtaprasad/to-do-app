package com.todo.service;

import java.util.List;

import com.todo.dao.TodoDao;
import com.todo.model.Todo;

public class TodoService {
	
	private TodoDao dao;
	
	public TodoService() {
		this.dao = new TodoDao();
	}
	
	public List<Todo> getAllTodos() {
		return this.dao.getAllTodos();
	}

}
