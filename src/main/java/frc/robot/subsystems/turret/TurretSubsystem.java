package frc.robot.subsystems.turret;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class TurretSubsystem {
    
    private WPI_TalonSRX elevation;
    private WPI_TalonSRX azimuth;
    private double azimuthGearRatio = 28.0/130.0;
    private double elevationGearRatio = 40.0/70.0;
    private double ticksPerRevolution = 8192.0;

    public void initialize() {
        elevation = new WPI_TalonSRX(7);
        azimuth = new WPI_TalonSRX(6);
    }

    public void setAzimuth(double degrees) {
         double position = degrees / 360.0 / azimuthGearRatio * ticksPerRevolution;
         azimuth.set(ControlMode.Position, position);
    }

    public void setElevation(double degrees) {
        double position = degrees / 360.0 / elevationGearRatio * ticksPerRevolution;
        elevation.set(ControlMode.Position, position);
    }

    public WPI_TalonSRX getElevation() {
        return elevation;
    }
    
    public WPI_TalonSRX getAzimuth() {
        return azimuth;
    }
}
