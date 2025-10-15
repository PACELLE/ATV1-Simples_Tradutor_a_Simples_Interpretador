public class Parser {
    
    private Scanner scan;
    private Token currentToken;
    private StringBuilder output = new StringBuilder();


    public Parser(byte[] input) {
        scan = new Scanner(input);
        currentToken = scan.nextToken();
    }

    private void nextToken () {
        currentToken = scan.nextToken();
    }

    public void parse () {
        statements();
    }

    private void match(Token.TokenType t) {
        if (currentToken.type == t) {
            nextToken();
        }else {
            throw new Error("syntax error");
        }
   }

    void expr() {
        term();
        oper();
    }
    void number () {
        output.append("push " + currentToken.lexeme + "\n");
        match(Token.TokenType.NUMBER);
    }

    void term () {
            if (currentToken.type == Token.TokenType.NUMBER)
                number();
            else if (currentToken.type == Token.TokenType.IDENT) {
                output.append("push " + currentToken.lexeme + "\n");
                match(Token.TokenType.IDENT);
            }
            else
                throw new Error("syntax error");
        }

    void oper () {
        if (currentToken.type == Token.TokenType.PLUS) {
            match(Token.TokenType.PLUS);
            term();
            output.append("add\n");
            oper();
        } else if (currentToken.type == Token.TokenType.MINUS) {
            match(Token.TokenType.MINUS);
            term();
            output.append("sub\n");
            oper();
        } 
    }

    void letStatement () {
        match(Token.TokenType.LET);
        var id = currentToken.lexeme;
        match(Token.TokenType.IDENT);
        match(Token.TokenType.EQ);
        expr();
        output.append("pop " + id + "\n");
        match(Token.TokenType.SEMICOLON);
    }

    void printStatement () {
        match(Token.TokenType.PRINT);
        expr();
        output.append("print\n");
        match(Token.TokenType.SEMICOLON);
    }

    void statement () {
        if (currentToken.type == Token.TokenType.PRINT) {
            printStatement();
        } else if (currentToken.type == Token.TokenType.LET) {
            letStatement();
        } else {
            throw new Error("syntax error");
        }
    }

    void statements () {
        
        while (currentToken.type != Token.TokenType.EOF) {
            statement();
        }
}

    public String output() {
        return output.toString().strip();
    }

}