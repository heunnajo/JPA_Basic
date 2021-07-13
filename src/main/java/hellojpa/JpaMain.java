package hellojpa;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.EntityTransaction;
import javax.persistence.Persistence;

public class JpaMain {
    public static void main(String[] args) {
        EntityManagerFactory emf = Persistence.createEntityManagerFactory("hello");

        EntityManager em = emf.createEntityManager();

        EntityTransaction tx = em.getTransaction();
        tx.begin();

        try {
            Member member = new Member();
            member.setId(2L);
            member.setName("HelloB");

            em.persist(member);
            tx.commit();
        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();//em이 결국 DB 연결을 담당하기 때문에 작업 끝나면 닫아줘야한다!!
        }
        emf.close();

    }
}
