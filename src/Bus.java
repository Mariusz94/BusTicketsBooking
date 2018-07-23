import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Bus {
    private Passenger[][] seats;
    private List<Passenger> listOfPassengers;
    private Map<String, Integer> grantedNumberForTheCity;

    Bus(List<String> city) {
        listOfPassengers = new ArrayList<>();
        grantedNumberForTheCity = new HashMap<>();
        seats = new Passenger[city.size()][20];

        awardingNumberToTheCity(city, grantedNumberForTheCity);
    }

    void awardingPlace(Passenger passenger) {
        int numberOfCityStart = grantedNumberForTheCity.get(passenger.getFromCity());
        int numberOfCityEnd = grantedNumberForTheCity.get(passenger.getToCity());
        for (int i = 0; i < seats[0].length; i++) {
            if (isSeatsIsFreeFromCityToCity(numberOfCityStart, numberOfCityEnd, i)) {
                listOfPassengers.add(passenger);
                seats[numberOfCityStart][i] = passenger;
                passenger.setNumberOfSeat(i + 1);
                break;
            }
        }
        if (passenger.getNumberOfSeat() != 0) {
            for (int i = numberOfCityStart + 1; i < numberOfCityEnd; i++) {
                seats[i]
                        [passenger.getNumberOfSeat() - 1] = passenger;
            }
        } else {
            System.out.println("No free seats");
        }
    }

    private boolean isSeatsIsFreeFromCityToCity(int numberOfCityStart, int numberOfCityEnd, int numberOfSeat) {
        boolean isFree = true;
        for (int i = numberOfCityStart; i <= numberOfCityEnd; i++) {
            if (seats[i][numberOfSeat] != null) {
                isFree = false;
            }
        }
        return isFree;
    }

    private static void awardingNumberToTheCity(List<String> city, Map<String, Integer> numberOfCity) {
        for (int i = 0; i < city.size(); i++) {
            numberOfCity.put(city.get(i), i);
        }
    }

    public Passenger[][] getSeats() {
        return seats;
    }

    public Map<String, Integer> getGrantedNumberForTheCity() {
        return grantedNumberForTheCity;
    }

    public List<Passenger> getListOfPassengers() {
        return listOfPassengers;
    }

}
