package study.todo.jpa.repository;

import org.springframework.context.annotation.EnableMBeanExport;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Slice;
import org.springframework.data.jpa.repository.*;
import org.springframework.data.repository.query.Param;
import study.todo.jpa.dto.MemberDto;
import study.todo.jpa.entity.Member;

import javax.persistence.Entity;
import javax.persistence.Lob;
import javax.persistence.LockModeType;
import javax.persistence.QueryHint;
import java.util.Collection;
import java.util.List;
import java.util.Optional;

public interface MemberRepository extends JpaRepository<Member, Long>, MemberCustomRepository {

    /**
     * 메소드 이름으로 쿼리 생성
     * 조건이 많으면 메소드명이 길어질수 있음
     */
    List<Member> findByUsernameAndAgeGreaterThan(String username, int age);

    //By뒤에 아무것도 없으면 전체조회. 있으면 Where로 들어감
    List<Member> findHelloBy();

    //Top숫자가 붙으면 limit조건으로 검색된다.
    List<Member> findTop3HelloBy();

    /**
     * NamedQuery 실무에서는 잘 사용하지 않음.
     */
    @Query(name = "Member.findByUsername")
    List<Member> findByUsername(@Param("username") String username);

    @Query("select m from Member m where m.username = :username and m.age = :age")
    List<Member> findUser(@Param("username") String username, @Param("age") int age);

    @Query("select m.username from Member m")
    List<String> findUsernameList();

    @Query("select new study.todo.jpa.dto.MemberDto(m.id, m.username, t.name) from Member m join m.team t")
    List<MemberDto> findMemberDto();

    @Query("select m from Member m where m.username in :names")
    List<Member> findByNames(@Param("names") Collection<String> name);

    /**
     * 반환값 다양함
     */
    List<Member> findListByUsername(String username);
    Member findMemberByUsername(String username);
    Optional<Member> findOptionalByUsername(String username);

    Page<Member> findByAge(int age, Pageable pageable);

    Slice<Member> findListByAge(int age, Pageable pageable);

    /**
     * count 쿼리도 join 해서 가져옴. 성능이 안좋음
     */
    /*
    @Query(
            value = "select m from Member m left join m.team t",
            countQuery = "select count(m) from Member m"
    )
    Page<Member> findByAge(int age, Pageable pagable);
    */

    @Modifying(clearAutomatically = true)
    @Query("update Member m set m.age = m.age+1 where m.age >= :age")
    int bulkAgePlus(@Param("age") int age);

    /**
     * fetch join을 사용 할 경우 가짜 객체가 아닌 Team 객체를 만들어서 한번에 조회해옴.
     */
    @Query("select m from Member m left join fetch m.team")
    List<Member>findMemberFetchJoin();

    /**
     * 내부적으로는 fetch join을 사용하는거지만 jpa에서는 손 쉽게 사용 가능하도록 EntityGraph를 제공함.
     * @return
     */
    @Override
    @EntityGraph(attributePaths = "team")
    List<Member> findAll();

    //@EntityGraph(attributePaths = "team")
    @EntityGraph("Member.all")
    List<Member> findEnitytyGraphByUsername(@Param("username") String username);

    @QueryHints(value = @QueryHint(name = "org.hibernate.readOnly", value = "true"))
    Member findReadOnlyByUsername(String username);

    //SELECT FOR UPDATE
    @Lock(LockModeType.PESSIMISTIC_WRITE)
    List<Member> findLockByUsername(String username);
}
