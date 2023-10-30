package study.todo.querydsl;

import com.querydsl.jpa.impl.JPAQueryFactory;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.annotation.Bean;
import org.springframework.web.bind.annotation.GetMapping;

import javax.persistence.EntityManager;

@SpringBootApplication
public class TodoQuerydslApplication {

	public static void main(String[] args) {
		SpringApplication.run(TodoQuerydslApplication.class, args);
	}

	/*
	//Bean 주입 방식
	@Bean
	JPAQueryFactory jpaQueryFactory(EntityManager em) {
		return new JPAQueryFactory(em);
	}
	*/
}
