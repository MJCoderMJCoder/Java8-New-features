package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Map;
import java.util.Optional;
import java.util.Set;
import java.util.stream.Collectors;

import org.junit.Test;

import Lambda4.Employee;
import Lambda4.Employee.Status;

public class streamTest3 {
	//终止操作
	//数组转集合
	List<Employee> list = Arrays.asList(
		new Employee("张三",12,5000.0,Status.BUSY,"New York"),	
		new Employee("李四",13,6000.0,Status.FREE,"London"),	
		new Employee("王五",14,7000.0,Status.VACATION,"New York"),	
		new Employee("赵六",15,8000.0,Status.BUSY,"New York"),	
		new Employee("田七",16,9000.0,Status.FREE,"Shanghai")
		);
	
	@Test
	public void test1(){
		boolean str= list.stream()
		    .allMatch((e)->e.getStatus().equals(Status.BUSY));
       System.out.println(str);
       
       
       Optional<Employee> a = list.stream().findFirst();
       System.out.println(a);
       
       //long aa = list.stream().count();
       //System.out.println(aa);
       
       Optional<Employee> aaa = list.stream().sorted((x,y)->-Double.compare(x.getSalary(),y.getSalary())).findFirst();
       System.out.println(aaa.get());
       System.out.println("===================================");
       Optional<Employee> aaaa = list.stream().filter((x)->x.getStatus().equals(Status.FREE)).findAny();
       System.out.println(aaaa.get());
       
       System.out.println("===================================");
       Optional<Employee> aaab =  list.stream().max((x,y)->Double.compare(x.getSalary(),y.getSalary()));
       System.out.println(aaab.get()+"最大的"+ "");
		
	}
	//规约可以将流中元素反复结合起来，得到一个值。	
	@Test
	public void test2(){
		List<Integer> NumList = Arrays.asList(1,2,3,4,5,6,7,8,9,10);
		Integer num = NumList.stream().reduce(0,(x,y)->x+y);
		System.out.println(num);
	}
	
	@Test
	public void test3(){
		Optional<Double> num = list.stream().map((e)->e.getSalary()).reduce((x,y)->Double.sum(x, y));
		System.out.println(num.get());
		
		Optional<Double> num2 = list.stream().map(Employee::getSalary).reduce(Double::sum);
		System.out.println(num2.get());
	}
	
	//收集，collect------将流转换成其他模式，接收一个collector接口的实现，用于给stream中的元素做汇总的方法。
	@Test
	public void test4(){
		List<String> listName = new ArrayList<String>();
		list.stream().map(Employee::getName).forEach((e)->listName.add(e));
		for (String string : listName) {
			System.out.println("名字是"+string);
		}
	}
	//collectors转成list
	@Test
	public void test5(){
		list.stream().map(Employee::getName).collect(Collectors.toList()).forEach(System.out::println);
	}
	
	//collectors转成set
	@Test
	public void test6(){
		 Set<String> set = list.stream().map(Employee::getName).collect(Collectors.toSet());
		 set.forEach(System.out::println);
	}
	
	//集合转set
	@Test
	public void test7(){
		 list.stream().collect(Collectors.toSet()).forEach(System.out::println);
	}
	//转特殊类型  hashset
	@Test
	public void test8(){
		 list.stream().collect(Collectors.toCollection(HashSet::new)).forEach(System.out::println);
	}
	
	@Test
	public void test9(){
		//计算总数
		long a = list.stream().collect(Collectors.counting());
		System.out.println(a);
		//计算平均值
		Double salary = list.stream().collect(Collectors.averagingDouble(Employee::getSalary));
		System.out.println(salary);
		//计算综合
		Double sum = list.stream().collect(Collectors.summingDouble(Employee::getSalary));
		System.out.println(sum);
		//最大值的工资
		Optional<Employee> to = list.stream().collect(Collectors.maxBy((x,y)->Double.compare(x.getSalary(),y.getSalary())));
		System.out.println("最大工资"+to.get());
		//最小值的年龄
		 Optional<Integer> minage = list.stream().map(Employee::getAge).collect(Collectors.minBy(Integer::compare));
		 System.out.println("最小年龄"+minage.get());
	}
	
	//分组
	@Test
	public void test10(){
		 Map<Status, List<Employee>>  a =list.stream().collect(Collectors.groupingBy(Employee::getStatus));
		 System.out.println(a);
	}
	
	//分组
	@Test
	public void test11(){
		 Map<Status, Map<Integer, List<Employee>>>lists =  list.stream()
				   .collect(Collectors.groupingBy(Employee::getStatus, Collectors.groupingBy(Employee::getAge)));
		 System.out.println(lists);
		
	}
	
	//分区
	@Test
	public void test12(){
		Map<Boolean,List<Employee>> a = list.stream().collect(Collectors.partitioningBy(e->e.getAge()>12));
		System.out.println(a);
	}
	//连接字符串
	@Test
	public void test13(){
		String nameString = list.stream().map(Employee::getName).collect(Collectors.joining(","));
		System.out.println(nameString);
		
	}
	

}
