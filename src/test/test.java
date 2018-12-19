package test;

import java.util.Arrays;
import java.util.List;

import org.junit.Test;

import Lambda4.Employee;
import Lambda4.Employee.Status;

public class test {
	//数组转集合
	List<Employee> list = Arrays.asList(
		new Employee("张三",12,5000.0,Status.BUSY,"New York"),	
		new Employee("李四",13,6000.0,Status.FREE,"London"),	
		new Employee("张三",14,7000.0,Status.VACATION,"New York"),	
		new Employee("李四",15,8000.0,Status.BUSY,"New York"),	
		new Employee("田七",16,9000.0,Status.FREE,"Shanghai")
		);
	
	@Test
	private void test1(){


		
	}

}
