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

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=IMPORTS

/**
 *
 */
public class arm2PID extends PIDSubsystem {
    

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTANTS

    
    private WPI_TalonSRX armTalon3;
    public static Encoder armQuad2;

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DECLARATIONS
    
    //Put encoder setpoints here
    public static final double 
    test = 1;
    
    public double currentPosition (double position) {
        position = armQuad2.getDistance();

    return position;
    }

    
    
    //double currentPosition = armQuad2.getDistance();
    // public static final double 
    


    // Initialize your subsystem here
    public arm2PID() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID
        super("arm2PID", 0.5, 0.0, 0.0);
        setAbsoluteTolerance(0.2);
        getPIDController().setContinuous(false);
        getPIDController().setName("arm2PID", "PIDSubsystem Controller");
        LiveWindow.add(getPIDController());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=PID

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
        armTalon3 = new WPI_TalonSRX(4);
        
        
        
        armQuad2 = new Encoder(0, 1, false, EncodingType.k4X);
        addChild("armQuad2",armQuad2);
        armQuad2.setDistancePerPulse(0.001);
        armQuad2.setPIDSourceType(PIDSourceType.kRate);
        

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CONSTRUCTORS
    
        // Use these to get going:
        // setSetpoint() -  Sets where the PID controller should move the system
        //                  to
        // enable() - Enables the PID controller.
    }

    @Override
    public void initDefaultCommand() {
        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        setDefaultCommand(new arm2Stop());

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=DEFAULT_COMMAND

        // Set the default command for a subsystem here.
        // setDefaultCommand(new MySpecialCommand());
    }

    @Override
    protected double returnPIDInput() {
        // Return your input value for the PID loop
        // e.g. a sensor, like a potentiometer:
        // yourPot.getAverageVoltage() / kYourMaxVoltage;

       
        return armQuad2.getDistance();

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=SOURCE
    }

    @Override
    protected void usePIDOutput(double output) {
        // Use output to drive your system, like a motor
        // e.g. yourMotor.set(output);

        // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
        armTalon3.pidWrite(output);

    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=OUTPUT
    }

    // BEGIN AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS


    // END AUTOGENERATED CODE, SOURCE=ROBOTBUILDER ID=CMDPIDGETTERS
    public void armStop () {
        armTalon3.stopMotor();
    }
    public void arm2Up () {
        armTalon3.set(-.1);
    }
    public void arm2Down () {
        armTalon3.set(.1);
    }
    //Put Encoder Stuff here mane
    public double getRate() {
        return armQuad2.getRate();
    }
    public double getDistance() {
        return armQuad2.getDistance();
    }
    public boolean getDirection () {
        return armQuad2.getDirection();
    }
    public void resetSmallEncoder() {
        armQuad2.reset();
    }
    public void spinForward (double forward) {
        Robot.arm2PID.armTalon3.set(forward);
    }
    
}