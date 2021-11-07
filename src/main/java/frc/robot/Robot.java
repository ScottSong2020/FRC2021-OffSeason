package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.climber.ClimberSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.PS4Constants;

import java.util.ArrayList;
import java.util.List;

public class Robot extends TimedRobot {

    public static final List<BitBucketsSubsystem> robotSubsystems = new ArrayList<>();
    private final Buttons buttons = new Buttons();
    private Config config;
    private DashboardConfig dashboardConfig;

    private ClimberSubsystem climberSubsystem;
    private ShooterSubsystem shooterSubsystem;

    @Override
    public void robotInit() {

        this.dashboardConfig = new DashboardConfig();
        this.config = new Config();

        climberSubsystem = new ClimberSubsystem();
        climberSubsystem.initialize();

        this.shooterSubsystem = new ShooterSubsystem(this.config, this.dashboardConfig);
        this.shooterSubsystem.init();

        // Initialize all subsystems (do this AFTER subsystem objects are created and
        // instantiated)
        robotSubsystems.forEach(BitBucketsSubsystem::init);

        climberSubsystem.setDefaultCommand(new RunCommand(
                () -> climberSubsystem.moveArms(buttons.operatorControl.getRawAxis(buttons.climbLeftAmnt),
                        buttons.operatorControl.getRawAxis(buttons.climbRightAmnt)),
                climberSubsystem));

        buttons.operatorFeeder.whenPressed(new InstantCommand(() -> {
            if (shooterSubsystem.isFeeding())
                shooterSubsystem.stopFeeder();
            else
                shooterSubsystem.spinFeeder(0.5F);
        }, shooterSubsystem));

        buttons.operatorSpinUp.whenPressed(new InstantCommand(() -> {
            if (shooterSubsystem.isShooting())
                shooterSubsystem.stopShooter();
            else
                shooterSubsystem.spinShooter(0.5F);
        }, shooterSubsystem));
    }

    @Override
    public void robotPeriodic() {

        // Run periodic function on all subsystems each time robotPeriodic is called
        robotSubsystems.forEach(BitBucketsSubsystem::periodic);

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