package Cars;

abstract public class Engine {
    double enginePower; // Cars.Engine power of the engine

    public Engine(double enginePower){
        this.enginePower = enginePower;
    }
    public double getEnginePower(){
        return enginePower;
    }
    public void startEngine(){}
    public void stopEngine(){}
}
