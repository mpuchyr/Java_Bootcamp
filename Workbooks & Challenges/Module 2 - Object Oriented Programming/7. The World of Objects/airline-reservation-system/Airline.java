public class Airline {
    private Person[] seats;

    public Airline() {
        this.seats = new Person[11];
    }

    public Person getPerson(int index) {
        return new Person(seats[index]);
    }

    public void setPerson(Person person) {
        this.seats[person.getSeatNumber() - 1] = new Person(person);
    }

    public void createReservation(Person person) {
        while (seats[person.getSeatNumber() - 1] != null) {
            System.out.println(person.getName() + ", seat: " + person.getSeatNumber() + " is already taken."
                + " Please choose another one.\n");
            person.chooseSeat();
        }
        this.seats[person.getSeatNumber() - 1] = new Person(person);
        System.out.println("Thank you " + person.getName() + " for flying with Java airlines. "
            + "Your seat number is " + person.getSeatNumber() + ".");
    }

    public String toString() {
        String temp = "";
        
        for (int i = 0; i < this.seats.length; i++) {
            if (seats[i] == null) {
                temp += "Seat " + (i+1) +" is empty.\n\n";
                continue;
            }

            temp += seats[i].toString();
            temp += "\n\n";

        }
        
        return temp;
    }
}
