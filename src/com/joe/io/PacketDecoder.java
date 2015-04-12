package com.joe.io;

import java.nio.ByteBuffer;

import com.joe.model.User;

@FunctionalInterface
public interface PacketDecoder {

	public void decode(User user, ByteBuffer buffer);

}
