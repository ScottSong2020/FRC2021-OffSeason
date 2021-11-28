package frc.robot.subsystems.turret;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import frc.robot.config.Config;
import frc.robot.config.Config.TurretConfig;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.MathUtils;

public class TurretSubsystem extends BitBucketsSubsystem {
    
    public TurretSubsystem(Config config, DashboardConfig dashboardConfig) {
        super(config, dashboardConfig);
        //TODO Auto-generated constructor stub
    }

    //Class lacks dashboard updates as of right now
    private WPI_TalonSRX elevation;
    private WPI_TalonSRX azimuth;
    private double azimuthGearRatio = config.turretConfig.AZIMUTH_GEAR_RATIO;
    private double elevationGearRatio = config.turretConfig.ELEVATION_GEAR_RATIO;
    private double ticksPerRevolution = config.turretConfig.TICKS_PER_REVOLUTION;

    public void init() {
        elevation = new WPI_TalonSRX(config.ELEVATION_MOTOR_ID);
        azimuth = new WPI_TalonSRX(config.AZIMUTH_MOTOR_ID);
    }

 
    public void setAzimuth(double degrees) {
         double position = degrees / 360.0 / azimuthGearRatio * ticksPerRevolution;
         MathUtils.clamp(position, -90, 90);
         azimuth.set(ControlMode.Position, position);
    }

    public void setElevation(double degrees) {
        double position = degrees / 360.0 / elevationGearRatio * ticksPerRevolution;
        MathUtils.clamp(position, 0, 60); 
        elevation.set(ControlMode.Position, position);
    }

    public double elevationConvert(double distance) {
        double exampleReturn = 45;
        return exampleReturn;
    }

    public WPI_TalonSRX getElevation() {
        return elevation;
    }
    
    public WPI_TalonSRX getAzimuth() {
        return azimuth;
    }

    @Override
    protected void addMotorsToList() {
        this.motorList.add(elevation);
        this.motorList.add(azimuth);
    }

    @Override
    public void periodic() {
        
    }

    @Override
    public void disable() {
        stopAzimuth();
        stopElevation();
    }
    
    public void stopAzimuth() {
        azimuth.set(0);
    }

    public void stopElevation() {
        elevation.set(0);
    }
}
