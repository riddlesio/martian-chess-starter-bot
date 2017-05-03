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
public class ToEmptyOrOppositePlayerValidator extends ChessPieceMoveValidator implements MoveValidator<MartianChessBoard> {

    @Override
    public Boolean isApplicable(MartianChessMove move, MartianChessBoard board) {
        return true;
    }

    @Override
    public ValidationResult validate(MartianChessMove move, MartianChessBoard board) {

        Point to = move.getTo();
        Point from = move.getFrom();


        MartianChessPiece toPiece = board.getFieldAt(to);
        MartianChessPiece fromPiece = board.getFieldAt(from);

        boolean isValid = false;

        if (toPiece == null) {
            isValid = true;
        } else {
            if (toPiece.getColor() != fromPiece.getColor()) {
                isValid = true;
            }
        }


        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "Your piece already occupies that field.");
    }
}
