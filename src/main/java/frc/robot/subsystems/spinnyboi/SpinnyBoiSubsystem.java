package frc.robot.subsystems.spinnyboi;
import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;

public class SpinnyBoiSubsystem extends BitBucketsSubsystem{

    public SpinnyBoiSubsystem(Config config, DashboardConfig dashboardConfig) {
        super(config, dashboardConfig);
    }

    private WPI_TalonSRX spinnyboi;

    @Override
    public void init() {
        spinnyboi = new WPI_TalonSRX(11);
        
    }

    public void spinForward(){
        spinnyboi.set(ControlMode.PercentOutput, 50);
    }

    public void spinBackward(){
        spinnyboi.set(ControlMode.PercentOutput, -50);
    }

    public void stopSpin(){
        spinnyboi.set(0);
    }

    @Override
    protected void addMotorsToList() {
        
    }

    @Override
    public void periodic() {
        
    }

    @Override
    public void disable() {
        
    }
}
