package frc.robot.config;

public class Config {

  // List of subsystem names:
  // Autonomous
  // BallManagement
  // Climber
  // Drive
  // Intake
  // Shooter
  // Spinnyboi
  // Turret
  // Vision

  //////////////////////////////////////////////////////////////////////////////
  // Subsystem Enablers
  public boolean enableBallManagementSubsytem = true;
  public boolean enableClimberSubsytem = true;
  public boolean enableDriveSubsytem = true;
  public boolean enableIntakeSubsytem = true;
  public boolean enableShooterSubsytem = true;
  public boolean enableSpinnyboiSubsytem = true;
  public boolean enableTurretSubsytem = true;
  public boolean enableVisionSubsytem = true;

  //////////////////////////////////////////////////////////////////////////////
  // Motor IDs

  // BallManagement Subsystem
  public int BALL_MANAGEMENT_MOTOR_ID = 14;

  // Climber Subsystem
  public int LEFT_ARM_MOTOR_ID = 12;
  public int RIGHT_ARM_MOTOR_ID = 8;

  // Drive Subsystem
  public int RIGHT_DRIVE_LEADER_ID = 1;
  public int LEFT_DRIVE_LEADER_ID = 2;
  public int RIGHT_DRIVE_FOLLOWER_ID = 3;
  public int LEFT_DRIVE_FOLLOWER_ID = 4;

  // Intake Subsystem
  public int INTAKE_MOTOR_ID = 1;

  // Shooter Subsystem
  public int FEEDER_MOTOR_ID = 15;
  public int SHOOTER_MOTOR_ID = 9;

  // Spinnyboi Subsystem
  public int SPINNYBOI_MOTOR_ID = 11;

  // Turret Subsystem
  public int AZIMUTH_MOTOR_ID = 7;
  public int ELEVATION_MOTOR_ID = 6;

}
