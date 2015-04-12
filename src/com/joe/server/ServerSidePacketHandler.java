package com.joe.server;

import com.joe.io.IncomingPacketHandler;
import com.joe.server.decoder.CustomMessageDecoder;
import com.joe.server.decoder.HelloWorldDecoder;
import com.joe.util.BufferUtil;

public class ServerSidePacketHandler extends IncomingPacketHandler {

	@Override
	public void definePackets() {
		setPacket(1, new HelloWorldDecoder());

		setPacket(2, (user, in) -> {
			String message = BufferUtil.getString(in);

			System.out.println(message);
		});

		setPacket(3, new CustomMessageDecoder());
	}
}
