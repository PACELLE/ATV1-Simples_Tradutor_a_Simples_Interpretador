public class App {
    public static void main(String[] args) throws Exception {
        String input = "let a = 42 + 5;";
        Scanner scan = new Scanner (input.getBytes());
        for (Token tk = scan.nextToken(); tk.type != Token.TokenType.EOF; tk = scan.nextToken()) {
            System.out.println(tk);
        }
    }
}
