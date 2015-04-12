package com.joe.server;

import java.io.IOException;
import java.net.InetSocketAddress;
import java.net.ServerSocket;
import java.net.Socket;
import java.util.ArrayList;

public final class Server {
	/**
	 * Port server is listed on.
	 */
	private static final int PORT = 43594;

	/**
	 * IP server is listed on.
	 */
	private static final String HOST = "127.0.0.1";

	/**
	 * Is the server running.
	 */
	private boolean running = true;

	/**
	 * Clients connected to the server.
	 */
	private static final ArrayList<ServerSideUser> clients = new ArrayList<>();

	public static void main(String[] args) {
		Server server = new Server();
		server.start();
	}

	/**
	 * Start the server.
	 */
	public final void start() {
		try (ServerSocket serverSocket = new ServerSocket()) {
			InetSocketAddress address = new InetSocketAddress(HOST, PORT);

			serverSocket.bind(address);

			System.out.println("Listening server on " + address.toString());

			handleConnections(serverSocket);
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Handle incoming connections. On socket accept create a new thread for the
	 * client.
	 * 
	 * @param serverSocket
	 *            The server socket the server is bound to.
	 */
	private final void handleConnections(ServerSocket serverSocket) {
		while (running) {
			try {
				Socket socket = serverSocket.accept();

				ServerSideUser client = new ServerSideUser(socket);
				clients.add(client);
				new Thread(client).start();

				System.out.println(socket);
			} catch (IOException e) {
				e.printStackTrace();
			}
		}
	}

	/**
	 * @return list of clients.
	 */
	public static final ArrayList<ServerSideUser> getClients() {
		return clients;
	}
}
