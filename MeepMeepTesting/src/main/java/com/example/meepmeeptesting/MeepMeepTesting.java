package com.example.meepmeeptesting;

import com.acmerobotics.roadrunner.geometry.Pose2d;
import com.acmerobotics.roadrunner.geometry.Vector2d;
import com.noahbres.meepmeep.MeepMeep;
import com.noahbres.meepmeep.roadrunner.DefaultBotBuilder;
import com.noahbres.meepmeep.roadrunner.entity.RoadRunnerBotEntity;

public class MeepMeepTesting {
    public static void main(String[] args) {
        MeepMeep meepMeep = new MeepMeep(800);

        RoadRunnerBotEntity myBot = new DefaultBotBuilder(meepMeep)
                // Set bot constraints: maxVel, maxAccel, maxAngVel, maxAngAccel, track width
                .setConstraints(52.48291908330528, 40, Math.toRadians(180), Math.toRadians(180), 14.2)
                .followTrajectorySequence(drive ->
                        drive.trajectorySequenceBuilder(new Pose2d(-33, -60, Math.toRadians(-180)))
//                                .splineToSplineHeading(new Pose2d(-12.5, -60, Math.toRadians(-180)), Math.toRadians(180)) set x to 0
//                                .splineToConstantHeading(new Vector2d(-12.5, -11.5), Math.toRadians(100))
//                                .splineToConstantHeading(new Vector2d(-24.5, -11.5), Math.toRadians(70)) weird substation path
                                  .splineToConstantHeading(new Vector2d(-35.5, -35.5), Math.toRadians(170))
//                                .splineTo(new Vector2d(-23.5, -12), Math.toRadians(180))
                                .splineToConstantHeading(new Vector2d(-23.5, -12), Math.toRadians(25))

                                .build()
                );

        meepMeep.setBackground(MeepMeep.Background.FIELD_POWERPLAY_OFFICIAL)
                .setDarkMode(true)
                .setBackgroundAlpha(0.95f)
                .addEntity(myBot)
                .start();
    }
}