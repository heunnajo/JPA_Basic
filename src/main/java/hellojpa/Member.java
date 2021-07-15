package hellojpa;


import javax.persistence.*;

@Entity//JPA가 로딩될 때 엔티티로 인식한다!
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @ManyToOne
    @JoinColumn(name="TEAM_ID")//Member와 연관관계를 갖는 것 TEAM_ID(조인하는 칼럼이름)
    private Team team;//회원 여러명이 팀 하나에 들어가기 때문에 회원 : 팀 = ManyToOne

    @OneToOne
    @JoinColumn(name = "LOCKER_ID")
    private Locker locker;

//    public void changeTeam(Team team) {
//        this.team = team;//팀을 셋팅하고
//        team.getMembers().add(this);//현재 회원을 팀 members에도 추가!
//    }


    public void setTeam(Team team) {
        this.team = team;
    }

    public Team getTeam() {
        return team;
    }

    public Member() {
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

}
