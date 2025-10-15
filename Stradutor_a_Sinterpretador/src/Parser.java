public class Parser {
    
    private Scanner scan;
    private Token currentToken;

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
        System.out.println("push " + currentToken.lexeme);
        match(Token.TokenType.NUMBER);
    }

    void term () {
            if (currentToken.type == Token.TokenType.NUMBER)
                number();
            else if (currentToken.type == Token.TokenType.IDENT) {
                System.out.println("push "+currentToken.lexeme);
                match(Token.TokenType.IDENT);
            }
            else
                throw new Error("syntax error");
        }

    void oper () {
        if (currentToken.type == Token.TokenType.PLUS) {
            match(Token.TokenType.PLUS);
            term();
            System.out.println("add");
            oper();
        } else if (currentToken.type == Token.TokenType.MINUS) {
            match(Token.TokenType.MINUS);
            term();
            System.out.println("sub");
            oper();
        } 
    }

    void letStatement () {
        match(Token.TokenType.LET);
        var id = currentToken.lexeme;
        match(Token.TokenType.IDENT);
        match(Token.TokenType.EQ);
        expr();
        System.out.println("pop "+id);
        match(Token.TokenType.SEMICOLON);
    }

    void printStatement () {
        match(Token.TokenType.PRINT);
        expr();
        System.out.println("print");
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
}