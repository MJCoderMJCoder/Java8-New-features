import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.List;
import java.util.TreeSet;
import java.util.stream.Collectors;

import org.junit.Test;

public class TestLameda {
	//原来的
	@Test
	public void test1(){
		Comparator<Integer> com = new Comparator<Integer>() {
			@Override
			public int compare(Integer o1, Integer o2) {
				return Integer.compare(o2, o2);
			}
		};
		TreeSet<Integer> ts = new TreeSet(com);
		
	}
	
	//lambda表达式
	@Test
	public void testlambda(){
		Comparator<Integer> com = (x,y)->Integer.compare(x, y);
		TreeSet<Integer> ts = new TreeSet(com);
	}
	
	
	
	//数组转集合
	List<Entity> list = Arrays.asList(
		new Entity("张三",12,111.222),	
		new Entity("李四",13,222.222),	
		new Entity("王五",14,333.222),	
		new Entity("赵六",15,444.222),	
		new Entity("田七",16,555.222)
		);
	
	
	public List<Entity> testlambda2(List<Entity> list){
		List<Entity> emps = new ArrayList<Entity>();
		for (Entity entity : list) {
			if(entity.getAgel()>13){
				emps.add(entity);
			}
		}
		return emps;
	}

	
	//优化
	public List<Entity> testlambda3(List<Entity> list,MyPredicate<Entity> mp){
		List<Entity> emps = new ArrayList<Entity>();
		for (Entity entity : list) {
			if(mp.test(entity)){
				emps.add(entity);
			}
		}
		return emps;
	}
	@Test
	public void test3(){
		List<Entity> testlambda3 = testlambda3(list,new MyPredicateImpl());
		for (Entity entity : testlambda3) {
			System.out.println(entity.getAgel());
		}
	}
	@Test
	public void test4(){
		List<Entity> testlambda3 = testlambda3(list,new MyPredicatesalaryImpl());
		for (Entity entity : testlambda3) {
			System.out.println(entity.getSalary());
		}
	}
	
	
	@Test
	public void test5(){
		List<Entity> testlambda3 = testlambda3(list,new MyPredicate<Entity>(){

			@Override
			public boolean test(Entity entity) {
				return entity.getAgel()>15;
			}
			
		});
		for (Entity entity : testlambda3) {
			System.out.println(entity.getSalary());
		}

	}
	
	@Test
	public void test6(){
		List<Entity> testlambda3 = testlambda3(list, (entity)->entity.getSalary()>300);
		testlambda3.forEach(System.out::println);
	}
	
	@Test
	public void test7(){
		list.stream()
		.filter((e)->e.getAgel()>12)
		.limit(2).forEach(System.out::println);
		System.out.println("-----------------------");
		list.stream().map(Entity::getName).forEach(System.out::println);


		
	}
	@Test
	public void test8(){
		list.stream()
		    .filter(x->x.getAgel()>13)
		    .filter(y->y.getAgel()<16)
		    .collect(Collectors.toList())
		    .forEach(System.out::println);
	}
	
	@Test
	public void name() {
		list.stream().parallel().forEach(System.out::println);;
	}

    

}
