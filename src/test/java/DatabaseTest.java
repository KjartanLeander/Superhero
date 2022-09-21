import org.junit.jupiter.api.BeforeEach;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;

import static org.junit.jupiter.api.Assertions.*;

class DatabaseTest {
private Database database;

@BeforeEach
void prepareTest(){
    database = new Database();
    database.createTestData();
}

    @Test
    void createTestData() {
        assertTrue (true);
    }

    @Test
    void createSuperhero() {

        //Arrange
        Database database = new Database();
        //Act
        database.createSuperhero("Simon","Git","stor",10,1,175,true);
        ArrayList<SuperHero> results = database.getallhelteDatabase();
        int actualSize = results.size();
        int expectedSize = 1;
        //Arrange
        assertEquals(actualSize,expectedSize);
    }
    @Test
    void searchFor() {
        Database database = new Database();
        database.createTestData();
        ArrayList<SuperHero> results = database.searchFor("Elseman");
        int actualSize = results.size();
        int expectedSize = 1;

        assertEquals(actualSize,expectedSize);
    }
    @Test
    void deleteSuperhero(){
    ArrayList<SuperHero> results = database.getallhelteDatabase();

    SuperHero superHero = results.get(0);
    boolean result = database.deleteSuperhero(superHero);
    boolean actualResult = database.deleteSuperhero( superHero );
    boolean expectedResult = true;

    assertEquals(actualResult,expectedResult);

    int expectedSize = results.size()-1;
    ArrayList<SuperHero>resultsAfterDelete = database.getallhelteDatabase();
    int actualSize = resultsAfterDelete.size();
    assertEquals(actualSize,expectedSize);
    }
}