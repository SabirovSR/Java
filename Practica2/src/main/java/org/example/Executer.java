package org.example;

public class Executer {
    private ICpu cpu;

    public Executer(ICpu cpu) {
        this.cpu = cpu;
    }

    public void run(Program program) throws Exception {
        for (int i = 0; i < program.i; i++) {
            cpu.exec(program.get(i));
        }
    }
}