public class FlightManager {
    private Moon moon;
    private Robot robot;


    public FlightManager(Moon moon, Robot robot) {
        this.moon = moon;
        this.robot = robot;
    }

    public void moveRobot(int newX, int newY)  {
        if (newX < 0 || newX > moon.getWidth() || newY < 0 || newY > moon.getHeight()) {
            throw new IllegalArgumentException("Coordinates: "+newX+ " "+newY+" are outside the Moon!");
        } else if (moon.getWidth() == 0 || moon.getHeight() ==0) {
            throw new IllegalArgumentException("Moon has no surface! You've set: "+moon.getWidth()+" "+moon.getHeight()+" for Moon surface!");
        }
        robot.setX(newX);
        robot.setY(newY);
        System.out.println(robot.name+" landed successfully! OVER");
    }

}
