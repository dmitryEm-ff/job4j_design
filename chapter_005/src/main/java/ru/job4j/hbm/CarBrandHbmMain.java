package ru.job4j.hbm;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class CarBrandHbmMain {
    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder().configure().build();
        try {
            SessionFactory sf = new MetadataSources(registry).buildMetadata().buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Car a1 = Car.of("a1");
            Car a2 = Car.of("a2");
            Car a3 = Car.of("a3");
            Car a4 = Car.of("a4");
            Car a5 = Car.of("a5");

            session.save(a1);
            session.save(a2);
            session.save(a3);
            session.save(a4);
            session.save(a5);

            Brand audi = Brand.of("Audi");
            audi.addCar(a1);
            audi.addCar(a2);
            audi.addCar(a3);
            audi.addCar(a4);
            audi.addCar(a5);

            session.save(audi);
            session.getTransaction().commit();
            session.close();
        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
