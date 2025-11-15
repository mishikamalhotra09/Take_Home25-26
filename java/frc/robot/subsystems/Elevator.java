package frc.robot.subsystems;

import edu.wpi.first.wpilibj2.command;
import edu.wpi.first.wpilibj2.command.InstantCommand;
import edu.wpi.first.wpilibj2.command.button.JoystickButton;
import edu.wpi.first.wpilibj.Joystick;
import com.revrobotics.CANSparkMax;

public class Elevator extends SubsystemBase {
  private CANSparkMax rightMotor = new CANSparkMax(1, motorType);
  private CANSparkMax leftMotor = new CANSparkMax(2, motorType);
  private Joystick controller = new Joystick(0);
  private int BTN_1 = 0;

  public Elevator() {
    rightMotor.follow(leftMotor);
    toggleElevatorButton.whenPressed(toggleElevator);
  }

  JoystickButton elevatorButton = new JoystickButton(controller, BTN_1);

  public static Command moveElevator = InstantCommand(() -> subsystems.Elevator.move(), subsystems.Elevator);


  public void move() {
    if (leftMotor.get() == 0) leftMotor.set(1);
    else if (leftMotor.get() > 0) leftMotor.set(-1);
    else leftMotor.set(0)
  }

  public void stop(){
    leftMotor.stopMotor();
  }

}
