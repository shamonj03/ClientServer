package com.joe.io;

import java.nio.ByteBuffer;
import java.util.HashMap;

import com.joe.model.User;

public abstract class IncomingPacketHandler {

	private HashMap<Integer, PacketDecoder> packets = new HashMap<>();

	public IncomingPacketHandler() {
		definePackets();
	}

	public abstract void definePackets();

	public void process(User user, int packetId, ByteBuffer buffer) {
		if (!packets.containsKey(packetId)) {
			System.out.println("Invalid packet for " + packetId);
			return;
		}
		PacketDecoder packet = packets.get(packetId);
		packet.decode(user, buffer);
	}

	public void setPacket(int packetId, PacketDecoder packet) {
		packets.put(packetId, packet);
	}
}
