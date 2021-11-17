package ru.job4j.hbm.hql;

import javax.persistence.*;
import java.util.ArrayList;
import java.util.List;
import java.util.Objects;

@Entity
@Table(name = "vacancydb")
public class VacancyDB {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;

    private String name;

    @OneToMany(cascade = CascadeType.ALL, orphanRemoval = true)
    private List<Vacancy> vacancies = new ArrayList<>();

    public static VacancyDB of(String name) {
        VacancyDB vacancyDB = new VacancyDB();
        vacancyDB.name = name;
        return vacancyDB;
    }

    public void addVacancy(Vacancy vacancy) {
        this.vacancies.add(vacancy);
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public List<Vacancy> getVacancies() {
        return vacancies;
    }

    public void setVacancies(List<Vacancy> vacancies) {
        this.vacancies = vacancies;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        VacancyDB vacancyDB = (VacancyDB) o;
        return id == vacancyDB.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "VacancyDB{" + "id=" + id + ", name='" + name + '\'' + ", vacancies=" + vacancies + '}';
    }
}
