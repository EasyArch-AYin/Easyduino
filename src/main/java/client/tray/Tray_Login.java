package client.tray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.MouseAdapter;
import java.awt.event.MouseEvent;

public class Tray_Login {
    public static void main(String[] args) {

        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(320,150,1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton jButton = new JButton("立即登录");
        jButton.setBounds(825,425 ,320,60);

        JLabel ACCOUNT = new JLabel("账号");
        ACCOUNT.setBounds(820,200,40,20);
        JLabel PASSWORD = new JLabel("密码");
        PASSWORD.setBounds(820,300,40,20);

        final JTextField jtf = new JTextField();
        final JPasswordField jpf = new JPasswordField();
        jtf.setBounds(820,220,320,40);
        jpf.setBounds(820,320,320,40);

        frame.add(jButton);
        frame.add(ACCOUNT);
        frame.add(PASSWORD);
        frame.add(jtf);
        frame.add(jpf);

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Tray_view();
                frame.setVisible(false);
            }
        });
        frame.setVisible(true);
    }
}
