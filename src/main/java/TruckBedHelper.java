

public class TruckBedHelper implements TruckBed{
    int maxAngle;
    public int bedState;

    public TruckBedHelper(int maxAngle){
        this.maxAngle =
        this.bedState = maxAngle;
    }
    public void raise(){bedState = maxAngle;}
    public void lower(){bedState = 0;}
    public int getBedState(){return bedState;}
}
