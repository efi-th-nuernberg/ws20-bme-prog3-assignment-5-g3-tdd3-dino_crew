public class Life implements ILife {
  
  public static void main(String[] args) {
    Life l = new Life(new String[] {  "     ",
                                      "     ",
                                      " *** ",
                                      "     ",
                                      "     " });
    l = (Life) l.nextGeneration();
  }


  public Life() {
    nukeAll();
  }

  // Constructor
  public Life(String[] setup) {
    this();
    for (int y = 0; y < setup.length; y++)
      for (int x = 0; x < setup[y].length(); x++)
        if (setup[y].charAt(x) != ' ')
          setAlive(x, y);
  }


  @Override
  public void nukeAll() {
    // destroy all
  }

  @Override
  public void setAlive(int x, int y) {
    // if isAlive == true
    // if x1y1, x2y2,x3y3 isAlive 
    // x4y4 setAlive 
  }

  @Override
  public void setDead(int x, int y) {
    //Lebende Zellen mit weniger als zwei lebenden Nachbarn sterben in der Folgegeneration an Einsamkeit.
    //Lebende Zellen mit mehr als drei lebenden Nachbarn sterben in der Folgegeneration an Überbevölkerung.

  }

  @Override
  public boolean isAlive(int x, int y) {
    int counter = 0;
    for (int i = (y-1); i <= (y+1); i++)
      for (int j = (x-1); j <= (x+1); j++){
        if(l[i].charAt(j)=='*') counter++; //l muss noch global definiert werden
      }
    return false;
  }

  @Override
  public ILife nextGeneration() {
    return null;
  }
}