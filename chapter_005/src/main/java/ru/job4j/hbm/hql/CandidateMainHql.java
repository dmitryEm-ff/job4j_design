package ru.job4j.hbm.hql;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CandidateMainHql {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            VacancyDB vacancyDB = VacancyDB.of("testDB");
            vacancyDB.addVacancy(Vacancy.of("one"));
            vacancyDB.addVacancy(Vacancy.of("two"));
            vacancyDB.addVacancy(Vacancy.of("three"));
            session.persist(vacancyDB);

            session.persist(Candidate.of("1", 2, 30000, vacancyDB));
            session.persist(Candidate.of("2", 3, 40000, vacancyDB));
            session.persist(Candidate.of("3", 4, 50000, vacancyDB));

            Candidate candidate = session.createQuery("select distinct can from Candidate can"
                    + " join fetch can.vacancyDB db"
                    + " join fetch db.vacancies where can.id = :id", Candidate.class)
                    .setParameter("id", 20)
                    .uniqueResult();

            System.out.println(candidate);

            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}