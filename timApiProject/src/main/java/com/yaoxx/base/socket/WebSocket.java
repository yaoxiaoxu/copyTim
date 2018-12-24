
package com.yaoxx.base.socket;

import java.io.IOException;
import java.util.concurrent.ConcurrentHashMap;

import javax.websocket.OnClose;
import javax.websocket.OnError;
import javax.websocket.OnMessage;
import javax.websocket.OnOpen;
import javax.websocket.Session;
import javax.websocket.server.PathParam;
import javax.websocket.server.ServerEndpoint;

import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import com.yaoxx.base.MyUtils;
import com.yaoxx.entity.sys.User;

import lombok.extern.log4j.Log4j2;

/**
 * @version: 1.0
 * @since: JDK 1.8.0_91
 * @Description:
 *
 * 				<br>
 * 				Modification History:<br>
 * 
 *               Date | Author | Version | Description<br>
 *               ------------------------------------------------------------------<br>
 * 
 *               2018年11月9日 | yao_x_x | 1.0 | 1.0 Version
 * 
 */
@ServerEndpoint("/websocket/{param}")
@Component
public class WebSocket {
	

	//websocket中 @Autowire失效
	private MyUtils myUtils = MyUtils.getBeanByClass(MyUtils.class);
	
	

	/**
	 * 现有链接数量--
	 */
	private static Integer countNum = 0;

	/**
	 * 用于存放每个客户端对应的socket对象 ConcurrentHashMap : 线程安全的map,
	 */
	private ConcurrentHashMap<WebSocket, String> webSocketMap = new ConcurrentHashMap<>();

	// 与某个客户端的链接会话。
	private Session session;
	

	/**
	 * 连接建立成功调用的方法
	 */
	@OnOpen
	public void onOpen(Session session,@PathParam("param")String sessionId) {
		
		this.session = session;
		// 更新webSocketMap
		User currentUser = myUtils.getCurrentUserByRedis(sessionId);
		if (currentUser!=null && StringUtils.isNoneBlank(currentUser.getName())) {
			webSocketMap.put(this, currentUser.getName());
		}
		addCountNum(); // 在线数加1
		System.out.println("==================websocket:onOpen()================");
		System.out.println("有新连接加入！当前链接数： " + WebSocket.getCountNum());
		System.out.println("=====================================================");
		try {
			sendMessage("-- 成功建立链接 --");
		} catch (IOException e) {
			System.err.println("-- 在WebSocket的onOpen方法中，发生了IO异常 --");
		}
	}
	
	/**
	 * 链接关闭--
	 */
	@OnClose
	public void onClose(){
		
		webSocketMap.remove(this);
		subCountNum();
		System.out.println("==================websocket:onClose()================");
		System.out.println("==有一链接关闭，剩余：=== "+getCountNum()+" ====================");
		System.out.println("=====================================================");
	}
	
	/**
	 * @param mes
	 * @param session
	 * @description 收到客户端的消息时
	 */
	@OnMessage
	public void onMessage(String mes,Session session){
		
		System.out.println("==================websocket:onMessage()================");
		System.out.println("==收到session:("+session.getId()+")的消息=== "+mes);
		System.out.println("=====================================================");
	}
	
	/**
	 * @param session
	 * @param error
	 * @description 发生错误时
	 */
	@OnError
	public void onError(Session session,Throwable error){
		
		System.out.println("==================websocket:onError()================");
		System.out.println("==session:("+session.getId()+")发生错误=== "+error.getMessage());
		System.out.println("=====================================================");
		
		error.printStackTrace();
	}
	
	/**
	 * @param mes
	 * @throws IOException
	 * @description 向客户端发送信息
	 */
	public void sendMessage(String mes) throws IOException{
		
//		this.session.getBasicRemote().sendText(mes); //同步发送信息
		this.session.getAsyncRemote().sendText(mes);
	}

	/**
	 * 在线人数 +1
	 */
	public static synchronized void addCountNum() {

		WebSocket.countNum++;
	}

	/**
	 * 在线人数 -1
	 */
	public static synchronized void subCountNum() {

		WebSocket.countNum--;
	}

	/**
	 * @return	获取在线人数
	 */
	public static synchronized Integer getCountNum() {

		return WebSocket.countNum;
	}

}
