package com.joe.model;

import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.net.Socket;
import java.nio.ByteBuffer;

import com.joe.io.IncomingPacketHandler;
import com.joe.io.PacketEncoder;

public abstract class User implements Runnable {

	/**
	 * Data being sent out.
	 */
	private OutputStream dos;

	/**
	 * Data being received.
	 */
	private InputStream dis;
	/**
	 * Is the client still running.
	 */
	private boolean running = true;

	private IncomingPacketHandler packetHandler;

	public User(Socket socket, IncomingPacketHandler packetHandler) throws IOException {
		this.dos = socket.getOutputStream();
		this.dis = socket.getInputStream();
		this.packetHandler = packetHandler;
	}

	public void run() {
		while (running) {
			processIncomingPackets();
		}
	}

	/**
	 * Process incoming packets.
	 */
	private void processIncomingPackets() {
		byte[] inData = new byte[1024];

		try {
			if (dis.available() == 0) {
				return;
			}

			@SuppressWarnings("unused")
			int count = dis.read(inData);

			ByteBuffer buffer = ByteBuffer.wrap(inData);

			int packetId = buffer.getInt();

			packetHandler.process(this, packetId, buffer);

			buffer.flip();
			buffer.clear();
		} catch (IOException e) {
			e.printStackTrace();
		}
	}

	/**
	 * Send a packet.
	 * 
	 * @param id
	 *            Packet id to send.
	 * @param packet
	 *            Packet information to send.
	 */
	protected void sendData(int id, PacketEncoder packet) {
		ByteBuffer buffer = ByteBuffer.allocate(1024);
		buffer.putInt(id);
		packet.encode(this, buffer);
		buffer.flip();

		try {
			dos.write(buffer.array());
			dos.flush();
		} catch (IOException e) {
			e.printStackTrace();
		}
		buffer.clear();
		System.out.println("Sent packet " + id);
	}

	public InputStream getDis() {
		return dis;
	}

	public OutputStream getDos() {
		return dos;
	}

}
