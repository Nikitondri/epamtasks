package by.zakharenko.task06composite.service.converter.rpn.impl;

import by.zakharenko.task06composite.service.converter.rpn.ConverterRPN;

import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Stack;
import java.util.regex.Matcher;
import java.util.regex.Pattern;

/** class for translating an infix expression into a postfix one */
public class ConverterRPNImpl implements ConverterRPN {
    private static final String EXPRESSION_REGEX = "([<>]+)|([\\d]+)|[()&|~^]";
    private final List<String> stack;
    private final Map<String, Integer> priority;

    public ConverterRPNImpl() {
        priority = new HashMap<>();
        priority.put("|", 1);
        priority.put("^", 2);
        priority.put("&", 3);
        priority.put("~", 4);
        priority.put(">>", 5);
        priority.put("<<", 5);
        priority.put(">>>", 5);
        stack = new Stack<>();
    }

    @Override
    public String convert(String expression) {
        Pattern pattern = Pattern.compile(EXPRESSION_REGEX);
        Matcher matcher = pattern.matcher(expression);
        StringBuilder postfixNotation = new StringBuilder();
        while (matcher.find()){
            String current = matcher.group();
            if(priority.containsKey(current)){
                postfixNotation.append(gotOperator(current, priority.get(current)));
            } else if("(".equals(current)){
                stack.add(0, current);
            } else if(")".equals(current)){
                postfixNotation.append(gotClosingBracket());
            } else {
                postfixNotation.append(current).append(" ");
            }
        }
        while (!stack.isEmpty()){
            postfixNotation.append(stack.remove(0)).append(" ");
        }
        return postfixNotation.toString().trim();
    }

    private String gotOperator(String current, int currentPriority){
        StringBuilder line = new StringBuilder();
        while (!stack.isEmpty()) {
            String top = stack.remove(0);
            if("(".equals(top) || priority.get(top) < currentPriority){
                stack.add(0, top);
                break;
            } else {
                line.append(top).append(" ");
            }
        }
        stack.add(0, current);
        return line.toString();
    }

    private String gotClosingBracket(){
        StringBuilder parenthesizedExpression = new StringBuilder();
        while (!stack.isEmpty()){
            String current = stack.remove(0);
            if("(".equals(current)){
                break;
            } else {
                parenthesizedExpression.append(current).append(" ");
            }
        }
        return parenthesizedExpression.toString();
    }
}
