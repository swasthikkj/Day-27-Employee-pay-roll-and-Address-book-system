package com.employeepayroll;
import java.io.File;
import java.io.IOException;

public class EmployeePayroll {

	private int id;
	private String name;
	private double salary;

	public EmployeePayroll() {

	}

	public EmployeePayroll(int id, String name, double salary) throws IOException {
		this.id = id;
		this.name = name;
		this.salary = salary;
	}

	public int getId() {
		return id;
	}
	public void setId(int id) {
		this.id = id;
	}
	public String getName() {
		return name;
	}
	public void setName(String name) {
		this.name = name;
	}
	public double getSalary() {
		return salary;
	}
	public void setSalary(double salary) {
		this.salary = salary;
	}
	@Override
	public String toString() {
		return "EmployeePayroll [id = " + id + ", name = " + name + ", salary = " + salary + "]";
	}	
}