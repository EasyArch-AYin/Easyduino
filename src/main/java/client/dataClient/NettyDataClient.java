package client.dataClient;

import io.netty.bootstrap.Bootstrap;
import io.netty.channel.Channel;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioDatagramChannel;


public class NettyDataClient {

    private EventLoopGroup group;
    private Bootstrap bootstrap;
    private Channel channel;

    //netty运行
    public void run(int PORT){

        group = new NioEventLoopGroup();

        bootstrap = new Bootstrap();

        bootstrap.group(group)
                .channel(NioDatagramChannel.class)
                .option(ChannelOption.SO_BROADCAST,true)
                .handler(new DataClientHanler());



        try {
            this.channel = bootstrap.bind(PORT).sync().channel();
            this.channel.closeFuture().await();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            group.shutdownGracefully();
        }
        System.out.println("客户端启动成功");

    }
    //得到channel用于传输数据
    public Channel getChannel(){
        return this.channel;
    }

    public static void main(String[] args){
        NettyDataClient Data = new NettyDataClient();
        Data.run(0);
    }
}
