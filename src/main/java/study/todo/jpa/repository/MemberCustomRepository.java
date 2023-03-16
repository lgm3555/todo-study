package study.todo.jpa.repository;

import study.todo.jpa.entity.Member;

import java.util.List;

public interface MemberCustomRepository {
    List<Member> findMemberCustom();
}
