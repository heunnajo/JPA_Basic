package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Team {
    @Id @GeneratedValue
    @Column(name = "TEAM_ID")
    private Long id;
    private String name;
    @OneToMany(mappedBy = "team")//현재 뭐랑 연결되있는지를 적어준다!Member 내에서 team이라는 필드!
    private List<Member> members = new ArrayList<>();//관례 : 이렇게 배열리스트 넣어주면 nullpointer안 뜸

    public List<Member> getMembers() {
        return members;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }
}
