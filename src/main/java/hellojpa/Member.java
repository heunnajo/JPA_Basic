package hellojpa;


import javax.persistence.*;

@Entity//JPA가 로딩될 때 엔티티로 인식한다!
@TableGenerator(name = "MEMBER_SEQ_GENERATOR",
        table = "MY_SEQUENCES",
        pkColumnValue = "MEMBER_SEQ", initialValue = 1,allocationSize = 50)
public class Member {

    @Id//PK
    @GeneratedValue(strategy = GenerationType.TABLE, generator = "MEMBER_SEQ_GENERATOR")
    private Long id;

    @Column(name="name",nullable = false)
    private String username;

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
