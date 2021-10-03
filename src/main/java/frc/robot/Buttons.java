package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.utils.PS4Constants;

public class Buttons {

    Joystick driverControl = new Joystick(0);
    Joystick operatorControl = new Joystick(1);

    //Shooter Subsystem

    JoystickButton operatorAimBot = new JoystickButton(operatorControl, PS4Constants.R2.getValue());
    JoystickButton operatorSpinUp = new JoystickButton(operatorControl, PS4Constants.L1.getValue());
    JoystickButton operatorFeeder = new JoystickButton(operatorControl, PS4Constants.L2.getValue());
    JoystickButton operatorFire = new JoystickButton(operatorControl, PS4Constants.CIRCLE.getValue());
    JoystickButton operatorZero = new JoystickButton(operatorControl, PS4Constants.SQUARE.getValue());

    int operatorAzimuth = PS4Constants.RIGHT_STICK_X.getValue();
    int operatorElevation = PS4Constants.RIGHT_STICK_Y.getValue();

    POVButton operatorNextElevation = new POVButton(operatorControl, 90); // right
    POVButton operatorLastElevation = new POVButton(operatorControl, 270); // left

    JoystickButton setElevationToDashboardNum = new JoystickButton(operatorControl, PS4Constants.OPTIONS.getValue());
}
