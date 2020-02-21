package client.tray;

import client.dataClient.DataClientHanler;
import io.netty.channel.Channel;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.WindowAdapter;
import java.awt.event.WindowEvent;

public class AddFriend {
    AddFriend(Channel channel,String ID){
        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(800,400,400, 350);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton ADD = new JButton("添加");
        ADD.setBounds(300,15,60,20);

        JLabel FriendID = new JLabel("好友ID" + ID);
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
            public void actionPerformed(ActionEvent e) {
                new DataClientHanler().xxx(channel);
            }
        });

        panel.add(ADD);
        panel.add(FriendID);
        frame.add(panel);

        frame.setVisible(true);
    }
}
