package client.tray;

import javax.swing.*;

public class NoFriend {
    NoFriend(){
        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(900, 400, 200, 200);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel jLabel = new JLabel("查无此人");
        jLabel.setBounds(50,50,100,20);

        JButton CONFIRM = new JButton("确定");
        CONFIRM.setBounds(60,100,90,40);

        frame.add(jLabel);
        frame.add(CONFIRM);

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new NoFriend();
    }
}
