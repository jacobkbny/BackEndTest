package com.tistory.jacobcloud.controller;

import java.util.List;
import java.util.stream.Collectors;

import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.tistory.jacobcloud.dto.ResponseDTO;
import com.tistory.jacobcloud.dto.TodoDTO;
import com.tistory.jacobcloud.model.TodoEntity;
import com.tistory.jacobcloud.service.TodoService;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

//데이터를 리턴하기 위한 Controller를 만들기 위한 어노테이션
@RestController
//공통된 URL 작성 - Localhost:포트번호/todo/
@RequestMapping("todo")
@RequiredArgsConstructor
public class TodoController {
	private final TodoService todoService;
	
	@PostMapping
	public ResponseEntity<?> createTodo(@RequestBody TodoDTO dto){
		try {
				//회원 정보르를 만들 수 없어서 임시로 아이디를 만듦.
				String temporaryUserId = "temp";
				//DTO를 Entity로 변환
				TodoEntity entity = TodoDTO.toEntity(dto);
				
				entity.setId(null);
				entity.setUserId(temporaryUserId);
				List<TodoEntity> entities = todoService.create(entity);
				//TodoEntity 의 List를 TodoList의 List로 변환
				List<TodoDTO> list = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
				
				ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(list).build();
					
					return ResponseEntity.ok().body(response);
		}catch(Exception e) {
			String error =e.getMessage();
			ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().error(error).build();
			return ResponseEntity.badRequest().body(response);
		}
		
	}
	
	@GetMapping
	
	public ResponseEntity<?> retrieveTodoList(){
		String temporaryUserId = "temp";
		List<TodoEntity> entities = todoService.retrieve(temporaryUserId);
		List<TodoDTO> list = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
		
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(list).build();
			
			return ResponseEntity.ok().body(response);
		
	}
	@PutMapping
	public ResponseEntity<?> update(@RequestBody TodoDTO dto){
		String temporaryUserId = "temp";
			TodoEntity entity =TodoDTO.toEntity(dto);
				entity.setUserId(temporaryUserId);
				
		List<TodoEntity> entities = todoService.update(entity);
			//entity의 list형태를 todoDTO의 list형태로 바꾸기 
			//entities.Stream() 는 List를 Stream으로 변환
			//map은 Stream의 모든 요소를 순서대로 매개변수로 대입된 함수를 적용해서 리턴한 값들을 가지고
			//스트림을 만들어주는 메서드
			//클래스이름 ::메서드 이름의 형태로 대입을 해야하는데 new는 생성자를 이용하곘다는 의미
			// collect는 Stream 을 배열이나 List,Set,Map으로 변환해주는 메서드입니다.
			//map으로 나온 결과를 List로 변환한 것.
		List<TodoDTO> list = entities.stream().map(TodoDTO::new).collect(Collectors.toList());
			//response 객체 생성
		ResponseDTO<TodoDTO> response = ResponseDTO.<TodoDTO>builder().data(list).build();
			
			return ResponseEntity.ok().body(response);
		
	}
	
}
