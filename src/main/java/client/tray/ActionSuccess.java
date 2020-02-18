package client.tray;

import javax.swing.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
/**
 * 操作成功页面
 */
public class ActionSuccess {
    ActionSuccess(){
        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(900, 400, 200, 200);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JLabel SUCCESS = new JLabel("操作成功");
        SUCCESS.setBounds(50,50,100,20);

        JButton CONFIRM = new JButton("确定");
        CONFIRM.setBounds(60,100,90,40);

        frame.add(SUCCESS);
        frame.add(CONFIRM);

        frame.setVisible(true);

        CONFIRM.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                frame.setVisible(false);
            }
        });
    }

    public static void main(String[] args) {
        new ActionSuccess();
    }
}
