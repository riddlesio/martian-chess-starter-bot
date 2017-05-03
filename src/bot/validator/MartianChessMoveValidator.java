package bot.validator;

import bot.model.MartianChessBoard;
import bot.model.MartianChessPiece;
import bot.model.ValidationResult;
import bot.move.MartianChessMove;
import java.awt.*;
import java.util.ArrayList;

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
public final class MartianChessMoveValidator implements MoveValidator<MartianChessBoard> {

    private ArrayList<MoveValidator> validators;

    public MartianChessMoveValidator() {

        ArrayList<MoveValidator> validators = new ArrayList<>();

        validators.add(new FromNotEmptyValidator());
        validators.add(new ToEmptyOrOppositePlayerValidator());
        validators.add(new ChessPieceColorValidator());
        validators.add(new DroneMoveValidator());
        validators.add(new PawnMoveValidator());
        validators.add(new QueenMoveValidator());
        validators.add(new NoJumpingMoveValidator());

        this.validators = validators;
    }

    @Override
    public Boolean isApplicable(MartianChessMove move, MartianChessBoard board) {

        return true;
    }

    @Override
    public ValidationResult validate(MartianChessMove move, MartianChessBoard board) {

        //get the piece at the from location
        Point from = move.getFrom();
        MartianChessPiece fromPiece = board.getFieldAt(from);

        boolean result = true;
        for (MoveValidator validator : validators) {
            if (validator.isApplicable(move, board)) {
                ValidationResult vr = validator.validate(move, board);
                if (!vr.isValid()) {
                    return vr;
                }
            }
        }


        /*
        if (validator != null) {
            ValidationResult result = validator.validate(move, state);
            if (!result.isValid()) {
                return result;
            }
        }
        */
        return new ValidationResult(true, "Ok");
    }

}
