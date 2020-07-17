package com.example.todolist.service;

import java.util.ArrayList;
import java.util.List;


import com.example.todolist.vo.TodolistVO;

public interface TodoService {
	List<TodolistVO> list ();
	
	void insert(TodolistVO todolistVO);
	
	int deleteTodo(List<Integer> checkList);
	
	int updateTodo(TodolistVO todolistVO);
	
	int updateStatus(int number, String status);
}
