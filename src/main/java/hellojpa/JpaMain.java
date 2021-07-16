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
            int a = 10;int b = 10;

            System.out.println("(a==b) = " + (a==b));

            Address address1 = new Address("seoul","Dong-il ro","10101");
            Address address2 = new Address("seoul","Dong-il ro","10101");

            System.out.println("(address1 == address2) = " + (address1 == address2));
            System.out.println("(address1 equals address2) = " + (address1.equals(address2)));


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
