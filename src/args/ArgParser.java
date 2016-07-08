package args;

public class ArgParser {
    public static void main(String[] args) {
        System.out.println(ArgParser.class);
        for (int i = 0; i < args.length; i++) {
            System.out.printf("[%d] %s\n", i, args[i]);
        }
    }
}
