package com.zhenai.ecsgame.framwork.internet;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.codec.http.websocketx.WebSocketServerProtocolHandler;
import io.netty.handler.codec.string.StringDecoder;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.CharsetUtil;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/18:02
 * @Description:
 */
public class ServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    @Override
    protected void initChannel(SocketChannel socketChannel) throws Exception {
//        socketChannel.pipeline().addLast(new HttpServerCodec());
//        socketChannel.pipeline().addLast(new ChunkedWriteHandler());
//        socketChannel.pipeline().addLast(new HttpObjectAggregator(8192));
//        socketChannel.pipeline().addLast(new WebSocketServerProtocolHandler("/ws", "WebSocket", true, 65536 * 10));
        socketChannel.pipeline().addLast("decoder",new StringDecoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast("encoder",new StringDecoder(CharsetUtil.UTF_8));
        socketChannel.pipeline().addLast(new NettyServerHandler());
    }
}
