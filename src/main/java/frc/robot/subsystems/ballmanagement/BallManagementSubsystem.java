package frc.robot.subsystems.ballmanagement;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;

public class BallManagementSubsystem extends BitBucketsSubsystem {

    public BallManagementSubsystem(Config config, DashboardConfig dashboardConfig) {
        super(config, dashboardConfig);
    }

    private WPI_TalonSRX ballmanagement;

    public void init() {
        ballmanagement = new WPI_TalonSRX(config.BALL_MANAGEMENT_MOTOR_ID);
    }

    public WPI_TalonSRX getBallmanagement() {
        return ballmanagement;
    }

    public void startSpinning() {
        ballmanagement.set(ControlMode.PercentOutput, 0.5);
    }

    public void stopSpinning() {
        ballmanagement.set(0);
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
