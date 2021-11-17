package ru.job4j.hbm.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.List;

public class CandidateMain {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Candidate one = Candidate.of("one", 2, 10000);
            Candidate two = Candidate.of("two", 10, 50000);
            Candidate three = Candidate.of("three", 5, 30000);

            session.save(one);
            session.save(two);
            session.save(three);

            //Выбрать всех Candidate
            List<Candidate> candidateList = session.createQuery("from Candidate").list();

            //Выбрать через setParameter
            Candidate candidateTestOne = (Candidate) session.createQuery("from Candidate c where c.id = :id")
                    .setParameter("id", 2).uniqueResult();

            //Выбрать по имени
            List<Candidate> candidateTestTwo = session.createQuery("from Candidate c where c.name = :name")
                    .setParameter("name", "name").list();

            //Обновить кандидата
            session.createQuery("update Candidate c set c.name = :name, c.exp = :exp, c.salary = :salary where c.id = :id")
                    .setParameter("name", "changed")
                    .setParameter("exp", 100)
                    .setParameter("salary", 500000)
                    .setParameter("id", 1)
                    .executeUpdate();

            //Удалить по id
            session.createQuery("delete from Candidate where id = :id")
                    .setParameter("id", 2)
                    .executeUpdate();

            //Добавить новую запись через concat()
            session.createQuery("insert into Candidate (name, exp, salary) "
                    + "select concat(c.name, 'NEW'), c.exp + 5, c.salary + 1000000 "
                    + "from Candidate c where c.id = :id")
                    .setParameter("id", 1)
                    .executeUpdate();

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}