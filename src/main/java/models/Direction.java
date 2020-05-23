package models;

/**
 * Direction
 */
public class Direction {
    public enum DirectionConstant {
        NORTH,
        SOUTH,
        WEST,
        EAST
    }

    /**
     * Get direction by angle
     * NORTH = (45; 135]
     * WEST = (135; 180] & [-180; -135]
     * SOUTH = (-135; -45]
     * NORTH = (-45; 45]
     * I fourth = [0; 90]
     * II fourth = [90; 180]
     * III fourth = [-180; -90]
     * IV fourth = [-90; 0]
     * @param angle angle
     * @return direction
     * @exception IllegalArgumentException if angle is in wrong range
     */
    public static DirectionConstant getDirection(double angle) {
        if(angle > 45 && angle <= 135) {
            return DirectionConstant.NORTH;
        }
        else if((angle > 135 && angle <= 180) || (angle >= -180 && angle <= -135)) {
            return DirectionConstant.WEST;
        }
        else if(angle > -135 && angle <= -45) {
            return DirectionConstant.SOUTH;
        }
        else if(angle > -45 && angle <= 45)
        {
            return DirectionConstant.EAST;
        }
        else {
            throw new IllegalArgumentException("Incorrect angle("+ angle + "), see getDirection method's description!");
        }
    }
}
