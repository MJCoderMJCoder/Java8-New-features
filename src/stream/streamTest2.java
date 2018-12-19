package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import Lambda4.Employee;
import Lambda4.Employee.Status;

public class streamTest2 {
	
	
	//数组转集合
	List<Employee> list = Arrays.asList(
		new Employee("张三",12,5000.0,Status.BUSY,"New York"),	
		new Employee("李四",13,6000.0,Status.FREE,"London"),	
		new Employee("王五",14,7000.0,Status.VACATION,"New York"),	
		new Employee("赵六",15,8000.0,Status.BUSY,"New York"),	
		new Employee("田七",16,9000.0,Status.FREE,"Shanghai")
		);
	//中间操作
	//筛选与切片
	@Test
	public void test(){
		Stream<Employee> s  = list.stream().filter((x)->x.getAge()>15);
		s.forEach(System.out::println);
		
	}
	
	
	@Test
	public void test2(){
		list.stream()
		    .filter((e)->e.getSalary()>100)
	        .skip(2)
		    .distinct()
		    .forEach(System.out::println);;
		
	}
	
	@Test
	public void test3(){
		//大小写转换
		List<String> lists = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		lists.stream().map((x)->x.toUpperCase()).forEach(System.out::println);
		
		System.out.println("------------------------------------------");
		list.stream()
		    .map(Employee::getName)
		    .forEach(System.out::println);
	}
	
	/**
	 * add与addAll的区别
	 */
	@Test
	public void test4(){
		List<String> lists = Arrays.asList("aaa","bbb","ccc","ddd","eee");
		List lists2 = new ArrayList();
		List lists3 = new ArrayList();
		lists2.add(lists);
		lists2.add(11);
		lists3.add(222);
		
		lists3.addAll(lists);
		System.out.println(lists2);
		System.out.println(lists3);

		
	}
	

}
