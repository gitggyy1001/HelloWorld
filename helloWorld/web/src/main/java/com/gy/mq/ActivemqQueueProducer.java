package com.gy.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.*;

/**
 * Created by hello on 2018/5/8.
 */
public class ActivemqQueueProducer {
    private Session session;
    private MessageProducer producer ;
    private Connection connection;


    public  void initialize() throws JMSException
    {
        ConnectionFactory connectFactory = new ActiveMQConnectionFactory(
                "tcp://localhost:61616");
        connection = connectFactory.createConnection();
        //session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);//支持事务
        session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);//不支持事务

        Destination destination =  session.createQueue("queue1");
        producer = session.createProducer(destination);
        producer.setDeliveryMode(DeliveryMode.NON_PERSISTENT);
        connection.start();

    }

    public void sendText(String Message)
    {
        try {
            TextMessage text = session.createTextMessage(Message);
            producer.send(text);
            session.commit();
            System.out.println("Sending message:"+text.getText());
        } catch (JMSException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }

    }

    public void submit() throws JMSException
    {
        session.commit();
    }
    // 关闭连接
    public void close() throws JMSException {
        System.out.println("Producer:->Closing connection");
        if (producer != null)
            producer.close();
        if (session != null)
            session.close();
        if (connection != null)
            connection.close();
    }

    public static void main(String[] args) throws JMSException {
        ActivemqQueueProducer activemqQueueProducer = new ActivemqQueueProducer();
        activemqQueueProducer.initialize();
        activemqQueueProducer.sendText("hello");
    }

}
