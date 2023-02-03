public class Bishop extends ChessPiece {
    public Bishop(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        if (checkBorder(toLine, toColumn) &&
                chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        boolean myPath = false;
        for (int i = 1; i < 8; i++) {
            if (checkBorder(toLine, toColumn) &&
                    (
                            (toLine == (line + i) && toColumn == (column + i)) ||
                                    (toLine == (line + i) && toColumn == (column - i)) ||
                                    (toLine == (line - i) && toColumn == (column + i)) ||
                                    (toLine == (line - i) && toColumn == (column - i))
                    )
            ) {
                myPath = true;
            }
        }   // put' ne proveryaet na prepyatstviya
        return myPath;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
