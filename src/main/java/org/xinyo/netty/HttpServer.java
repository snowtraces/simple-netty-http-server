package org.xinyo.netty;

import io.netty.bootstrap.ServerBootstrap;
import io.netty.channel.ChannelFuture;
import io.netty.channel.nio.NioEventLoopGroup;
import io.netty.channel.socket.nio.NioServerSocketChannel;
import org.xinyo.controller.RestController;
import org.xinyo.init.BaseInitializer;
import org.xinyo.init.ControllerInitializer;
import org.xinyo.service.Service;

public class HttpServer {
    public static void main(String[] args) throws Exception{
        BaseInitializer initializer = new BaseInitializer();
        initializer
                .addController(RestController.class)
                .addService(Service.class)
                .init();


        NioEventLoopGroup bossGroup = new NioEventLoopGroup();
        NioEventLoopGroup workerGroup = new NioEventLoopGroup();
        try {
            ServerBootstrap bootstrap = new ServerBootstrap();
            bootstrap.group(bossGroup, workerGroup)
                    .channel(NioServerSocketChannel.class)
                    .childHandler(new HttpServerChannelInitializer());

            ChannelFuture future = bootstrap.bind(9090).sync();
            future.channel().closeFuture().sync();

        } finally {
            bossGroup.shutdownGracefully();
            workerGroup.shutdownGracefully();
        }
    }
}
