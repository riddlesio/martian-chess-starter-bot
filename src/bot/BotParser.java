// Copyright 2015 theaigames.com (developers@theaigames.com)

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
import bot.move.MartianChessMove;

import java.util.Random;
import java.util.Scanner;

/**
 * MyBot class
 * 
 * Main class that will keep reading output from the engine.
 * Will either update the bot state or get actions.
 * 
 * @author Jim van Eeden <jim@starapple.nl>, Joost de Meij <joost@starapple.nl>
 */

public class BotParser {
    
	final Scanner scan;
    final BotStarter bot;
    
    private MartianChessBoard mBoard;
    public static int mBotId = 0;
    public static ChessPieceColor mColor = ChessPieceColor.WHITE;

    
    public BotParser(BotStarter bot) {
		this.scan = new Scanner(System.in);
		this.bot = bot;
	}
    
    public void run() {
        mBoard = new MartianChessBoard(4, 8);
        while(scan.hasNextLine()) {
            String line = scan.nextLine();

            if(line.length() == 0) {
                continue;
            }

            String[] parts = line.split(" ");
            
            if(parts[0].equals("settings")) {
                if (parts[1].equals("your_color")) {
                    mColor = parts[2].equals("white") ? ChessPieceColor.WHITE : ChessPieceColor.BLACK;
                }
            } else if(parts[0].equals("update")) { /* new field data */
                if (parts[2].equals("field")) {
                    String data = parts[3];
                    mBoard.setFieldsFromString(data); /* Parse Field with data */
                }
            } else if(parts[0].equals("action")) {
                if (parts[1].equals("move")) { /* move requested */
                    MartianChessMove move = bot.makeTurn(mBoard, mColor);
                    System.out.println("move " + move.toString());
                }
            }
            else { 
                System.out.println("unknown command");
            }
        }
    }
}