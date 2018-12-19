package Lambda3;

import java.util.ArrayList;
import java.util.List;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Predicate;
import java.util.function.Supplier;

import org.junit.Test;

public class TestLambda {
	//1.Consumer消费型接口
	public void happy(Double money,Consumer<Double> con){
		con.accept(money);
	}
	
	@Test
	public void test1(){
		happy(10000.0, (con)->System.out.print("这是小费"+con+"元"));
	}
	
	//2.Supplier<T>供给型接口 T get();
	//需求，产生定个数整数，并将这些整数放入集合中。
	public List<Integer> getNumList(int num,Supplier<Integer>sp){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			Integer n = sp.get();
			list.add(n);
		}
		return list;
	}
	
	@Test
	public void test2(){
		List<Integer> getNumList = getNumList(10, ()->(int)(Math.random()*100));
		for (int i = 0; i < getNumList.size(); i++) {
			System.out.println(getNumList.get(i));
		}
	}
	
	//3.函数型接口Function<T,R>
	//需求：用于处理字符串R apply(T t)
	public String getString(String str,Function<String,String> fc){
		return fc.apply(str);
	}
	
	@Test
	public void test3(){
		String abc = getString("abc", (x)->x.toUpperCase());
		System.out.println(abc);
		System.out.println();
	}
	
	
	//断言型接口Predicate
	//bollean test(T t);
	//需求：处理字符串--将满足条件的字符串添加到集合当中。
	public List<Integer> getStringList(List<Integer> stringList,Predicate<Integer> pre){
		List<Integer> list  = new ArrayList<Integer>();
		for (Integer num : stringList) {
			if(pre.test(num)){
				list.add(num);
			}
		}
		return list;
	}
	
	
	@Test
	public void test4(){
		List<Integer> stringList  = new ArrayList<Integer>();
		stringList.add(1);
		stringList.add(3);
		stringList.add(5);
		stringList.add(7);
		stringList.add(9);
		List<Integer> list = getStringList(stringList, (x)->x>3);
		for (Integer num : list) {
			System.out.println(num);
		}
	}
	
	@Test
	public void test11(){
		Consumer con =  System.out::println;
		con.accept("abc");
	}
	

	
	
	

}
