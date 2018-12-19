package FlatMap;
import java.util.Arrays;
import org.junit.Test;
public class test {
	
	@Test
	public void test1(){
		Integer[] arr = new Integer[]{1,2,3,4,5};
		Integer num1 = Arrays.stream(arr).reduce(0,Integer::sum);
		System.out.println(num1);
	}
	//predicate谓语断言（传一个惨返回Boolean）
	//function（传一个参，返回一个值）
	//consumer消费接口，传一个参，没有返回值
	//suppier 没有参，返回一个值
	
	@Test
	public void test2(){
		
		
		
	}

}
