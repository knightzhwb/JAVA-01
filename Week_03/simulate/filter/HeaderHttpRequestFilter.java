package simulate.filter;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.http.FullHttpRequest;

public class HeaderHttpRequestFilter{
//    public void filter(FullHttpRequest fullRequest, ChannelHandlerContext ctx) {
//        fullRequest.headers().set("mao", "soul");
//    }
    public void filter(FullHttpRequest fullRequest) {
        fullRequest.headers().set("mao","soul");
    }
}
