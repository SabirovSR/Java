package org.example;

public class Executer {
    private ICpu cpu;

    public Executer(ICpu cpu) {
        this.cpu = cpu;
    }

    public void run(Command[] program) {
        for (Command cmd : program) {
            cpu.exec(cmd);
        }
    }
}