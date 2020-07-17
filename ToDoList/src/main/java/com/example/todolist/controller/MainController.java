package com.example.todolist.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.example.todolist.service.TodoService;
import com.example.todolist.vo.TodolistVO;

@CrossOrigin
@Controller
@RequestMapping("/todo")
public class MainController {
	//컨트롤러 단에서는 값의 유무만 확인, 로직은 impl에서 처리
	@Autowired
	TodoService todoService;
	
	
	@RequestMapping("/test")
	public List<TodolistVO> getList() {
		return todoService.list();
	}
	
	@GetMapping("/list")
	public String index(Model model) {
		
		model.addAttribute("list", todoService.list());
		
		return "index";
	}
	
	@PostMapping("/input")
	public String input (TodolistVO todolistVO) {
		todoService.insert(todolistVO);
		
		return "redirect:/todo/list";
	}
	
	@ResponseBody
	@PostMapping(value="/delete" , produces = "application/json;charset=UTF-8")
	public String delete (@RequestParam(value="array[]") List<Integer> checkList) {
		String retVal = null;
		
		if(checkList.size() == 0) {
			retVal = "Fail";
		}else {
			int result = todoService.deleteTodo(checkList);

			if(result != 0) {
				retVal = "OK";
			} else {
				retVal = "Fail";
			}
		}
		
		return retVal;
	}
	
	@ResponseBody
	@PostMapping(value="/update" , produces = "application/json;charset=UTF-8")
	public String update (TodolistVO todolistVO) {
		String retVal = null;
		
		if(todolistVO == null) {
			retVal = "Fail";
		} else {
			int result = todoService.updateTodo(todolistVO);
			
			if(result != 0) {
				retVal = "OK";
			} else {
				retVal = "Fail";
			}
		}
		
		return retVal;
	}
	
	@ResponseBody
	@PostMapping(value="/updateStatus" , produces = "application/json;charset=UTF-8")
	public String delete (@RequestParam(value="number") int number, @RequestParam(value="status") String status) {
		String retVal = null;
		
		if((Integer)number == null || status == null) {
			retVal = "Fail";
		} else {
			int result = todoService.updateStatus(number, status);

			if(result != 0) {
				retVal = "OK";
			} else {
				retVal = "Fail";
			}
		}
		return retVal;
	}
	
}
