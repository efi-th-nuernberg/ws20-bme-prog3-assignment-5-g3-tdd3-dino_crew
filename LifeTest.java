import org.junit.Test;
import static org.junit.Assert.*;

public class LifeTest {
    
    @Test
    // Eine neue Zelle an einem bisher belebten Rasterpunkt entsteht, wenn genau drei benachbarte Rasterpunkte mit lebenden Zellen besetzt sind
    public void createNewCell() {
        
        // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit drei Nachbarn sollte jetzt leben
        assertTrue(nextGen.isAlive(1, 1));

        //***
        //-*-
    }

    @Test
    // Lebende Zellen mit weniger als zwei lebenden Nachbarn sterben in der Folgegeneration an Einsamkeit.
    public void destroyLonelyCell() {
        // Arrange: eine lebende Zellen
        Life l = new Life();
        // Zelle, die wir checken
        l.setAlive(1, 1);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit keine Nachbarn sollte jetzt sterben
        assertFalse(nextGen.isAlive(1, 1));
    }

    @Test
    // Eine lebende Zelle mit zwei oder drei lebenden Nachbarn bleibt in der Folgegeneration am Leben.
    public void keepAliveCell() {
      // Arrange: drei lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        //Zelle, die wir checken
        l.setAlive(1, 1);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit zweo oder drei Nachbarn sollte jetzt am leben bleiben
        assertTrue(nextGen.isAlive(1, 1));
    }

    @Test
    // Lebende Zellen mit mehr als drei lebenden Nachbarn sterben in der Folgegeneration an Überbevölkerung.
    public void destroyCrowdedCell() {
      // Arrange: fuenf lebende Zellen
        Life l = new Life();
        l.setAlive(0, 0);
        l.setAlive(0, 1);
        l.setAlive(0, 2);
        l.setAlive(1, 2);
        //Zelle, die wir checken
        l.setAlive(1, 1);

        // Act: Berechnung der Folgegeneration
        ILife nextGen = l.nextGeneration();

        // Assert: Rasterpunkt mit mehr als drei Nachbarn sollte jetzt sterben
        assertFalse(nextGen.isAlive(1, 1));
    }
}
