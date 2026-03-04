import Cars.Car;

import java.awt.event.ActionEvent;

public interface ControllPanelListener {
    void actOnGasButton(int gasAmount);
    void actOnBrakeButton(int brakeAmount);
    void actOnTurboOnButton();
    void actOnTurboOffButton();
    void actOnLiftBedButton();
    void actOnLowerBedButton();
    void actOnStartButton();
    void actOnStopButton();
}
