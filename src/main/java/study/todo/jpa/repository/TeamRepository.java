package study.todo.jpa.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import study.todo.jpa.entity.Team;

import java.util.List;

public interface TeamRepository extends JpaRepository<Team, Long> {
    List<Team> findByName(String name);
}
