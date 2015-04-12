package com.joe.util;

import java.nio.ByteBuffer;

public class BufferUtil {
	/**
	 * Put a string into the buffer.
	 * 
	 * @param buffer
	 *            The buffer to store the message in.
	 * @param message
	 *            The message to put.
	 */
	public static void putString(ByteBuffer buffer, String message) {
		byte[] data = message.getBytes();

		buffer.putInt(data.length);
		buffer.put(data);
	}

	/**
	 * Get a string from a buffer.
	 * 
	 * @param buffer
	 *            The buffer to receive a string from.
	 * @return A string.
	 */
	public static String getString(ByteBuffer buffer) {
		int length = buffer.getInt();

		byte[] data = new byte[length];

		buffer.get(data, 0, length);

		return new String(data);
	}
}
