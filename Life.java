public class Life implements ILife {
  
  private final int SIZE = 5;
  private int[][] actualGeneration = new int[SIZE][SIZE];

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
    for (int y = 0; y < SIZE; y++)
      for (int x = 0; x < SIZE; x++)
        setDead(x,y);
  }

  @Override
  public void setAlive(int x, int y) {
    actualGeneration[y][x] = 1;
    for(int i = 0; i < SIZE; i++){
      for(int j = 0; j < SIZE; j++){
      }
    }
  }

  @Override
  public void setDead(int x, int y) {
    actualGeneration[y][x] = 0;
  }

  @Override
  public boolean isAlive(int x, int y) {
  if(actualGeneration[y][x] == 1) return true;
  return false;
  }

  @Override
  public ILife nextGeneration() {
    Life nextGen = new Life();  
    for (int y = 0; y < SIZE; y++){
      for (int x = 0; x < SIZE; x++){
        if(actualGeneration[y][x]==1 && (countNeighbours(x,y)==2||countNeighbours(x,y)==3)){
          nextGen.setAlive(x,y);
        } else if (actualGeneration[y][x]==0 && countNeighbours(x,y)==3){
          nextGen.setAlive(x,y);
        } 
      }
    }
    return nextGen;
  }

  public int countNeighbours(int x, int y){
    int neighbours = 0;
    for (int j = (y-1); j <= (y+1); j++)
      if(j>=0 && j<SIZE)
        for (int i = (x-1); i <= (x+1); i++)
          if(i>=0 && i<SIZE)
            if(actualGeneration[j][i] == 1)
              neighbours++;
    if(actualGeneration[y][x]==1) neighbours--;   
    return(neighbours);
  }
}