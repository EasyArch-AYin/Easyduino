package client.tray;

import client.dataClient.NettyDataClient;
import io.netty.buffer.Unpooled;
import io.netty.channel.socket.DatagramPacket;
import io.netty.util.CharsetUtil;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;
import java.net.InetSocketAddress;

public class AddFriend {
    AddFriend(NettyDataClient DataClient,String MyID, String ID){
        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(800,400,400, 350);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton ADD = new JButton("添加");
        ADD.setBounds(300,15,60,20);

        JLabel FriendID = new JLabel("好友ID:" + ID);
        FriendID.setBounds(80,10,200,25);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBounds(0,0,400,50);
        panel.setBorder(BorderFactory.createEtchedBorder());

        //按照此人ID查找此人，选择添加与否

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowOpened(WindowEvent e) {

            }
        });

        ADD.addActionListener(new ActionListener() {
            @Override
            //给服务器发送申请人ID和被申请人ID
            public void actionPerformed(ActionEvent e) {
                DataClient.getChannel().writeAndFlush(new DatagramPacket(Unpooled.copiedBuffer(MyID+ "+" + ID, CharsetUtil.UTF_8),new InetSocketAddress("127.0.0.1",8087)));
            }
        });

        panel.add(ADD);
        panel.add(FriendID);
        frame.add(panel);

        frame.setVisible(true);
    }
}
