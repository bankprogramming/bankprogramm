package de.bankprogramming.wrappers;

/**
 * Created by Czichotzki on 28.05.2017.
 */
public interface Wrapper<T>{
    public T getOriginal();
    public void updateValues();
}
