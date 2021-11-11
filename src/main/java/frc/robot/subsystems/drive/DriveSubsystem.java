package frc.robot.subsystems.drive;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.drive.DifferentialDrive;
import frc.robot.subsystems.BitBucketsSubsystem;

public class DriveSubsystem extends BitBucketsSubsystem{
    private WPI_TalonSRX leftDriveLeader;
    private WPI_TalonSRX rightDriveLeader;
    private WPI_TalonSRX rightDriveFollower;
    private WPI_TalonSRX leftDriveFollower;
    private DifferentialDrive differentialDrive;
    @Override
    public void init() {
        rightDriveLeader = new WPI_TalonSRX(1);
        leftDriveLeader = new WPI_TalonSRX(2);
        rightDriveFollower = new WPI_TalonSRX(3);
        leftDriveFollower = new WPI_TalonSRX(4);

        DifferentialDrive m_drive = new DifferentialDrive(leftDriveLeader, rightDriveLeader);
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
    public static Object drive(double rawAxis, double rawAxis2) {
        return null;
    }
    

    
}
