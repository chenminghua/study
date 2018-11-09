package com.meiling.syll.lg;

import org.quickserver.net.server.ClientCommandHandler;
import org.quickserver.net.server.ClientHandler;

import java.io.IOException;
import java.net.SocketTimeoutException;

/**
 * @author: minghua
 * @date: 2018/11/9 16:37
 * @modified By:
 */
public class MainHandler implements ClientCommandHandler {

    @Override
    public void gotConnected(ClientHandler handler)
            throws SocketTimeoutException, IOException {
        System.out.println("Got Client: " +
                handler.getSocket().getInetAddress());
        handler.sendClientMsg("Hello Word!");
    }

    @Override
    public void handleCommand(ClientHandler handler, String command)
            throws SocketTimeoutException, IOException {
        if (command.equals("quit")) {
            handler.sendClientMsg("bye");
            handler.closeConnection();
        } else {
            handler.sendClientMsg("You Sent: " + command);
        }
    }

    @Override
    public void lostConnection(ClientHandler clientHandler) throws IOException {

    }

    @Override
    public void closingConnection(ClientHandler clientHandler) throws IOException {

    }


}
