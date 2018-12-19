

import java.awt.Button;
import java.awt.Frame;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Random;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.Supplier;
import java.util.stream.Collectors;

import org.junit.Before;
import org.junit.Test;

public class Testlambda {
	
	private List<User> us = new ArrayList<User>();
	@Before
	public void getBody(){
		Random rm = new Random();
		for (int i = 0; i <= 100; i++) {
			us.add(new User("user"+i,rm.nextInt(50)+50));
		}
		
	}
	
	@Test
	public void test1(){
		List<String>  names = Arrays.asList("tom","jary","joun","aa");
        String a =names.stream().sorted().collect(Collectors.joining(","));
        System.out.println(a);
	}
	
	
	@Test
   public void test2(){
		Frame frame = new Frame();
		frame.setSize(100,100);
		Button b = new Button("lambda");
		b.addActionListener(a->System.out.println("出现啦"));
		frame.add(b);
		b.setVisible(true);
   } 
	
	@Test
	public void test3(){
		//us.stream().forEach(System.out::println);
		us.stream()
		  .filter(x->x.getScore()>85)
		  .sorted((x,y)->Integer.compare(x.getScore(),y.getScore())).map(User::getName)
		  .forEach(System.out::println);
		  
		
	}
	
	@Test
	public void test4(){
	Double a = us.stream().collect(Collectors.averagingInt(User::getScore));
	System.out.println(a);
	}
	
	
	/**
	 * 有参数，有返回值
	 */
	@Test
	public void test5(){
		String abc = ToUpper("abcdefg", e->e.toUpperCase());
		System.out.println(abc);
		
	}
	
	public String ToUpper(String str,Function<String,String> fc){
		return fc.apply(str);
	}
	
	/**
	 * 有参数无返回值
	 */
	@Test
	public void test6(){
		getSize("abc", (con)->System.out.println(con));
	}
	
	public void getSize(String str,Consumer<String>con){
		con.accept(str);
	}
	
	/**
	 * 无参数有返回值
	 * //需求，产生指定个数整数，并将这些整数放入集合中。
	 */
	
	public List<Integer> getNumList(int num,Supplier<Integer>sp){
		List<Integer> list = new ArrayList<Integer>();
		for (int i = 0; i < num; i++) {
			Integer a = sp.get();
			list.add(a);
		}
		return list;
	}
	@Test
	public void test7(){
		List<Integer> list = getNumList(10, ()->(int)(Math.random()*1000));
		for (Integer integer : list) {
			System.out.println(integer);
		}
	}
	
	@Test
	public void test8(){


	}
		

}
