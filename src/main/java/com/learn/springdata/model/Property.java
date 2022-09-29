package com.learn.springdata.model;

import com.fasterxml.jackson.annotation.JsonIgnore;
import lombok.Getter;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;
import org.hibernate.Hibernate;

import javax.persistence.*;
import java.util.Objects;

@Getter
@Setter
@ToString
@RequiredArgsConstructor
@Entity
public class Property {
   @Id
   @GeneratedValue
   private Long id;

   private String name;

   private Long value;

   @ManyToOne()
   @JsonIgnore
   @JoinColumn(name = "person_id")
   private Person person;

   @Override
   public boolean equals(Object o) {
      if (this == o) return true;
      if (o == null || Hibernate.getClass(this) != Hibernate.getClass(o)) return false;
      Property publisher = (Property) o;
      return id != null && Objects.equals(id, publisher.id);
   }

   @Override
   public int hashCode() {
      return getClass().hashCode();
   }
}
