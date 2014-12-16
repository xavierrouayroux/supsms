/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package com.supsms.message;

import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageListener;
import javax.jms.TextMessage;

/**
 *
 * @author fabien
 */
public class SmsMessageListener implements MessageListener{

    @Override
    public void onMessage(Message message) {
        TextMessage textMessage = (TextMessage) message;
        try
        {
          System.out.print("Received the following message: ");
          System.out.println(textMessage.getText());
          System.out.println();
        }
        catch (JMSException e)
        {
          e.printStackTrace();
        }    
    }
}
