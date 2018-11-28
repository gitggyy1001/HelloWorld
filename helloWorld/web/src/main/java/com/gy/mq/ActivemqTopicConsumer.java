package com.gy.mq;

import org.apache.activemq.ActiveMQConnectionFactory;

import javax.jms.Connection;
import javax.jms.ConnectionFactory;
import javax.jms.Destination;
import javax.jms.Message;
import javax.jms.MessageConsumer;
import javax.jms.MessageListener;
import javax.jms.Session;
import javax.jms.TextMessage;
import javax.jms.Topic;

/**
 * Created by hello on 2018/11/26.
 */
public class ActivemqTopicConsumer {
    private ConnectionFactory connectionFactory;
    private Connection connection;
    private Session session;
    private Topic destination;
    private MessageConsumer messageConsumer;

    public static void main(String[] args) {
        /**
         * Pub/Sub模型中，消息可被多个对象接收，不同于P2P模型
         */
        ActivemqTopicConsumer consumer1 = new ActivemqTopicConsumer();
        consumer1.doReceive();
//        ActivemqTopicConsumer consumer2 = new ActivemqTopicConsumer();
//        consumer2.doReceive();
    }

    public void doReceive() {
        try {
            connectionFactory = new ActiveMQConnectionFactory();
            connection = connectionFactory.createConnection();
            // 设置客户端id ，配置持久化订阅者必须
            connection.setClientID("DurableSubscriber1");
            connection.start();
            session = connection.createSession(true, Session.AUTO_ACKNOWLEDGE);
            destination = session.createTopic("topic1");
            //messageConsumer = session.createConsumer(destination);
            messageConsumer = session.createDurableSubscriber(destination, "DurableSubscriber1");

            // 方式一：监听接收
            receiveByListener();

            // 方式二：阻塞接收
            // receiveByManual();

        } catch (Exception e) {
            e.printStackTrace();
        }

    }

    /**
     * 通过注册监听器的方式接收消息，属于被动监听
     */
    private void receiveByListener() {
        try {
            messageConsumer.setMessageListener(new MessageListener() {
                @Override
                public void onMessage(Message message) {
                    if (message instanceof TextMessage) {
                        try {
                            TextMessage msg = (TextMessage) message;
                            System.out.println("Received:“" + msg.getText()
                                    + "”");
                            session.commit();
                        } catch (Exception e) {
                            e.printStackTrace();
                        }
                    }

                }
            });
        } catch (Exception e) {
            e.printStackTrace();
        }
    }

    /**
     * 通过手动去接收消息的方式，属于主动获取
     */
    private void receiveByManual() {
        while (true) {
            try {
                /**
                 * 通过receive()方法阻塞接收消息，参数为超时时间（单位：毫秒）
                 */
                TextMessage message = (TextMessage) messageConsumer
                        .receive(60000);
                if (message != null) {
                    System.out.println("Received:“" + message.getText() + "”");
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        }
    }
}

