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
            Movie movie = new Movie();
            movie.setDirector("Cameron");
            movie.setActor("Leonardo Dicaprio");
            movie.setName("Titanic");
            movie.setPrice(10000);

            em.persist(movie);

            //쿼리를 보기 위해(아래와 같이하면 DB에서 직접 데이터를 조회해서 가져오기 때문에)
            em.flush();//영속성 컨텍스트에 있는 것을 DB에 넣는다!
            em.clear();//영속성 컨텍스트를 지운다!(1차 캐시에 아무것도 없음)

            Item item = em.find(Item.class, movie.getId());
            System.out.println("item = " + item);

            tx.commit();

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();//em이 결국 DB 연결을 담당하기 때문에 자원을 다 쓰고 작업 끝나면 닫아줘야한다!!
        }
        emf.close();//애플리케이션 종료 또는 WAS 내려갈 때 emf도 닫아준다!
    }
}
