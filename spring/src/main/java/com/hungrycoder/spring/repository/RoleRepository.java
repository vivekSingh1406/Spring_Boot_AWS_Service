package com.hungrycoder.spring.repository;

import java.util.Optional; // Import Optional for handling optional values

import com.hungrycoder.spring.models.EmployeeRole; // Import EmployeeRole enumeration
import com.hungrycoder.spring.models.Role; // Import Role model
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface RoleRepository extends JpaRepository<Role, String> {

  Optional<Role> findByName(EmployeeRole name);
}
