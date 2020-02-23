package server.dataServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class DataServerInitializer extends ChannelInitializer<NioDatagramChannel> {

    private DataServerHandler dataServerHandler = new DataServerHandler();

    protected void initChannel(NioDatagramChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("MyDataServerHandler",this.dataServerHandler);
    }
    //用于获取Handler对象
    DataServerHandler getDataServerHandler(){
        return this.dataServerHandler;
    }
}
