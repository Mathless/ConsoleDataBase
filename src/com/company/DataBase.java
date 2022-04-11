package com.company;

import java.util.*;

class DataBase {
    private final HashMap<String, Table> dataBase;

    public static boolean areDistinct(List<String> arr) {
        Set<String> s = new HashSet<>(arr);
        return (s.size() == arr.size());
    }

    DataBase() {
        this.dataBase = new HashMap<>();
    }

    public void createTable(String tableName, ArrayList<String> columns) {
        if (!this.dataBase.containsKey(tableName)) {
            if (!areDistinct(columns)) {
                System.out.print("ОШИБКА, все столбцы должны быть уникальными");
                return;
            }
            this.dataBase.put(tableName, new Table(columns));
        } else {
            System.out.print("Таблица с таким именем уже есть\n");
        }
    }

    public void addRowToTable(String tableName, ArrayList<String> row) {
        if (dataBase.containsKey(tableName)) {
            dataBase.get(tableName).addRow(row);
        } else {
            System.out.print("Таблицы с таким именем нет\n");
        }
    }

    public void printTable(String tableName) {
        if (dataBase.containsKey(tableName)) {
            dataBase.get(tableName).print();
        } else {
            System.out.print("Таблицы с таким именем нет\n");
        }
    }

    public void getSpecificRowFromTable(String tableName, int rowIndex) {
        if (dataBase.containsKey(tableName)) {
            dataBase.get(tableName).get(rowIndex);
        } else {
            System.out.print("Таблицы с таким именем нет\n");
        }
    }
}
