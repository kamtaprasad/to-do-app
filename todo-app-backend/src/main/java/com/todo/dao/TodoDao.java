package com.todo.dao;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import com.todo.model.Todo;

public class TodoDao {
	
	private static final String URL = "jdbc:mysql://localhost:3306/todoapp";
    private static final String USER = "dev";
    private static final String PASSWORD = "Algo@2012";
    
    {
    	try {
			Class.forName("com.mysql.jdbc.Driver");
		} catch (ClassNotFoundException e) {
			e.printStackTrace();
		}
    }
    
    public List<Todo> getAllTodos() {
    	List<Todo> todos = new ArrayList<Todo>();
    	String sql = "SELECT * FROM TODO ORDER BY created_on DESC";
    	
    	try (Connection connection = DriverManager.getConnection(URL, USER, PASSWORD)) {
    		PreparedStatement preparableStatement = connection.prepareStatement(sql);
    		ResultSet resultSet = preparableStatement.executeQuery();
    		
    		while (resultSet.next()) {
    			Todo todo = new Todo();
    			
    			todo.setId(resultSet.getInt("id"));
    			todo.setTitle(resultSet.getString("title"));
    			todo.setCreatedOn(resultSet.getDate("created_on"));
    			todo.setCompleted(resultSet.getBoolean("completed"));
    			todos.add(todo);
    		}
    		
    	} catch (SQLException e) {
			e.printStackTrace();
			throw new RuntimeException("Failed while getting the todos from database", e);
		} 
    	return todos;
    	
    }

}
