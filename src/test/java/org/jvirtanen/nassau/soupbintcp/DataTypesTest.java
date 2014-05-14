package org.jvirtanen.nassau.soupbintcp;

import static org.junit.Assert.*;
import static org.jvirtanen.nassau.soupbintcp.DataTypes.*;
import static org.jvirtanen.nassau.util.Strings.*;

import java.nio.ByteBuffer;
import org.junit.Test;

public class DataTypesTest {

    @Test
    public void gettingAlphanumeric() {
        ByteBuffer buffer = wrap("foo");

        assertEquals("foo", getAlphanumeric(buffer, 3));
    }

    @Test
    public void gettingNumeric() {
        ByteBuffer buffer = wrap("123");

        assertEquals(123, getNumeric(buffer, 3));
    }

    @Test
    public void gettingNumericPadLeft() {
        ByteBuffer buffer = wrap(" 12");

        assertEquals(12, getNumeric(buffer, 3));
    }

    @Test
    public void puttingAlphanumericPadLeft() {
        ByteBuffer buffer = ByteBuffer.allocate(3);

        putAlphanumericPadLeft(buffer, "foo", 3);
        buffer.flip();

        assertEquals("foo", remaining(buffer));
    }

    @Test
    public void puttingTooLongAlphanumericPadLeft() {
        ByteBuffer buffer = ByteBuffer.allocate(2);

        putAlphanumericPadLeft(buffer, "foo", 2);
        buffer.flip();

        assertEquals("oo", remaining(buffer));
    }

    @Test
    public void puttingTooShortAlphanumericPadLeft() {
        ByteBuffer buffer = ByteBuffer.allocate(4);

        putAlphanumericPadLeft(buffer, "foo", 4);
        buffer.flip();

        assertEquals(" foo", remaining(buffer));
    }

    @Test
    public void puttingAlphanumericPadRight() {
        ByteBuffer buffer = ByteBuffer.allocate(3);

        putAlphanumericPadRight(buffer, "foo", 3);
        buffer.flip();

        assertEquals("foo", remaining(buffer));
    }

    @Test
    public void puttingTooLongAlphanumericPadRight() {
        ByteBuffer buffer = ByteBuffer.allocate(2);

        putAlphanumericPadRight(buffer, "foo", 2);
        buffer.flip();

        assertEquals("fo", remaining(buffer));
    }

    @Test
    public void puttingTooShortAlphanumericPadRight() {
        ByteBuffer buffer = ByteBuffer.allocate(4);

        putAlphanumericPadRight(buffer, "foo", 4);
        buffer.flip();

        assertEquals("foo ", remaining(buffer));
    }

    @Test
    public void puttingNumeric() {
        ByteBuffer buffer = ByteBuffer.allocate(3);

        putNumeric(buffer, 123, 3);
        buffer.flip();

        assertEquals("123", remaining(buffer));
    }

    @Test
    public void puttingTooLongNumeric() {
        ByteBuffer buffer = ByteBuffer.allocate(2);

        putNumeric(buffer, 123, 2);
        buffer.flip();

        assertEquals("23", remaining(buffer));
    }

    @Test
    public void puttingTooShortNumeric() {
        ByteBuffer buffer = ByteBuffer.allocate(4);

        putNumeric(buffer, 123, 4);
        buffer.flip();

        assertEquals(" 123", remaining(buffer));
    }

}
