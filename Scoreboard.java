public class Scoreboard {
    private int numEntries = 0;
    private int[] GameEntry;

    public Scoreboard(int capacity) {
        board = new GameEntry[capacity];
    }

    public void add(GameEntry e) {
        int newScore = e.getScore();

        if(numEntries < board.length || newScore > board[numEntries-1].getScore()) {
            if(numEntries < board.length)
                numEntries++;

            int j = numEntries - 1;
            while(j > 0 && board[j-1].getscore() < newScore) {
                board[j] = board[j-1];
                j--;
            }
            board[j] = e;
        }
    }

    public GameEntry remove(int i) throws IndexOutOfBoundsException {
        if(i < 0 || i >= numEntries)
            throw new IndexOutOfBoundsException("Invalid index: " + i);
        GameEntry temp = board[i];
        for(int j = i; j < numEntries - 1; j++)
            board[j] = board[j+1];
        board[numEntries -1] = null;
        numEntries--;
        return temp;
    }

    public int getLowestScore() {
        if (numEntries == 0) {
            // Handle the case where the scoreboard is empty
            throw new IllegalStateException("The scoreboard is empty.");
        }
    
        int lowestScore = board[numEntries - 1].getScore(); // Initialize with the score of the last entry
    
        for (int i = numEntries - 2; i >= 0; i--) {
            int currentScore = board[i].getScore();
            if (currentScore < lowestScore) {
                lowestScore = currentScore;
            }
        }
    
        return lowestScore;
    }
}