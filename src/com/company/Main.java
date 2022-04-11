package com.company;

import java.util.*;

public class Main {


    //Табличная база данных
    public static void main(String[] args) {
        Scanner in = new Scanner(System.in);
        ArrayList<String> command;
        System.out.print("Это табличная база данных,\nкоторая представляет из себя таблицу.\nДля работы с ней надо ввести желаемые столбцы.\nВсе столбцы должны быть уникальными\nПоддерживаемые команды: add, print, get (by_primary_key), create\n");
        DataBase dataBase = new DataBase();
        do {
            command = new ArrayList<>(Arrays.asList(in.nextLine().split(" ")));
            if (command.size() > 2 && command.get(0).equals("create") ) {
                command.remove(0);
                dataBase.createTable(command.remove(0), command);
            }
            if (command.size() > 2 && command.get(0).equals("add") ) {
                command.remove(0);
                dataBase.addRowToTable(command.remove(0),  command);
            }
            if (command.size() == 3 && command.get(0).equals("get") ) {
                command.remove(0);
                dataBase.getSpecificRowFromTable(command.remove(0), Integer.parseInt(command.get(0)));
            }
            if ( command.size() == 2 && command.get(0).equals("print")) {
                dataBase.printTable(command.get(1));
            }
        } while (!command.get(0).equals("exit"));
    }
}
