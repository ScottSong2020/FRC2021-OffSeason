package frc.robot.subsystems.vision;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;

public class VisionSubsystem {
   private double angle;
   private double distance;
   
    
   public void initialize(){
       
   }

//hi matt it's zak i am sorry for invading ur code
//if u could write the vision func in a way that returns the angle and dist for me that would be epic 
   public double getAngle() {
      angle = 32.0;
      return angle;
   }
   public double getDistance() {
      distance = 87.0;
      return distance;
   }

}
