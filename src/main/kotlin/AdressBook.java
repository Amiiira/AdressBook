import java.util.ArrayList;
import java.util.TreeMap;

public class AdressBook {
    public static void main(String[] args){}

    public static TreeMap<String, Adress> addressBook = new TreeMap<String, Adress>();

    public  boolean AddPair(String name, Adress adres){
        if (!addressBook.containsKey(name)) addressBook.put(name, adres);
        else throw new IllegalArgumentException("Это имя уже есть в адресной книге");

        return true;
    }

    public static boolean DeletePerson(String name){
        if (addressBook.containsKey(name)) addressBook.remove(name);
        else throw new IllegalArgumentException("Невозможно удалить то, чего нет");
        return false;
    }
    public boolean ChangeAddress(String name, Adress newAdres){
        if (addressBook.containsKey(name)) addressBook.replace(name,newAdres);
        else throw new IllegalArgumentException("Невозможно изменить то, чего нет");
        return false;
    }
    public double GetAddress(String name){
        if (addressBook.containsKey(name))  addressBook.get(name);
        else throw new IllegalArgumentException("Человек не найден");
        return 0;
    }
    public ArrayList<String> GetListByStreet(String newStreet){
        ArrayList<String> list = new ArrayList<String>();
        for (String name : addressBook.keySet()) {
            if (addressBook.get(name).getStreet().equals(newStreet))
                list.add(name);
        }
        return list;
    }
    public ArrayList<String> GetListByHouse(String newStreet, int newHouse){
        ArrayList<String> secondList = new ArrayList<String>();
        for (String name : addressBook.keySet()) {
            if (addressBook.get(name).getStreet().equals(newStreet) && addressBook.get(name).getHouse() == newHouse)
                secondList.add(name);
        }
        return secondList;
    }
}
