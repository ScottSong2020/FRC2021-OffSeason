package frc.robot.subsystems.intake;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.WPI_TalonSRX;

import edu.wpi.first.wpilibj.Compressor;
import edu.wpi.first.wpilibj.DoubleSolenoid;
import edu.wpi.first.wpilibj.Solenoid;
import edu.wpi.first.wpilibj.DoubleSolenoid.Value;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj2.command.button.POVButton;
import frc.robot.Constants;
import frc.robot.config.Config;
import frc.robot.subsystems.BitBucketsSubsystem;
import frc.robot.utils.DashboardConfig;
import frc.robot.utils.PS4Constants;


public class IntakeSubsystem extends BitBucketsSubsystem {

    public IntakeSubsystem(Config config, DashboardConfig dashboardConfig) {
        super(config, dashboardConfig);
        //TODO Auto-generated constructor stub
    }

    private WPI_TalonSRX intake;

    @Override
    public void init() {
        intake = new WPI_TalonSRX(config.INTAKE_MOTOR_ID);

    }
    //intake starts (runs forward)

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


    public void spinForward() {
        intake.set(ControlMode.PercentOutput, 0.5);
    }


    public void spinBackward() {
        intake.set(ControlMode.PercentOutput, -0.5);
    }


    public void startSpinning() {
        intake.set(ControlMode.PercentOutput, 0.5);
    }


    public void stopSpinning() {
        intake.set(ControlMode.PercentOutput, 0);
    }

    public void pneumatics() {

    //creates closed loop control to allow pressure to be stored
        Compressor c = new Compressor(0);
        c.setClosedLoopControl(true);
        c.setClosedLoopControl(false);

        boolean enabled = c.enabled();
        boolean pressureSwitch =c.getPressureSwitchValue();
        double current = c.getCompressorCurrent();

    //declaring a solenoid
        Solenoid exampleSolenoid = new Solenoid(1);
        exampleSolenoid.set(true);
        exampleSolenoid.set(false);

    //double solenoid for intake
        DoubleSolenoid intakeSolenoid = new DoubleSolenoid(1, 2);
        intakeSolenoid.set(Value.kOff);
        intakeSolenoid.set(Value.kForward);
        intakeSolenoid.set(Value.kReverse);

    //conditionals for toggling solenoids
    
    }
}
