import java.awt.*;


//todo: load och unload behöver hantera car-transporterns och bilarnas relativa position,
// samt uppdatera position för cargo vid move() (kopiera Orientation från VFM460 till Car?)
public class VolvoFM460CarTransport extends Truck implements Loadable<PersonalVehicle> {
    Loader<PersonalVehicle> loader = new Loader<>(8); // hjälpklass till Loadable

    // default instansiering av klassen
    public VolvoFM460CarTransport(){
        super (460, Color.white, "Volvo FM 460",0, 0, "north");}

    // Specifik instansiering
    public VolvoFM460CarTransport(double enginePower, Color color, double x, double y, String direction){
        super (enginePower, color, "Volvo FM 460",x, y, direction);}

    public void load(PersonalVehicle item) {loader.load(item);}
    public PersonalVehicle unLoad() {return loader.unLoad();}
}
