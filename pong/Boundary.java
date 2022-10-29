package pong;

public class Boundary {
    
    private int MAX_WINDOW_X, MAX_WINDOW_Y;

    public Boundary(int MAX_WINDOW_X, int MAX_WINDOW_Y) {
        MAX_WINDOW_X = this.MAX_WINDOW_X;
        MAX_WINDOW_Y = this.MAX_WINDOW_Y;
    }

    public boolean isOutOfBounds(Ball ball) {
        if (ball.getX() < 0 || ball.getX() > MAX_WINDOW_X - ball.getWidth()){
            return true;
        } else if (ball.getY() < 0 || ball.getY() > MAX_WINDOW_Y - ball.getHeight()) {
            return true;
        } else {
            return false;
        }
    }

    public static boolean isOutOfBounds(Wall wall) {
        if (wall.getY() < 0 || wall.getY() > MAX_WINDOW_Y - wall.getHeight()){
            return true;
        } else {
            return false;
        }
    }
}