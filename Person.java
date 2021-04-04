package com.series;

public class Person {
    private String name;
    private String birthDate;
    private String pesel;
    private boolean sex;

    public Person(String name, String birthDate, boolean sex) {
        this.name = name;
        this.birthDate = birthDate;
        this.sex = sex;
    }

    public String getName() {
        return name;
    }

    public boolean isSex() {
        return sex;
    }

    public String getBirthDate() {
        String[] birthDate = this.birthDate.split("-");
        int year = Integer.parseInt(birthDate[0]);
        int month = Integer.parseInt(birthDate[1]);
        int day = Integer.parseInt(birthDate[2]);
        if (year > 1900 && year < 2000) {
            year -= 1900;
            if (year < 10) {
                birthDate[0] = "0" + year;
            } else {
                birthDate[0] = Integer.toString(year);
            }
            if (month < 10) {
                birthDate[1] = "0" + month;
            }else{
                birthDate[1] = Integer.toString(month);
            }
            if (day < 10) {
                birthDate[2] = "0" + day;
            } else {
                birthDate[2] = Integer.toString(day);
            }
            this.birthDate = birthDate[0] + birthDate[1] + birthDate[2];
        } else if (year < 2100 && year >= 2000) {
            year -= 2000;
            if (year < 10) {
                birthDate[0] = "0" + year;
            } else {
                birthDate[0] = Integer.toString(year);
            }
            month += 20;
            if (day < 10) {
                birthDate[2] = "0" + day;
            } else {
                birthDate[2] = Integer.toString(day);
            }
            this.birthDate = birthDate[0] + month + birthDate[2];
        } else if (year >= 2100 && year < 2200) {
            year -= 2100;
            if (year < 10) {
                birthDate[0] = "0" + year;
            } else {
                birthDate[0] = Integer.toString(year);
            }
            month += 40;
            if (day < 10) {
                birthDate[2] = "0" + day;
            } else {
                birthDate[2] = Integer.toString(day);
            }
            this.birthDate = birthDate[0] + month + birthDate[2];
        }
        return this.birthDate;
    }

    public String getPesel() {
        return pesel;
    }

    public void setPesel(String pesel) {
        this.pesel = pesel;
    }
}
