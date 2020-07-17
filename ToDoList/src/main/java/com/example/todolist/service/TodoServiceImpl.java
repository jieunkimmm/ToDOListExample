package com.example.todolist.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.todolist.mapper.TodoMapper;
import com.example.todolist.vo.TodolistVO;

@Service
public class TodoServiceImpl implements TodoService{

	@Autowired
	private TodoMapper todoMapper;
	

	@Override
	public List<TodolistVO> list() {
		List<TodolistVO> todo = todoMapper.list();
		
		return todo;
	}


	@Override
	public void insert(TodolistVO todolistVO) {

		todoMapper.insert(todolistVO);
	}

	@Override
	public int deleteTodo(List<Integer> checkArray) {
		
		return todoMapper.deleteTodo(checkArray);
	}


	@Override
	public int updateTodo(TodolistVO todolistVO) {
		return todoMapper.updateTodo(todolistVO);
	}


	@Override
	public int updateStatus(int number, String status) {
		int result = 0;
		TodolistVO todolistVO = new TodolistVO();
		
		if(status.equals("미완료")) {
			todolistVO.setStatus("완료");
			todolistVO.setNum(number);
		} else {
			todolistVO.setStatus("미완료");
			todolistVO.setNum(number);
		}
		
		result = todoMapper.updateStatus(todolistVO);
		
		return result;
	}


}
