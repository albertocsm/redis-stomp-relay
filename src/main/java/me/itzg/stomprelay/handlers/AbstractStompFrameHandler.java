package me.itzg.stomprelay.handlers;

import io.netty.channel.ChannelHandlerContext;
import io.netty.handler.codec.stomp.DefaultStompFrame;
import io.netty.handler.codec.stomp.StompHeaders;

/**
 * @author Geoff Bourne
 */
public abstract class AbstractStompFrameHandler implements StompFrameHandler {
    protected ChannelHandlerContext context;
    protected StompHeaders headers;
    protected DefaultStompFrame response;
    protected boolean closeAfterResponse;

    public AbstractStompFrameHandler(ChannelHandlerContext context, StompHeaders headers) {
        this.headers = headers;
        this.context = context;
    }

    @Override
    public DefaultStompFrame getResponse() {
        return response;
    }

    @Override
    public boolean isCloseAfterResponse() {
        return closeAfterResponse;
    }

    @Override
    public abstract StompFrameHandler invoke();

    public static boolean arrayContains(String[] acceptedVersions, String value) {
        for (String entry : acceptedVersions) {
            if (entry.equals(value)) {
                return true;
            }
        }
        return false;
    }
}