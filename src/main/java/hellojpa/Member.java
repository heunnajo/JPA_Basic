package hellojpa;

import javax.persistence.Entity;
import javax.persistence.Id;

@Entity//JPA가 로딩될 때 엔티티로 인식한다!
public class Member {
    @Id//JPA에 PK 알려준다!!!
    private Long id;
    private String name;
    private int age;
    private int gogo;
    //JPA는 리플렉션해야해서 동적으로 객체 생성해야하기 때문에 기본 생성자 있어야 한다!
    public Member() {
    }

    public Member(Long id, String name) {
        this.id = id;
        this.name = name;
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
