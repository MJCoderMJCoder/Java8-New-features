package Optional;

import java.security.cert.PKIXRevocationChecker.Option;
import java.util.Optional;

import org.junit.Test;

import Lambda4.Employee;
import Lambda4.Employee.Status;

/**
 * optional容器
 * @author root
 *
 */
public class TestOptional {
	/*
	 * 一、Optional 容器类：用于尽量避免空指针异常
	 * 	Optional.of(T t) : 创建一个 Optional 实例
	 * 	Optional.empty() : 创建一个空的 Optional 实例
	 * 	Optional.ofNullable(T t):若 t 不为 null,创建 Optional 实例,否则创建空实例
	 * 	isPresent() : 判断是否包含值
	 * 	orElse(T t) :  如果调用对象包含值，返回该值，否则返回t
	 * 	orElseGet(Supplier s) :如果调用对象包含值，返回该值，否则返回 s 获取的值
	 * 	map(Function f): 如果有值对其处理，并返回处理后的Optional，否则返回 Optional.empty()
	 * 	flatMap(Function mapper):与 map 类似，要求返回值必须是Optional
	 */
	
	@Test
	public void test1(){
		Optional<Employee> op = Optional.of(new Employee());
		System.out.println(op.get().getAge());
	}
	
	@Test
	public void test2(){
		Optional<Employee> op = Optional.empty();
		System.out.println(op);
	}
	
	@Test
	public void test3(){
		Optional<Employee> op = Optional.ofNullable(new Employee());
/*		if(op.isPresent()){
			System.out.println(op.get());
		}else{
			System.out.println("没值");
		}*/
		Employee emp = op.orElse(new Employee("zhangsan",18,888.888,Status.BUSY,"上海"));
		System.out.println(emp);
	}
	
	
	//map
	@Test
	public void test4(){
		Optional<Employee> op = Optional.ofNullable(new Employee("zhangsan",18,888.888,Status.BUSY,"上海"));
		Optional<String> name = op.map(Employee::getName);
		System.out.println(name.get());
		
	}
	
	//例子
	//需求：获取男人心中女神的名字
	@Test
	public void test5(){
		Optional<Man> man = Optional.ofNullable(null);
		String name = godnessName(man);
		System.out.println(name);
	}
	

	
	
	
	public String godnessName(Optional<Man> man){
		return man.orElse(new Man())
				  .getGodness()
				  .orElse(new Godness("小美"))
				  .getName();
	}
	
	
	

}
