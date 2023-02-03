public class King extends ChessPiece {
    public King(String color) {
        super(color);
    }

    @Override
    public String getColor() {
        return color;
    }

    @Override
    public boolean canMoveToPosition(ChessBoard chessBoard, int line, int column, int toLine, int toColumn) {
        return checkBorder(toLine, toColumn) &&
                (
                        (toLine == (line + 1) && toColumn == (column + 1)) ||
                                (toLine == (line + 1) && toColumn == (column - 1)) ||
                                (toLine == (line - 1) && toColumn == (column + 1)) ||
                                (toLine == (line - 1) && toColumn == (column - 1)) ||
                                (toLine == (line + 0) && toColumn == (column + 1)) ||
                                (toLine == (line + 0) && toColumn == (column - 1)) ||
                                (toLine == (line + 1) && toColumn == (column + 0)) ||
                                (toLine == (line - 1) && toColumn == (column - 0))
                );
    }

    public boolean isUnderAttack(ChessBoard board, int line, int column) {
        boolean result = false;
        for (int l = 0; l < 8; l++) {
            for (int c = 0; c < 8; c++) {
                if (!(board.board[l][c] == null) && !board.board[l][c].getColor().equals(getColor()) && checkBorder(line, column)) {
                    result = board.board[l][c].canMoveToPosition(board, l, c, line, column);
                }
            }
        }
        return !result;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}