package pong;

public class Boundary {
    
    private static int MAX_WINDOW_X;
    private static int MAX_WINDOW_Y;
    private static int xCenter;
    private static int yCenter;

    public Boundary(int MAX_WINDOW_X, int MAX_WINDOW_Y) {
        Boundary.MAX_WINDOW_X = MAX_WINDOW_X;
        Boundary.MAX_WINDOW_Y = MAX_WINDOW_Y;
        xCenter = MAX_WINDOW_X / 2;
        yCenter = MAX_WINDOW_Y / 2;
    }

    public boolean isOutOfBoundX(Ball ball) {
        if (ball.getX() < 0 || ball.getX() > MAX_WINDOW_X - ball.getWidth()){
            return true;
        } else return false;
    }

    public boolean isOutOfBoundY(Ball ball) {
        if (ball.getY() < 0 || ball.getY() > MAX_WINDOW_Y - ball.getHeight()) {
            return true;
        } else return false;
    }

    public int isOutOfBoundsY(Wall wall) {
        if (wall.getY() > MAX_WINDOW_Y - wall.getHeight()){
            return 1;
        } else if (wall.getY() < 0) {
            return -1;
        } else return 0;
    }

    public boolean isTouchingWall(Ball ball, Wall wall) {
        if (ball.intersects(wall)) {
            return true;
        } else return false;
    }

    public int getxCenter() {
        return xCenter;
    }

    public int getyCenter() {
        return yCenter;
    }

    public int getMaxWindowX() {
        return MAX_WINDOW_X;
    }

    public int getMaxWindowY() {
        return MAX_WINDOW_Y;
    }
}