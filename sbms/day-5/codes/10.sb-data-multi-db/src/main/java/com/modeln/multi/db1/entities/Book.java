package com.modeln.multi.db1.entities;

import jakarta.persistence.Entity;
import jakarta.persistence.Id;
import jakarta.persistence.Table;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data	
@AllArgsConstructor	
@NoArgsConstructor
@Entity
@Table(name="BOOK_TBL")
public class Book {
  @Id
  private int id;
  private String name;
}

