package com.hungrycoder.spring.models;

import jakarta.persistence.*;

@Entity
@Table(name = "roles")
public class Role {

  @Id
  @GeneratedValue(strategy = GenerationType.UUID)
  private String id;

  @Enumerated(EnumType.STRING)
  @Column(length = 20)
  private EmployeeRole name;

  public Role() {}

  public Role(EmployeeRole name) {
    this.name = name;
  }

  public String getId() {
    return id;
  }

  public void setId(String id) {
    this.id = id;
  }

  public EmployeeRole getName() {
    return name;
  }

  public void setName(EmployeeRole name) {
    this.name = name;
  }
}
