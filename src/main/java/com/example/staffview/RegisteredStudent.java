package com.example.staffview;

public class RegisteredStudent {
    String MatricNo;
    String Name;

    public RegisteredStudent(String matricNo, String name) {
        MatricNo = matricNo;
        Name = name;
    }

    public String getMatricNo() {
        return MatricNo;
    }

    public String getName() {
        return Name;
    }

    public void setMatricNo(String matricNo) {
        MatricNo = matricNo;
    }

    public void setName(String name) {
        Name = name;
    }
}

