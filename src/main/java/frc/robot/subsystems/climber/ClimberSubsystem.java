package frc.robot.subsystems.climber;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.XboxController.Button;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;
import edu.wpi.first.wpilibj2.command.SubsystemBase;

public class ClimberSubsystem extends BitBucketsSubsystem
{
    public ClimberSubsystem(DashboardConfig dashboardConfig) {
        super(dashboardConfig);
        //TODO Auto-generated constructor stub
    }
    private WPI_TalonSRX leftArm;
    private WPI_TalonSRX rightArm;
    boolean pit = false;
    double motorSpeed = 0.1;
    boolean activateClimber = false;
    boolean operatorHolding = false;
    boolean driverHolding = false;
    double leftArmMoved1;
    double rightArmMoved1;

    @Override
    public void init() {
       // leftArm = new WPI_TalonSRX(12);
       // rightArm = new WPI_TalonSRX(8);
        // junior motors
       leftArm = new WPI_TalonSRX(1);
       rightArm = new WPI_TalonSRX(2);
       rightArm.setInverted(true);
       SmartDashboard.putNumber("climberSubsystem/leftArm", leftArmMoved1);
       SmartDashboard.putNumber("climberSubsystem/rightArm", rightArmMoved1);

        SmartDashboard.setDefaultBoolean(this.getName() + "/pitEnabled", false);
        SmartDashboard.setDefaultNumber(this.getName() + "/motorSpeed", 0.1);
    }

    public void moveArms(double leftArmMoved,double rightArmMoved)
    {
        if(!pit)
        {
            leftArmMoved1 = Math.abs(leftArmMoved)*motorSpeed;
            rightArmMoved1 = Math.abs(rightArmMoved)*motorSpeed;

        }
        else
        {
            leftArmMoved1 = (leftArmMoved)*motorSpeed;
            rightArmMoved1 = (rightArmMoved)*motorSpeed;  

        }
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


        var pitEnabled = SmartDashboard.getBoolean(this.getName() + "/pitEnabled", false);
        var motorValues = SmartDashboard.getNumber(this.getName() + "/motorSpeed", 0.1);
        motorSpeed = motorValues;
        if (motorSpeed < 0)
        {
            motorSpeed = 0;
        }
        if (motorSpeed > 1)
        {
            motorSpeed =1;
        }
        pit = pitEnabled;

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
    
    @Override
    protected void addMotorsToList() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void periodic() {
        // TODO Auto-generated method stub
        
    }
    @Override
    public void disable() {
        // TODO Auto-generated method stub
        
    }
   
}
