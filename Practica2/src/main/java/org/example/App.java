package org.example;

public class App {
    public static void main(String[] args) throws Exception {
        Program program = new Program();

        program.add(new Command("init", "10", "20"));
        program.add(new Command("init", "11", "25"));
        program.add(new Command("init", "12", "5"));
        program.add(new Command("ld", "a", "10"));
        program.add(new Command("ld", "b", "11"));
        program.add(new Command("ld", "c", "12"));
        program.add(new Command("add"));
        program.add(new Command("print")); // вывод 20 25 5 45
        program.add(new Command("mv", "a", "d"));
        program.add(new Command("mv", "b", "c"));
        program.add(new Command("div"));
        program.add(new Command("print"));  // вывод 45 5 5 9

        ICpu cpu = BCpu.build();
        Executer exec = new Executer(cpu);

        try {
            exec.run(program);
        } catch (Exception e) {
            System.out.println("Error: " + e.getMessage());
        }

        System.out.print("Все команды: ");
        program.forEach(System.out::print);

        System.out.println();

        System.out.println(program.GetRangeOfMemory());

        program.MostPopularInstruction();
    }
}
