public class Rook extends ChessPiece {
    public Rook(String color) {
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
        return false;
    }

    @Override
    public String getSymbol() {
        return null;
    }
}
