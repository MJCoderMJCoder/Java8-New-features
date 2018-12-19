package ForkJion;


import java.util.concurrent.RecursiveTask;

public class FonkJoinCalulate extends RecursiveTask<Long>{

	/**
	 * 
	 */
	private static final long serialVersionUID = 1L;
	
	
	private long start;
	private long end;
	
	private static final long EHRESHOLD = 10000;
	
	
	public FonkJoinCalulate(long start,long end){
		this.start= start;
		this.end = end ;
	}

	@Override
	protected Long compute() {
		long length = end - start;
		if(length<=EHRESHOLD){
			long sum = 0;
			for (long i = start; i <=end; i++) {
				sum+=i;
			}
			return sum;
		}else{
			long moddle = (start+end)/2;
			FonkJoinCalulate left = new FonkJoinCalulate(start,moddle);
			left.fork();//拆分子任务，压入线程队列
			
			FonkJoinCalulate right = new FonkJoinCalulate(moddle+1,end);
			right.fork();//拆分子任务，压入线程队列
			return left.join()+right.join();
		}
		
	}

}
