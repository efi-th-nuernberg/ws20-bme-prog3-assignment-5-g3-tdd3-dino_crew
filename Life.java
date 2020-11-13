public class Life implements ILife {
  
  private final int SIZE = 5;
  private int[][] actualGeneration = new int[SIZE][SIZE];
  private int[][] newGeneration = new int[SIZE][SIZE];

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
    for (int y = 0; y < SIZE; y++)
      for (int x = 0; x < SIZE; x++)
        if (setup[y].charAt(x) != ' ') setAlive(x, y);
        else setDead(x, y);
  }

  @Override
  public void nukeAll() {
    // destroy all
  }

  @Override
  public void setAlive(int x, int y) {
    actualGeneration[y][x] = 1;
  }

  @Override
  public void setDead(int x, int y) {
    actualGeneration[y][x] = 0;
  }

  @Override
  public boolean isAlive(int x, int y) {
    if(actualGeneration[y][x] == 1) return true;
    else return false;
  }

  public int checkForNextGen(int x, int y){
    // createNewCell: drei Nachbarn = setAlive
    // destroyLonelyCell: weniger als zwei lebende Nachbarn = setDead
    // keepAliveCell: zwei oder drei lebende Nachbarn = isAlive(bleibt am leben)
    // destroyCrowdedCell: mehr als drei lebende Nachbarn = setDead
    int neighbours = 0;
    for (int i = 0; i < (y+1); i++)
      for (int j = 0; j < (x+1); j++)
        if(x>=0 && x<SIZE && y>=0 && y<SIZE)
          if(actualGeneration[y][x] == 1)
            neighbours++;
    if(neighbours==2 || neighbours==3) return(1);
    return(0);
  }

  @Override
  public ILife nextGeneration() {
    for (int y = 0; y < SIZE; y++)
      for (int x = 0; x < SIZE; x++)
        newGeneration[y][x] = checkForNextGen(x,y);
    actualGeneration = newGeneration;
    
    String l[] = new String[SIZE];
    for(int i = 0; i < SIZE; i++){
      for(int j = 0; j < SIZE; j++){
        if(isAlive(i,j)) l[i]+=1;
        else l[i]+=0;
      }
    }
    Life nextGen = new Life(l);
    return nextGen;
  }
}