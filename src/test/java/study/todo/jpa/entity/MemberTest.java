package study.todo.jpa.entity;

import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.annotation.Rollback;
import org.springframework.transaction.annotation.Transactional;
import study.todo.jpa.repository.MemberRepository;
import study.todo.jpa.repository.TeamRepository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest
@Transactional
@Rollback(value = false)
class MemberTest {

    @PersistenceContext
    EntityManager em;

    @Autowired
    MemberRepository memberRepository;

    @Autowired
    TeamRepository teamRepository;

    @Test
    public void testEntity() {
        Team teamA = new Team("teamA");
        Team teamB = new Team("teamB");
        em.persist(teamA);
        em.persist(teamB);

        Member member1 = new Member("member1", 10, teamA);
        Member member2 = new Member("member2", 20, teamA);
        Member member3 = new Member("member3", 30, teamB);
        Member member4 = new Member("member4", 40, teamB);
        em.persist(member1);
        em.persist(member2);
        em.persist(member3);
        em.persist(member4);

        em.flush();
        em.clear();

        List<Member> members = em.createQuery("select m from Member m", Member.class).getResultList();

        for (Member member : members) {
            System.out.println("member = " + member);
            System.out.println("member.team = " + member.getTeam());
        }
    }

    @Test
    public void EventJpaBaseEntity() throws Exception {
        Member member = new Member("member1");
        memberRepository.save(member);

        Thread.sleep(100);
        member.setUsername("member2");
        
        em.flush();
        em.clear();

        Member member1 = memberRepository.findById(member.getId()).get();
        System.out.println("member1.getCreateDate() = " + member1.getCreateDate());
        System.out.println("member1.getUpdateDate() = " + member1.getUpdateDate());
    }

    @Test
    public void EventBaseEntity() throws InterruptedException {
        Team team = new Team("teamA");
        teamRepository.save(team);

        Thread.sleep(1000);
        team.setName("teamB");

        em.flush();
        em.clear();

        List<Team> team1 = teamRepository.findByName(team.getName());
        System.out.println("team1.get(0).getCreateDateTime() = " + team1.get(0).getCreateDateTime());
        System.out.println("team1.get(0).getLastModifiedDate() = " + team1.get(0).getLastModifiedDate());
        System.out.println("team1.get(0) = " + team1.get(0).getCreateBy());
        System.out.println("team1.get(0) = " + team1.get(0).getLastModifiedBy());
    }
}