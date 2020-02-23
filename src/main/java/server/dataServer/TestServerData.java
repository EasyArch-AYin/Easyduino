package server.dataServer;

import io.netty.buffer.Unpooled;
import io.netty.channel.Channel;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.net.InetSocketAddress;

public class TestServerData {
    public void view(NettyDataServer DataServer) {
        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(800, 400, 400, 350);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton jButton = new JButton("点我发送消息");
        jButton.setBounds(200,100,200,80);

        frame.add(jButton);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                Channel channel = DataServer.getChannel();
                int port = DataServer.getInitializer().getDataServerHandler().getPort();
                //模拟服务器给客户端发送数据成功
                channel.writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer("我在给你发数据", CharsetUtil.UTF_8),new InetSocketAddress("127.0.0.1",port)));
                System.out.println("数据发送成功");
            }
        });

        frame.setVisible(true);



    }
}