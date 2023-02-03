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
        if (checkBorder(toLine, toColumn) &&
                chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        return checkBorder(toLine, toColumn) &&
                ((
                        (
                                (line == (isWhite() ? 1 : 6) && toLine == (line + (isWhite() ? 2 : -2))) &&
                                        chessBoard.board[toLine + (isWhite() ? 1 : -1)][toColumn] == null
                        ) ||
                                toLine == (line + (isWhite() ? 1 : -1))
                ) && toColumn == column);
    }

    @Override
    public String getSymbol() {
        return "P";
    }
}
