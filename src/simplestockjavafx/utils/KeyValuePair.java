/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package simplestockjavafx.utils;

/**
 *
 * @author macako
 */
public class KeyValuePair {

    private final Integer key;
    private final String value;

    public KeyValuePair(Integer key, String value) {
        this.key = key;
        this.value = value;
    }

    public Integer getKey() {
        return key;
    }

    public String toString() {
        return value;
    }
}
