package com.wzm.github.util.concurrent;

import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.Callable;
import java.util.concurrent.ExecutionException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.Future;

/**
 * 
 * @author lsf
 *
 */
public class ConcurrentExecutor {
	
	final public static ExecutorService executor = Executors.newCachedThreadPool() ;
	
	/**
	 * sync
	 * @param <Response>
	 * @param taskList
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static <Response>List<Response> execute( List<Callable<Response>> taskList )
		throws InterruptedException, ExecutionException{
		
		return get( asyncExecute( taskList ) );
	}
	
	/**
	 * async
	 * @param <Response>
	 * @param taskList
	 * @return
	 */
	public static <Response>List<Future<Response>> asyncExecute( List<Callable<Response>> taskList ){
		List<Future<Response>> futureList = new ArrayList<Future<Response>>( taskList.size() );
		for( int i = 0; i < taskList.size(); i++ ){
			futureList.add( i , executor.submit(taskList.get( i ) ) );
		}
		return futureList;
	}
	
	/**
	 * 
	 * @param <Response>
	 * @param futureList
	 * @return
	 * @throws InterruptedException
	 * @throws ExecutionException
	 */
	public static <Response>List<Response> get( List<Future<Response>> futureList )
		throws InterruptedException, ExecutionException{
		
		List<Response> respList= new ArrayList<Response>( futureList.size() );
		
		for( int i = 0; i < futureList.size(); i++ ){
			respList.add( i , futureList.get( i ).get() );
		}
		return respList;
		
	}
	
}
