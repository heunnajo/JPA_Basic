package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;
import java.util.List;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");//설정파일에서 설정한 이름 가져온다

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member1 = new Member();
            member1.setUsername("A");

            Member member2 = new Member();
            member2.setUsername("B");

            Member member3 = new Member();
            member3.setUsername("C");

            System.out.println("==================");
            em.persist(member1);//1, 51
            em.persist(member2);//메모리에서 호출
            em.persist(member3);//메모리에서 호출..하닫가 51을 만나는 순간 nextCall이 호출되고 다시 50개 가져옴

            System.out.println("member1 = " + member1.getId());
            System.out.println("member2 = " + member1.getId());
            System.out.println("member3 = " + member1.getId());

            System.out.println("==================");
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();//em이 결국 DB 연결을 담당하기 때문에 자원을 다 쓰고 작업 끝나면 닫아줘야한다!!
        }
        emf.close();//애플리케이션 종료 또는 WAS 내려갈 때 emf도 닫아준다!
    }
}
