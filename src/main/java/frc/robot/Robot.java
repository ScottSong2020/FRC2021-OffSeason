package frc.robot;

import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.subsystems.climber.ClimberSubsystem;

import java.util.ArrayList;
import java.util.List;

public class Robot extends TimedRobot {

    public static final List<BitBucketsSubsystem> ROBOT_SUBSYSTEMS = new ArrayList<>();
    
    private ClimberSubsystem climberSubsystem;
    
    @Override
    public void robotInit() {

        climberSubsystem = new ClimberSubsystem();
        climberSubsystem.initialize();
        

        //Initialize all subsystems (do this AFTER subsystem objects are created and instantiated)
        ROBOT_SUBSYSTEMS.forEach(BitBucketsSubsystem::init);
    }

    @Override
    public void robotPeriodic() {

        //Run periodic function on all subsystems each time robotPeriodic is called
        ROBOT_SUBSYSTEMS.forEach(BitBucketsSubsystem::periodic);

        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    public static Robot win() {
        return new Robot();
    }

}