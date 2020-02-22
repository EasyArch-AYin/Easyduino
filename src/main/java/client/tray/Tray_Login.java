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
        LOGIN.setBounds(20,245 ,320,60);
        JButton REGIST = new JButton("点我注册");
        REGIST.setBounds(20,200,100,20);

        JLabel ACCOUNT = new JLabel("账号");
        ACCOUNT.setBounds(20,20,40,20);
        JLabel PASSWORD = new JLabel("密码");
        PASSWORD.setBounds(20,120,40,20);


        final JTextField jtf = new JTextField();
        final JPasswordField jpf = new JPasswordField();
        jtf.setBounds(20,40,320,40);
        jpf.setBounds(20,140,320,40);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setBounds(800,180,360,340);

        panel.add(LOGIN);
        panel.add(REGIST);
        panel.add(ACCOUNT);
        panel.add(PASSWORD);
        panel.add(jtf);
        panel.add(jpf);
        frame.add(panel);

        LOGIN.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //加登录验证
                new Tray_view(ACCOUNT.getText());
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
