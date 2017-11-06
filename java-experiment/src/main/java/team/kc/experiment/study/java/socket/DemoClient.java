package team.kc.experiment.study.java.socket;

import java.io.IOException;
import java.io.OutputStreamWriter;
import java.io.Writer;
import java.net.Socket;
import java.util.Scanner;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DemoClient {
	protected static final Logger logger = 
		LoggerFactory.getLogger(DemoClient.class);
	
	private static final String SHUTDOWN_FLAG = "quit";
	
	public static void main (String[] args) {
		runClient( DemoServer.HOST, DemoServer.PORT );
	}
	
	/**
	 * 根据host:port连接socket，与服务器通讯
	 * @param host
	 * @param port
	 */
	public static void runClient (String host, int port) {
		Scanner sc = new Scanner(System.in);
		do {
			String strInput = sc.nextLine();
			sendOneMsg(host, port, strInput);
			
			//遇到关闭命令停止循环
			if (SHUTDOWN_FLAG.equals(strInput)) { break; }
		} while (true);
		
		sc.close();
		
		logger.info("Server Shutdown!");
	}
	
	/**
	 * 根据host:port连接socket，发送msg信息
	 * @param host
	 * @param port
	 * @param msg
	 */
	public static void sendOneMsg (String host, int port, String msg) {
		logger.info( "Message is sending ("+msg+")." );

		try {
			Socket client = new Socket(host, port);
			Writer writer = new OutputStreamWriter(client.getOutputStream());
			writer.write(msg);
			writer.flush();
			writer.close();
			client.close();
		} catch (IOException e) {
			logger.error( "Client send error:"+e.getMessage(), e);
		}
	}
	
}
