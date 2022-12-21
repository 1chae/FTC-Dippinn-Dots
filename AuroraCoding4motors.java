package org.firstinspires.ftc.teamcode;

import com.qualcomm.robotcore.eventloop.opmode.LinearOpMode;
import com.qualcomm.robotcore.eventloop.opmode.TeleOp;
import com.qualcomm.robotcore.hardware.DcMotor;
import com.qualcomm.robotcore.hardware.DcMotorSimple;
import com.qualcomm.robotcore.hardware.Servo;

@TeleOp(name = "AuroraCoding4motors (Blocks to Java)")
public class AuroraCoding4motors extends LinearOpMode {

  private DcMotor BackLeftMotor;
  private DcMotor FrontLeftMotor;
  private Servo handservo;
  private DcMotor BackRightMotor;
  private DcMotor FrontRightMotor;
  private DcMotor ArmMotor;
  private Servo testservohand;

  /**
   * This function is executed when this Op Mode is selected from the Driver Station.
   */
  @Override
  public void runOpMode() {
    BackLeftMotor = hardwareMap.get(DcMotor.class, "Back Left Motor");
    FrontLeftMotor = hardwareMap.get(DcMotor.class, "Front Left Motor");
    handservo = hardwareMap.get(Servo.class, "hand servo");
    BackRightMotor = hardwareMap.get(DcMotor.class, "Back Right Motor");
    FrontRightMotor = hardwareMap.get(DcMotor.class, "Front Right Motor");
    ArmMotor = hardwareMap.get(DcMotor.class, "Arm Motor");
    testservohand = hardwareMap.get(Servo.class, "test servo hand");

    // Put initialization blocks here.
    waitForStart();
    BackLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    FrontLeftMotor.setDirection(DcMotorSimple.Direction.REVERSE);
    if (opModeIsActive()) {
      // Put run blocks here.
      while (opModeIsActive()) {
        // Put loop blocks here.
        if (gamepad2.dpad_left) {
          handservo.setPosition(1);
        } else if (gamepad2.dpad_right) {
          handservo.setPosition(0);
        }
        if (gamepad1.right_bumper) {
          BackLeftMotor.setPower(-1);
          BackRightMotor.setPower(1);
          FrontLeftMotor.setPower(1);
          FrontRightMotor.setPower(-1);
        } else if (gamepad1.left_bumper) {
          BackLeftMotor.setPower(1);
          BackRightMotor.setPower(-1);
          FrontLeftMotor.setPower(-1);
          FrontRightMotor.setPower(1);
        }
        if (gamepad1.x) {
          BackLeftMotor.setPower(-1);
          FrontLeftMotor.setPower(-1);
          BackRightMotor.setPower(1);
          FrontRightMotor.setPower(1);
        } else if (gamepad1.b) {
          FrontRightMotor.setPower(-1);
          BackRightMotor.setPower(-1);
          BackLeftMotor.setPower(1);
          FrontLeftMotor.setPower(1);
        }
        if (gamepad1.dpad_up) {
          ArmMotor.setPower(-1);
        } else {
          ArmMotor.setPower(0);
        }
        if (gamepad1.dpad_down) {
          ArmMotor.setPower(0.5);
        } else {
          ArmMotor.setPower(0);
        }
        if (gamepad1.a) {
          testservohand.setPosition(-1);
        }
        if (gamepad1.y) {
          testservohand.setPosition(1);
        }
        BackLeftMotor.setPower(-gamepad1.left_stick_y);
        BackRightMotor.setPower(-gamepad1.left_stick_y);
        FrontLeftMotor.setPower(-gamepad1.left_stick_y);
        FrontRightMotor.setPower(-gamepad1.left_stick_y);
        telemetry.update();
        telemetry.addData("Back Right Pow", BackRightMotor.getPower());
        telemetry.addData("Back Left Pow", BackLeftMotor.getPower());
        telemetry.addData("Front Left Pow", FrontLeftMotor.getPower());
        telemetry.addData("Front Right Pow", FrontRightMotor.getPower());
        telemetry.addData("Arm Pow", ArmMotor.getPower());
        telemetry.addData("Servo Position", handservo.getPosition());
      }
    }
  }
}
