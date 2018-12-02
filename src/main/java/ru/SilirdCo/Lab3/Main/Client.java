package ru.SilirdCo.Lab3.Main;

import java.rmi.registry.LocateRegistry;
import java.rmi.registry.Registry;
import java.util.Arrays;
import java.util.Scanner;

public class Client {
    private final String ENTER_NAME = "Enter your name: ";
    private static Scanner scanner;
    private final static String RESULT = "Результат: ";

    private boolean callRemote(int id) {
        try{
            Registry reg = LocateRegistry.getRegistry(Server.PORT);
            IServer srv = (IServer)reg.lookup(Server.NAME);

            switch (id) {
                case 1:
                    int a1;
                    int b1;

                    int result1;

                    System.out.print("Введите первое число: ");
                    a1 = scanner.nextInt();
                    System.out.print("Введите второе число: ");
                    b1 = scanner.nextInt();

                    result1 = srv.div(a1, b1);
                    System.out.println(RESULT + result1);
                    System.out.println();
                    return true;
                case 2:
                    int a2;
                    int b2;

                    boolean result2;

                    System.out.print("Введите первое число: ");
                    a2 = scanner.nextInt();
                    System.out.print("Введите второе число: ");
                    b2 = scanner.nextInt();

                    result2 = srv.lessOrEqual(a2, b2);
                    System.out.println(RESULT + result2);
                    System.out.println();
                    return true;
                case 3:
                    boolean a3;
                    boolean b3;

                    boolean result3;

                    System.out.print("Введите первую логическую переменную (true/false): ");
                    a3 = scanner.nextBoolean();
                    System.out.print("Введите вторую логическую переменную (true/false): ");
                    b3 = scanner.nextBoolean();

                    result3 = srv.and(a3, b3);
                    System.out.println(RESULT + result3);
                    System.out.println();
                    return true;
                case 4:
                    String str;

                    String[] result4;

                    System.out.print("Введите строку: ");
                    str = scanner.nextLine();
                    str = scanner.nextLine();

                    result4 = srv.split(str);
                    System.out.println(RESULT + Arrays.toString(result4));
                    System.out.println();
                    return true;
                default:
                    return false;
            }
        }
        catch(Exception ex){
            ex.printStackTrace();
        }

        return true;
    }

    public static void main(String[] args) {
        scanner = new Scanner(System.in);

        boolean cont = true;
        while(cont) {
            System.out.print("Введите идентификатор операции\n" +
                    " [1] Остаток от деления\n" +
                    " [2] Меньше или равно\n" +
                    " [3] Логическое И\n" +
                    " [4] Разбиение строк\n");
            int id;

            System.out.print("Введите id: ");
            id = scanner.nextInt();

            Client c = new Client();
            cont = c.callRemote(id);
        }
    }
}
