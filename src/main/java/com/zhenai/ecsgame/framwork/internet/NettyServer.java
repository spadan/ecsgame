package com.zhenai.ecsgame.framwork.internet;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.ChannelOption;
import io.netty.channel.EventLoopGroup;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;

import java.net.InetSocketAddress;

/**
 * @Auther: haitong.zhang
 * @Date: 2019/12/31/18:05
 * @Description:
 */
public class NettyServer {
    public void start(InetSocketAddress socketAddress) {

//        EventLoopGroup
        NioEventLoopGroup bossGroup = new NioEventLoopGroup(1);
        NioEventLoopGroup workGroup = new NioEventLoopGroup(200);

        ServerBootstrap bootstrap = new ServerBootstrap()
                .group(bossGroup, workGroup)
                .channel(NioServerSocketChannel.class)
                .childHandler(new ServerChannelInitializer())
                .localAddress(socketAddress)
                ////设置队列大小
                .option(ChannelOption.SO_BACKLOG, 1024);

        try {
            ChannelFuture future = bootstrap.bind(socketAddress).sync();
            System.out.println("服务开始，开始监听端口:"+socketAddress.getPort());
            future.channel().closeFuture().sync();
        } catch (InterruptedException e) {
            e.printStackTrace();
        }finally {
            bossGroup.shutdownGracefully();
            workGroup.shutdownGracefully();
        }


    }
}
