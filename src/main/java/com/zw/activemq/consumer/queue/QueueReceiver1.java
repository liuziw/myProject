
package com.zw.activemq.consumer.queue;

import org.springframework.stereotype.Component;

import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;
import java.util.concurrent.TimeUnit;

/**
 * 
 * @author liang
 * @description  队列消息监听器
 * 
 */
@Component
public class QueueReceiver1 implements MessageListener {

	@Override
	public void onMessage(Message message) {
		try {
			TimeUnit.MILLISECONDS.sleep(5000);
			System.out.println("发送短信1:"+((TextMessage)message).getText());
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
}
