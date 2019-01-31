package frc.robot;

import com.ctre.phoenix.motorcontrol.ControlMode;
import com.ctre.phoenix.motorcontrol.can.TalonSRX;

import org.opencv.core.Mat;
import org.opencv.imgproc.Imgproc;

import edu.wpi.cscore.CvSink;
import edu.wpi.cscore.CvSource;
import edu.wpi.cscore.UsbCamera;
import edu.wpi.first.wpilibj.DigitalInput;
import edu.wpi.first.wpilibj.DriverStation;
import edu.wpi.first.wpilibj.Encoder;
import edu.wpi.first.wpilibj.Joystick;
import edu.wpi.first.wpilibj.TimedRobot;
import edu.wpi.first.wpilibj.CounterBase.EncodingType;
import edu.wpi.first.wpilibj.smartdashboard.SmartDashboard;
import frc.robot.Robot;

/**
 * This is a demo program showing the use of the RobotDrive class, specifically
 * it contains the code necessary to operate a robot with tank drive.
 */
public class Robot extends TimedRobot {

  private Encoder Encoder;
  private final int LEFT_JOYSTICK = 1;
  private final int RIGHT_JOYSTICK = 5;
  //butttons
  private final int CIRCLE = 2;
  private final int SQUARE = 3;
  private final int TRIANGLE = 4;
  //back buttons R y L
  private final int L1 = 5;
  private final int R1 = 6;
  //back axis
  private final int L2 = 2;
  private final int R2 = 3;
  //Axis buttons
  private final int LEFT_BUTTON = 9;
  private final int RIGHT_BUTTON = 10;

  @Override
  public void robotInit(){
  
    Encoder = new Encoder(0, 1, false, EncodingType.k2X);
  }

  @Override
  public void teleopInit() {
    
    Encoder.setMaxPeriod(0.1);
    Encoder.setMinRate(10);
    Encoder.setDistancePerPulse((Math.PI*(8.0/12.0))/7.0);
    Encoder.setReverseDirection(true);
    Encoder.setSamplesToAverage(7);

    Encoder.reset();
   }

  @Override
  public void teleopPeriodic() {
    
    int count = Encoder.get();
    double raw = Encoder.getRaw();
    double distance = Encoder.getDistance();
    double period = Encoder.getPeriod();
    double rate = Encoder.getRate();
    boolean direction = Encoder.getDirection();
    boolean stopped = Encoder.getStopped();


    SmartDashboard.putNumber("Right count ", count%128);
    SmartDashboard.putNumber("Right distance ", distance);
    SmartDashboard.putNumber("Right rate ", rate);
    SmartDashboard.putBoolean("Right stopped ", stopped);

  }



}