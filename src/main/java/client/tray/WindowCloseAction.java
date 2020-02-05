package client.tray;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;

public class WindowCloseAction {
    public WindowCloseAction() {
        final JFrame frame = new JFrame("TrayTest");
        frame.setSize(300, 300);
        frame.setLayout(new GridLayout(3, 3));
        frame.setLocationRelativeTo(null);

        final JRadioButton TRAY = new JRadioButton("最小化到托盘");
        final JRadioButton CLOSE = new JRadioButton("退出程序");
        ButtonGroup group = new ButtonGroup();

        JButton jButton = new JButton("确定");

        group.add(TRAY);
        group.add(CLOSE);

        frame.add(TRAY);
        frame.add(CLOSE);
        frame.add(jButton);



        frame.addWindowListener(new WindowAdapter() {
            @Override
            public void windowClosing(WindowEvent e) {
                frame.setVisible(false);
            }
        });

        jButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                if (TRAY.isSelected()){
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
                        frame.setVisible(false);
                        // 添加托盘图标到系统托盘
                        try {
                            tray.add(trayIcon);
                        } catch (AWTException ex) {
                            ex.printStackTrace();
                        }
                    }else {
                        System.out.println("当前系统不支持系统托盘");
                        frame.setVisible(false);
                    }
                }else if (CLOSE.isSelected()){
                    System.exit(0);
                }
            }
        });

        frame.setVisible(true);
    }

    public static void main(String[] args) {
        new WindowCloseAction();
    }
}
