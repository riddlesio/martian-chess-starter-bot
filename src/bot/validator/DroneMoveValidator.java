package bot.validator;


import bot.model.MartianChessBoard;
import bot.model.MartianChessPieceType;
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
public class DroneMoveValidator extends ChessPieceMoveValidator implements MoveValidator<MartianChessBoard> {

    @Override
    public Boolean isApplicable(MartianChessMove move, MartianChessBoard board) {

        return this.isMovedPieceOfType(move, board, MartianChessPieceType.DRONE);
    }

    @Override
    public ValidationResult validate(MartianChessMove move, MartianChessBoard board) {

        // Drones move one or two spaces horizontally or vertically, without jumping. (Like chess rooks, but with limited range.)

        Point from = move.getFrom();
        Point to = move.getTo();

        int deltaX = Math.abs(to.x - from.x);
        int deltaY = Math.abs(to.y - from.y);

        int maxDelta = deltaX;
        if (deltaY > deltaX) maxDelta = deltaY;

        boolean straightMove = false;
        if (deltaX == 0 || deltaY == 0) straightMove = true;

        boolean isValid = false;
        if (straightMove && maxDelta <= 2) {
            isValid = true;
        }

        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "Drones move one or two spaces horizontally or vertically");
    }
}
