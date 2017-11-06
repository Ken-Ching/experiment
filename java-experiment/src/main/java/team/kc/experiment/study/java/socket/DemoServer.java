package team.kc.experiment.study.java.socket;

import java.io.IOException;
import java.io.InputStreamReader;
import java.io.Reader;
import java.net.ServerSocket;
import java.net.Socket;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * Server for Socket Demo
 * @author KenC
 *
 */
public class DemoServer {
	protected static final Logger logger = 
		LoggerFactory.getLogger(DemoServer.class);
	
	public static final String SHUTDOWN_FLAG = "QUIT";
	public static final String HOST = "localhost";
	public static int PORT = 9090;
	
	public static void main (String[] args) {
		runServer( PORT );
	}

	/**
	 * 利用端口port启动Socket Server，监听客户请求
	 * @param port 端口
	 */
	public static void runServer (int port) {
		ServerSocket serverSocket = null;
		try {
			//指定绑定的端口，并监听此端口。
			serverSocket = new ServerSocket(port);
			logger.info( "Port "+port+" is listening for client request... " );
			
			processAccept( serverSocket );
			
			logger.info("Server Shutdown!");
		} catch (IOException e) {
			logger.error("Server Start Exception:"+e.getMessage(), e);
		} finally {
			try {
				serverSocket.close();
			} catch (IOException e) {
				logger.error("Server Socket close fail:"+e.getMessage(), e);
			}
		}
	}
	
	/** 处理客户请求 */
	private static void processAccept (ServerSocket serverSocket) {
		do {
			Socket socket = null;
			try {
				socket = serverSocket.accept();
				logger.info("New connection accepted in "+
						socket.getInetAddress()+":"+socket.getPort() );
				
				//接受客户请求信息
				Reader reader = new InputStreamReader(socket.getInputStream());
	            char chars[] = new char[1024];
	            int len;
	            StringBuilder strB = new StringBuilder();
	            while ((len=reader.read(chars)) != -1) {
	               strB.append(new String(chars, 0, len));
	            }
	            
	            logger.info( "Accept message: "+strB.toString() );
	            reader.close();
	            
	            //遇到关闭命令停止循环
	            if ( SHUTDOWN_FLAG.equals(strB.toString()) ) { break; }
			} catch (IOException e) {
				logger.error("Server Accept Exception:"+e.getMessage(), e);
			}
		} while (true);//循环监听直到遇到结束命令
	}
}
