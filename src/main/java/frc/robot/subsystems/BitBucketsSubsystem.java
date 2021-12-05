package frc.robot.subsystems;

import com.ctre.phoenix.motorcontrol.can.BaseTalon;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Sendable;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.SubsystemBase;
import frc.robot.Robot;
import frc.robot.config.Config;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.DashboardKey;

import java.util.ArrayList;
import java.util.List;

public abstract class BitBucketsSubsystem extends SubsystemBase
{
    protected final DriverStation driverStation;
    protected final Config config;
    protected final DashboardConfig dashboardConfig;

    protected final List<BaseTalon> motorList;

    public BitBucketsSubsystem(Config config, DashboardConfig dashboardConfig)
    {
        this.setName(this.getClass().getSimpleName());

        this.driverStation = DriverStation.getInstance();
        this.config = config;
        this.dashboardConfig = dashboardConfig;

        this.motorList = new ArrayList<>();
        this.addMotorsToList();

        Robot.robotSubsystems.add(this);
    }

    //Required Implementations

    //Called when the subsystem is first initialized
    public abstract void init();

    //Used to add all subsystem specific motor objects to the motor list
    protected abstract void addMotorsToList();

    //Called periodically
    public abstract void periodic();

    //Called when subsystem is closed/disabled
    public abstract void disable();

    //Get motors used by subsystem
    public List<? extends BaseTalon> getMotorList()
    {
        return this.motorList;
    }

    //Dashboard Updates
    protected <T> void setDashboardValue(DashboardKey enumKey, T value)
    {
        if(!this.dashboardConfig.isEnabled(enumKey)) return;

        String key = this.getName() + "/" + enumKey.name;

        if(value instanceof Boolean) SmartDashboard.putBoolean(key, (boolean)value);
        else if(value instanceof Integer || value instanceof Double || value instanceof Float) SmartDashboard.putNumber(key, (double)value);
        else if(value instanceof String) SmartDashboard.putString(key, (String)value);
        else if(value instanceof Sendable) SmartDashboard.putData(key, (Sendable)value);
    }

    public void updateDashboard()
    {

    }
}
