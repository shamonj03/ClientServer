package com.joe.server.decoder;

import java.nio.ByteBuffer;

import com.joe.io.PacketDecoder;
import com.joe.model.User;
import com.joe.util.BufferUtil;

public class HelloWorldDecoder implements PacketDecoder {

	@Override
	public void decode(User user, ByteBuffer buffer) {
		String message = BufferUtil.getString(buffer);
		int number = buffer.getInt();

		System.out.println(message);
		System.out.println(number);
	}

}
