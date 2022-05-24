package com.tistory.jacobcloud.Persistence;

import java.util.List;

import org.springframework.data.jpa.repository.*;

import com.tistory.jacobcloud.model.TodoEntity;
public interface TodoRepository extends JpaRepository<TodoEntity,String> {
	
		public List<TodoEntity> findByUserId(String userid);
	
	
}




