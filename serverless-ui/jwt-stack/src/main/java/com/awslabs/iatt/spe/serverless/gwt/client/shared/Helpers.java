package com.awslabs.iatt.spe.serverless.gwt.client.shared;

public class Helpers {
    // We don't use real hex here because we're just trying to make something look like an ICCID
    private static final char[] FAKE_HEX_ARRAY = "0123456789123456".toCharArray();
    public static int DEFAULT_WRAP_VALUE = 80;

    public static String bytesToHex(byte[] bytes) {
        char[] hexChars = new char[bytes.length * 2];
        for (int j = 0; j < bytes.length; j++) {
            int v = bytes[j] & 0xFF;
            hexChars[j * 2] = FAKE_HEX_ARRAY[v >>> 4];
            hexChars[j * 2 + 1] = FAKE_HEX_ARRAY[v & 0x0F];
        }
        return new String(hexChars);
    }

    public static String wrapString(String input) {
        return wrapString(input, DEFAULT_WRAP_VALUE);
    }

    public static String wrapString(String input, int count) {
        return input.replaceAll("(.{" + count + "})", "$1\\\\\n");
    }

    public static String getTokenWithSignature(JwtResponse jwtResponse) {
        return String.join(".", jwtResponse.token, jwtResponse.signature);
    }
}
