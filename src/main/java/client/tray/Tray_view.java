package client.tray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class Tray_view {
        static final JFrame frame = new JFrame("TrayTest");
    public Tray_view(){

        frame.setBounds(320,150,1280, 720);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        //点击退出时弹出选择窗口
        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                new WindowCloseAction();
            }
        });

        //添加托盘
        if (SystemTray.isSupported()){
            // 获取当前平台的系统托盘
            final SystemTray tray = SystemTray.getSystemTray();
            // 加载一个图片用于托盘图标的显示
            Image image = Toolkit.getDefaultToolkit().getImage("C:\\Users\\11578\\IdeaProjects\\Easyduino\\src\\main\\resources\\wy.png");

            // 创建点击图标时的弹出菜单
            PopupMenu popupMenu = new PopupMenu();
            MenuItem openItem = new MenuItem("open");
            MenuItem exitItem = new MenuItem("exit");
            popupMenu.add(openItem);
            popupMenu.add(exitItem);

            // 创建一个托盘图标
            final TrayIcon trayIcon = new TrayIcon(image,"托盘",popupMenu);
            // 托盘图标自适应尺寸
            trayIcon.setImageAutoSize(true);

            exitItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    // 点击退出菜单时退出程序
                    System.exit(0);
                }
            });

            openItem.addActionListener(new ActionListener() {
                @Override
                public void actionPerformed(ActionEvent e) {
                    //点击打开时弹出界面
                    frame.setVisible(true);
                }
            });

            // 添加托盘图标到系统托盘
            try {
                tray.add(trayIcon);
            } catch (AWTException ex) {
                ex.printStackTrace();
            }
        }else {
            System.out.println("当前系统不支持系统托盘");
        }

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new Tray_view();
    }
}
