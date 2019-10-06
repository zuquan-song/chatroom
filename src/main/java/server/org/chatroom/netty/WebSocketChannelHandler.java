package server.org.chatroom.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;

public class WebSocketChannelHandler extends ChannelInitializer<SocketChannel> {

    @Override
    protected void initChannel(SocketChannel sc) throws Exception {
        sc.pipeline().addLast("http-codec", new HttpServerCodec());
        sc.pipeline().addLast("aggregator", new HttpObjectAggregator(65536));
        sc.pipeline().addLast("handler", new WebSocketHandler());
    }
}
