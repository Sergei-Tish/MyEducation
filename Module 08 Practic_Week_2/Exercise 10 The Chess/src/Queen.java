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
        if (!inBound(toLine, toColumn)) return false;
        //FOR TEST// System.out.print("int line " + line + ", int column " + column + ", int toLine " + toLine + ", int toColumn " + toColumn);
        if (chessBoard.board[toLine][toColumn] != null &&
                chessBoard.board[toLine][toColumn].getColor().equals(this.getColor())) {
            return false;
        }
        //for horizontal move
        if (toLine == line && toColumn > column) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '=', '>');
        }
        if (toLine == line && toColumn < column) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '=', '<');
        }
        if (toLine > line && toColumn == column) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '>', '=');
        }
        if (toLine < line && toColumn == column) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '<', '=');
        }

        //for diagonal move

        if (toLine > line && toColumn > column && Math.abs(toLine - line) == Math.abs(toColumn - column)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '>', '>');
        }
        if (toLine > line && toColumn < column && Math.abs(toLine - line) == Math.abs(column - toColumn)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '>', '<');
        }
        if (toLine < line && toColumn > column && Math.abs(line - toLine) == Math.abs(toColumn - column)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '<', '>');
        }
        if (toLine < line && toColumn < column && Math.abs(line - toLine) == Math.abs(column - toColumn)) {
            return checkPath(chessBoard, line, column, toLine, toColumn, '<', '<');
        }

        return false;
    }

    private boolean checkPath(ChessBoard chessBoard, int line, int column, int toLine, int toColumn, char ratioLines, char ratioColumns) {
        int intIndexLine = 0;
        switch (ratioLines) {
            case '>':
                intIndexLine = 1;
                break;
            case '<':
                intIndexLine = -1;
                break;
        }
        int intIndexColumn = 0;
        switch (ratioColumns) {
            case '>':
                intIndexColumn = 1;
                break;
            case '<':
                intIndexColumn = -1;
                break;
        }
        for (int i = 1; i < 8; i++) {
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

    // ДАЛЬШЕ НЕ КОПИРУЙ ДЛЯ КОМПИЛЯЦИИ НА САЙТЕ!!!
    public static void main(String[] args) {
        ChessBoard chessBoard = new ChessBoard("White");
        chessBoard.board[3][3] = new Queen("White");
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 7, 0));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 7, 1));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 7, 2));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 7, 3));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 7, 4));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 7, 5));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 7, 6));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 7, 7));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 6, 0));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 6, 1));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 6, 2));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 6, 3));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 6, 4));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 6, 5));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 6, 6));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 6, 7));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 5, 0));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 5, 1));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 5, 2));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 5, 3));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 5, 4));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 5, 5));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 5, 6));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 5, 7));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 4, 0));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 4, 1));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 4, 2));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 4, 3));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 4, 4));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 4, 5));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 4, 6));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 4, 7));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 3, 0));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 3, 1));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 3, 2));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 3, 3));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 3, 5));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 3, 6));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 3, 7));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 2, 0));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 2, 1));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 2, 2));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 2, 4));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 2, 5));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 2, 6));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 2, 7));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 1, 0));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 1, 1));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 1, 3));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 1, 4));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 1, 5));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 1, 6));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 1, 7));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 0, 0));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 0, 2));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 0, 3));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 0, 4));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 0, 5));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 0, 6));
        System.out.println(chessBoard.board[3][3].canMoveToPosition(chessBoard, 3, 3, 0, 7));
    }

}
/*
 3, 3,  7, 0
 3, 3,  7, 1
 3, 3,  7, 2
 3, 3,  7, 3
 3, 3,  7, 4
 3, 3,  7, 5
 3, 3,  7, 6
 3, 3,  7, 7
 3, 3,  6, 0
 3, 3,  6, 1
 3, 3,  6, 2
 3, 3,  6, 3
 3, 3,  6, 4
 3, 3,  6, 5
 3, 3,  6, 6
 3, 3,  6, 7
 3, 3,  5, 0
 3, 3,  5, 1
 3, 3,  5, 2
 3, 3,  5, 3
 3, 3,  5, 4
 3, 3,  5, 5
 3, 3,  5, 6
 3, 3,  5, 7
 3, 3,  4, 0
 3, 3,  4, 1
 3, 3,  4, 2
 3, 3,  4, 3
 3, 3,  4, 4
 3, 3,  4, 5
 3, 3,  4, 6
 3, 3,  4, 7
 3, 3,  3, 0
 3, 3,  3, 1
 3, 3,  3, 2
 3, 3,  3, 3
 3, 3,  3, 5
 3, 3,  3, 6
 3, 3,  3, 7
 3, 3,  2, 0
 3, 3,  2, 1
 3, 3,  2, 2
 3, 3,  2, 4
 3, 3,  2, 5
 3, 3,  2, 6
 3, 3,  2, 7
 3, 3,  1, 0
 3, 3,  1, 1
 3, 3,  1, 3
 3, 3,  1, 4
 3, 3,  1, 5
 3, 3,  1, 6
 3, 3,  1, 7
 3, 3,  0, 0
 3, 3,  0, 2
 3, 3,  0, 3
 3, 3,  0, 4
 3, 3,  0, 5
 3, 3,  0, 6
 3, 3,  0, 7

int line 3, int column 3, int toLine 7, int toColumn 0ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 7, int toColumn 1ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 7, int toColumn 2ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 7, int toColumn 3 -=TRUE=-
int line 3, int column 3, int toLine 7, int toColumn 4ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 7, int toColumn 5ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 7, int toColumn 6ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 7, int toColumn 7 -=TRUE=-
int line 3, int column 3, int toLine 6, int toColumn 0 -=TRUE=-
int line 3, int column 3, int toLine 6, int toColumn 1ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 6, int toColumn 2ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 6, int toColumn 3 -=TRUE=-
int line 3, int column 3, int toLine 6, int toColumn 4ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 6, int toColumn 5ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 6, int toColumn 6 -=TRUE=-
int line 3, int column 3, int toLine 6, int toColumn 7ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 5, int toColumn 0ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 5, int toColumn 1 -=TRUE=-
int line 3, int column 3, int toLine 5, int toColumn 2ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 5, int toColumn 3 -=TRUE=-
int line 3, int column 3, int toLine 5, int toColumn 4ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 5, int toColumn 5 -=TRUE=-
int line 3, int column 3, int toLine 5, int toColumn 6ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 5, int toColumn 7ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 4, int toColumn 0ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 4, int toColumn 1ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 4, int toColumn 2 -=TRUE=-
int line 3, int column 3, int toLine 4, int toColumn 3 -=TRUE=-
int line 3, int column 3, int toLine 4, int toColumn 4 -=TRUE=-
int line 3, int column 3, int toLine 4, int toColumn 5ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 4, int toColumn 6ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 4, int toColumn 7ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 3, int toColumn 0 -=TRUE=-
int line 3, int column 3, int toLine 3, int toColumn 1 -=TRUE=-
int line 3, int column 3, int toLine 3, int toColumn 2 -=TRUE=-
int line 3, int column 3, int toLine 3, int toColumn 3int line 3, int column 3, int toLine 3, int toColumn 4 -=TRUE=-
int line 3, int column 3, int toLine 3, int toColumn 5 -=TRUE=-
int line 3, int column 3, int toLine 3, int toColumn 6 -=TRUE=-
int line 3, int column 3, int toLine 3, int toColumn 7 -=TRUE=-
int line 3, int column 3, int toLine 2, int toColumn 0ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 2, int toColumn 1ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 2, int toColumn 2int line 3, int column 3, int toLine 2, int toColumn 3 -=TRUE=-
int line 3, int column 3, int toLine 2, int toColumn 4 -=TRUE=-
int line 3, int column 3, int toLine 2, int toColumn 5ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 2, int toColumn 6ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 2, int toColumn 7ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 1, int toColumn 0ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 1, int toColumn 1int line 3, int column 3, int toLine 1, int toColumn 2ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 1, int toColumn 3 -=TRUE=-
int line 3, int column 3, int toLine 1, int toColumn 4ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 1, int toColumn 5 -=TRUE=-
int line 3, int column 3, int toLine 1, int toColumn 6ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 1, int toColumn 7ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 0, int toColumn 0int line 3, int column 3, int toLine 0, int toColumn 1ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 0, int toColumn 2ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 0, int toColumn 3 -=TRUE=-
int line 3, int column 3, int toLine 0, int toColumn 4ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 0, int toColumn 5ne podoshlo  -=FALSE=-
int line 3, int column 3, int toLine 0, int toColumn 6 -=TRUE=-
int line 3, int column 3, int toLine 0, int toColumn 7ne podoshlo  -=FALSE=-

 */