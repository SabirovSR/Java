package org.example;

public interface IIterable {
    boolean hasNext();
    Command next() throws Exception;
}
