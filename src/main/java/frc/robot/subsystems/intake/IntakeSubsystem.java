package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.PS4Constants;


public class IntakeSubsystem extends BitBucketsSubsystem{

    public IntakeSubsystem(Config config, DashboardConfig dashboardConfig) {
        super(config, dashboardConfig);
        //TODO Auto-generated constructor stub
    }

    private WPI_TalonSRX intake;

    @Override
    public void init() {
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
