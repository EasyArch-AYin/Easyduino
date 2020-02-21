package client.tray;

import client.dataClient.NettyDataClient;

import javax.swing.*;
import java.awt.*;
import java.awt.event.*;
import java.io.IOException;
import java.net.URI;
import java.nio.channels.Channel;

public class Tray_view {
    static final JFrame frame = new JFrame("TrayTest");
    Channel channel = (Channel) new NettyDataClient().run(0);
    Tray_view(){
        //打开界面和启动托盘
        view();

    }

    public void view(){
        frame.setBounds(320,150,1280, 720);
        frame.setLayout(null);
        frame.setLocationRelativeTo(null);

        JButton StartGame = new JButton("开始游戏");
        StartGame.setBounds(600,570,150,60);

        JTextField FRIEND = new JTextField("请输入id");
        FRIEND.setBounds(0,0,260,40);

        JPanel panel = new JPanel();
        panel.setLayout(null);
        panel.setBorder(BorderFactory.createEtchedBorder());
        panel.setBounds(1000,200,260,420);

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
        //开始游戏
        StartGame.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                try {
                    Desktop.getDesktop().browse(URI.create("https://scratch.mit.edu/"));
//                  Desktop.getDesktop().open(new File("C:\\Users\\11578\\IdeaProjects\\Easyduino\\src\\main\\java\\client\\tray\\test.html"));
                } catch (IOException ex) {
                    ex.printStackTrace();
                }
            }
        });
        //添加好友
        FRIEND.addKeyListener(new KeyAdapter() {
            @Override
            public void keyPressed(KeyEvent e) {
                if (e.getKeyCode() == 10){
                    //在库中查找有无此人的id，有则添加好友，无则返回没有
                    if (true){
                        //弹出添加好友窗口
                        String ID = FRIEND.getText();
                        new AddFriend((io.netty.channel.Channel) channel,ID);
                    }else {
                        //弹出无此人窗口
                        new NoFriend();
                    }
                }
            }
        });

        panel.add(FRIEND);
        frame.add(panel);
        frame.add(StartGame);

        frame.setVisible(true);

    }

    public static void main(String[] args) {
        new Tray_view();
    }
}
