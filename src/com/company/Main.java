package com.company;

import java.util.*;


public class Main {
    public static boolean areDistinct(List<String> arr) {
        Set<String> s = new HashSet<String>(arr);
        return (s.size() == arr.size());
    }


    //Табличная база данных
    public static void main(String[] args) {
        List<List<String>> DataBase = new ArrayList<>();
        Scanner in = new Scanner(System.in);
        List<String> command, columns;
        System.out.print("Это табличная база данных,\nкоторая представляет из себя таблицу.\nДля работы с ней надо ввести желаемые столбцы.\nВсе столбцы должны быть уникальными\nПоддерживаемые команды: add, print, get (by_primary_key)\n");
        columns = Arrays.asList(in.nextLine().split(" "));
        if (!areDistinct(columns)) {
            System.out.print("ОШИБКА, все столбцы должны быть уникальными");
            return;
        }
        int primary_key = 0;
        do {
            command = Arrays.asList(in.nextLine().split(" "));
            if (command.get(0).equals("add")) {
                command.set(0, Integer.toString(primary_key));
                if (columns.size() != command.size() - 1) {
                    System.out.print("ОШИБКА при добавлении, значений должно быть столько же сколько и колонок\n");
                } else {

                    DataBase.add(command);
                    primary_key += 1;
                }
            }
            if (command.get(0).equals("get")) {
                int index = Integer.parseInt(command.get(1));
                if (index >= primary_key) {
                    System.out.print("ОШИБКА при получении, в таблице нет такой строки\n");
                } else {
                    System.out.println(DataBase.get(index));
                }
            }
            if (command.get(0).equals("print")) {
                for (String field :
                        columns) {

                    System.out.print(field + " ");
                }
                System.out.println("");
                for (List<String> row :
                        DataBase) {

                    for (String field :
                            row) {

                        System.out.print(field + " ");
                    }
                    System.out.println("");
                }
            }


        } while (!command.get(0).equals("exit"));
    }
}
