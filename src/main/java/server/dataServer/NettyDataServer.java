package server.dataServer;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class NettyDataServer {

    private EventLoopGroup group;
    private Bootstrap bootstrap;
    private Channel channel;
    private DataServerInitializer initializer = new DataServerInitializer();
    public void run() {

            group = new NioEventLoopGroup();
            bootstrap = new Bootstrap();

            bootstrap.group(group)
                    .channel(NioDatagramChannel.class)
                    .option(ChannelOption.SO_BROADCAST, true)
                    .handler(this.initializer);

            try {
                this.channel = bootstrap.bind("127.0.0.1", 8087).sync().channel();
                System.out.println("服务器启动成功");
                this.channel.closeFuture().await();
            } catch (InterruptedException e) {
                e.printStackTrace();
            } finally {
                group.shutdownGracefully();
            }
    }

    //用于获取channel
    public Channel getChannel(){
        return this.channel;
    }

    //用于获取Initializer对象
    public DataServerInitializer getInitializer(){return this.initializer;}
}
