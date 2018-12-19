package Lambda4;

import java.util.Comparator;
import java.util.function.BiPredicate;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;

import org.junit.Test;

public class TestMethod {
	// 方法引用：若Lambda体中的内容有方法已经实现，我们使用方法引用

	// 三种格式
	// 1.对象::实例方法名
	// 2.类::静态方法名
	// 3.类::实例方法名
	@Test
	public void test1() {
		Consumer<String> con = System.out::println;
		con.accept("abc");
	}

	@Test
	public void test3() {
		Comparator<Integer> com = Integer::compare;
		Integer num = com.compare(11, 22);
		System.out.println(num);
	}

	@Test
	public void test2() {
		BiPredicate<String, String> pc2 = String::equals;
		boolean a = pc2.test("abc", "abc");
		System.out.println(a);

		// BiPredicate<String,String> pc2 = new BiPredicate<String, String>() {
		//
		// @Override
		// public boolean test(String t, String u) {
		// // TODO Auto-generated method stub
		// return t.equals(u);
		// }
		// };
	}

	@Test
	public void test4(){
		Supplier<Employee> su = Employee::new;
		Employee a = su.get();
		System.out.println(a);
	}

	@Test
	public void test5() {
		Function<String, Employee> fc = (x) -> new Employee(x);
		Employee name = fc.apply("张三");
		System.out.println(name);
	}

}
