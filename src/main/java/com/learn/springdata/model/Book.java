package com.learn.springdata.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.List;
import java.util.Objects;

@Getter
@Setter
@RequiredArgsConstructor
@Entity
public class Book {

    @Id
    @GeneratedValue
    private Long id;

    private String title;

    private int pages;

    @OneToMany(cascade = {CascadeType.ALL},
            mappedBy = "book"
    )
//    @ToString.Exclude
    List<Publisher> publishers;

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
        Book book = (Book) o;
        return id != null && Objects.equals(id, book.id);
    }

    @Override
    public int hashCode() {
        return getClass().hashCode();
    }
}
