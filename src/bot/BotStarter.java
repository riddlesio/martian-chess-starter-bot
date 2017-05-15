// // Copyright 2015 theaigames.com (developers@theaigames.com)

//    Licensed under the Apache License, Version 2.0 (the "License");
//    you may not use this file except in compliance with the License.
//    You may obtain a copy of the License at

//        http://www.apache.org/licenses/LICENSE-2.0

//    Unless required by applicable law or agreed to in writing, software
//    distributed under the License is distributed on an "AS IS" BASIS,
//    WITHOUT WARRANTIES OR CONDITIONS OF ANY KIND, either express or implied.
//    See the License for the specific language governing permissions and
//    limitations under the License.
//	
//    For the full copyright and license information, please view the LICENSE
//    file that was distributed with this source code.

package bot;
import bot.model.ChessPieceColor;
import bot.model.MartianChessBoard;
import bot.model.MartianChessPiece;
import bot.model.ValidationResult;
import bot.move.MartianChessMove;
import bot.validator.MartianChessMoveValidator;

import java.awt.*;
import java.util.ArrayList;
import java.util.Random;

/**
 * BotStarter class
 * 
 * Magic happens here. You should edit this file, or more specifically
 * the makeTurn() method to make your bot do more than random moves.
 * 
 * @author Jim van Eeden <jim@starapple.nl>, Joost <joost@starapple.nl>
 */

public class BotStarter {	

     /**
      * Makes a turn. Edit this method to make your bot smarter.
      *
      * @return A MartianChessMove
      */
     public MartianChessMove makeTurn(MartianChessBoard board, ChessPieceColor color) {

         ArrayList<MartianChessMove> moves = new ArrayList<>();
         int startY = (color == ChessPieceColor.BLACK) ? 0 : 3;

         for (int x = 0; x < 4; x++) {
             for (int y = startY; y < startY + 4; y++) {
                 moves.addAll(getMoves(board, x, y));
             }
         }

         Random RNG = new Random();
         if (moves.size() > 0) {
             return moves.get(RNG.nextInt(moves.size()));
         }
         return new MartianChessMove(new Point(1, 1), new Point(2, 2));
     }

    private ArrayList<MartianChessMove> getMoves(MartianChessBoard board, int pieceX, int pieceY) {

        ArrayList<MartianChessMove> moves = new ArrayList<>();

        for (int x = 0; x < 4; x++) {
            for (int y = 0; y < 8; y++) {
                MartianChessMove move = new MartianChessMove(new Point(pieceX, pieceY), new Point(x, y));

                MartianChessMoveValidator validator = new MartianChessMoveValidator();
                ValidationResult result = validator.validate(move, board);
                if (result.isValid()) {
                    moves.add(move);
                }
            }
        }
        return moves;
    }
     
 	public static void main(String[] args) {
 		BotParser parser = new BotParser(new BotStarter());
 		parser.run();
 	}
 }
