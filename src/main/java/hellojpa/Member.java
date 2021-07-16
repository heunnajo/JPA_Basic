package hellojpa;


import javax.persistence.*;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

@Entity//JPA가 로딩될 때 엔티티로 인식한다!
public class Member {

    @Id @GeneratedValue
    @Column(name = "MEMBER_ID")
    private Long id;

    @Column(name="USERNAME")
    private String username;

    @Embedded
    private Address homeAddress;

    @OneToMany(cascade = CascadeType.ALL,orphanRemoval = true)
    @JoinColumn(name="MEMBER_ID")//일대다 단방향.
    private List<AddressEntity> addressHistory = new ArrayList<>();


    //값타입 컬렉션 예시
    @ElementCollection//값 타입 컬렉션
    @CollectionTable(name="FAVORITE_FOOD", joinColumns = @JoinColumn(name="MEMBER_ID"))
    @Column(name="FOOD_NAME")//임베디드 타입인 Address은 필드(컬럼)가 여러개지만 Set<String>은 필드가 하나다.여러개의 String을 저장할 뿐.
    private Set<String> favoriteFoods = new HashSet<>();



    //    @ElementCollection
//    @CollectionTable(name="ADDRESS",joinColumns = @JoinColumn(name="MEMBER_ID"))
//    private List<Address> addressHistory = new ArrayList<>();
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
    public Address getHomeAddress() { return homeAddress; }
    public void setHomeAddress(Address homeAddress) { this.homeAddress = homeAddress; }

    public Set<String> getFavoriteFoods() {
        return favoriteFoods;
    }

    public void setFavoriteFoods(Set<String> favoriteFoods) {
        this.favoriteFoods = favoriteFoods;
    }

    public List<AddressEntity> getAddressHistory() {
        return addressHistory;
    }

    public void setAddressHistory(List<AddressEntity> addressHistory) {
        this.addressHistory = addressHistory;
    }


}
