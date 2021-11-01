package ru.job4j.hbm.lazy;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

import java.util.ArrayList;
import java.util.List;

public class LazyMain {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        List<Brand> list = new ArrayList<>();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Brand brand1 = Brand.of("brand1");
            Auto auto1 = Auto.of("auto1", brand1);
            Auto auto2 = Auto.of("auto2", brand1);
            Auto auto3 = Auto.of("auto3", brand1);
            session.persist(brand1);
            session.persist(auto1);
            session.persist(auto2);
            session.persist(auto3);

            list = session.createQuery("select distinct b from Brand b join fetch b.autos").list();
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
        for (Auto auto : list.get(0).getAutos()) {
            System.out.println(auto);
        }
    }
}
