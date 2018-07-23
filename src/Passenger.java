public class Passenger implements Comparable<Passenger> {
    private static int number = 0;
    private int numberPassenger = 0;
    private String name;
    private String lastName;
    private String fromCity;
    private String toCity;
    private int numberOfSeat;


    public Passenger(String name, String lastName, String fromCity, String toCity) {
        this.numberPassenger = ++number;
        this.name = name;
        this.lastName = lastName;
        this.fromCity = fromCity;
        this.toCity = toCity;
    }

    public String getName() {
        return name;
    }

    public String getLastName() {
        return lastName;
    }

    public String getFromCity() {
        return fromCity;
    }

    public String getToCity() {
        return toCity;
    }

    public int getNumberOfSeat() {
        return numberOfSeat;
    }

    public void setNumberOfSeat(int numberOfSeat) {
        this.numberOfSeat = numberOfSeat;
    }

    public int getNumberPassenger() {
        return numberPassenger;
    }

    @Override
    public String toString() {
        return "Passenger{" +
                "numberPassenger='" + numberPassenger + '\'' +
                "name='" + name + '\'' +
                ", lastName='" + lastName + '\'' +
                ", fromCity='" + fromCity + '\'' +
                ", toCity='" + toCity + '\'' +
                ", numberOfSeat=" + numberOfSeat +
                '}';
    }

    @Override
    public int compareTo(Passenger o) {
        return numberPassenger > o.numberPassenger ? 1 : -1;
    }
}
