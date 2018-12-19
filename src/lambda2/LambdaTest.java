package lambda2;

import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.List;

import org.junit.Test;

public class LambdaTest {
	List<Entity> list = Arrays.asList(new Entity("张三", 52, 111.222), new Entity("李四", 13, 222.222),
			new Entity("王五", 33, 333.222), new Entity("赵六", 5, 444.222), new Entity("田七", 46, 555.222));

	@Test
	public void test1() {
		Collections.sort(list, (x, y) -> {
			if (x.getAge() == y.getAge()) {
				return x.getName().compareTo(y.getName());
			} else {
				return -Integer.compare(x.getAge(), y.getAge());
			}
		});
		for (Entity entity : list) {
			System.out.println(entity.getAge() + "," + entity.getName());
		}
	}

	public String getvalue(String str, MyFunction mf) {
		return mf.getValue(str);
	}

	@Test
	public void test2() {
		System.out.println(getvalue("abc", (x) -> x.toUpperCase()));
	}

	public Long getvalueTo(Long t1, Long t2, Myfunction2<Long, Long> mf) {
		return mf.getvlue(t1, t2);
	}

	@Test
	public void test3() {
		System.out.println(getvalueTo(1000L, 1111L, (a, d) -> {
			System.out.println("dsafdf");
			return (a + d);
		}));
	}
}
