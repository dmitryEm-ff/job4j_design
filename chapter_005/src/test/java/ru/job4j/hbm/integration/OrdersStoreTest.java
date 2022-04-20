package ru.job4j.hbm.integration;

import org.apache.commons.dbcp2.BasicDataSource;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import java.io.BufferedReader;
import java.io.FileInputStream;
import java.io.IOException;
import java.io.InputStreamReader;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.List;

import static org.hamcrest.core.Is.is;
import static org.junit.Assert.*;

public class OrdersStoreTest {
    private BasicDataSource pool = new BasicDataSource();

    @Before
    public void setUp() throws SQLException {
        pool.setDriverClassName("org.hsqldb.jdbcDriver");
        pool.setUrl("jdbc:hsqldb:mem:tests;sql.syntax_pgs=true");
        pool.setUsername("sa");
        pool.setPassword("");
        pool.setMaxTotal(2);
        StringBuilder builder = new StringBuilder();
        try (BufferedReader br = new BufferedReader(
                new InputStreamReader(new FileInputStream("./db/update_001.sql")))
        ) {
            br.lines().forEach(line -> builder.append(line).append(System.lineSeparator()));
        } catch (IOException e) {
            e.printStackTrace();
        }
        pool.getConnection().prepareStatement(builder.toString()).executeUpdate();
    }

    @After
    public void wipeTable() throws SQLException {
        new OrdersStore(pool).clear();
    }

    @Test
    public void whenSaveOrderAndFindAllOneRowWithDescription() {
        OrdersStore store = new OrdersStore(pool);
        store.save(Order.of("name1", "description1"));
        List<Order> all = (List<Order>) store.findAll();
        assertThat(all.size(), is(1));
        assertThat(all.get(0).getDescription(), is("description1"));
    }

    @Test
    public void whenFindByIdThenSuccess() {
        OrdersStore store = new OrdersStore(pool);
        Order expected = store.save(Order.of("name1", "description1"));
        Order rsl = store.findById(expected.getId());

        assertThat(expected, is(rsl));
    }

    @Test
    public void whenFindByNameThenSuccess() {
        OrdersStore store = new OrdersStore(pool);
        Order expected = store.save(Order.of("name1", "description1"));
        Order rsl = store.findByName("name1");

        assertThat(expected, is(rsl));
    }

    @Test
    public void whenUpdateObject() {
        OrdersStore store = new OrdersStore(pool);
        Order rsl = store.save(Order.of("name1", "description1"));
        rsl.setDescription("desc2");
        store.update(rsl);
        Order expected = store.findByName("name1");

        assertThat(expected.getDescription(), is("desc2"));
    }
}