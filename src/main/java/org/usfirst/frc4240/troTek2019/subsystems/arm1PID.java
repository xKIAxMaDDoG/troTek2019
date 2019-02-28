// RobotBuilder Version: 2.0
//
// This file was generated by RobotBuilder. It contains sections of
// code that are automatically generated and assigned by robotbuilder.
// These sections will be updated in the future when you export to
// Java from RobotBuilder. Do not put any code or make any change in
// the blocks indicating autogenerated code or it will be lost on an
// update. Deleting the comments indicating the section will prevent
// it from being updated in the future.


package org.usfirst.frc4240.troTek2019.subsystems;

import org.usfirst.frc4240.troTek2019.Robot;
import org.usfirst.frc4240.troTek2019.commands.*;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.command.PIDSubsystem;
import edu.wpi.first.wpilibj.PIDSource;
import edu.wpi.first.wpilibj.PIDOutput;
import edu.wpi.first.wpilibj.livewindow.LiveWindow;
// BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.PIDSourceType;
import edu.wpi.first.wpilibj.SpeedControllerGroup;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class arm1PID extends PIDSubsystem {

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    private WPI_TalonSRX armTalon1;
    private WPI_TalonSRX armTalon2;
    private SpeedControllerGroup armSpeedController;
    private Encoder armQuad1;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS

    //Add Presets For armBIG locations
    public static final double 
    TOP = .035,
    MIDDLE = .03,
    BOTTOM = .021,
    STOW = .001;
    // Initialize your subsystem here
    
    public arm1PID() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("arm1PID", 0.5, 0.0, 0.0);
        setAbsoluteTolerance(0.002);
        getPIDController().setContinuous(false);
        getPIDController().setName("arm1PID", "PIDSubsystem Controller");
        LiveWindow.add(getPIDController());
        getPIDController().setOutputRange(-5.0, 5.0);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        //setSetpoint(STOW);
        //enable();
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        armTalon1 = new WPI_TalonSRX(7);
        
        
        
        armTalon2 = new WPI_TalonSRX(5);
        
        
        
        armSpeedController = new SpeedControllerGroup(armTalon1, armTalon2  );
        addChild("armSpeedController",armSpeedController);
        
        
        armQuad1 = new Encoder(2, 3, false, EncodingType.k4X);
        addChild("armQuad1",armQuad1);
        armQuad1.setDistancePerPulse(0.001);
        armQuad1.setPIDSourceType(PIDSourceType.kDisplacement);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS


        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
        setSetpoint(0.0);
    	disable();
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        //setDefaultCommand(new MySpecialCommand());
    }

    @Override
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

        return armQuad1.getDistance();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }

    @Override
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        armSpeedController.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    public void armUp () {
        Robot.arm1PID.armSpeedController.set(-.35);
    }
    public void armDown () {
        Robot.arm1PID.armSpeedController.set(.1);
    }
    public void armStop () {
        Robot.arm1PID.armSpeedController.stopMotor();
    }
    //Place encoder stuff here
    public double getRate () {
        return armQuad1.getRate();
    }
    public double getDistance() {
        return armQuad1.getDistance();
    }
    public boolean getDirection () {
        return armQuad1.getDirection();
    }
    public void resetBigEncoder() {
        armQuad1.reset();
    }
    public void spinForward (double forward) {
        Robot.arm1PID.armSpeedController.set(forward);
    }
    public void armHold () {
        Robot.arm1PID.armSpeedController.set(-.25);
    }
    public double driveWithTrigger () {
        return Robot.oi.xboxController.getRawAxis(2);
    }
    

}