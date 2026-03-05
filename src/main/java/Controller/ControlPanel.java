package Controller;

import javax.swing.*;
import javax.swing.event.ChangeEvent;
import javax.swing.event.ChangeListener;
import java.awt.*;
import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.util.ArrayList;

public class ControlPanel extends JPanel {
    private static final int FrameSizeX = 800;
    private static final int FrameSizeY = 800;

    ArrayList<ControllPanelListener> listeners = new ArrayList<>();

    JPanel controlPanel = new JPanel();

    JPanel gasPanel = new JPanel();
    JSpinner gasSpinner = new JSpinner();
    int gasAmount = 0;
    JLabel gasLabel = new JLabel("Amount of gas");


    JButton gasButton = new JButton("Gas");
    JButton brakeButton = new JButton("Brake");
    JButton turboOnButton = new JButton("Saab Turbo on");
    JButton turboOffButton = new JButton("Saab Turbo off");
    JButton liftBedButton = new JButton("Lift Bed");
    JButton lowerBedButton = new JButton("Lower Bed");

    JButton startButton = new JButton("Start all cars");
    JButton stopButton = new JButton("Stop all cars");

    JButton AddCarButton = new JButton("Add Volvo240");
    JButton RemoveCarButton = new JButton("Remove Car");
    public  ControlPanel(){
        initComponents();
    }

    private void initComponents(){

        SpinnerModel spinnerModel =
                new SpinnerNumberModel(0, //initial value
                        0, //min
                        1, //max
                        1);//step
        gasSpinner = new JSpinner(spinnerModel);
        gasSpinner.addChangeListener(new ChangeListener() {
            public void stateChanged(ChangeEvent e) {
                gasAmount = (int) ((JSpinner)e.getSource()).getValue();
            }
            }
        );

        gasPanel.setLayout(new BorderLayout());
        gasPanel.add(gasLabel, BorderLayout.PAGE_START);
        gasPanel.add(gasSpinner, BorderLayout.PAGE_END);

        this.add(gasPanel);

        controlPanel.setLayout(new GridLayout(2,4));

        controlPanel.add(gasButton, 0);
        controlPanel.add(turboOnButton, 1);
        controlPanel.add(liftBedButton, 2);
        controlPanel.add(brakeButton, 3);
        controlPanel.add(turboOffButton, 4);
        controlPanel.add(lowerBedButton, 5);
        controlPanel.add(AddCarButton, 6);
        controlPanel.add(RemoveCarButton, 7);
        controlPanel.setPreferredSize(new Dimension((FrameSizeX /2)+4, 200));
        this.add(controlPanel);
        controlPanel.setBackground(Color.CYAN);


        startButton.setBackground(Color.blue);
        startButton.setForeground(Color.green);
        startButton.setPreferredSize(new Dimension(FrameSizeX /5-15,200));
        this.add(startButton);


        stopButton.setBackground(Color.red);
        stopButton.setForeground(Color.black);
        stopButton.setPreferredSize(new Dimension(FrameSizeX /5-15,200));
        this.add(stopButton);

        // This actionListener is for the gas button only
        gasButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(ControllPanelListener l : listeners){
                    l.actOnGasButton(gasAmount);
                }

//                for(Car car : cars){
//                carC.gas(gasAmount, car);}
            }
        });

        brakeButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                int brakeAmount = gasAmount;
                for(ControllPanelListener l : listeners){
                    l.actOnBrakeButton(brakeAmount);
                }

//                for(Car car : cars){
//                carC.brake(brakeAmount);}
            }
        });
        turboOnButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(ControllPanelListener l : listeners){
                    l.actOnTurboOnButton();
                }

//                for(Car car : cars){
//                carC.turboOn();}
            }
        });
        turboOffButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(ControllPanelListener l : listeners){
                    l.actOnTurboOffButton();
                }

//                    for(Car car : cars){
//                carC.turboOff(car);}
            }
        });
        liftBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(ControllPanelListener l : listeners){
                    l.actOnLiftBedButton();
                }

//                for(Car car : cars){
//                carC.liftBed(car);}
            }
        });
        lowerBedButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                System.out.println("in lower bed button");
                for(ControllPanelListener l : listeners){
                    l.actOnLowerBedButton();
                }

//                for(Car car : cars){
//                carC.lowerBed(car);}
            }
        });

        startButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(ControllPanelListener l : listeners){
                    l.actOnStartButton();
                }

//                for(Car car : cars){
//                carC.startEngine(car);}
            }
        });
        stopButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for (ControllPanelListener l : listeners) {
                    l.actOnStopButton();
                }

//                for(Car car : cars){
//                carC.stopEngine(car);}
            }});
        AddCarButton.addActionListener(new ActionListener() {
           @Override
           public void actionPerformed(ActionEvent e) {
               for(ControllPanelListener l : listeners){
                   l.actOnAddCarButton();
               }
           }
        });
        RemoveCarButton.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                for(ControllPanelListener l : listeners){
                    l.actOnRemoveCarButton();
                }
            }
        });
    }



    public void addListener(ControllPanelListener l){
        listeners.add(l);
    }
}
