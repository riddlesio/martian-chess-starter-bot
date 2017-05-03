package bot.validator;


import bot.BotParser;
import bot.model.MartianChessBoard;
import bot.model.MartianChessPiece;
import bot.model.ValidationResult;
import bot.move.MartianChessMove;

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
public class ChessPieceColorValidator extends ChessPieceMoveValidator implements MoveValidator<MartianChessBoard> {

    @Override
    public Boolean isApplicable(MartianChessMove move, MartianChessBoard board) {

        return true;
    }

    @Override
    public ValidationResult validate(MartianChessMove move, MartianChessBoard board) {

        MartianChessPiece piece = board.getFieldAt(move.getFrom());
        if (piece.getColor() == BotParser.mColor) {
            return new ValidationResult(true, "");
        }

        return new ValidationResult(false, "This piece doesn't belong to you");
    }
}