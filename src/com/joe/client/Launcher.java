package com.joe.client;

import java.io.IOException;
import java.net.Socket;
import java.net.UnknownHostException;

public class Launcher {

	/**
	 * Port server is listed on.
	 */
	private static final int PORT = 43594;

	/**
	 * IP server is listed on.
	 */
	private static final String HOST = "127.0.0.1";

	public static void main(String[] args) {
		connect();
	}

	/**
	 * Connect to server.
	 */
	public static void connect() {
		try {
			Socket socket = new Socket(HOST, PORT);
			System.out.println("Connected");

			ClientSideUser user = new ClientSideUser(socket);

			new Thread(user).start();
		} catch (UnknownHostException e) {
			e.printStackTrace();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

}
