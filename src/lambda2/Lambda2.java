package lambda2;

import java.util.Comparator;
import java.util.function.Consumer;

import org.junit.Test;

public class Lambda2 {
	//箭头操作符->
	
	/**
	 * 左右遇一括号省
	 * 左侧推断类型省
	 */
	//无参数，无返回值
	@Test
	public void test1(){
		Runnable rn  = ()->System.out.println("word");
		rn.run();
	}

	//有参数，无返回值
	@Test
	public void test2(){
		Consumer<String> con = x-> System.out.println(x);
		con.accept("666");

	}
	//有2参数，有返回值
	@Test
	public void test3(){
		Comparator<Integer> com = (x,y)->{
			System.out.println("665544");
			return Integer.compare(x, y);
		};
	}
	
	//---------------------------------------------------------------------//
	
	
	//对一个数进行运算
	@Test
	public void test4(){
	Integer num = getValue(12, e->e * e);
	System.out.println(num);
	System.out.println(getValue(50, e->e-10));
	}
	
	public Integer getValue(Integer num,MyFun mf){
		return mf.getvalue(num);
	}
	
	
}
