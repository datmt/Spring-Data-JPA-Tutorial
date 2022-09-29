package com.learn.springdata.model;

import lombok.*;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Publisher {
   @Id
   @GeneratedValue
   private Long id;

   private String name;

   private int estYear;

   @ManyToOne()
   @JoinColumn(name = "book_id")
   private Book book;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
      Publisher publisher = (Publisher) o;
      return id != null && Objects.equals(id, publisher.id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
