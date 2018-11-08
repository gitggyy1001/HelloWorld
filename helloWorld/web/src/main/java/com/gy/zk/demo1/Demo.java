package com.gy.zk.demo1;

import org.apache.zookeeper.*;

import java.io.IOException;
import java.util.concurrent.atomic.AtomicLong;

/**
 * Created by hello on 2018/9/18.
 */
public class Demo {
    // 会话超时时间，设置为与系统默认时间一致
    private static final int SESSION_TIMEOUT = 30000;
    // 创建 ZooKeeper 实例

    ZooKeeper zk;

    Watcher wh = new Watcher() {
        public void process(org.apache.zookeeper.WatchedEvent event)
        {
            System.out.println(event.toString());
        }
    };

    private void createZKInstance() throws IOException
    {
        zk = new ZooKeeper("localhost:2181", Demo.SESSION_TIMEOUT, this.wh);
    }

    private void ZKOperations() throws IOException, InterruptedException, KeeperException
    {
        System.out.println("/n1. 创建 ZooKeeper 节点 (znode ： zoo2, 数据： myData2 ，权限： OPEN_ACL_UNSAFE ，节点类型： Persistent");
        zk.create("/zoo2", "myData2".getBytes(), ZooDefs.Ids.OPEN_ACL_UNSAFE, CreateMode.PERSISTENT);
        System.out.println("/n2. 查看是否创建成功： ");
        System.out.println(new String(zk.getData("/zoo2", false, null)));
        System.out.println("/n3. 修改节点数据 ");
        zk.setData("/zoo2", "shenlan211314".getBytes(), -1);
        System.out.println("/n4. 查看是否修改成功： ");
        System.out.println(new String(zk.getData("/zoo2", false, null)));
        System.out.println("/n5. 删除节点 ");
        zk.delete("/zoo2", -1);
        System.out.println("/n6. 查看节点是否被删除： ");
        System.out.println(" 节点状态： [" + zk.exists("/zoo2", false) + "]");
    }

    private void ZKClose() throws InterruptedException
    {
        zk.close();
    }

    public static void main(String[] args) throws IOException, InterruptedException, KeeperException {
        AtomicLong s = new AtomicLong(1L);
        System.out.println(s);
        System.out.println(s.incrementAndGet());
        System.out.println(s);

        Long l = new Long(-888881003L);
        boolean b = l<0;
        System.out.println(b);

//        Demo dm = new Demo();
//        dm.createZKInstance();
//        dm.ZKOperations();
//        dm.ZKClose();
    }
}
