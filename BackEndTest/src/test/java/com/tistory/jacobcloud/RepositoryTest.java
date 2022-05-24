package com.tistory.jacobcloud;

import java.util.List;
import java.util.Optional;

import org.hibernate.internal.build.AllowSysOut;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import com.tistory.jacobcloud.Persistence.TodoRepository;
import com.tistory.jacobcloud.model.TodoEntity;

@SpringBootTest
public class RepositoryTest {
	@Autowired
	private TodoRepository todoRepository;
	
//	@Test
	public void TestInsert() {
		TodoEntity todo = TodoEntity.builder().userId("pkb").title("test").build();
			todoRepository.save(todo);
		
	}
//	@Test
	public void Testupdate() {
		TodoEntity todo = TodoEntity.builder().id("40288a1e80f442cf0180f442db7d0000").userId("pkb").title("updated").build();
		todoRepository.save(todo);
		
	}
	
//	@Test
	public void TestDetail() {
		//기본키를 가지고 데이터를 조회
		
		Optional<TodoEntity> result = todoRepository.findById("111");
		
		if(result.isPresent()) {
			
			System.out.println("result---"+result.get());
		}else {
			System.out.println("데이터가 존재하지 않습니다.");
		}
		
	}
		@Test
	public void TestList() {
		//기본키를 가지고 데이터를 조회
		
		List<TodoEntity> result = todoRepository.findByUserId("pkb");
		
		if(result.size()>0) {
				for(TodoEntity todo:result) {
					System.out.println(todo);
				}
		}else {
			System.out.println("데이터가 존재하지 않습니다.");
		}
		
	}
	
	//삭제는 기본키를 가지고 지우는 것 과 Entity를 이용해서 지우는 2가지를 제공
//		@Test
		public void testDelete() {
			
			todoRepository.deleteById("40288a1e80f442cf0180f442db7d0000");
		}
		
}
