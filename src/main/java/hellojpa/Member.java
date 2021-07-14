package hellojpa;

import javax.persistence.*;
import java.util.Date;

@Entity//JPA가 로딩될 때 엔티티로 인식한다!
//@Table(uniqueConstraints = )
public class Member {

    @Id//PK
    private Long id;
    @Column(name = "name",nullable = false)
    private String username;
    private Integer age;

    //DB에 자바의 enum을 쓰고 싶다면 @Enumerated를 쓰면 된다!
    @Enumerated(EnumType.STRING)
    private RoleType roleType;

    //Date 타입 = 날짜, 시간, 타임스탬프(날짜+시간)
    @Temporal(TemporalType.TIMESTAMP)
    private Date createdDate;
    @Temporal(TemporalType.TIMESTAMP)
    private Date lastModifiedDate;

    @Lob//VARCHAR를 넘어서는 큰 것을 쓰고 싶을 때 사용, String이면 DB에서 clob으로 타입 생성!
    private String description;
    //JPA는 리플렉션해야해서 동적으로 객체 생성해야하기 때문에 기본 생성자 있어야 한다!
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

    public Integer getAge() {
        return age;
    }

    public void setAge(Integer age) {
        this.age = age;
    }

    public RoleType getRoleType() {
        return roleType;
    }

    public void setRoleType(RoleType roleType) {
        this.roleType = roleType;
    }

    public Date getCreatedDate() {
        return createdDate;
    }

    public void setCreatedDate(Date createdDate) {
        this.createdDate = createdDate;
    }

    public Date getLastModifiedDate() {
        return lastModifiedDate;
    }

    public void setLastModifiedDate(Date lastModifiedDate) {
        this.lastModifiedDate = lastModifiedDate;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }
}
