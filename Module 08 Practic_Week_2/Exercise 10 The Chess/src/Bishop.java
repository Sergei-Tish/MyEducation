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
        if (!checkBorder(toLine, toColumn)) return false;
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        boolean myPath = false;

        if (toLine > line && toColumn > column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + i) && toColumn == (column + i)) {
                    return true;
                } else if (chessBoard.board[line + i][column + i] != null) {
                    return false;
                }
            }
        }
        if (toLine > line && toColumn < column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + i) && toColumn == (column - i)) {
                    return true;
                } else if (chessBoard.board[line + i][column - i] != null) {
                    return false;
                }
            }
        }
        if (toLine < line && toColumn > column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line - i) && toColumn == (column + i)) {
                    return true;
                } else if (chessBoard.board[line - i][column + i] != null) {
                    return false;
                }
            }
        }
        if (toLine < line && toColumn < column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line - i) && toColumn == (column - i)) {
                    return true;
                } else if (chessBoard.board[line - i][column - i] != null) {
                    return false;
                }
            }
        }
        /*      -= MY FIRST TRY =-
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

         */
        return false;
    }

    @Override
    public String getSymbol() {
        return "B";
    }
}
