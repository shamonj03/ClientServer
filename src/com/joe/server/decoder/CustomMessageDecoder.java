package com.joe.server.decoder;

import java.nio.ByteBuffer;

import com.joe.io.PacketDecoder;
import com.joe.model.User;
import com.joe.util.BufferUtil;

public class CustomMessageDecoder implements PacketDecoder {

	@Override
	public void decode(User user, ByteBuffer buffer) {
		String message = BufferUtil.getString(buffer);

		System.out.println(message);
	}

}
