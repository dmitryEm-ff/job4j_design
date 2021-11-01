package ru.job4j.hbm.lazy;

import javax.persistence.*;
import java.util.Objects;

@Entity
@Table(name  = "auto")
public class Auto {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private int id;
    private String name;

    @ManyToOne
    @JoinColumn(name = "brand_id")
    private Brand brand;

    public static Auto of(String name, Brand brand) {
        Auto auto = new Auto();
        auto.name = name;
        auto.brand = brand;
        return auto;
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

    public Brand getBrand() {
        return brand;
    }

    public void setBrand(Brand brand) {
        this.brand = brand;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) {
            return true;
        }
        if (o == null || getClass() != o.getClass()) {
            return false;
        }
        Auto auto = (Auto) o;
        return id == auto.id;
    }

    @Override
    public int hashCode() {
        return Objects.hash(id);
    }

    @Override
    public String toString() {
        return "Auto{"
                + "id=" + id
                + ", name='" + name + '\''
                + ", brand=" + brand
                + '}';
    }
}