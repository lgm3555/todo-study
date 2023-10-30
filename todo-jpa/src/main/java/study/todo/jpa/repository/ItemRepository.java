package study.todo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.todo.jpa.entity.Item;

public interface ItemRepository extends JpaRepository<Item, Long> {
}
