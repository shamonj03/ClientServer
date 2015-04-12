package com.joe.server;

import java.io.IOException;
import java.net.Socket;

import com.joe.model.User;

public class ServerSideUser extends User {

	public ServerSideUser(Socket socket) throws IOException {
		super(socket, new ServerSidePacketHandler());
	}

	/*
	 * Do stuff pertaining to the user in here.
	 */
}
