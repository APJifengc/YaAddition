package io.github.apjifengc.yaaddition.util;

import com.google.gson.*;
import lombok.Getter;

import java.math.BigDecimal;
import java.math.BigInteger;

/**
 * This presents a JSON-like data for blocks, items and so on.
 *
 * @author APJifengc
 */
public class Data {
    private static JsonParser parser = new JsonParser();
    @Getter
    private final JsonObject jsonObject;

    /**
     * Create an empty data.
     */
    public Data() {
        this.jsonObject = new JsonObject();
    }

    /**
     * Create a data from a JSON string.
     *
     * @param json The JSON string.
     * @throws IllegalArgumentException Throws when the JSON string is not a JSON object.
     */
    public Data(String json) throws IllegalArgumentException {
        try {
            this.jsonObject = (JsonObject) parser.parse(json);
        } catch (ClassCastException e) {
            throw new IllegalArgumentException("The JSON string '" + json + "' is not a JSON object");
        }
    }

    /**
     * Create a data from a JSON object.
     *
     * @param object The JSON object.
     */
    public Data(JsonObject object) {
        this.jsonObject = object;
    }

    /**
     * Get the data's content by path.
     *
     * @param path The path to the value. <p/>
     *             eg. <br/>
     *             {@code get("foo", "bar")} -> {@code foo.bar} <br/>
     *             {@code get("array", 5)} -> {@code array[5]} <br/>
     * @return Return the JSON element to the path.
     */
    public JsonElement get(Object... path) {
        JsonElement element = jsonObject;
        for (Object object : path) {
            if (object instanceof String) {
                element = element.getAsJsonObject().get((String) object);
            } else if (object instanceof Integer) {
                element = element.getAsJsonArray().get((Integer) object);
            }
        }
        return element;
    }

    /**
     * Get the data's int by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the int value to the path.
     * @see Data#get
     */
    public int getInt(Object... path) {
        return get(path).getAsInt();
    }

    /**
     * Get the data's long by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the long value to the path.
     * @see Data#get
     */
    public long getLong(Object... path) {
        return get(path).getAsLong();
    }

    /**
     * Get the data's short by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the short value to the path.
     * @see Data#get
     */
    public short getShort(Object... path) {
        return get(path).getAsShort();
    }

    /**
     * Get the data's float by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the float value to the path.
     * @see Data#get
     */
    public float getFloat(Object... path) {
        return get(path).getAsFloat();
    }

    /**
     * Get the data's double by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the double value to the path.
     * @see Data#get
     */
    public double getDouble(Object... path) {
        return get(path).getAsDouble();
    }

    /**
     * Get the data's number by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the number value to the path.
     * @see Data#get
     */
    public Number getNumber(Object... path) {
        return get(path).getAsNumber();
    }

    /**
     * Get the data's boolean by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the boolean value to the path.
     * @see Data#get
     */
    public boolean getBoolean(Object... path) {
        return get(path).getAsBoolean();
    }

    /**
     * Get the data's character by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the character value to the path.
     * @see Data#get
     */
    public char getCharacter(Object... path) {
        return get(path).getAsCharacter();
    }

    /**
     * Get the data's byte by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the byte value to the path.
     * @see Data#get
     */
    public byte getByte(Object... path) {
        return get(path).getAsByte();
    }

    /**
     * Get the data's string by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the string value to the path.
     * @see Data#get
     */
    public String getString(Object... path) {
        return get(path).getAsString();
    }

    /**
     * Get the data's big integer by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the big integer value to the path.
     * @see Data#get
     */
    public BigInteger getBigInteger(Object... path) {
        return get(path).getAsBigInteger();
    }

    /**
     * Get the data's big decimal by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the big decimal value to the path.
     * @see Data#get
     */
    public BigDecimal getBigDecimal(Object... path) {
        return get(path).getAsBigDecimal();
    }

    /**
     * Get the data's array by path.
     *
     * @param path See {@link Data#get}.
     * @return Return the array value to the path.
     * @see Data#get
     */
    public JsonArray getArray(Object... path) {
        return get(path).getAsJsonArray();
    }

    /**
     * Set the value to the path.
     *
     * @param value The value to set.
     * @param path  See (@link Data#get}
     */
    public void set(Object value, Object... path) {
        JsonElement element = jsonObject;
        for (int i = 0; i < path.length - 1; i++) {
            Object object = path[i];
            if (object instanceof String) {
                String string = (String) object;
                JsonObject jsonObject = element.getAsJsonObject();
                if (!jsonObject.has(string)) jsonObject.add(string, createEmptyElement(path[i+1]));
                element = jsonObject.get(string);
            } else if (object instanceof Integer) {
                int integer = (Integer) object;
                JsonArray jsonArray = element.getAsJsonArray();
                while (jsonArray.size() <= integer) jsonArray.add(createEmptyElement(path[i+1]));
                element = jsonArray.get(integer);
            }
        }
        if (path[path.length - 1] instanceof String) {
            String string = (String) path[path.length - 1];
            element.getAsJsonObject().add(string, createJsonPrimitive(value));
        } else if (path[path.length - 1] instanceof Integer) {
            int integer = (Integer) path[path.length - 1];
            JsonArray jsonArray = element.getAsJsonArray();
            while (jsonArray.size() < integer) jsonArray.add(new JsonObject());
            jsonArray.add(createJsonPrimitive(value));
        }
    }

    private JsonElement createEmptyElement(Object path) {
        if (path instanceof String) return new JsonObject();
        else if (path instanceof Integer) return new JsonArray();
        return null;
    }

    private JsonPrimitive createJsonPrimitive(Object object) {
        if (object instanceof Number) return new JsonPrimitive((Number) object);
        if (object instanceof String) return new JsonPrimitive((String) object);
        if (object instanceof Character) return new JsonPrimitive((Character) object);
        if (object instanceof Boolean) return new JsonPrimitive((Boolean) object);
        return null;
    }

    @Override
    public String toString() {
        return jsonObject.toString();
    }
}
