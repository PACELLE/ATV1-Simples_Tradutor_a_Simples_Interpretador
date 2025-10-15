public class Token {
    final TokenType type;
    final String lexeme;

    public Token (TokenType type, String lexeme) {
        this.type = type;
        this.lexeme = lexeme;
    }

    public String toString() {
        return "<"+ type +">" + lexeme + "</"+ type + ">";
    }

    public enum TokenType {
        PLUS,MINUS, EQ, SEMICOLON,

        // Literals.
        NUMBER,
        IDENT,
        
        LET,

        EOF
    }
}
