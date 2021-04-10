package ru.job4j.tdd;

import static org.junit.Assert.assertThat;
import static org.hamcrest.Matchers.is;

import org.junit.Test;

import java.util.Arrays;
import java.util.Calendar;
import java.util.List;

public class CinemaTest {
    @Test
    public void buy() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2020, 10, 10, 23, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);
        assertThat(ticket, is(new Ticket3D()));
    }

    @Test
    public void find() {
        Cinema cinema = new Cinema3D();
        cinema.add(new Session3D());
        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions, is(Arrays.asList(new Session3D())));
    }

    @Test
    public void add() {
        Cinema cinema = new Cinema3D();
        Session session = new Session3D();
        cinema.add(session);
        List<Session> sessions = cinema.find(s -> true);
        assertThat(true, is(sessions.get(0)));
    }

    @Test
    public void whenSameSeat() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 04, 10, 15, 00);
        Ticket ticket = cinema.buy(account, 1, 1, date);

        Account secondAccount = new AccountCinema();
        Calendar secondDate = Calendar.getInstance();
        secondDate.set(2021, 04, 10, 15, 30);
        Ticket secondTicket = cinema.buy(secondAccount, 1, 1, secondDate);

        Ticket result = null;
        assertThat(secondTicket, is(result));
    }

    @Test
    public void whenWrongDate() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2022, 05, 10, 15, 30);
        Ticket ticket = cinema.buy(account, 1, 1, date);

        Ticket result = null;
        assertThat(ticket, is(result));
    }

    @Test
    public void whenWrongSeat() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema3D();
        Calendar date = Calendar.getInstance();
        date.set(2021, 04, 10, 15, 00);
        Ticket ticket = cinema.buy(account, 99, 99, date);

        Ticket result = null;
        assertThat(ticket, is(result));
    }

    @Test
    public void whenWrongCinema() {
        Account account = new AccountCinema();
        Cinema cinema = new Cinema4D();

        List<Session> sessions = cinema.find(session -> true);
        assertThat(sessions.size(), is(0));
    }
}