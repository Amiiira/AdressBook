import org.junit.Test;
import org.junit.jupiter.api.BeforeEach;

import java.util.ArrayList;

import static org.junit.Assert.*;

public class TestAdressBook {
    private String name1 = "Blohin";
    private String name2 = "Avechkin";
    private String name3 = "Vasnechova";
    private String name4 = "Kamenskih";

    private Adress address1 = new Adress("Nevskiy",13,4);
    private Adress address2 = new Adress("Nevskiy",13,53);
    private Adress address3 = new Adress("Nevskiy",27,64);
    private Adress address4 = new Adress("Lesnaya",68,78);
    private Adress address5 = new Adress("Krasnoarmeyskaya",48,72);
    private Adress address6 = new Adress("Plochad Vostania", 45, 65);
    private AdressBook testAdressbook;

    @BeforeEach
    void start() {
        AdressBook testAdressbook = new AdressBook();
        testAdressbook.AddPair(name1,address1);
        testAdressbook.AddPair(name2,address2);
        testAdressbook.AddPair(name3,address3);
    }

    @Test
    public void AddPair(){
        assertTrue(testAdressbook.AddPair(name4,address4));
        assertFalse(testAdressbook.AddPair(name1, address1));
    }

    @Test
    public void DeletePerson(){
        assertTrue(testAdressbook.DeletePerson(name3));
        assertFalse(testAdressbook.DeletePerson("Volkova"));

    }

    @Test
    public void ChangeAddress(){
        testAdressbook.ChangeAddress(name1, address5);
        ArrayList<String> excepted = new ArrayList<>();
        excepted.add("Krasnoarmeyskaya");
        excepted.add("48");
        excepted.add("72");
        assertEquals(excepted, testAdressbook.GetAddress(name1));
        assertTrue(testAdressbook.ChangeAddress(name2, address6));
        assertFalse(testAdressbook.ChangeAddress("Lyubanskaya", address5));
    }

    @Test
    public void GetAddress(){
        ArrayList<String> excepted1 = new ArrayList<>();
        ArrayList<String> excepted2 = new ArrayList<>();
        excepted1.add("Nevskiy");
        excepted1.add("13");
        excepted1.add("4");
        assertEquals(excepted1, testAdressbook.GetAddress(name1));
        assertEquals(excepted2, testAdressbook.GetAddress("Jungkook"));
    }

    @Test
    public void GetListByStreet(){
        ArrayList<String> excepted1 = new ArrayList<>();
        ArrayList<String> excepted2 = new ArrayList<>();
        excepted1.add(name3);
        excepted1.add(name2);
        excepted1.add(name1);
        assertEquals(excepted1, testAdressbook.GetListByStreet("Nevskiy"));
        assertEquals(excepted2, testAdressbook.GetListByStreet("Stachek"));
    }

    @Test
    public void GetListByHouse(){
        ArrayList<String> excepted1 = new ArrayList<>();
        ArrayList<String> excepted2 = new ArrayList<>();
        excepted1.add(name2);
        excepted1.add(name1);
        assertEquals(excepted1, testAdressbook.GetListByHouse("Nevskiy", 13));
        assertEquals(excepted2, testAdressbook.GetListByHouse("Nevskiy", 123));
        assertEquals(excepted2, testAdressbook.GetListByHouse("Gagarina", 163));
    }


}
