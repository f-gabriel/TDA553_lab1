public class TruckBedHelper implements TruckBed{
    public int bedState;
    public TruckBedHelper(){}
    public void raise(){bedState = 1;}
    public void lower(){bedState = 0;}
    public int getBedState(){return bedState;}
}
