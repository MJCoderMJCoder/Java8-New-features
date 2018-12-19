package ForkJion;

import java.time.Duration;
import java.time.Instant;
import java.util.concurrent.ForkJoinPool;
import java.util.concurrent.ForkJoinTask;
import java.util.stream.LongStream;

import org.junit.Test;

public class TestForkJoin {
	
	/**
	 * forkjoin框架 68
	 */
	@Test
	public void test1(){
		Instant start = Instant.now();
		ForkJoinPool pool = new ForkJoinPool();
		ForkJoinTask<Long> task = new FonkJoinCalulate(0,100000000L);
		Long sum = pool.invoke(task);
		System.out.println(sum);
		Instant end = Instant.now();
		System.out.println("耗费时间是："+Duration.between(start, end).toMillis());
	}
	
	/**
	 * 普通for循环  427
	 */
	@Test
	public void test2(){
		Instant start = Instant.now();
		Long sum = 0l;
		for (long i = 0; i <= 100000000L; i++) {
			sum+=i;
		}
		System.out.println(sum);
		Instant end = Instant.now();
		System.out.println("耗费时间是："+Duration.between(start, end).toMillis());
		
	}
	
	/**
	 * java8并行流
	 */
    //并行流----------并行流的时间是：17600
	@Test
	public void test3(){
		Instant start = Instant.now();
		Long a = LongStream.rangeClosed(0, 100000000000L)
		          .parallel()
		          .reduce(0,Long::sum);
		System.out.println(a);
		Instant end = Instant.now();
		System.out.println("并行流的时间是："+Duration.between(start, end).toMillis());
	}
	//串行流——————————串行流的时间是：51832
	@Test
	public void test4(){
		Instant start = Instant.now();
		Long a = LongStream.rangeClosed(0, 100000000000L)
		          .sequential()
		          .reduce(0,Long::sum);
		System.out.println(a);
		Instant end = Instant.now();
		System.out.println("串行流的时间是："+Duration.between(start, end).toMillis());
	}


}
