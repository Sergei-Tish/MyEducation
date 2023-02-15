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
        if (!inBound(toLine, toColumn)) return false;
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        return
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
        if (!inBound(line, column)) return false;
        boolean result = false;
        for (int forLine = 0; forLine < 8; forLine++) {
            for (int forColumn = 0; forColumn < 8; forColumn++) {
                if ((board.board[forLine][forColumn] != null) && !board.board[forLine][forColumn].getColor().equals(getColor())) {
                    result = board.board[forLine][forColumn].canMoveToPosition(board, forLine, forColumn, line, column);
                }
            }
        }
        return result;
    }

    @Override
    public String getSymbol() {
        return "K";
    }
}