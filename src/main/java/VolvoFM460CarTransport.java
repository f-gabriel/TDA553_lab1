import java.awt.*;


// todo: load och unload behöver hantera car-transporterns och bilarnas relativa position
public class VolvoFM460CarTransport extends Truck implements Loadable<PersonalVehicle> {
    Loader<PersonalVehicle> loader = new Loader<>(8);


    public VolvoFM460CarTransport(){
        //double enginePower = 460;
        super (460,2, Color.white, "Volvo FM 460",0, 0, "north");
    }
    public void load(PersonalVehicle item){
        loader.load(item);
    }
    public PersonalVehicle unLoad(){
        return loader.unLoad();
    }
}
