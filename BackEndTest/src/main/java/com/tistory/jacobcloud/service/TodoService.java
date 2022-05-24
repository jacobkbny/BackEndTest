package com.tistory.jacobcloud.service;

import java.util.List;

import com.tistory.jacobcloud.model.TodoEntity;

public interface TodoService {
		//데이터 삽입
	public List<TodoEntity> create (final TodoEntity entity);
		//데이터 삭제
	public List<TodoEntity> delete (final TodoEntity entity);
		//데이터 추출
	public TodoEntity detail (final String id);
		//userid에 해당하는 데이터 조회
	public List<TodoEntity> retrieve (final String userId);
		//데이터 수정
	public List<TodoEntity> update (final TodoEntity entity);

}
