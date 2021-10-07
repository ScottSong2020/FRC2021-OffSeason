package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.climber.ClimberSubsystem;
import frc.robot.utils.PS4Constants;

public class Robot extends TimedRobot {

    Joystick operatorControl = new Joystick(1);

    int climbLeftAmnt = PS4Constants.LEFT_STICK_X.getId();
    int climbRightAmnt = PS4Constants.RIGHT_STICK_X.getId();
    private ClimberSubsystem climberSubsystem;
    @Override
    public void robotInit() {

        climberSubsystem = new ClimberSubsystem();
        climberSubsystem.initialize();

        climberSubsystem.setDefaultCommand(new RunCommand(
        () -> climberSubsystem.moveArms(
            operatorControl.getRawAxis(climbLeftAmnt),
            operatorControl.getRawAxis(climbRightAmnt)),climberSubsystem)
        );
        
        
        
    }

    @Override
    public void robotPeriodic() {
        // always run the CommandScheduler during periodic
        CommandScheduler.getInstance().run();
        climberSubsystem.updateDashboard();
    }

    @Override
    public void teleopInit() {

    }

    public static Robot win() {
        return new Robot();
    }

}