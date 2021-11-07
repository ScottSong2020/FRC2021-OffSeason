package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends SubsystemBase
{
    private WPI_TalonSRX leftArm;
    private WPI_TalonSRX rightArm;
    
    boolean activateClimber = false;
    boolean operatorHolding = false;
    boolean driverHolding = false;
    double leftArmMoved1;
    double rightArmMoved1;

    public void initialize() {
        leftArm = new WPI_TalonSRX(12);
        rightArm = new WPI_TalonSRX(8);
        // junior motors
     //  leftArm = new WPI_TalonSRX(1);
       //rightArm = new WPI_TalonSRX(2);
       rightArm.setInverted(true);
    }
    public void moveArms(double leftArmMoved,double rightArmMoved)
    {
        leftArmMoved1 = Math.abs(leftArmMoved)*1;
        rightArmMoved1 = Math.abs(rightArmMoved)*1;

        if(activateClimber)
        {
            leftArm.set(ControlMode.PercentOutput,leftArmMoved1);
            rightArm.set(ControlMode.PercentOutput,rightArmMoved1);
            
        }

    }   
    public void updateDashboard()
    {
        SmartDashboard.putNumber("climberSubsystem/leftArm", leftArmMoved1);
        SmartDashboard.putNumber("climberSubsystem/rightArm", rightArmMoved1);

    }
    public void setOperatorActive() {
        operatorHolding = true;
        if(operatorHolding && driverHolding)
        {
            activateClimber = true;
        }
     }
     public void setOperatorInactive() {
        operatorHolding = false;
    
     }
     public void setDriverActive() {
        driverHolding = true;
        if(operatorHolding && driverHolding)
        {
            activateClimber = true;
        }
     }
     public void setDriverInActive() 
     {
        driverHolding = false;
     }
   
}
