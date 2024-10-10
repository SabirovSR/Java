package org.example;

import java.lang.Iterable;
import java.util.*;

public class Program implements Iterable<Command> {
    int i = 0;
    Command[] commands;

    int minMem = 1025;
    int maxMem = -1;

    public Program (){
        commands = new Command[20];
    }

    public void add(Command command){
        commands[i] = command;
        i++;

        RangeOfMemory(command);
    }

    public Command get(int n) throws Exception {
        if (n < 0 || n > i) throw new Exception("Out of memory");
        return commands[n];
    }

    public int getI() {
        return i;
    }

    private void RangeOfMemory(Command c)  {
        if (Objects.deepEquals(c.getCommand(), "init")){
            int mem = Integer.parseInt(c.getArgs()[0]);
            minMem = Math.min(minMem, mem);
            maxMem = Math.max(maxMem, mem);
        }
    }

    public String GetRangeOfMemory(){
        if (minMem == 1025 || maxMem == -1)
            return "Memory not use";
        return "Range of memory: " + minMem + "-" + maxMem;
    }

    public void MostPopularInstruction() {
        // Шаг 1: создаём HashMap для хранения количества встреч каждого названия команды
        Map<String, Integer> commandCount = new HashMap<>();

        // Шаг 2: проходим по массиву команд и считаем их популярность
        for (Command command : commands) {
            if (command == null) continue;
            String name = command.getCommand();
            commandCount.put(name, commandCount.getOrDefault(name, 0) + 1);
        }

        // Шаг 3: находим команду с максимальной популярностью
        String mostPopularCommand = null;
        int maxCount = 0;

        for (Map.Entry<String, Integer> entry : commandCount.entrySet()) {
            if (entry.getValue() > maxCount) {
                mostPopularCommand = entry.getKey();
                maxCount = entry.getValue();
            }
        }
        // Сделать map
        // Использовать straeme либо collectio

        // Шаг 4: выводим самую популярную команду
        if (mostPopularCommand != null) {
            System.out.println("Самая популярная команда: " + mostPopularCommand + " (использована " + maxCount + " раз)");
        } else {
            System.out.println("Команд нет.");
        }

        // Шаг 5: создаём список из записей карты и сортируем по значениям (популярности)
        List<Map.Entry<String, Integer>> sortedCommands = new ArrayList<>(commandCount.entrySet());
        sortedCommands.sort((entry1, entry2) -> entry2.getValue().compareTo(entry1.getValue()));

        // Шаг 6: выводим команды в порядке убывания популярности
        System.out.println("Команды по убыванию популярности:");
        for (Map.Entry<String, Integer> entry : sortedCommands) {
            System.out.println("Команда: " + entry.getKey() + ", Количество: " + entry.getValue());
        }
    }

    @Override
    public Iterator<Command> iterator() {
        return new Iterator<Command>() {
            private int i = -1;
            @Override
            public boolean hasNext() {
                return i+1 < getI();
            }

            @Override
            public Command next(){
                i++;
                if(i >= 0  && i < getI()) {
                    return commands[i];
                }
                return null;
            }
        };
    }
}