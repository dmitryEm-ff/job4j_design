package ru.job4j.hbm.manytomany;

import org.hibernate.Session;
import org.hibernate.SessionFactory;
import org.hibernate.boot.MetadataSources;
import org.hibernate.boot.registry.StandardServiceRegistry;
import org.hibernate.boot.registry.StandardServiceRegistryBuilder;

public class AutorBookHbmMain {

    public static void main(String[] args) {
        final StandardServiceRegistry registry = new StandardServiceRegistryBuilder()
                .configure()
                .build();
        try {
            SessionFactory sf = new MetadataSources(registry)
                    .buildMetadata()
                    .buildSessionFactory();
            Session session = sf.openSession();
            session.beginTransaction();

            Book book1 = Book.of("Head First Java");
            Book book2 = Book.of("Effective Java");
            Book book3 = Book.of("Java-The complete reference");
            Book book4 = Book.of("Java Programming Cookbook");

            Autor author1 = Autor.of("Kathy Sierra");
            Autor author2 = Autor.of("Bert Bates");
            Autor author3 = Autor.of("Joshua Bloch");
            Autor author4 = Autor.of("Herbert Schildt");

            book1.addAutor(author1);
            book1.addAutor(author2);
            book2.addAutor(author3);
            book3.addAutor(author4);
            book4.addAutor(author4);

            session.persist(book1);
            session.persist(book2);
            session.persist(book3);
            session.persist(book4);

            Book book = session.get(Book.class, 1);
            session.remove(book);
            book = session.get(Book.class, 3);
            session.remove(book);

            session.getTransaction().commit();
            session.close();

        } catch (Exception e) {
            e.printStackTrace();
        } finally {
            StandardServiceRegistryBuilder.destroy(registry);
        }
    }
}
