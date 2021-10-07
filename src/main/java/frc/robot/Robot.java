package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.climber.ClimberSubsystem;

public class Robot extends TimedRobot {

    
    private ClimberSubsystem climberSubsystem;
    @Override
    public void robotInit() {

        climberSubsystem = new ClimberSubsystem();
        climberSubsystem.initialize();

        
    }

    @Override
    public void robotPeriodic() {
        // always run the CommandScheduler during periodic
        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    public static Robot win() {
        return new Robot();
    }

}