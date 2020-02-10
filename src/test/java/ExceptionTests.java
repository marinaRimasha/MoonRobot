
import org.junit.jupiter.api.Assertions;
import org.junit.jupiter.api.Test;

import static org.junit.jupiter.api.Assertions.assertEquals;

public class ExceptionTests {


    @Test
    public void RobotCannotLand() { //Testing that moving robot to -10 via x will cause an exception, happypath for exception
        Robot robot = new Robot(0, 0, "Curiosity");
        Moon moon = new Moon(100, 100);
        FlightManager manager = new FlightManager(moon, robot);
        int newX = -10;
        int newY = 0;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            manager.moveRobot(newX, newY);
        });
        assertEquals("Coordinates: " + newX + " " + newY + " are outside the Moon!", exception.getMessage(), "Incorrect exception message!");
    }

    @Test
    public void RobotCanLand() { //Testing exception not thrown when moving robot to coordinates 10 and 10
        Robot robot = new Robot(0, 0, "Vasilyok");
        Moon moon = new Moon(100, 100);
        FlightManager manager = new FlightManager(moon, robot);
        int newX = 10;
        int newY = 10;

        manager.moveRobot(newX, newY);

        assertEquals(10, newX, "X coordinate not set! Robot didn't land!");
        assertEquals(10, newY, "Y coordinate not set! Robot didn't land!");
    }

    @Test
    public void RobotCannotLand_Y() { //Testing that moving robot to 101 via Y will cause an exception, happypath for exception
        Robot robot = new Robot(0, 0, "Puziryok");
        Moon moon = new Moon(100, 100);
        FlightManager manager = new FlightManager(moon, robot);
        int newX = 10;
        int newY = 101;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            manager.moveRobot(newX, newY);
        });
        assertEquals("Coordinates: " + newX + " " + newY + " are outside the Moon!", exception.getMessage(), "Incorrect exception message!");
    }


    @Test
    public void RobotCannotLandBothNegative() { //Testing that moving robot to negative coordinates  will cause an exception, happypath for exception
        Robot robot = new Robot(0, 0, "Bomba");
        Moon moon = new Moon(100, 100);
        FlightManager manager = new FlightManager(moon, robot);
        int newX = -1;
        int newY = -1;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            manager.moveRobot(newX, newY);
        });
        assertEquals("Coordinates: " + newX + " " + newY + " are outside the Moon!", exception.getMessage(), "Incorrect exception message!");
    }

    @Test
    public void RobotCanLandZero() { //Testing that moving robot to 0 coordinates  will  not cause an exception, happypath for exception
        Robot robot = new Robot(0, 0, "Wall-e");
        Moon moon = new Moon(100, 100);
        FlightManager manager = new FlightManager(moon, robot);
        int newX = 0;
        int newY = 0;

        manager.moveRobot(newX, newY);

        assertEquals(0, newX, "X coordinate not set! Robot didn't land!");
        assertEquals(0, newY, "Y coordinate not set! Robot didn't land!");
    }

    @Test
    public void RobotSetupInittiallyWrong() { //setting initial starting points of robot wrong
        Robot robot = new Robot(-1, 0, "Tiny");
        Moon moon = new Moon(100, 100);
        FlightManager manager = new FlightManager(moon, robot);

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            manager.moveRobot(robot.x, robot.y);
        });
        assertEquals("Coordinates: " + robot.x + " " + robot.y + " are outside the Moon!", exception.getMessage(), "Incorrect exception message!");

    }

    @Test
    public void RobotZeroMoonArea() { //Moon is empty
        Robot robot = new Robot(0, 0, "Bomba");
        Moon moon = new Moon(0, 0);
        FlightManager manager = new FlightManager(moon, robot);
        int newX = 0;
        int newY = 0;

        Exception exception = Assertions.assertThrows(IllegalArgumentException.class, () -> {
            manager.moveRobot(newX, newY);
        });
        assertEquals("Moon has no surface! You've set: "+moon.getWidth()+" "+moon.getHeight()+" for Moon surface!", exception.getMessage(), "Incorrect exception message!");
    }

}
