package server.dataServer;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.nio.NioDatagramChannel;

public class DataServerInitializer extends ChannelInitializer<NioDatagramChannel> {

    protected void initChannel(NioDatagramChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();

        pipeline.addLast("MyDataServerHandler",new DataServerHandler());
    }
}
