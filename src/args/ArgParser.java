package args;

import java.util.ArrayList;
import java.util.List;
import java.util.regex.Pattern;
import java.util.regex.Matcher;

public class ArgParser {
  public static void main(String[] args) {
    System.out.println(ArgParser.class);
    for (int i = 0; i < args.length; i++) {
      System.out.printf("[%d] %s\n", i, args[i]);
    }
  }

  public static String[] parse(String line) {
    List<String> matchList = new ArrayList<String>();
    Pattern regex = Pattern.compile("[^\\s\"']+|\"([^\"]*)\"|'([^']*)'");
    Matcher regexMatcher = regex.matcher(line);
    while (regexMatcher.find()) {
      if (regexMatcher.group(1) != null) {
        matchList.add(regexMatcher.group(1));
      } else if (regexMatcher.group(2) != null) {
        matchList.add(regexMatcher.group(2));
      } else {
        matchList.add(regexMatcher.group());
      }
    }
    String[] cargs = new String[matchList.size()];
    cargs = matchList.toArray(cargs);
    return cargs;
  }
}
