/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supsms.message;

import java.util.Queue;
import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.MessageProducer;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 *
 * @author fabien
 */
public class MessageSender {
    @Resource(mappedName = "jms/SupSms")
  private static ConnectionFactory connectionFactory;
  @Resource(mappedName = "jms/SupSmsQueue")
  private static Queue queue;

  public void produceMessages(String message)
  {
    MessageProducer messageProducer;
    TextMessage textMessage;
    try {
        Connection connection = connectionFactory.createConnection();
        Session session = connection.createSession(false,
          Session.AUTO_ACKNOWLEDGE);
        messageProducer = session.createProducer((Destination) queue);
        textMessage = session.createTextMessage();

        textMessage.setText(message);
        messageProducer.send(textMessage);

        messageProducer.close();
        session.close();
        connection.close();
    }
    catch (JMSException e) {
      e.printStackTrace();
    }
  }
}
