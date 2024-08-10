package org.primepro.hrmapp;

import java.time.LocalDate;
import java.util.List;

import org.primepro.hrmapp.entities.Emp;
import org.primepro.hrmapp.repositories.EmpRepository;
import org.primepro.hrmapp.repositories.EmpRepositoryImpl;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.context.ApplicationContext;

@SpringBootApplication
public class HrmappApplication {

	public static void main(String[] args) {
		ApplicationContext context = SpringApplication.run(HrmappApplication.class, args);
		EmpRepository repo = context.getBean("empRepository", EmpRepositoryImpl.class);
		// Emp e=new Emp(2,"Vaishali","Hyderabad",LocalDate.of(2024, 01, 01));
		Emp e = new Emp();
		e.setName("Tisha");
		e.setAddress("Hyderabad");
		e.setDateOfJoin(LocalDate.of(2014, 06, 03));
		repo.insert(e);
		repo.delete(6); // if you want to delete then make sure that eno exists or not

		// get List of employees
		List<Emp> list = repo.getEmployees();
		for (Emp l : list) {
			System.out.println(l.getEno() + "\t" + l.getName() + "\t" + l.getAddress() + "\t" + l.getDateOfJoin());
		}

		// get single employee
		Emp emp = repo.getEmployee(2);
		System.out.println(emp.getEno() + "\t" + emp.getName() + "\t" + emp.getAddress() + "\t" + emp.getDateOfJoin());

		// Update
		Emp emp1 = new Emp();
		emp1.setAddress("Nagpur");
		repo.updateEmployee(2, emp1);

	}

}
