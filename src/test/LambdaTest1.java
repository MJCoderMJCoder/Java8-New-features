package test;

import java.util.Arrays;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collector;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

import Lambda4.Employee;
import Lambda4.Employee.Status;

public class LambdaTest1 {
	
	//数组转集合
	List<Employee> list = Arrays.asList(
		new Employee("张三",12,5000.0,Status.BUSY,"New York"),	
		new Employee("李四",13,6000.0,Status.FREE,"London"),	
		new Employee("王五",14,7000.0,Status.VACATION,"New York"),	
		new Employee("赵六",15,8000.0,Status.BUSY,"New York"),	
		new Employee("田七",16,9000.0,Status.FREE,"Shanghai")
		);
	
	
	
	//anyMath检查是否匹配一个元素
	@Test
	public void test1(){
		boolean a = list.stream().anyMatch(x->x.getName().equals("张三1"));
		System.out.println(a);
	}
	
	//返回所有salary大于6000
	@Test
	public void test2(){
		list.stream().filter(xdsds->xdsds.getSalary()>6000).forEach(System.out::println);
	}
	
	//找出工资最高
	@Test
	public void test3(){
		Optional<Employee> emp = list.stream().max((x,y)->Double.compare(x.getSalary(),y.getSalary()));
		System.out.println(emp);
	}
	
	//返回姓名列表
	@Test
	public void test4(){
		list.stream().map(Employee::getAge).forEach(System.out::println);
	}
	
	//List转换成Map
	@Test
	public void test5(){
		Map<String,Employee> emp = list.stream().collect(Collectors.toMap((key->key.getName()),(value ->value)));
		emp.forEach((key,value)->System.out.println(key+""+value));
	}
	
	//统计办公室是New York的个数
	@Test
	public void test6(){
		long a = list.stream().filter(x->x.getOffice().equals("New York")).count();
		System.out.println(a);
	}
	//List转换为Set
	@Test
	public void test7(){
		Set<Employee> a = list.stream().distinct().collect(Collectors.toSet());
		System.out.print(a);
	}
	
	//查找办公室地点是New York的员工
	@Test
	public void test8(){
		list.stream().filter(x->x.getOffice().equals("New York")).map(Employee::getName).forEach(System.out::println);
	}
	
	//按照工资的降序来列出员工信息
	@Test
	public void test9(){
		List<Employee> lists = list.stream().sorted((x,y)->-Double.compare(x.getSalary(),y.getSalary())).collect(Collectors.toList());
		lists.forEach(System.out::println);
	}
	//按照名字的升序列出员工信息
	@Test
	public void test10(){
		 list.stream()
		     .sorted((x,y)->x.getName().compareTo(y.getName()))
		     .collect(Collectors.toList()).forEach(System.out::println);
	}
	
	//获取工资最高的前2条员工信息
	@Test
	public void test11(){
		 list.stream()
		     .sorted((x,y)->-Double.compare(x.getSalary(),y.getSalary()))
		     .limit(2)
		     .collect(Collectors.toList())
		     .forEach(System.out::println);

	}
	
	//获取平均工资
	@Test
	public void test12(){
		 Double a =list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		 System.out.println(a);
	}
	
	

	@Test
	public void test13(){
		Optional<Integer> age = Optional.of(20);
		System.out.println(age);
		Optional<Integer> ageMap = age.filter(a->a>18);
	}
	
	
	

}
