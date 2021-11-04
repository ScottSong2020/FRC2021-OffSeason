package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.Constants;
import frc.robot.utils.PS4Constants;


public class IntakeSubsystem {

    private static final String operatorControl = null;
    private WPI_TalonSRX intake;
    public void initialize() {
        intake = new WPI_TalonSRX(Constants.INTAKE_MOTOR_ID);
        
    }

    //stops the intake from running
    public void stopIntake() {
        
    }
    
    //intake runs forwards (intakes)
    public void startIntake() {

    }

    //intake runs in the opposite direction (outtakes)
    public void reverseIntake() {
        
    }

    //POVButton operatorIntake = new POVButton(operatorControl, 180); // down
   // POVButton operatorOutake = new POVButton(operatorControl, 0); // up
   // JoystickButton operatorToggleIntake = new JoystickButton(operatorControl, PS4Constants.R1.getId());

}
