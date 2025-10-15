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
        expr();
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
}