package frc.robot;

import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj2.command.CommandScheduler;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import edu.wpi.first.wpilibj2.command.RunCommand;
import frc.robot.subsystems.climber.ClimberSubsystem;
import frc.robot.subsystems.drive.DriveSubsystem;
import frc.robot.subsystems.shooter.ShooterSubsystem;
import frc.robot.subsystems.spinnyboi.SpinnyBoiSubsystem;
import frc.robot.subsystems.turret.TurretSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.PS4Constants;

import java.sql.Driver;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;

public class Robot extends TimedRobot {

    public static final List<BitBucketsSubsystem> robotSubsystems = new ArrayList<>();
    private final Buttons buttons = new Buttons();
    private Config config;
    private DashboardConfig dashboardConfig;

    private ClimberSubsystem climberSubsystem;
    private ShooterSubsystem shooterSubsystem;
    private DriveSubsystem driveSubsystem;
    private SpinnyBoiSubsystem spinnyBoiSubsystem;
    private TurretSubsystem turretSubsystem;
    
    private ExecutorService smartDashboardThread = Executors.newSingleThreadExecutor();

    private List<BitBucketsSubsystem> subsystems = new ArrayList<>();

    private boolean disableDash = false;

    @Override
    public void robotInit() {

        this.dashboardConfig = new DashboardConfig();
        this.config = new Config();

        //SpinnyBoi Subsystem motors
        spinnyBoiSubsystem = new SpinnyBoiSubsystem(config, dashboardConfig);
        spinnyBoiSubsystem.init();

        buttons.operatorSpinForward.whenPressed(() -> {
            spinnyBoiSubsystem.spinForward();
        });

        buttons.operatorSpinBackward.whenPressed(() -> {
            spinnyBoiSubsystem.spinBackward();
        });

        buttons.operatorSpinForward.whenReleased(() -> {
            spinnyBoiSubsystem.stopSpin();
        });

        buttons.operatorSpinBackward.whenReleased(() -> {
            spinnyBoiSubsystem.stopSpin();
        });

        climberSubsystem = new ClimberSubsystem(config, dashboardConfig);
        climberSubsystem.init();

        this.shooterSubsystem = new ShooterSubsystem(this.config, this.dashboardConfig);
        this.shooterSubsystem.init();

        this.turretSubsystem = new TurretSubsystem(config, this.dashboardConfig);
        this.turretSubsystem.init();

        subsystems.add(climberSubsystem);
        subsystems.add(shooterSubsystem);

        for(BitBucketsSubsystem subsystemsToBeAdded: subsystems)
        {
            subsystemsToBeAdded.init();
        }
        
        // Initialize all subsystems (do this AFTER subsystem objects are created and
        // instantiated)

      robotSubsystems.forEach(BitBucketsSubsystem::init);

        climberSubsystem.setDefaultCommand(new RunCommand(
                () -> climberSubsystem.moveArms(buttons.operatorControl.getRawAxis(buttons.climbLeftAmnt),
                        buttons.operatorControl.getRawAxis(buttons.climbRightAmnt)),
                climberSubsystem));

        buttons.operatorClimbActivated.whenPressed(() -> climberSubsystem.setOperatorActive());
        buttons.operatorClimbActivated.whenReleased(() -> climberSubsystem.setOperatorInactive());
        buttons.operatorClimbActivated.whenPressed(() -> climberSubsystem.setDriverActive());
        buttons.operatorClimbActivated.whenReleased(() -> climberSubsystem.setDriverInActive());
        
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
        
        Buttons b = new Buttons();

        driveSubsystem.setDefaultCommand(new RunCommand(
            () -> DriveSubsystem.drive(
                b.driverControl.getRawAxis(b.driveSpeedAxis),
                b.driverControl.getRawAxis(b.driveTurnAxis)),
                driveSubsystem)
        );
        


        smartDashboardThread.submit(() -> {
            // run forever
            while(true) {
                // check if we should still be running, and break if not
                if(disableDash)
                {
                    break;
                }

                // do some updates
                for(BitBucketsSubsystem subsystemsToBeAdded: subsystems)
                {
                    subsystemsToBeAdded.updateDashboard();
                }
                // only update once a second
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    // TODO Auto-generated catch block
                    e.printStackTrace();
                }
            }
        });
    }

    @Override
    public void robotPeriodic() {

        // Run periodic function on all subsystems each time robotPeriodic is called
        robotSubsystems.forEach(BitBucketsSubsystem::periodic);

        CommandScheduler.getInstance().run();
    }

    @Override
    public void teleopInit() {

    }

    public static Robot win() {
        return new Robot();
    }

}