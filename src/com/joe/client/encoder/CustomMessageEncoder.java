package com.joe.client.encoder;

import java.nio.ByteBuffer;

import com.joe.io.PacketEncoder;
import com.joe.model.User;
import com.joe.util.BufferUtil;

public class CustomMessageEncoder implements PacketEncoder {

	private String message;

	public CustomMessageEncoder(String message) {
		this.message = message;
	}

	@Override
	public void encode(User user, ByteBuffer buffer) {
		BufferUtil.putString(buffer, message);
	}

}
