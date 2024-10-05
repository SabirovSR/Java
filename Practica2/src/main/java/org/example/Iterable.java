package org.example;

public class Iterable implements IIterable {
    int i = 0;
    Program program;

    public Iterable(Program vp_prog){
        program = vp_prog;
    }

    @Override
    public boolean hasNext() {
        return i < program.getI();
    }

    @Override
    public Command next() throws Exception {
        i++;
        return program.get(i-1);
    }
}
