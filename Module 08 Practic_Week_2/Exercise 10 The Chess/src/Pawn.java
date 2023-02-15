public class Pawn extends ChessPiece {
    public Pawn(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    public boolean isWhite() {
        return "White".equals(getColor());
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        System.out.println("int line " + line + ", int column " + column + ", int toLine " + toLine + ", int toColumn " + toColumn + " ");
        if (!inBound(toLine, toColumn)) return getFalse();
        //FOR TEST//

        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return getFalse();
        }
        if (column == toColumn) {
            if (isWhite() &&
                    line == 1 &&
                    toLine == 3 &&
                    chessBoard.board[2][column] == null) {
                return getTrue();
            }
            if (isWhite() &&
                    toLine == (line + 1)) {
                return getTrue();
            }

            if (!isWhite() &&
                    line == 6 &&
                    toLine == 4 &&
                    chessBoard.board[5][column] == null) {
                return getTrue();
            }
            if (!isWhite() &&
                    toLine == (line - 1)) {
                return getTrue();
            }
        }

        if (((toColumn == (column + 1)) ||
                toColumn == (column - 1)) &&
                chessBoard.board[toLine][toColumn] != null) {
            if (isWhite() && toLine == (line + 1)) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
            }
            if (!isWhite() && toLine == (line - 1)) {
                return !chessBoard.board[toLine][toColumn].getColor().equals(this.getColor());
            }
        } else return getFalse();
        return false;
    }


    @Override
    public String getSymbol() {
        return "P";
    }
}
/*
        int line 1, int column 0, int toLine 2, int toColumn 0
        TRUE
        int line 1, int column 0, int toLine 3, int toColumn 0
        TRUE
        int line 1, int column 0, int toLine 4, int toColumn 0
        FALSE
        int line 1, int column 0, int toLine 5, int toColumn 0
        FALSE
        int line 1, int column 0, int toLine 6, int toColumn 0
        FALSE
        int line 1, int column 0, int toLine 7, int toColumn 0
        FALSE
        int line 1, int column 0, int toLine 2, int toColumn 1
        E
*/