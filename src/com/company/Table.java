package com.company;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

class Table {
    private List<String> columns;
    private int primaryKey;
    private ArrayList<ArrayList<String>> DataBase;



    Table(List<String> columns) {

        this.DataBase = new ArrayList<>();
        this.columns = columns;
        primaryKey = 0;
    }

    public void addRow(ArrayList<String> row) {
        row.add(0, Integer.toString(primaryKey));
        if (columns.size() != row.size() - 1) {
            System.out.print("ОШИБКА при добавлении, значений должно быть столько же сколько и колонок\n");
        } else {
            this.DataBase.add(row);
            primaryKey += 1;
        }
    }

    public void get(int rowIndex) {

        if (rowIndex >= primaryKey) {
            System.out.print("ОШИБКА при получении, в таблице нет такой строки\n");
        } else {
            System.out.println(String.join(" ", DataBase.get(rowIndex)));
        }
    }

    public void print() {
        System.out.print("  ");
        for (String field :
                columns) {

            System.out.print(field + " ");
        }
        System.out.println();
        for (List<String> row :
                DataBase) {

            for (String field :
                    row) {

                System.out.print(field + " ");
            }
            System.out.println();
        }
    }

}
