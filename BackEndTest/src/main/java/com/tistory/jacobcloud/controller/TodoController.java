package com.tistory.jacobcloud.controller;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.jacobcloud.service.TodoService;

import lombok.RequiredArgsConstructor;

//데이터를 리턴하기 위한 Controller를 만들기 위한 어노테이션
@RestController
//공통된 URL 작성 - Localhost:포트번호/todo/
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;
	
}
