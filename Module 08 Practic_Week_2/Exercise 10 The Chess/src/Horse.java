public class Horse extends ChessPiece {
    public Horse(String color) {
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
        if (checkBorder(toLine, toColumn) &&
                (
                                (toLine == (line + 2) && toColumn == (column + 1)) ||
                                (toLine == (line + 2) && toColumn == (column - 1)) ||
                                (toLine == (line - 2) && toColumn == (column + 1)) ||
                                (toLine == (line - 2) && toColumn == (column - 1)) ||
                                (toLine == (line + 1) && toColumn == (column + 2)) ||
                                (toLine == (line - 1) && toColumn == (column + 2)) ||
                                (toLine == (line + 1) && toColumn == (column - 2)) ||
                                (toLine == (line - 1) && toColumn == (column - 2))
                )
        ) {
            return true;
        } else return false;
    }

    @Override
    public String getSymbol() {
        return "H";
    }
}
