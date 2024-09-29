package org.example;

public class BCpu implements ICpu {
    private int[] registers = new int[4]; // 4 регистра
    private int[] memory = new int[1024]; // Память (1024 элемента int)

    public static BCpu build() {
        return new BCpu();
    }

    @Override
    public void exec(Command c) {
        // Реализация команд
        switch (c.getCommand()) {
            case "init":
                int address = Integer.parseInt(c.getArgs()[0]);
                int value = Integer.parseInt(c.getArgs()[1]);
                memory[address] = value;
                break;
            case "ld":
                int regIndex = getRegisterIndex(c.getArgs()[0]);
                address = Integer.parseInt(c.getArgs()[1]);
                registers[regIndex] = memory[address];
                break;
            case "st":
                regIndex = getRegisterIndex(c.getArgs()[0]);
                address = Integer.parseInt(c.getArgs()[1]);
                memory[address] = registers[regIndex];
                break;
            case "mv":
                int sourceRegIndex = getRegisterIndex(c.getArgs()[0]);
                int destRegIndex = getRegisterIndex(c.getArgs()[1]);
                registers[sourceRegIndex] = registers[destRegIndex];
                break;
            case "print":
                printRegisters();
                break;
            case "add":
                registers[3] = registers[0] + registers[1]; // d = a + b
                break;
            case "sub":
                registers[3] = registers[0] - registers[1]; // d = a - b
                break;
            case "mult":
                registers[3] = registers[0] * registers[1]; // d = a * b
                break;
            case "div":
                registers[3] = registers[0] / registers[1]; // d = a / b
                break;
            default:
                throw new IllegalArgumentException("Unknown command: " + c.getCommand());
        }
    }

    private int getRegisterIndex(String reg) {
        switch (reg) {
            case "a": return 0;
            case "b": return 1;
            case "c": return 2;
            case "d": return 3;
            default: throw new IllegalArgumentException("Unknown register: " + reg);
        }
    }

    private void printRegisters() {
        System.out.println(registers[0] + " " + registers[1] + " " + registers[2] + " " + registers[3]);
    }
}