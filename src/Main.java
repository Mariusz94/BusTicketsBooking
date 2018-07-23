import java.util.Arrays;
import java.util.List;

public class Main {

    public static void main(String[] args) {
        Main main = new Main();
        List<String> city = Arrays.asList("Zakopane", "Kraków", "Łódź", "Koszalin", "Gdańsk");

        Bus bus = new Bus(city);
        main.addStartPassengers(bus);

        Passenger[][] seats = bus.getSeats();

        listOfPassengers(bus);

        System.out.println();
        System.out.println();

        main.arrangementOfPassengers(seats);
    }

    private void arrangementOfPassengers(Passenger[][] seats) {
        for (int i = 0; i < seats.length; i++) {
            for (int i1 = 0; i1 < seats[i].length; i1++) {
                if (seats[i][i1] != null){
                    System.out.print(seats[i][i1].getNumberPassenger() + " ");
                }else{
                    System.out.print("w ");
                }
            }
            System.out.println("");
        }
    }

    private static void listOfPassengers(Bus bus) {
        bus.getListOfPassengers().stream()
                .sorted()
                .forEach(s-> System.out.println(s.toString()));
    }

    private void addStartPassengers(Bus bus) {
        bus.awardingPlace(new Passenger("Angelika", "Kowalska", "Zakopane", "Gdańsk"));
        bus.awardingPlace(new Passenger("Henryk", "Pies", "Zakopane", "Koszalin"));
        bus.awardingPlace(new Passenger("Basia", "Gozdzik", "Zakopane", "Łódź"));
        bus.awardingPlace(new Passenger("Kasia", "Wiatrak", "Zakopane", "Kraków"));
        bus.awardingPlace(new Passenger("Krzysztof", "Kubek", "Kraków", "Gdańsk"));
        bus.awardingPlace(new Passenger("Józek", "Gniazdko", "Kraków", "Koszalin"));
        bus.awardingPlace(new Passenger("Tobisz", "Długosz", "Kraków", "Łódź"));
        bus.awardingPlace(new Passenger("Antosz", "Wojtyczko", "Łódź", "Gdańsk"));
        bus.awardingPlace(new Passenger("Ignacy", "Ząb", "Zakopane", "Gdańsk"));

    }

}
