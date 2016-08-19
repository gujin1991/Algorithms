package August18th;
import java.util.*;

public class SnakeGame {
	private int score;
    private Set<Integer> set;
    private int[][] sfood;
    private List<Integer> snake;
    private int height;
    private int width;
    
    /** Initialize your data structure here.
        @param width - screen width
        @param height - screen height 
        @param food - A list of food positions
        E.g food = [[1,1], [1,0]] means the first food is positioned at [1,1], the second is at [1,0]. */
    public SnakeGame(int width, int height, int[][] food) {
        score = 0;
        set = new HashSet<>();
        sfood = food;
        snake = new ArrayList<>();
        snake.add(0);
        set.add(0);
        this.width = width;
        this.height = height;
    }
    
    /** Moves the snake.
        @param direction - 'U' = Up, 'L' = Left, 'R' = Right, 'D' = Down 
        @return The game's score after the move. Return -1 if game over. 
        Game over when snake crosses the screen boundary or bites its body. */
    public int move(String direction) {
        if(score == - 1) return -1;
        int newHeadx = snake.get(score) % width;
        int newHeady = snake.get(score) / width;        

        switch(direction) {
            case "U":
                newHeady--;
                break;
            case "D":
                newHeady++;
                break;
            case "R":
                newHeadx++;
                break;
            case "L":
                newHeadx--;
            default:
                break;
        }
        
        int newHead = newHeady * width + newHeadx;
        
        set.remove(snake.get(0));
        if(newHeadx >= width || newHeadx < 0 || newHeady < 0 || newHeady >= height || set.contains(newHead)) {
            return -1;
        }
        
        if(score < sfood.length && newHeadx == sfood[score][1] && newHeady == sfood[score][0]) {
            score++;
            set.add(snake.get(0));
            
        } else {
            snake.remove(0);
        }
        set.add(newHead);
        snake.add(newHead);
        
        return score;
    }
}
