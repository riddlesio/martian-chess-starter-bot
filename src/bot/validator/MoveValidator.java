package bot.validator;


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
public interface MoveValidator<B> {

    Boolean isApplicable(MartianChessMove move, B board);

    ValidationResult validate(MartianChessMove move, B board);
}