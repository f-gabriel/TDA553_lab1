//todo se över bedState. Ska 1 vara uppe eller nere?

public class TruckBedHelper implements TruckBed{
    int maxAngle = 1;
    public int bedState = 1;

    public TruckBedHelper(){
        this.bedState = maxAngle;
    }
    public void raise(){bedState = maxAngle;}
    public void lower(){bedState = 0;}
    public int getBedState(){return bedState;}
}
