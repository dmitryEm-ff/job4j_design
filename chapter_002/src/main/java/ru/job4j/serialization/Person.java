package ru.job4j.serialization;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import javax.xml.bind.JAXBContext;
import javax.xml.bind.JAXBException;
import javax.xml.bind.Marshaller;
import javax.xml.bind.annotation.*;
import java.io.StringWriter;
import java.util.Arrays;

@XmlRootElement(name = "person")
@XmlAccessorType(XmlAccessType.FIELD)
public class Person {
    @XmlAttribute
    private boolean sex;
    @XmlAttribute
    private int age;
    private Contact contact;
    @XmlElementWrapper(name = "statuses")
    @XmlElement(name = "status")
    private String[] status;

    public Person() {
    }

    public Person(boolean sex, int age, Contact contact, String... statuses) {
        this.sex = sex;
        this.age = age;
        this.contact = contact;
        this.status = statuses;
    }

    public boolean isSex() {
        return sex;
    }

    public int getAge() {
        return age;
    }

    public Contact getContact() {
        return contact;
    }

    public String[] getStatuses() {
        return status;
    }

    @Override
    public String toString() {
        return "Person{"
                + "sex=" + sex
                + ", age=" + age
                + ", contact=" + contact
                + ", statuses=" + Arrays.toString(status)
                + '}';
    }

    public static void main(String[] args) throws JAXBException {

        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");

        JAXBContext context = JAXBContext.newInstance(Person.class);
        Marshaller marshaller = context.createMarshaller();
        marshaller.setProperty(Marshaller.JAXB_FORMATTED_OUTPUT, Boolean.TRUE);

        try (StringWriter writer = new StringWriter()) {
            marshaller.marshal(person, writer);
            String result = writer.getBuffer().toString();
            System.out.println(result);
        } catch (Exception e) {

        }
    }

//    public static void main(String[] args) {
//        final Person person = new Person(false, 30, new Contact("11-111"), "Worker", "Married");
//
//        /* Преобразуем объект person в json-строку. */
//        final Gson gson = new GsonBuilder().create();
//        System.out.println(gson.toJson(person));
//
//        /* Модифицируем json-строку */
//        final String personJson =
//                "{"
//                        + "\"sex\":false,"
//                        + "\"age\":35,"
//                        + "\"contact\":"
//                        + "{"
//                        + "\"phone\":\"+7(924)111-111-11-11\""
//                        + "},"
//                        + "\"statuses\":"
//                        + "[\"Student\",\"Free\"]"
//                        + "}";
//        final Person personMod = gson.fromJson(personJson, Person.class);
//        System.out.println(personMod);
//    }
}
