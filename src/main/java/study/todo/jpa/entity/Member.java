package study.todo.jpa.entity;

import lombok.*;

import javax.persistence.*;
import java.util.ArrayList;

@Entity
@Getter @Setter
@NoArgsConstructor(access = AccessLevel.PROTECTED)
//연관 관계는 toString (team) 하지 않는게 좋음
@ToString(of = {"id", "username", "age"})
@NamedQuery(
        /**
         * 실무에서 사용하지 않음.
        */
        name="Member.findByUsername",
        query="select m from Member m where m.username = :username"
)
@NamedEntityGraph(name = "Member.all", attributeNodes = @NamedAttributeNode("team"))
public class Member extends JpaBase {

    @Id @GeneratedValue
    @Column(name = "member_id")
    private Long id;
    private String username;
    private int age;

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "team_id")
    private Team team;

    //protected Member() {}

    public Member(String username) {
        this.username = username;
    }

    public Member(String username, int age) {
        this.username = username;
        this.age = age;
    }

    public Member(String username, int age, Team team) {
        this.username = username;
        this.age = age;
        if (team != null) {
            changeTeam(team);
        }
    }

    public void changeTeam(Team team) {
        this.team = team;
        team.getMembers().add(this);
    }
}
