package team.kc.experiment.study.java;

import java.util.Random;

/**
 * 线程的例子
 * @author KenC
 */
public class ThreadDemo {
	public static void main (String[] args) {
		for (int i = 0; i < 3; ++i) {
			JobProvider.createJob().start();
		}
	}
}

/** 任务的提供者 */
class JobProvider {
	public static Thread createJob () {
		return new Thread(new Job());
	}
}

/** Runnable实现的多线程 */
class Job implements Runnable {
	private static Random random = new Random();
	private static int idSeq = 0;
	
	private String id;

	protected Job () {
		this.id = ""+(++idSeq);
	}

	public void run() {
		try {
			for (int i = 0; i < 4; ++i) {
				System.out.printf("Job(%s) is running in step %d.\n", id, i+1);
				Thread.sleep( random.nextInt(1000) );
			}
			System.out.printf("Job(%s) is finished.\n", id);
		} catch (InterruptedException e) {
			System.out.printf("Job(%s) is interrupted.\n", id);
		}
	}
}