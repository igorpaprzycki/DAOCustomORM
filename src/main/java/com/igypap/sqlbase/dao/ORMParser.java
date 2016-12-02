package com.igypap.sqlbase.dao;

import org.jetbrains.annotations.NotNull;

import java.lang.reflect.Field;

/**
 * Created by igypap on 02.12.16.
 */
public final class ORMParser {
    private ORMParser() {

    }


    @NotNull
    public static String createTable(Object o, String autoIncrementFieldName) {
        StringBuilder queryToBuild = new StringBuilder();
        queryToBuild.append("CREATE TABLE IF NOT EXISTS ");
        queryToBuild.append(o.getClass().getSimpleName() + "(");

        Field[] fields = o
                .getClass()
                .getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            queryToBuild.append(fields[i].getName() + " " + specifyType(fields[i]) + " NOT NULL");
            if (fields[i].getName().equals(autoIncrementFieldName)) {
                queryToBuild.append(" PRIMARY KEY AUTOINCREMENT");
            }
            if (i < fields.length - 1) {
                queryToBuild.append(", ");
            } else {
                queryToBuild.append(")");
            }
        }
        return queryToBuild.toString();
    }

    @NotNull
    public static String insertIntoTable(Object o, String autoIncrementFieldName) throws IllegalAccessException {
        StringBuilder queryToBuild = new StringBuilder();
        queryToBuild.append("INSERT INTO ");
        queryToBuild.append(o.getClass().getSimpleName() + "(");

        Field[] fields = o
                .getClass()
                .getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].getName().equals(autoIncrementFieldName)) {
                queryToBuild.append(fields[i].getName());
                if (i < fields.length - 1) {
                    queryToBuild.append(", ");
                } else {
                    queryToBuild.append(")");
                }
            }
        }
        queryToBuild.append(" VALUES(");
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].getName().equals(autoIncrementFieldName)) {
                fields[i].setAccessible(true);
                if (fields[i].getType().getSimpleName().equals("String")) {
                    queryToBuild.append("'" + fields[i].get(o) + "'");
                } else {
                    queryToBuild.append(fields[i].get(o));
                }

                if (i < fields.length - 1) {
                    queryToBuild.append(", ");
                } else {
                    queryToBuild.append(")");
                }
            }
        }


        return queryToBuild.toString();
    }

    @NotNull
    public static String deleteFromTable(Object o, String autoIncrementFieldName) throws IllegalAccessException {
//        "DELETE FROM Book WHERE(" +
//                "title='" + title + "' AND author=" + "'" + author + "' AND pages=" + pages + ")";
        StringBuilder queryToBuild = new StringBuilder();
        queryToBuild.append("DELETE FROM ");
        queryToBuild.append(o.getClass().getSimpleName() + " WHERE(");

        Field[] fields = o
                .getClass()
                .getDeclaredFields();
        for (int i = 0; i < fields.length; i++) {
            if (!fields[i].getName().equals(autoIncrementFieldName)) {
                fields[i].setAccessible(true);
                queryToBuild.append(fields[i].getName() + "=");
                if (fields[i].getType().getSimpleName().equals("String")) {
                    queryToBuild.append("'" + fields[i].get(o) + "'");
                } else {
                    queryToBuild.append(fields[i].get(o));
                }
                if (i < fields.length - 1) {
                    queryToBuild.append(" AND ");
                } else {
                    queryToBuild.append(")");
                }
            }
        }

        return queryToBuild.toString();
    }

    @NotNull
    private static String specifyType(Field field) {
        String fieldName = field.getType().getSimpleName();
        if (fieldName.equals("int")) {
            return "INTEGER";
        } else if (fieldName.equals("Integer")) {
            return "INTEGER";
        } else if (fieldName.equals("String")) {
            return "TEXT";
        } else if (fieldName.equals("double")) {
            return "REAL";
        } else if (fieldName.equals("Double")) {
            return "REAL";
        } else {
            return "TEXT";
        }
    }
}