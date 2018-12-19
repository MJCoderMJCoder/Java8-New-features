package stream;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Before;
import org.junit.Test;

public class TestTransaction {
	
	List<Transaction> transactions = null;
	
	@Before
	public void before(){
		Trader raoul = new Trader("Raoul", "Cambridge");
		Trader mario = new Trader("Mario", "Milan");
		Trader alan = new Trader("Alan", "Cambridge");
		Trader brian = new Trader("Brian", "Cambridge");
		
		transactions = Arrays.asList(
				new Transaction(brian, 2011, 300),
				new Transaction(raoul, 2012, 1000),
				new Transaction(raoul, 2011, 400),
				new Transaction(mario, 2012, 710),
				new Transaction(mario, 2012, 700),
				new Transaction(alan, 2012, 950)
		);
	}
	
	@Test
	public void test10(){
		List<Transaction> list = transactions.stream().collect(Collectors.toCollection(ArrayList::new));
		list.forEach(System.out::println);
		transactions.forEach(System.out::println);
	}
	
	//1. 找出2011年发生的所有交易， 并按交易额排序（从低到高）
	@Test
	public void test1(){
		transactions.stream()
		            .filter(e->e.getYear()==2011)//过滤
		            .sorted((x,y)->Integer.compare(x.getValue(),y.getValue()))//排序
		            .forEach(System.out::println);

	}
	
	//2. 交易员都在哪些不同的城市工作过？
	@Test
	public void test2(){
		transactions.stream().map(e->e.getTrader().getCity()).distinct().forEach(System.out::println);
		
	}
	
	//3. 查找所有来自剑桥的交易员，并按姓名排序
	@Test
	public void test3(){
		transactions.stream()
		            .filter(e->e.getTrader().getCity().equals("Cambridge"))//过滤
		            .map(Transaction::getTrader)   //过滤
		            .sorted((x,y)->x.getName().compareTo(y.getName())) //排序
		            .forEach(System.out::println);

		// @formatter:on

	}
	
	//4. 返回所有交易员的姓名字符串，按字母顺序排序
	@Test
	public void test4(){
		transactions.stream()
		            .map(e->e.getTrader().getName())
		            .sorted()
		            .distinct()
		            .forEach(System.out::println);
		System.out.println("=================================");
		
		String newStr = transactions.stream()
        .map(e->e.getTrader().getName())
        .sorted()
        .distinct()
        .reduce("",String::concat);
		System.out.println(newStr);

		
		
	
	}
	
	public static Stream<String> filterCharacter(String str){
		List<String> list = new ArrayList<String>();
		for (Character string : str.toCharArray()) {
			list.add(string.toString());
			
		}
		return list.stream();
	}
	
	//5. 有没有交易员是在米兰工作的？
	@Test
	public void test5(){
		boolean a = transactions.stream()
		            .anyMatch(e->e.getTrader().getCity().equals("Milan"));
		System.out.println(a);

	}
	
	
	//6. 打印生活在剑桥的交易员的所有交易额
	@Test
	public void test6(){
		Optional<Integer> a = transactions.stream().filter(e->e.getTrader().getCity().equals("Cambridge"))
				                         .map(Transaction::getValue)
				                         .reduce(Integer::sum);

		System.out.println(a.get());

	}
	
	
	//7. 所有交易中，最高的交易额是多少
	@Test
	public void test7(){
		
		 Optional<Integer> a = transactions.stream()
		.map(Transaction::getValue)
		.collect(Collectors.maxBy(Integer::compare));
		 System.out.println(a.get());
		 
		 System.out.println("========================");
		 
		 Optional<Transaction> b = transactions.stream().collect(Collectors.maxBy((x,y)->Integer.compare(x.getValue(),y.getValue())));
		 System.out.println(b.get().getValue());
		 
		 System.out.println("========================");
		 
		 Optional<Integer> c = transactions.stream().map(Transaction::getValue).max(Integer::compare);
		 System.out.println(c);
		 
	}
	
	//8. 找到交易额最小的交易
	@Test
	public void test8(){
		
		 Optional<Transaction> a = transactions.stream()
		.collect(Collectors.minBy((x,y)->Integer.compare(x.getValue(),y.getValue())));
		 System.out.println(a.get());
	}

}