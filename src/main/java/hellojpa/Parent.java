package hellojpa;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;

@Entity
public class Parent {

    @Id
    @GeneratedValue
    @Column(name="parent_id")
    private Long id;

    private String name;

    @OneToMany(mappedBy = "INNER_JOIN",cascade = CascadeType.ALL, orphanRemoval = true)//parent가 child를 관리하고 있지만 컬렉션에 빠지만 ?
    private List<Child> children = new ArrayList<>();

    public void addChild(Child child){
        children.add(child);
        child.setParent(this);
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

    public List<Child> getChildren() {
        return children;
    }

    public void setChildren(List<Child> children) {
        this.children = children;
    }
}
