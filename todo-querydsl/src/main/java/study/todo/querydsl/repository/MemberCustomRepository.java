package study.todo.querydsl.repository;

import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import study.todo.querydsl.dto.MemberSearchCondition;
import study.todo.querydsl.dto.MemberTeamDto;

import java.util.List;

public interface MemberCustomRepository {
    List<MemberTeamDto> search(MemberSearchCondition condition);
    Page<MemberTeamDto> searchPageSimple(MemberSearchCondition condition, Pageable pagable);
    Page<MemberTeamDto> searchPageComplex(MemberSearchCondition condition, Pageable pagable);
}
