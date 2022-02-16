package by.zakharenko.task06composite.service.interpreter.math;

import by.zakharenko.task06composite.service.interpreter.math.terminal.*;

import java.util.ArrayList;
import java.util.List;
import java.util.Scanner;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

public class Client {
    private static final String EXPRESSION_REGEX = "([<>]+)|([\\d]+)|[()&|~^]";
    private final List<AbstractMathExpression> listExpression;


    public Client(String expression) {
        listExpression = new ArrayList<>();
        parse(expression);
    }

    public Number calculate(){
        Context context = new Context();
        for(AbstractMathExpression terminal : listExpression){
            terminal.interpret(context);
        }
        return context.popValue();
    }

    private void parse(String expression){
        Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(expression);
        while (matcher.find()){
            String element = matcher.group();
            switch (element){
                case ">>>" -> listExpression.add(new TerminalExpressionUnsignedRightShift());
                case ">>" -> listExpression.add(new TerminalExpressionRightShift());
                case "<<" -> listExpression.add(new TerminalExpressionLeftShift());
                case "&" -> listExpression.add(new TerminalExpressionAnd());
                case "|" -> listExpression.add(new TerminalExpressionOr());
                case "~" -> listExpression.add(new TerminalExpressionNot());
                case "^" -> listExpression.add(new TerminalExpressionXOR());
                default -> {
                    Scanner scanner = new Scanner(element);
                    if(scanner.hasNextInt()){
                        listExpression.add(new NonTerminalExpressionNumber(scanner.nextInt()));
                    }
                }
            }
        }
    }
}
