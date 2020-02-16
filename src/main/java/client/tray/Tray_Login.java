package client.tray;

import javax.swing.*;
import java.awt.event.*;

public class Tray_Login {
    public static void main(String[] args) {

        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(320,150,1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.EXIT_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton LOGIN = new JButton("立即登录");
        LOGIN.setBounds(820,425 ,320,60);
        JButton REGIST = new JButton("点我注册");
        REGIST.setBounds(820,380,100,20);

        JLabel ACCOUNT = new JLabel("账号");
        ACCOUNT.setBounds(820,200,40,20);
        JLabel PASSWORD = new JLabel("密码");
        PASSWORD.setBounds(820,300,40,20);


        final JTextField jtf = new JTextField();
        final JPasswordField jpf = new JPasswordField();
        jtf.setBounds(820,220,320,40);
        jpf.setBounds(820,320,320,40);

        frame.add(LOGIN);
        frame.add(REGIST);
        frame.add(ACCOUNT);
        frame.add(PASSWORD);
        frame.add(jtf);
        frame.add(jpf);

        LOGIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //加登录验证
                new Tray_view();
                frame.setVisible(false);
            }
        });

        REGIST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                new Tray_Regist();
            }
        });

        frame.setVisible(true);
    }
}
