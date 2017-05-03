package bot.validator;


import bot.model.MartianChessBoard;
import bot.model.MartianChessPiece;
import bot.model.MartianChessPieceType;
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
public abstract class ChessPieceMoveValidator {


    protected Boolean isMovedPieceOfType(MartianChessMove move, MartianChessBoard board, MartianChessPieceType pieceType) {
        MartianChessPiece piece = board.getFieldAt(move.getFrom());
        return piece.hasType(pieceType);
    }
}
