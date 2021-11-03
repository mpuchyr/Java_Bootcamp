package models;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.concurrent.TimeUnit;

public class Contact {

    private String name;
    private String phoneNumber;
    private String birthDate;
    private int age;

    public Contact(String name, String phoneNumber, String birthDate) throws ParseException {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be null/blank");
        }

        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number cannot be null/blank and must be at least 5 digits");
        }
        
        this.name = name;
        this.phoneNumber = phoneNumber;
        this.birthDate = birthDate;
        this.age = this.toAge(birthDate);

    }

    public Contact (Contact source) {
        this.name = source.name;
        this.phoneNumber = source.phoneNumber;
        this.birthDate = source.birthDate;
        this.age = source.age;
    }

    public String getName() {
        return this.name;
    }

    public String getPhoneNumber() {
        return this.phoneNumber;
    }

    public String getBirthDate() {
        return this.birthDate;
    }

    public int getAge() {
        return this.age;
    }


    public void setName(String name) {
        if (name == null || name.isBlank()) {
            throw new IllegalArgumentException("Name cannot be blank or null");
        }

        this.name = name;
    }

    public void setPhoneNumber(String phoneNumber) {
        if (phoneNumber == null || phoneNumber.isBlank() || phoneNumber.length() < 5) {
            throw new IllegalArgumentException("Phone number cannot be null/blank and must be at least 5 digits");
        }
        this.phoneNumber = phoneNumber;
    }

    public void setBirthDate(String birthDate) throws ParseException {
        this.birthDate = birthDate;
        this.setAge(toAge(birthDate));
    }

    private void setAge(int age) throws ParseException {
        this.age = age;
    }

    public int toAge(String birthDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat("MM/dd/yyyy");
        format.setLenient(false);
        Date date = new Date();
        Date toDate = format.parse(birthDate);
        long bDateMill = toDate.getTime();
        long tDateMill = date.getTime();
        return (int)(TimeUnit.MILLISECONDS.toDays((tDateMill - bDateMill)) / 365);
    }

    public String toString() {
        return "Name: " + this.name + "\n"
            + "Phone number: " + this.phoneNumber + "\n"
            + "Birth Date: " + this.birthDate + "\n"
            + "Age: " + this.age + " years old\n";
    }


}
