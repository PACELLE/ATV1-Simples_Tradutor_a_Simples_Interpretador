import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.stream.Collectors;

class Command {
    public enum Type { ADD, SUB, PUSH, POP, PRINT; }
    public Command.Type type;
    public String arg = "";

    public Command(String[] command) {
        type = Command.Type.valueOf(command[0].toUpperCase());
        if (command.length > 1) {
            arg = command[1];
        }
    }

    public String toString() { return type.name() + " " + arg; }
}

public class Interpretador {
    List<String[]> commands;
    Stack<Integer> stack = new Stack<>();
    Map<String,Integer> variables = new HashMap<>();

    Interpretador (String input) {
        // Divide por qualquer quebra de linha (LF, CRLF, CR)
        commands = Arrays.stream(input.split("\\R"))
            .map(String::strip) // remove espaços no início/fim
            .filter(s -> !s.isEmpty() && !s.startsWith("//")) // ignora vazias e comentários de linha
            .map(s -> {
                // remove comentários no final da linha, se houver: "push 10 // comentário"
                int idx = s.indexOf("//");
                if (idx >= 0) s = s.substring(0, idx).strip();
                // split por 1 ou mais espaços (evita tokens vazios)
                return s.split("\\s+");
            })
            .filter(arr -> arr.length > 0)
            .collect(Collectors.toList());
    }

    public boolean hasMoreCommands () {
        return !commands.isEmpty();
    }

    public Command nextCommand () {
        return new Command(commands.remove(0));
    }

    public void run () {
        while (hasMoreCommands()) {
            Command command = nextCommand();
            switch (command.type) {
                case ADD: {
                    int arg2 = stack.pop();
                    int arg1 = stack.pop();
                    stack.push(arg1 + arg2);
                    break;
                }
                case SUB: {
                    int arg2 = stack.pop();
                    int arg1 = stack.pop();
                    stack.push(arg1 - arg2);
                    break;
                }
                case PUSH: {
                    Integer value = variables.get(command.arg);
                    if (value != null) {
                        stack.push(value);
                    } else {
                        // pode lançar NumberFormatException se o token não for número
                        stack.push(Integer.parseInt(command.arg));
                    }
                    break;
                }
                case POP: {
                    int value = stack.pop();
                    variables.put(command.arg, value);
                    break;
                }
                case PRINT: {
                    int arg = stack.pop();
                    System.out.println(arg);
                    break;
                }
                default:
                    throw new Error("unknown command: " + command.type);
            }
        }
    }
}
