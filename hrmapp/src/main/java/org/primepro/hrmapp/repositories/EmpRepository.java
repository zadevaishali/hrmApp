package org.primepro.hrmapp.repositories;

import java.util.List;

import org.primepro.hrmapp.entities.Emp;

public interface EmpRepository {
  void insert(Emp e);
  void delete(int eno);
  List<Emp> getEmployees();
  Emp getEmployee(int eno);
  void updateEmployee(int eno,Emp e);
}
