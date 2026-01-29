
// Class som hanterar position och riktning
public class Orientation {
    double xCoordinate;
    double yCoordinate;

    public enum Directions {NORTH, WEST, SOUTH, EAST}
    Directions currentDirection;

    public Orientation(double xCoordinate, double yCoordinate, String direction){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        setStartingDirection(direction);
    }

    // sätter startriktning utifrån argument <String direction>
    void setStartingDirection(String direction){
        String lowerDirection = direction.toLowerCase();
        switch (lowerDirection) {
            case "east" :
                currentDirection = Directions.EAST;
                break;
            case "south" :
                currentDirection = Directions.SOUTH;
                break;
            case "west" :
                currentDirection = Directions.WEST;
                break;
            default:
                currentDirection = Directions.NORTH;
                break;
        }
    }

    //set och get funktioner för position
    public double getX(){return xCoordinate;}
    public double getY(){return yCoordinate;}
    public void setX(double x){xCoordinate = x;}
    public void setY(double y){yCoordinate = y;}

    public void setPosition(double x, double y){
        setX(x);
        setY(y);
    }

    //set och get funktioner för direction
    public Directions getCurrentDirection(){return currentDirection;}
    public void setCurrentDirection(Directions direction){
        currentDirection = direction;
    }

    // new currentCoordinate = old [currentCoordinate] + value
    public void addToCoordinate(char coordinate, double value){
        switch (coordinate){
            case 'x':
                setX(getX() + value);
                break;
            case 'y' :
                setY(getY() + value);
                break;
            default:
                System.out.println("wrong coordinate name. Maybe try lower case?");
                break;
        }
    }
}
