package client.tray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tray_view {
    public Tray_view(){
        final JFrame frame = new JFrame("TrayTest");
        frame.setBounds(320,150,1280, 720);
        frame.setDefaultCloseOperation(WindowConstants.HIDE_ON_CLOSE); // 点击关闭按钮时隐藏窗口
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new WindowCloseAction();
            }
        });

        if (SystemTray.isSupported()){
            // 获取当前平台的系统托盘
            SystemTray tray = SystemTray.getSystemTray();
            // 加载一个图片用于托盘图标的显示
            Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\11578\\IdeaProjects\\Easyduino\\src\\main\\resources\\wy.png");

            // 创建点击图标时的弹出菜单
            PopupMenu popupMenu = new PopupMenu();
            MenuItem openItem = new MenuItem("open");
            MenuItem exitItem = new MenuItem("exit");
            popupMenu.add(openItem);
            popupMenu.add(exitItem);

            // 创建一个托盘图标
            TrayIcon trayIcon = new TrayIcon(image,"托盘",popupMenu);
            // 托盘图标自适应尺寸
            trayIcon.setImageAutoSize(true);

            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 点击退出菜单时退出程序
                    System.exit(0);
                }
            });

            // 创建点击图标时的弹出菜单
            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 创建点击图标时的弹出菜单
                    if (!frame.isShowing()){
                        frame.setVisible(true);
                    }
                }
            });

            trayIcon.addMouseListener(new MouseAdapter() {
                @Override
                public void mouseClicked(MouseEvent e) {
                    switch (e.getButton()){
                        case MouseEvent.BUTTON1:{
                            System.out.println("托盘被鼠标左键点击");
                            break;
                        }
                        case MouseEvent.BUTTON2:{
                            System.out.println("托盘被鼠标中键点击");
                            break;
                        }
                        case MouseEvent.BUTTON3:{
                            System.out.println("托盘被鼠标右键点击");
                            break;
                        }
                    }
                }
            });

            // 添加托盘图标到系统托盘
            try {
                tray.add(trayIcon);
            } catch (AWTException e) {
                e.printStackTrace();
            }
        }else {
            System.out.println("当前系统不支持系统托盘");
        }
        frame.setVisible(true);
    }
}
