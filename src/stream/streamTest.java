package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.stream.Stream;

import org.junit.Test;

import Lambda4.Employee;

public class streamTest {
	/**
	 * stream的三步
	 * 1.创建
	 * 2.中间操作
	 * 3.终止操作
	 * 
	 */
	
	
	//创建stream
	@Test
	public void test1(){
		//1.可以通过Collection系列集合提供的stream()或者通过parallelStream();
		List<String> list = new ArrayList<>();
		Stream<String> s = list.stream();
		
		//2.通过arrays中的静态方法stream()
		Employee[] emps = new Employee[10];
		Stream<Employee> ss = Arrays.stream(emps);
		
		
		//3.通过Stream类中的OF方法
		Stream<String> sss = Stream.of("aa","bb","bb");
		
		//4.创建无限流
		//4.1迭代
		Stream<Integer> ssss = Stream.iterate(0, (x)->x+2);
		//ssss.limit(10).forEach(System.out::println);
		
		//4.2生成
		Stream.generate(()->(Math.random())*100)
						   .limit(5)
		                   .forEach(System.out::println);;
		
	}

}
