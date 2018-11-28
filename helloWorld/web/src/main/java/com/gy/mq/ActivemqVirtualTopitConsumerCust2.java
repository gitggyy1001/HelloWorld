package com.gy.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.JMSException;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;

/**
 * Created by hello on 2018/11/27.
 */
public class ActivemqVirtualTopitConsumerCust2 implements MessageListener {
    private String name = "";
    private Connection connection = null;
    private Session session = null;
    private MessageConsumer consumer = null;
    ActivemqVirtualTopitConsumerCust2(String name){
        this.name=name;
    }

    public ActivemqVirtualTopitConsumerCust2(){}

    public  void initialize() throws JMSException
    {ConnectionFactory connectFactory = new ActiveMQConnectionFactory(
            "tcp://localhost:61616");
        Connection connection = connectFactory.createConnection();
        session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
        Destination destination =  session.createQueue("Consumer.cust.VirtualTopic.test");
        consumer = session.createConsumer(destination);
        connection.start();
    }

    public void recive()
    {
        try {
            System.out.println("Consumer("+name+"):->Begin listening...");
            // 开始监听
            consumer.setMessageListener(this);  //(异步接收)
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
    }

    @Override
    public void onMessage(Message arg0) {
        // TODO Auto-generated method stub
        try{
            if(arg0 instanceof TextMessage)
            {
                TextMessage txtMsg = (TextMessage) arg0;
                System.out.println("consumer("+name+")异步 recive:"+txtMsg.getText());
                Thread.sleep(500);
                session.commit();
            }
        }catch(Exception e)
        {
            e.printStackTrace();
        }

    }
    public void submit() throws JMSException
    {
        session.commit();
    }
    // 关闭连接
    public void close() throws JMSException {
        System.out.println("Consumer:->Closing connection");
        if (consumer != null)
            consumer.close();
        if (session != null)
            session.close();
        if (connection != null)
            connection.close();
    }

    public static void main(String[] args) {
        ActivemqVirtualTopitConsumerCust2 activemqVirtualTopitConsumerCust2 = new ActivemqVirtualTopitConsumerCust2();
        try {
            activemqVirtualTopitConsumerCust2.initialize();
            activemqVirtualTopitConsumerCust2.recive();
        } catch (JMSException e) {
            e.printStackTrace();
        }

    }
}
