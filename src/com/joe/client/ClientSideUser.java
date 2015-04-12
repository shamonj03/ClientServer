package com.joe.client;

import java.io.IOException;
import java.net.Socket;

import com.joe.client.encoder.CustomMessageEncoder;
import com.joe.client.encoder.HelloWorldEncoder;
import com.joe.model.User;
import com.joe.util.BufferUtil;

public final class ClientSideUser extends User {

	public ClientSideUser(Socket socket) throws IOException {
		super(socket, new ClientSidePacketHandler());

		System.out.println("test");

		/*
		 * Example packet using encoder.
		 */
		sendData(1, new HelloWorldEncoder());

		/*
		 * Example packet using anonymous class.
		 */
		sendData(2, (user, out) -> {
			BufferUtil.putString(out, "testing lololo");
		});

		/*
		 * Example packet using variable data.
		 */
		sendData(3, new CustomMessageEncoder("Hi how are you?"));
		sendData(3, new CustomMessageEncoder("Testing 123!"));
	}
}