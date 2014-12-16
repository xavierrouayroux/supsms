/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supsms.message;

import javax.annotation.Resource;
import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.JMSException;
import javax.jms.MessageConsumer;
import javax.jms.Queue;
import javax.jms.Session;

/**
 *
 * @author fabien
 */
public class MessageReceiver {
    @Resource(mappedName = "jms/GlassFishBookConnectionFactory")
    private static ConnectionFactory connectionFactory;
    @Resource(mappedName = "jms/GlassFishBookQueue")
    private static Queue queue;
    private Connection connection;
    private MessageConsumer messageConsumer;
    private Session session;

    public void getMessages()
    {
        try
        {
            connection = connectionFactory.createConnection();
            session = connection.createSession(false, Session.AUTO_ACKNOWLEDGE);
            messageConsumer = session.createConsumer(queue);
            messageConsumer.setMessageListener(new SmsMessageListener());
            connection.start();
        }
        catch (JMSException e)
        {
            e.printStackTrace();
        }
    }
    
    public void CloseConnection() throws JMSException {
        messageConsumer.close();
        session.close();
        connection.close();
    }
}
