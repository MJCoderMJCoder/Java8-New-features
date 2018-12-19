package FlatMap;

import java.math.BigDecimal;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.Objects;
import java.util.Optional;
import java.util.function.BinaryOperator;
import java.util.stream.Collectors;
import java.util.stream.Stream;

import org.junit.Test;

public class TestFlatMap {
	
	
	//找出票房在十亿以上的
	@Test
	public void test1(){
		List<Director> ds = new ArrayList<Director>();
		ds.stream()
		  .flatMap(f->f.getFilms().stream())
		  .filter(x->Objects.isNull(x.getBoxOffice())?x.getBoxOffice().compareTo(BigDecimal.TEN)>0:false)
		  .forEach(System.out::println);
	}
	
	//列出参加过斯皮尔伯格电影的演员名单
	@Test
	public void test2(){
		List<Director> ds = new ArrayList<Director>();
		ds.stream()
		  .filter(s->s.getName().equals("sipiweboge"))
		  .flatMap(f->f.getFilms().stream())
		  .flatMap(a->a.getActors().stream())
		  .map(y->y.getName())
		  .distinct()
		  .forEach(System.out::println);;
	}
	
	
	@Test
	public void test3(){
		Stream<List<Integer>> inputStream = Stream.of(
				 Arrays.asList(1),
				 Arrays.asList(2, 3),
				 Arrays.asList(4, 5, 6)
				 );
				inputStream.
				flatMap((childList) -> childList.stream())
				.forEach(System.out::println);
	}
	
	@Test
	public void test4(){
		Integer[] sixNums = {1, 2, 3, 4, 5, 6};
		Integer[] evens =
		Stream.of(sixNums).filter(n -> n%2 == 0).toArray(Integer[]::new);
		System.out.println(evens);
	}
	
	@Test
	public void test5(){
		Integer[] concat = {1,2,3,4,5};
		 Integer a = Stream.of(concat).mapToInt(x->x).sum();
		 System.out.println(a);
		 String [] bb={"A", "B", "C", "D"};
		String b =  Stream.of(bb).reduce("", String::concat);
		System.out.println(b);

	}
	
	@Test
	public void test6(){
		List<Integer> numList = Arrays.asList(1,2,3,4,5,6,7,8,9,10,11,12,13,14);
		 Optional<Integer> min = numList.stream().min(Integer::compare);
		 System.out.println(min.get());
		 Integer sum = numList.stream().reduce(0,Integer::sum);
		 System.out.println(sum);
		 Integer sum2 = numList.stream().collect(Collectors.summingInt(x->x));
		 System.out.println(sum2);
	}
	
	@Test
	public void test7(){
		Stream.iterate(1, x->x+2).limit(10).forEach(System.out::println);
	}
	
	
	//没有参数的排序方法，  要能够使用sorted()方法进行排序，要求流的数据类型必须实现Comparable接口
	//默认是自然排序
	@Test
	public void test8(){
		Stream.of(3,6,5,3,8,0,2,1).sorted().forEach(System.out::println);;
		
	}
	@Test
	public void tset9(){
		Stream.of(5,6,7,8,4,3,2,4,6,65,5,3,545,6775,56453,53,43)
		      .sorted((x,y)->Integer.compare(x, y)).forEach(System.out::println);;
	}
	
	@Test
	public void test10(){
		Comparator<Integer> com =  Integer::compare;
		Stream.of(1,3,5,6,7,4,3,2,5,6,7,8).sorted(com.reversed()).forEach(System.out::println);;
	}
	@Test
	public void test11(){
		Stream.of(1,3,5,6,7,4,3,2,5,6,7,8)
		      .sorted(Integer::compare)
		      .sorted(Comparator.reverseOrder())
		      .forEach(System.out::println);;
	}
	
	//选择平均平方
	@Test
	public void test12(){
		Stream.of(1,2,3,4,5).map(x->x*x).forEach(System.out::println);

	}
	
	
		

}
