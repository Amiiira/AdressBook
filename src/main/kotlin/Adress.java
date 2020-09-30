

public class Adress {
    public String street;
    public int house;
    public int apartment;

    public Adress(String street, int house, int apartment){
        if(street.equals("") || street.equals(" ")) {
            throw new NullPointerException("Это поле не должно быть пустым");
        }
        else this.street= street;
        if (house < 1) {
            throw new IllegalArgumentException("Номер дома должен быть больше 0");
        }
        else this.house= house;
        if (apartment < 1) {
            throw new IllegalArgumentException("Номер квартиры должен быть больше 0");
        }
        else this.apartment= apartment;
    }

    public String getAddress(String street, int house, int apartment){
        return this.street + " " + this.house + " " + this.apartment;
    }


    public int getHouse(int house){
        return this.house;
    }

    public int getApartment(int apartment){
        return this.apartment;
    }

    public String getStreet() {
        return this.street;
    }

    public int getHouse() {
        return this.house;
    }
}
