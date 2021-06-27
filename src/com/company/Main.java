package com.company;

import java.io.*;
import java.util.HashMap;
import java.util.Map;

public class Main {

    public static void main(String[] args) throws IOException {
        File text = new File("data/input_task48.txt");
        System.out.println(text.getAbsolutePath());
        BufferedWriter writeText;
        try {
            writeText = new BufferedWriter(new FileWriter("input_task48.txt"));
        } catch (IOException e) {
            System.out.println("Фаил не найден!");
            return;
        }
        writeText.write("99 Текст для записи 48 в фаил 7. Для задания номер 48. Номер дома 50");
        writeText.close();

        BufferedReader readFile;
        try {
            readFile = new BufferedReader(new FileReader("input_task48.txt"));
        } catch (IOException e) {
            System.out.println("Фаил не найден!!");
            return;
        }
        String str = readFile.readLine();
        System.out.println(str);

        String[] strOnlyWithNum = str.split("\\D+");
        for (int i=0; i< strOnlyWithNum.length; i++) {
            System.out.print(strOnlyWithNum[i] + " ");
        }

        Integer summ = 0;
        for (int i=0; i< strOnlyWithNum.length; i++) {
            summ = summ + (Integer.parseInt(strOnlyWithNum[i]));
        }
        System.out.println("\n" + "Сумма чисел: " + summ);

        Map<String, Integer> numbers = new HashMap<String, Integer>();
        for (String num : strOnlyWithNum) {
            Integer counter = numbers.get(num);
            if (counter == null) {
                counter = 0;
            }
            numbers.put(num, counter + 1);
        }
        System.out.println(numbers.keySet());
    }
}