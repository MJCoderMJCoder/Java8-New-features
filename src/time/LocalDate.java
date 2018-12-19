package time;

import java.time.DayOfWeek;
import java.time.Instant;
import java.time.LocalDateTime;
import java.time.temporal.TemporalAdjusters;

import org.junit.Test;

public class LocalDate {
	//LocalDate   localtime  LocalDateTime
	
	@Test
	public void test1(){
		LocalDateTime ld = LocalDateTime.now();
		System.out.println(ld);
		System.out.println("===========================");
		LocalDateTime ld2 =  LocalDateTime.of(2018, 02, 26, 17, 07);
		System.out.println(ld2);
		LocalDateTime ld3 = ld.plusYears(2);
		System.out.println(ld3);
		LocalDateTime ld4 = ld.minusMonths(1);
		System.out.println(ld4);
		System.out.println("===========================");
		int ld40 = ld.getDayOfMonth();
		DayOfWeek ld41 = ld.getDayOfWeek();
		int ld42 = ld.getDayOfYear();
		System.out.println(ld40);
		System.out.println(ld41);
		System.out.println(ld42);
		
	}
	
	/**
	 * instant
	 * 
	 */
	
	@Test
	public void test2(){
		LocalDateTime a = LocalDateTime.now();
		Instant b = Instant.now();//默认获取的UTC时区
		System.out.println(a);
		System.out.println(b);
		
	}
	//时间校正器
	@Test
	public void test3(){
		LocalDateTime  time = LocalDateTime.now();
		System.out.println(time);
		LocalDateTime first = time.with(TemporalAdjusters.next(DayOfWeek.SUNDAY));
		System.out.println(first);
		
	}

}
