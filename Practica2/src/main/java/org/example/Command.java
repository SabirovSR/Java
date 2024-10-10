package org.example;

public class Command {
    private String command;
    private String[] args;

    @Override
    public String toString() {
        return command + " ";
    }

    //String... — это синтаксис, который используется для работы с переменным количеством аргументов в методах Java.
    // Это называется varargs (variable arguments).
    //Когда вы объявляете метод с аргументом вида String... args, это означает,
    // что метод может принимать любое количество строковых аргументов (включая 0),
    // которые внутри метода будут восприниматься как массив.
    public Command(String command, String... args) {
        this.command = command;
        this.args = args;
    }

    public String getCommand() {
        return command;
    }

    public String[] getArgs() {
        return args;
    }
}