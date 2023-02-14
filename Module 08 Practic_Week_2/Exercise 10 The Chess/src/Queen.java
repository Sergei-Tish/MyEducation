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
        if (!checkBorder(toLine, toColumn)) return false;
        boolean myPath = false;
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        //for horizontal move
        if (toLine == line && toColumn > column) {
            for (int i = 0; i < 8; i++) {
                if (toColumn == (column + i)) {
                    return true;
                } else if (chessBoard.board[toLine][column + i] != null) {
                    return false;
                }
            }
        }
        if (toLine == line && toColumn < column) {
            for (int i = 0; i < 8; i++) {
                if (toColumn == (column - i)) {
                    return true;
                } else if (chessBoard.board[toLine][column - i] != null) {
                    return false;
                }
            }
        }
        if (toColumn == column && toLine > line) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + i)) {
                    return true;
                } else if (chessBoard.board[toLine + i][toColumn] != null) {
                    return false;
                }
            }
        }
        if (toColumn == column && toLine > line) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line - i)) {
                    return true;
                } else if (chessBoard.board[toLine - i][toColumn] != null) {
                    return false;
                }
            }
        }

        //for diagonal move
        if (toLine > line && toColumn > column) {
            //checkPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, char indexLine, char indexColumn)
            return checkPath(chessBoard, line, column, toLine, toColumn, '>', '>');
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + (i * 1)) && toColumn == (column + (i * 1))) {
                    return true;
                } else if (chessBoard.board[line + (i * 1)][column + (i * 1)] != null) {
                    return false;
                }
            }
        }
        if (toLine > line && toColumn < column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + (i * 1)) && toColumn == (column + (i * (-1)))) {
                    return true;
                } else if (chessBoard.board[line + (i * 1)][column + (i * (-1))] != null) {
                    return false;
                }
            }
        }
        if (toLine < line && toColumn > column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + (i * (-1))) && toColumn == (column + (i * 1))) {
                    return true;
                } else if (chessBoard.board[line + (i * (-1))][column + (i * 1)] != null) {
                    return false;
                }
            }
        }
        if (toLine < line && toColumn < column) {
            for (int i = 0; i < 8; i++) {
                if (toLine == (line + (i * (-1))) && toColumn == (column + (i * (-1)))) {
                    return true;
                } else if (chessBoard.board[line + (i * (-1))][column + (i * (-1))] != null) {
                    return false;
                }
            }
        }


        return myPath;
    }

    private boolean checkPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, char indexLine, char indexColumn) {
        int intIndexLine;
        switch (indexLine) {
            case '>' -> intIndexLine = 1;
            case '<' -> intIndexLine = -1;
            default -> intIndexLine = 0;
        }
        int intIndexColumn;
        switch (indexColumn) {
            case '>' -> intIndexColumn = 1;
            case '<' -> intIndexColumn = -1;
            default -> intIndexColumn = 0;
        }
        for (int i = 0; i < 8; i++) {
            if (toLine == (line + (i * intIndexLine)) && toColumn == (column + (i * intIndexColumn))) {
                return true;
            } else if (chessBoard.board[line + (i * intIndexLine)][column + (i * intIndexColumn)] != null) {
                return false;
            }
        }
        return false;
    }
    @Override
    public String getSymbol() {
        return "Q";
    }
}
