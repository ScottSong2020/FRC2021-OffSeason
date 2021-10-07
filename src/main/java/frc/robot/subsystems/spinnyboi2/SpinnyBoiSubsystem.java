package frc.robot.subsystems.spinnyboi2;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

public class SpinnyBoiSubsystem {
    private WPI_TalonSRX spinnyboi;

    public void initialize(){
        spinnyboi = new WPI_TalonSRX(11);
    }
}
