package bot.validator;

import bot.model.MartianChessBoard;
import bot.model.ValidationResult;
import bot.move.MartianChessMove;
import java.awt.*;

/**
 * ${PACKAGE_NAME}
 *
 * This file is a part of martianchess
 *
 * Copyright 2016 - present Riddles.io
 * For license information see the LICENSE file in the project root
 *
 * @author Niko
 */
public class NoJumpingMoveValidator extends ChessPieceMoveValidator implements MoveValidator<MartianChessBoard> {

    @Override
    public Boolean isApplicable(MartianChessMove move, MartianChessBoard board) {
        return true;
    }

    @Override
    public ValidationResult validate(MartianChessMove move, MartianChessBoard board) {

        Point from = move.getFrom();
        Point to = move.getTo();

        Point intermediate = new Point(from.x, from.y);
        int deltaX = Math.abs(to.x - from.x);
        int deltaY = Math.abs(to.y - from.y);

        boolean isValid = true;

        int maxDelta = deltaX;
        if (deltaY > deltaX) maxDelta = deltaY;

        for (int i = 0; i < maxDelta; i++) {
            if (intermediate.x < to.getX())
                intermediate.x = intermediate.x + 1;
            if (intermediate.x > to.getX())
                intermediate.x = intermediate.x - 1;
            if (intermediate.y < to.getY())
                intermediate.y = intermediate.y + 1;
            if (intermediate.y > to.getY())
                intermediate.y = intermediate.y - 1;

            if (intermediate.x != to.x || intermediate.y != to.y) {
                if (board.getFieldAt(intermediate) != null)
                    isValid = false;
            }
        }


        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "Jumping over other pieces is not allowed.");
    }
}
