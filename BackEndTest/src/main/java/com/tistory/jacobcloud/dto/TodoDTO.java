package com.tistory.jacobcloud.dto;


import java.time.LocalDateTime;

import com.tistory.jacobcloud.model.TodoEntity;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@NoArgsConstructor
@AllArgsConstructor
public class TodoDTO {
	private String id;
	private String title;
	private boolean done;
	private LocalDateTime regdate;
	private LocalDateTime moddate;
	//TodoEntity를 매개변수로 해서 TodoDTO를 생성하는 생성자
	//final을 붙이면 값을 임의로 변경을 할수 없게 만듦.
	//final을 붙이는 이유는 이 생성자는 TodoEntity를 매개변수로 '만' 받는 생성자
	public TodoDTO(final TodoEntity todo) {
		this.id = todo.getId();
		this.title =todo.getTitle();
		this.done = todo.isDone();
		this.regdate =todo.getRegdate();
		this.moddate = todo.getModdate();
	}
	
		//잠정은 DTO 와 Entity 변환 작업을 Service에서 호출하기 떄문에 자기한데 만들어져 있으면 코드를 읽기가 편함
		public static TodoEntity toEntity(final TodoDTO dto) {
				return TodoEntity.builder().id(dto.getId()).title(dto.getTitle()).done(dto.isDone()).build();
			
		}
	
}

