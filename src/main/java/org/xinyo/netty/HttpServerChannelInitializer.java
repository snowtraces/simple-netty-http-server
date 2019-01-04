package org.xinyo.netty;

import io.netty.channel.ChannelInitializer;
import io.netty.channel.ChannelPipeline;
import io.netty.channel.socket.SocketChannel;
import io.netty.handler.codec.http.HttpObjectAggregator;
import io.netty.handler.codec.http.HttpServerCodec;
import io.netty.handler.stream.ChunkedWriteHandler;
import io.netty.util.concurrent.DefaultEventExecutorGroup;
import io.netty.util.concurrent.EventExecutorGroup;

public class HttpServerChannelInitializer extends ChannelInitializer<SocketChannel> {
    static final EventExecutorGroup eventExecutors = new DefaultEventExecutorGroup(16);

@Override
    protected void initChannel(SocketChannel ch) throws Exception {
        ChannelPipeline pipeline = ch.pipeline();
        pipeline.addLast(
                new HttpServerCodec(),
                new HttpObjectAggregator(1024 * 1024),
                new ChunkedWriteHandler()
        );
        pipeline.addLast(eventExecutors, new HttpServerHandler());
    }
}
