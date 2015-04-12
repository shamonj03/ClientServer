package com.joe.client.encoder;

import java.nio.ByteBuffer;

import com.joe.io.PacketEncoder;
import com.joe.model.User;
import com.joe.util.BufferUtil;

public class HelloWorldEncoder implements PacketEncoder {

	@Override
	public void encode(User user, ByteBuffer buffer) {
		BufferUtil.putString(buffer, "Hello world!");
		buffer.putInt(123);
	}

}
