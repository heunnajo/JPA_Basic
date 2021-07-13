package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//JPA가 로딩될 때 엔티티로 인식한다!
public class Member {
    @Id//JPA에 PK 알려준다!!!
    private Long id;
    private String name;

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
