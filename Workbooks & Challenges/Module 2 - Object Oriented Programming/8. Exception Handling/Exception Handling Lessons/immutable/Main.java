public class Main {
    public static void main(String[] args) {
        Person person = new Person("Ryan", "Canadian"); // Mutable or Immutable?
        Person person2 = person;
        person2 = new Person("John", "American");
    }
}
