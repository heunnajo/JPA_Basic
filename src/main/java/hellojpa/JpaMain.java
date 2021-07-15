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


            //회원 저장
            Member member = new Member();
            member.setUsername("member1");
            //member.changeTeam(team);
            em.persist(member);

            //팀 저장
            Team team = new Team();
            team.setName("TeamA");
            //team.getMembers().add(member); //외래키 업데이트!
            em.persist(team);

            //team기준 연관관계 편의 메서드
            team.addMember(member);

            tx.commit();
//            em.flush();
//            em.clear();
            //양방향 연관관계 : Member=>Team, Team=>Member 참조!
//            Member findMember = em.find(Member.class, member.getId());
//            List<Member> members = findMember.getTeam().getMembers();
//
//            System.out.println("==============");
//            for (Member m : members) {
//                System.out.println("m.getUsername() = " + m.getUsername());
//            }
//            System.out.println("==============");

        } catch (Exception e){
            tx.rollback();
        } finally {
            em.close();//em이 결국 DB 연결을 담당하기 때문에 자원을 다 쓰고 작업 끝나면 닫아줘야한다!!
        }
        emf.close();//애플리케이션 종료 또는 WAS 내려갈 때 emf도 닫아준다!
    }
}
