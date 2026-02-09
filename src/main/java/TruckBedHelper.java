//todo se över bedState. Ska 1 vara uppe eller nere?

public class TruckBedHelper implements TruckBed{
    public int bedState = 1;
    public TruckBedHelper(){}
    public void raise(){bedState = 1;}
    public void lower(){bedState = 0;}
    public int getBedState(){return bedState;}
}
