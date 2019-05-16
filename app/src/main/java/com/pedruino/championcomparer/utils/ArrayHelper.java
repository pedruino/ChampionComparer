package com.pedruino.championcomparer.utils;

public final class ArrayHelper {

    /**
     * Joins all array elements into single string
     *
     * @param elements  a array of elements
     * @param separator the character separator
     * @return
     */
    public static final String stringJoin(int[] elements, char separator) {
        StringBuilder builder = new StringBuilder();

        builder.append(elements[0]);

        for (int i = 1; i < elements.length; i++) {
            builder.append(separator).append(elements[i]);
        }

        return builder.toString();
    }
}
