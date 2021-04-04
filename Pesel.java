package com.series;


import java.util.HashMap;
import java.util.Random;

public class Pesel {
    private HashMap<String,Person> existingPesels = new HashMap<>();

    public String generate (Person person) {
        Random random = new Random();
        int generated = random.nextInt(1000);

        String temp = person.getBirthDate() + zeros(generated) + generated + generateGenderDigit(person);
        temp += generateChecksum(temp);
        if (existingPesels.get(temp) != null) {
            return generate(person);
        }
        existingPesels.put(temp,person);
        person.setPesel(temp);
        return temp;
    }
    private String zeros (int generated) {
        String s = "";
        if (generated > 10 && generated < 100) {
            s ="0";
        }
        if (generated > 1 && generated < 10) {
            s = "00";
        }
        if (generated == 0) {
            s = "000";
        }
        return s;
    }

    private int generateChecksum(String generated) {
        long number = Long.parseLong(generated);
        int res = 1;
        int i = 10;
        while (number > 0) {
            long temp = number % 10;
            switch (i) {
                case 10: case 6: case 2:
                    res += temp * 3;
                    break;
                case 9: case 5: case 1:
                    res += temp;
                    break;
                case 8: case 4:
                    res += temp * 9;
                    break;
                case 7: case 3:
                    res += temp * 7;
            }
            i--;
            number /= 10;
        }
        res %= 10;
        return res;
    }

    private int generateGenderDigit(Person person) {
        Random random = new Random();
        int digit = random.nextInt(10);
        if (person.isSex() && digit % 2 != 0) {
            return generateGenderDigit(person);
        } else if (!person.isSex() && digit % 2 == 0) {
            return generateGenderDigit(person);
        }
        return digit;
    }
}
