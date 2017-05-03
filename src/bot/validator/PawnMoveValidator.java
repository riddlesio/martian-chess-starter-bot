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
public class PawnMoveValidator extends ChessPieceMoveValidator implements MoveValidator<MartianChessBoard> {

    @Override
    public Boolean isApplicable(MartianChessMove move, MartianChessBoard board) {

        return this.isMovedPieceOfType(move, board, MartianChessPieceType.PAWN);
    }

    @Override
    public ValidationResult validate(MartianChessMove move, MartianChessBoard board) {

        // Pawns move one space diagonally in any direction. (Unlike chess pawns, they may move backwards.)

        Point from = move.getFrom();
        Point to = move.getTo();

        int deltaX = Math.abs(to.x - from.x);
        int deltaY = Math.abs(to.y - from.y);

        boolean isValid = false;

        if (deltaX == deltaY && deltaX == 1) {
            isValid = true;
        }

        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "The pawn can only move one space diagonally.");
    }
}
