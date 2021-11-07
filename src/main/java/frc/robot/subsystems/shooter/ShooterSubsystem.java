package frc.robot.subsystems.shooter;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.Constants;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.DashboardKey;

import java.util.Arrays;
import java.util.List;

public class ShooterSubsystem extends BitBucketsSubsystem
{
    private boolean isFeeding;
    private boolean isShooting;

    private WPI_TalonSRX feederMotor;
    private WPI_TalonSRX shooterMotor;

    public ShooterSubsystem(Config config,DashboardConfig dbConfig)
    {
        super(config,dbConfig);
    }

    @Override
    public void init()
    {
        this.feederMotor = new WPI_TalonSRX(config.FEEDER_MOTOR_ID);
        this.shooterMotor = new WPI_TalonSRX(config.SHOOTER_MOTOR_ID);

        this.isFeeding = false;
        this.isShooting = false;
    }

    @Override
    protected void addMotorsToList()
    {
        this.motorList.add(this.feederMotor);
        this.motorList.add(this.shooterMotor);
    }

    @Override
    public void periodic()
    {

    }

    public void spinFeeder(float target)
    {
        this.isFeeding = true;
        this.feederMotor.set(ControlMode.PercentOutput, target);

        this.updateDashboard(DashboardKey.FEEDER_STATE, "Feeding");
    }

    public void stopFeeder()
    {
        this.isFeeding = false;
        this.feederMotor.set(0);

        this.updateDashboard(DashboardKey.FEEDER_STATE, "Off");
    }

    public void spinShooter(float target)
    {
        this.isShooting = true;
        this.shooterMotor.set(ControlMode.PercentOutput, target);

        this.updateDashboard(DashboardKey.SHOOTER_STATE, "Shooting");
    }

    public void stopShooter()
    {
        this.isShooting = false;
        this.shooterMotor.set(0);

        this.updateDashboard(DashboardKey.SHOOTER_STATE, "Off");
    }

    @Override
    public void disable()
    {
        this.stopFeeder();
        this.stopShooter();
    }

    public boolean isFeeding()
    {
        return this.isFeeding;
    }

    public boolean isShooting()
    {
        return this.isShooting;
    }
}