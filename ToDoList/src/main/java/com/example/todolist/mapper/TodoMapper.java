package com.example.todolist.mapper;

import java.util.List;

import org.apache.ibatis.annotations.Param;

import com.example.todolist.vo.TodolistVO;

public interface TodoMapper {
	List<TodolistVO> list ();
	
	void insert(TodolistVO todolistVO);
	
	int deleteTodo(List<Integer> checkArray);
	
	int updateTodo(TodolistVO todolistVO);
	
	int updateStatus(TodolistVO todolistVO);
}
