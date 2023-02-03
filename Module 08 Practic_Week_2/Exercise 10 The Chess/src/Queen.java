public class Queen extends ChessPiece {
    public Queen(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        boolean myPath = false;
        if (checkBorder(toLine, toColumn) &&
                chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        if (toLine == line) {
            for (int i = 0; i < 8; i++) {
                if (toColumn == (column + i)) {
                    return true;
                } else if (chessBoard.board[toLine][column + i] != null) {
                    return false;
                }
            }
        }
        if (toColumn == column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + i)) {
                    return true;
                } else if (chessBoard.board[toLine + i][toColumn] != null) {
                    return false;
                }
            }
        }
        for (int i = 1; i < 8; i++) {
            if (checkBorder(toLine, toColumn) &&
                    (
                                    (toLine == (line + i) && toColumn == (column + i)) ||
                                    (toLine == (line + i) && toColumn == (column - i)) ||
                                    (toLine == (line - i) && toColumn == (column + i)) ||
                                    (toLine == (line - i) && toColumn == (column - i)) ||
                                    (toLine == (line - 0) && toColumn != (column - 0)) ||
                                    (toLine != (line - 0) && toColumn == (column - 0))
                    )
            ) {
                myPath = true;
            }
        }
        return myPath;
    }

    @Override
    public String getSymbol() {
        return "Q";
    }
}
