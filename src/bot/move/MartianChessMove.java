package bot.move;

import java.awt.*;

/**
 * @author Niko van Meurs <niko@riddles.io>
 */
public final class MartianChessMove {

	
	public enum MoveTypes{
		Regular
	}
	
	
	public MoveTypes moveType;
	
			
    /**
     * Coordinate of the Field from which should be moved
     */
    private Point from;

    /**
     * Coordinate of the Field to which a Piece should be moved
     */
    private Point to;

    
    /**
     *
     * @param from Points to the field from which the move is executed
     * @param to   Points to the field to which the move is executed
     */
    public MartianChessMove(Point from, Point to) {

        this.from = from;
        this.to = to;
        this.moveType = MoveTypes.Regular;
    }

    /**
     * Returns the coordinate for the move's source Field
     * @return Coordinate
     */
    public Point getFrom() {
        return from;
    }

    /**
     * Returns the coordinate for the move's target Field
     * @return Coordinate
     */
    public Point getTo() {
        return to;
    }

    public String toString() {
        return from.x + "," + from.y + " " + to.x + "," + to.y;
    }
}
