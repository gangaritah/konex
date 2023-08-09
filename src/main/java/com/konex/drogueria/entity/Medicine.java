package com.konex.drogueria.entity;

import jakarta.persistence.*;
import lombok.Data;
import lombok.Getter;
import lombok.Setter;

import java.util.Date;

@Data
@Entity
@Table(name = "medicine")
public class Medicine {
  @Id
  @GeneratedValue(strategy = GenerationType.IDENTITY)
  private Integer id;
  private String name;
  private String laboratory;
  private Date manufacturingDate;
  private Date dueDate;
  private Integer stock;
  private Integer valueUnit;
}
