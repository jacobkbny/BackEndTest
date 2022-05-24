package com.tistory.jacobcloud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.tistory.jacobcloud.Persistence.TodoRepository;
import com.tistory.jacobcloud.model.TodoEntity;

import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
@Slf4j
@Service
@RequiredArgsConstructor
public class TodoServiceImpl  implements TodoService{

		
		private final TodoRepository todoRepository;
		//유효성 검사 메서드 - 인터페이스에 만들어도 되고 ServiceImpl에 만들어도 되는데 인터페이스에 만들면 publicdmfh
		//만들어야 해서 외부에서 호출할 수 있게 됩니다.
		//외부에서 호출할 수 없도록 할 떄는 ServiceImpl 에서 private 으로 구현하고 외부에서 호출이 가능하도록
		//하고자 한다면 service 인터페이스에 default로 만들면 된다
		private void validate(final TodoEntity entity) {
			if(entity == null) {
				log.warn("Entity is Null");
				throw new RuntimeException("Entity cannot be null");
			}
			if(entity.getUserId() == null) {
				log.warn("Unknown User");
				throw new RuntimeException("Unknown User");
			}
		}	
		
		@Override
		public List<TodoEntity> create(TodoEntity entity) {
				validate(entity);
				todoRepository.save(entity);
			return todoRepository.findByUserId(entity.getUserId());
		}

		@Override
		public List<TodoEntity> delete(TodoEntity entity) {
			validate(entity);
			TodoEntity todo = detail(entity.getId());
			//
			if(todo !=null) {
				todoRepository.delete(entity);
			}
			return todoRepository.findByUserId(entity.getUserId());
		}

		@Override
		public TodoEntity detail(String id) {
				TodoEntity todo = null;
				Optional<TodoEntity> result=todoRepository.findById(id);
				if(result.isPresent()) {
					todo=result.get();
				}
			return todo;
		}

		@Override
		public List<TodoEntity> retrieve(String userId) {
			return todoRepository.findByUserId(userId);
		}

		@Override
		public List<TodoEntity> update(TodoEntity entity) {
			validate(entity);
				TodoEntity todo = detail(entity.getId());
				if(todo !=null) {
					todoRepository.save(entity);
				}
			return todoRepository.findByUserId(entity.getUserId());
		}
	
		
		
	
}
