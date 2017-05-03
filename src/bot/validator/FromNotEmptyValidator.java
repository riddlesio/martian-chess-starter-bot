package bot.validator;


import bot.model.MartianChessBoard;
import bot.model.MartianChessPiece;
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
public class FromNotEmptyValidator extends ChessPieceMoveValidator implements MoveValidator<MartianChessBoard> {

    @Override
    public Boolean isApplicable(MartianChessMove move, MartianChessBoard board) {
        return true;
    }

    @Override
    public ValidationResult validate(MartianChessMove move, MartianChessBoard board) {

        Point from = move.getFrom();
        MartianChessPiece piece = board.getFieldAt(from);

        boolean isValid = piece != null;
        if (isValid) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "There is no martianchess chessPiece at the specified source field");
    }
}
