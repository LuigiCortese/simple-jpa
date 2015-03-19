package com.mui.jpaproject;

import javax.persistence.EntityManager;
import javax.persistence.EntityManagerFactory;
import javax.persistence.Persistence;

import com.mui.jpaproject.entities.Employee;

public class Main {

	public static void main(String[] args) {
		new Main().operate();
	}
	
	public void operate(){
		
		EntityManagerFactory emfactory = Persistence.createEntityManagerFactory("JPAProject"); 
		EntityManager entitymanager = emfactory.createEntityManager();
		
		createEmployee(entitymanager);
		
		updateEmployee(entitymanager);
		
		deleteEmployee(entitymanager);
		
		entitymanager.close();
		emfactory.close();
		
	}
	
	/**
	 * create employee
	 */
	public void createEmployee(EntityManager entitymanager){
		
		entitymanager.getTransaction().begin();

		Employee employee = new Employee();
		employee.setId(7);
		employee.setFirstName("Mario");
		employee.setLastName("Rossi");
		employee.setSalary(40000);

		entitymanager.persist(employee);
		entitymanager.getTransaction().commit();

	}
	
	/**
	 * update employee
	 * @param entitymanager
	 */
	public void updateEmployee(EntityManager entitymanager){
		entitymanager.getTransaction().begin();
		Employee employee = entitymanager.find(Employee.class, 7);
		employee.setSalary(46000);
		entitymanager.getTransaction( ).commit( );
	}
	
	/**
	 * delete employee
	 */
	public void deleteEmployee(EntityManager entitymanager){
		entitymanager.getTransaction().begin();
		Employee employee = entitymanager.find(Employee.class, 7);
		entitymanager.remove(employee);
		entitymanager.getTransaction( ).commit( );
	}

}
