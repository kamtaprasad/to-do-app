package com.todo.controller;

import java.io.IOException;
import java.util.List;

import javax.servlet.ServletException;
import javax.servlet.annotation.WebServlet;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

import com.fasterxml.jackson.core.JsonGenerationException;
import com.fasterxml.jackson.databind.JsonMappingException;
import com.fasterxml.jackson.databind.ObjectMapper;
import com.todo.model.Todo;
import com.todo.service.TodoService;

@WebServlet("/api/todos/*")
public class TodoServlet extends HttpServlet {
	
	private TodoService service;
	private ObjectMapper objectMapper;
	
	@Override
	public void init() throws ServletException {
		super.init();
		this.service = new TodoService();
		this.objectMapper = new ObjectMapper();
	}
	
	@Override
	protected void doGet(HttpServletRequest req, HttpServletResponse resp) throws ServletException, IOException {
		List<Todo> todos = this.service.getAllTodos();
		sendJsonResponse(resp, todos);
	}

	private void sendJsonResponse(HttpServletResponse resp, List<Todo> todos) throws JsonGenerationException, JsonMappingException, IOException {
		resp.setContentType("application/json");
        resp.setCharacterEncoding("UTF-8");
        objectMapper.writeValue(resp.getWriter(), todos);		
	}

}
