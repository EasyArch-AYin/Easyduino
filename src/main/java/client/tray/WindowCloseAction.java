package client.tray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowCloseAction {
        private final JFrame frame = new JFrame("TrayTest");
    public WindowCloseAction() {

        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(3, 3));
        frame.setLocationRelativeTo(null);

        //添加单选按钮
        final JRadioButton TRAY = new JRadioButton("最小化到托盘");
        final JRadioButton CLOSE = new JRadioButton("退出程序");

        //添加按钮组并将两个单选按钮加入按钮组
        JButton jButton = new JButton("确定");
        ButtonGroup group = new ButtonGroup();
        group.add(TRAY);
        group.add(CLOSE);

        frame.add(TRAY);
        frame.add(CLOSE);
        frame.add(jButton);

        //添加关闭窗口的事件
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                //关闭窗口时打开view界面
                frame.setVisible(false);
                Tray_view.frame.setVisible(true);
            }
        });

        //点击确定时对选择的事件进行响应
        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TRAY.isSelected()){
                    //最小化时隐藏窗口
                    frame.setVisible(false);
                }else if (CLOSE.isSelected()){
                    //退出时退出程序
                    System.exit(0);
                }
            }
        });

        frame.setVisible(true);
    }
}
