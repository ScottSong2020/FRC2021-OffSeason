package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.utils.PS4Constants;

public class Buttons {

    Joystick driverControl = new Joystick(0);
    Joystick operatorControl = new Joystick(1);

    JoystickButton operatorSpinForward = new JoystickButton(operatorControl, PS4Constants.TRIANGLE.getId());
    JoystickButton operatorSpinBackward = new JoystickButton(operatorControl, PS4Constants.CROSS.getId());
    
}
