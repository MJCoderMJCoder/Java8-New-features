package time;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Collectors;
import java.util.stream.IntStream;
import java.util.stream.Stream;

import org.junit.Test;

import Lambda4.Employee;
import Lambda4.Employee.Status;

public class TestStream {
	@Test
	public void test1(){
		int[] ints = new int[]{1,2,3,4,5};
		IntStream a = Arrays.stream(ints);
		a.forEach(System.out::println);
	}
	
	
	@Test
	public void test2(){
		Employee [] emp =new Employee[]{new Employee("张三",15,2000.0,Status.BUSY,"上海"),new Employee("李四",25,5000.0,Status.BUSY,"北京")};
		Stream<Employee> empList = Arrays.stream(emp);
		empList.forEach(System.out::println);
	}
	
	/**
	 * 无限流创建样例  如20个数字的集合
	 */
	@Test
	public void test3(){
		List<Integer> IntegerList = new ArrayList<Integer>();
		List<Integer> list = Stream.generate(()->(int)(Math.random()*100)).limit(20).collect(Collectors.toList());
		list.forEach(x->IntegerList.add(x));
		IntegerList.forEach(System.out::println);
	}
	
	
	/**
	 * 无限流迭代
	 */
	@Test
	public void test4(){
		Stream.iterate(0, x->x+1).limit(10).forEach(System.out::println);;
	}
	
	//查看所有以a开头的字符串
	@Test
	public void test5(){
		String []  a = new String[]{"abc","aa","bb","bac","acb","aaa"};
		Stream.of(a).filter(x->x.length()<3).forEach(System.out::println);
	}
	
	
	@Test
	public void test6(){
		String [] str = new String[]{"yes","YES","Yes","NO","No"};
		String abc = Stream.of(str).map(x->x.toUpperCase()).collect(Collectors.joining(",","[","]"));
		System.out.println(abc);
	}
	
	@Test
	public void test7(){
		String [] str1 = new String[]{"a","b","c","d","e"};
		String [] str2 = new String[]{"f","g","h","i","j"};
		String [] str3 = new String[]{"k","l","m","n","o"};
		String abc = Stream.of(str1,str2,str3).flatMap(arr->Stream.of(arr)).collect(Collectors.joining(","));
		System.out.println(abc);
	}

}
