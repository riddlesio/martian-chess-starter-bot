package bot.validator;

import bot.model.*;
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
public class QueenMoveValidator extends ChessPieceMoveValidator implements MoveValidator<MartianChessBoard> {

    @Override
    public Boolean isApplicable(MartianChessMove move, MartianChessBoard board) {

        return this.isMovedPieceOfType(move, board, MartianChessPieceType.QUEEN);
    }

    @Override
    public ValidationResult validate(MartianChessMove move, MartianChessBoard board) {

        // Queens move any distance horizontally, vertically, or diagonally, without jumping. (The same as chess queens.)
        Point from = move.getFrom();
        Point to = move.getTo();
        int deltaX = Math.abs(to.x - from.x);
        int deltaY = Math.abs(to.y - from.y);

        boolean isValid = true;
        boolean straightMove = false, diagonalMove = false;

        if (deltaX == 0 || deltaY == 0) straightMove = true;
        if (deltaX == deltaY) diagonalMove = true;
        if (!straightMove && !diagonalMove)
            isValid = false;

        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The queen can only move horizontally, vertically or diagonally");
    }
}
