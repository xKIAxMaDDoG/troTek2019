// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4240.troTek2019;

import org.usfirst.frc4240.troTek2019.commands.*;
import edu.wpi.first.wpilibj.smartdashboard.*;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.buttons.*;
import org.usfirst.frc4240.troTek2019.subsystems.*;


/**
 * This class is the glue that binds the controls on the physical operator
 * interface to the commands and command groups that allow control of the robot.
 */
public class OI {
    //// CREATING BUTTONS
    // One type of button is a joystick button which is any button on a joystick.
    // You create one by telling it which joystick it's on and which button
    // number it is.
    // Joystick stick = new Joystick(port);
    // Button button = new JoystickButton(stick, buttonNumber);

    // There are a few additional built in buttons you can use. Additionally,
    // by subclassing Button you can create custom triggers and bind those to
    // commands the same as any other Button.

    //// TRIGGERING COMMANDS WITH BUTTONS
    // Once you have a button, it's trivial to bind it to a button in one of
    // three ways:

    // Start the command when the button is pressed and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenPressed(new ExampleCommand());

    // Run the command while the button is being held down and interrupt it once
    // the button is released.
    // button.whileHeld(new ExampleCommand());

    // Start the command when the button is released  and let it run the command
    // until it is finished as determined by it's isFinished method.
    // button.whenReleased(new ExampleCommand());


    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    public JoystickButton jB1;
    public JoystickButton jB2;
    public JoystickButton jB4;
    public JoystickButton jB5;
    public JoystickButton jB6;
    public Joystick xboxController;
    public JoystickButton joystickButton1;
    public JoystickButton joystickButton2;
    public Joystick xbox2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    public OI() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS

        xbox2 = new Joystick(1);
        
        joystickButton2 = new JoystickButton(xbox2, 1);
        joystickButton2.whileHeld(new arm2Down());
        joystickButton1 = new JoystickButton(xbox2, 3);
        joystickButton1.whileHeld(new arm2Up());
        xboxController = new Joystick(0);
        
        jB6 = new JoystickButton(xboxController, 6);
        jB6.whileHeld(new arm2Down());
        jB5 = new JoystickButton(xboxController, 5);
        jB5.whileHeld(new arm2Up());
        jB4 = new JoystickButton(xboxController, 4);
        jB4.whileHeld(new armBigCargo3(0));
        jB2 = new JoystickButton(xboxController, 2);
        jB2.whileHeld(new armBigSecondCargoPID(0));
        jB1 = new JoystickButton(xboxController, 1);
        jB1.whileHeld(new armBigFirstCargoPID(0));


        // SmartDashboard Buttons
        SmartDashboard.putData("Autonomous Command", new AutonomousCommand());
        SmartDashboard.putData("driveWithController", new driveWithController());
        SmartDashboard.putData("armUp", new armUp());
        SmartDashboard.putData("armDown", new armDown());
        SmartDashboard.putData("armStop", new armStop());
        SmartDashboard.putData("arm2Up", new arm2Up());
        SmartDashboard.putData("arm2Down", new arm2Down());
        SmartDashboard.putData("arm2Stop", new arm2Stop());
        SmartDashboard.putData("armBigHold", new armBigHold());
        SmartDashboard.putData("armBigFirstCargoPID: setpoint", new armBigFirstCargoPID(.021));

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    }
        //SmartDashboard Telemetry
       

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
    public Joystick getxboxController() {
        return xboxController;
    }

    public Joystick getxbox2() {
        return xbox2;
    }


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=FUNCTIONS
}

