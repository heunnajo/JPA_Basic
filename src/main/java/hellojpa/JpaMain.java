package hellojpa;

import org.hibernate.Hibernate;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.time.LocalDateTime;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//설정파일에서 설정한 이름 가져온다

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Address address = new Address("seoul","Dong-il ro","10101");

            Member member1 = new Member();
            member1.setUsername("member1");
            member1.setHomeAddress(address);
            em.persist(member1);
            //인스턴스를 복사해서 사용!! Address 객체에 복사하는 메서드 정의해도 좋음.
            //하나의 필드만 변경되더라도 통으로 새로 생성하는 것이 좋다고 함!
            Address newAddress = new Address("New City", address.getStreet(), address.getZipcode());
            member1.setHomeAddress(newAddress);//처음부터 다시 셋팅해야함..

//            Member member2 = new Member();
//            member2.setUsername("member2");
//            member2.setHomeAddress(copiedAddress);
//            em.persist(member2);

            //member1.getHomeAddress().setCity("NEW YORK");

            tx.commit();
        } catch (Exception e){
            tx.rollback();
            e.printStackTrace();
        } finally {
            em.close();//em이 결국 DB 연결을 담당하기 때문에 자원을 다 쓰고 작업 끝나면 닫아줘야한다!!
        }
        emf.close();//애플리케이션 종료 또는 WAS 내려갈 때 emf도 닫아준다!
    }
}
