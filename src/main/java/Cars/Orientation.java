package Cars;

// Class som hanterar position och riktning
public class Orientation implements HasOrientation {
    double xCoordinate;
    double yCoordinate;

    DIRECTIONS currentDirection;

    public Orientation(double xCoordinate, double yCoordinate, String direction){
        this.xCoordinate = xCoordinate;
        this.yCoordinate = yCoordinate;

        setStartingDirection(direction);
    }

    public Orientation(Orientation orientation){
        this.xCoordinate = orientation.xCoordinate;
        this.yCoordinate = orientation.yCoordinate;
        this.currentDirection = orientation.currentDirection;
    }

    // sätter startriktning utifrån argument <String direction>
    void setStartingDirection(String direction){
        String lowerDirection = direction.toUpperCase();
        currentDirection = DIRECTIONS.valueOf(lowerDirection); // todo byt namn om funkar
    }


    //set och get funktioner för position
    public double getX(){return xCoordinate;}
    public double getY(){return yCoordinate;}
    public void setX(double x){xCoordinate = x;}
    public void setY(double y){yCoordinate = y;}

    public void setPosition(double x, double y){setX(x); setY(y);}

    //set och get funktioner för direction
    public DIRECTIONS getCurrentDirection(){return currentDirection;}
    public void setCurrentDirection(DIRECTIONS direction){
        currentDirection = direction;
    }
    public String getCurrentDirectionAsString(){
        return currentDirection.toString();
    }

    // new currentCoordinate = old [currentCoordinate] + value
    public void addToCoordinate(double value){
        switch (currentDirection.getCoordinate()){
            case 'x':
                setX(getX() + value * currentDirection.getPosOrNegMultiplier());
                break;
            case 'y' :
                setY(getY() + value * currentDirection.getPosOrNegMultiplier());
                break;
        }
    }










//    public enum Directions {NORTH, WEST, SOUTH, EAST}
//    Directions currentDirection;
//
//    public Orientation(double xCoordinate, double yCoordinate, String direction){
//        this.xCoordinate = xCoordinate;
//        this.yCoordinate = yCoordinate;
//
//        setStartingDirection(direction);
//    }
//
//    // sätter startriktning utifrån argument <String direction>
//    void setStartingDirection(String direction){
//        String lowerDirection = direction.toLowerCase();
//        switch (lowerDirection) {
//            case "east" :
//                currentDirection = Directions.EAST;
//                break;
//            case "south" :
//                currentDirection = Directions.SOUTH;
//                break;
//            case "west" :
//                currentDirection = Directions.WEST;
//                break;
//            default:
//                currentDirection = Directions.NORTH;
//                break;
//        }
//    }
//
//    //set och get funktioner för position
//    public double getX(){return xCoordinate;}
//    public double getY(){return yCoordinate;}
//    public void setX(double x){xCoordinate = x;}
//    public void setY(double y){yCoordinate = y;}
//
//    public void setPosition(double x, double y){setX(x); setY(y);}
//
//    //set och get funktioner för direction
//    public Directions getCurrentDirection(){return currentDirection;}
//    public void setCurrentDirection(Directions direction){
//        currentDirection = direction;
//    }
//    public String getCurrentDirectionAsString(){
//        return switch (getCurrentDirection()) {
//            case NORTH -> "north";
//            case EAST -> "east";
//            case SOUTH -> "south";
//            case WEST -> "west";
//        };
//    }
//
//    // new currentCoordinate = old [currentCoordinate] + value
//    public void addToCoordinate(char coordinate, double value){
//        switch (coordinate){
//            case 'x':
//                setX(getX() + value);
//                break;
//            case 'y' :
//                setY(getY() + value);
//                break;
//            default:
//                System.out.println("wrong coordinate name. Maybe try lower case?");
//                break;
//        }
//    }















}
