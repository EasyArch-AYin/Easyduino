package client.tray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;

class Tray_Regist {
    Tray_Regist() {
        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(730, 250, 460, 520);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel ACCOUNT = new JLabel("账号");
        ACCOUNT.setBounds(150,130,40,20);
        JLabel PASSWORD = new JLabel("密码");
        PASSWORD.setBounds(150,190,40,20);

        final JTextField jtf = new JTextField();
        final JPasswordField jpf = new JPasswordField();
        jtf.setBounds(150,150,200,40);
        jpf.setBounds(150,210,200,40);

        JButton REGIST = new JButton("确定");
        REGIST.setBounds(180,380,120,40);

        frame.add(ACCOUNT);
        frame.add(PASSWORD);
        frame.add(jtf);
        frame.add(jpf);
        frame.add(REGIST);

        REGIST.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                //加入库方法
                new ActionSuccess();
                frame.setVisible(false);
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Tray_Regist();
    }
}
