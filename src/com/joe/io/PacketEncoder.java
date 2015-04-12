package com.joe.io;

import java.nio.ByteBuffer;

import com.joe.model.User;

@FunctionalInterface
public interface PacketEncoder {

	public void encode(User user, ByteBuffer buffer);

}
