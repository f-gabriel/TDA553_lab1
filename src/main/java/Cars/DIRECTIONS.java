package Cars;

public enum DIRECTIONS {
    NORTH('y', 1),
    WEST('x', -1),
    SOUTH('y', -1),
    EAST('x', 1);

    private char coordinate;
    private int posOrNegMultiplier;

    DIRECTIONS(char coordinate, int posOrNegMultiplier){
        this.coordinate = coordinate;
        this.posOrNegMultiplier = posOrNegMultiplier;
    }

    public char getCoordinate(){
        return coordinate;
    }
    public int getPosOrNegMultiplier(){
        return posOrNegMultiplier;
    }
    public DIRECTIONS turnLeft(){
        int leftIndex = this.ordinal() + 1;
        int lengthDirections = DIRECTIONS.values().length;
        return DIRECTIONS.values()[leftIndex % lengthDirections];
    }
    public DIRECTIONS turnRight(){
        int rightIndex = this.ordinal() -1;
        int lengthDirections = DIRECTIONS.values().length;
        return DIRECTIONS.values()[rightIndex % lengthDirections];
    }
    public DIRECTIONS turnAround(){
        int oppositeIndex = this.ordinal() + 2;
        int lengthDirections = DIRECTIONS.values().length;
        return DIRECTIONS.values()[oppositeIndex % lengthDirections];
    }
}
