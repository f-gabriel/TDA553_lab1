import java.awt.*;
import java.util.List;


public class VolvoFM460CarTransport extends Truck implements Loadable<PersonalVehicle> {
    Loader<PersonalVehicle> loader = new Loader<>(8); // hjälpklass till Loadable

    // default instansiering av klassen
    public VolvoFM460CarTransport(){
        super (460, Color.white, "Volvo FM 460",0, 0, "north");}

    // Specifik instansiering
    public VolvoFM460CarTransport(double enginePower, Color color, double x, double y, String direction){
        super (enginePower, color, "Volvo FM 460",x, y, direction);}


    // metoder från loadable
    public List<PersonalVehicle> getCargo(){return loader.getCargo();}
    public void load(PersonalVehicle item) {
        double maxDistAllowed = 1;
        double distanceX = item.getX() - getX(); // Hämtar x resp. y koordinater för både bil som ska lastas och
        double distanceY = item.getY() - getY(); // lastbilen som lastar och tar skillnaden för dem.

        if (Math.sqrt(Math.pow(distanceX, 2) + Math.pow(distanceY, 2)) <= maxDistAllowed) {
            if (getBedState() == 0) {
                loader.load(item);
            } else {
                System.out.println("Rampen är stängd");
            }
        } else {
            System.out.println("bilen är för långt borta");
        }
    }
    public PersonalVehicle unLoad() {
        if (getBedState() == 0) {
            PersonalVehicle car = loader.unLoad();

            switch (orientation.currentDirection) {
                case NORTH:
                    car.addToCoordinate('y', -1);
                    break;
                case WEST:
                    car.addToCoordinate('x', 1);
                    break;
                case SOUTH:
                    car.addToCoordinate('y', 1);
                    break;
                case EAST: // Skulle kunna skrivas som default istället
                    car.addToCoordinate('x', -1);
                    break;
            }
            return car;
        }
        System.out.println("Rampen är stängd");
        return null;
    }

    // metoder från Car
    @Override
    public void move() {
        super.move();
        for (PersonalVehicle car: getCargo()){
            car.setPosition(getX(),getY());
        }
    }
}
