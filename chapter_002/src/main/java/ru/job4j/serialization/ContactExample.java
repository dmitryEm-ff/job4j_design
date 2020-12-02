package ru.job4j.serialization;

import java.io.*;
import java.nio.file.Files;

public class ContactExample implements Serializable {
    private static final long serialVersionUID = 1L;
    private final int zipCode;
    private final String phone;

    public ContactExample(int zipCode, String phone) {
        this.zipCode = zipCode;
        this.phone = phone;
    }

    public int getZipCode() {
        return zipCode;
    }

    public String getPhone() {
        return phone;
    }

    @Override
    public String toString() {
        return "Contact{" + "zipCode=" + zipCode + ", phone='" + phone + '\'' + '}';
    }

    public static void main(String[] args) throws IOException, ClassNotFoundException {
        final ContactExample contactExample = new ContactExample(123456, "+7 (111) 111-11-11");

        /* Запись объекта в файл */
        File tempFile = Files.createTempFile(null, null).toFile();
        try (FileOutputStream fos = new FileOutputStream(tempFile);
             ObjectOutputStream oos =
                     new ObjectOutputStream(fos)) {
            oos.writeObject(contactExample);
        }

        /* Чтение объекта из файла */
        try (FileInputStream fis = new FileInputStream(tempFile);
             ObjectInputStream ois =
                     new ObjectInputStream(fis)) {
            final ContactExample contactFromFile = (ContactExample) ois.readObject();
            System.out.println(contactFromFile.getPhone().equals(contactExample.getPhone()));
            System.out.println(contactFromFile.getZipCode() == contactExample.getZipCode());
            System.out.println(contactFromFile + " equal to " + contactExample);
        }
    }
}