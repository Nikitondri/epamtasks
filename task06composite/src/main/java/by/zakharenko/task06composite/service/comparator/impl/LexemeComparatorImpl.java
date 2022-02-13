package by.zakharenko.task06composite.service.comparator.impl;

import by.zakharenko.task06composite.entity.SymbolLeaf;
import by.zakharenko.task06composite.entity.TextComponent;
import by.zakharenko.task06composite.service.comparator.TextComponentComparator;

import java.util.ArrayList;
import java.util.List;

public class LexemeComparatorImpl implements TextComponentComparator {
    private final char ch;

    public LexemeComparatorImpl(char newCh) {
        ch = newCh;
    }

    @Override
    public int compare(TextComponent o1, TextComponent o2) {
        List<TextComponent> lexeme1Symbols = createLexemeSymbols(o1);
        List<TextComponent> lexeme2Symbols = createLexemeSymbols(o2);
        int numEntering1 = countEntering(lexeme1Symbols);
        int numEntering2 = countEntering(lexeme2Symbols);
        if(numEntering1 == numEntering2){
            return compareLexemesByAlphabet(lexeme1Symbols, lexeme2Symbols);
        } else {
            return Integer.compare(numEntering2, numEntering1);
        }
    }

    private List<TextComponent> createLexemeSymbols(TextComponent lexeme){
        List<TextComponent> symbols = new ArrayList<>();
        for(TextComponent component: lexeme.getComponents()){
            if(component instanceof SymbolLeaf){
                symbols.add(component);
            } else {
                symbols.addAll(component.getComponents());
            }
        }
        return symbols;
    }

    private int countEntering(List<TextComponent> symbols){
        int numEntering = 0;
        for (TextComponent Symbol : symbols) {
            if (Symbol.value() == ch) {
                numEntering++;
            }
        }
        return numEntering;
    }

    private int compareLexemesByAlphabet(List<TextComponent> lexeme1Symbols, List<TextComponent> lexeme2Symbols){
        StringBuilder str1 = createStr(lexeme1Symbols);
        StringBuilder str2 = createStr(lexeme2Symbols);
        return str1.compareTo(str2);
    }

    private StringBuilder createStr(List<TextComponent> lexemeSymbols){
        StringBuilder str = new StringBuilder();
        for(TextComponent component : lexemeSymbols){
            str.append(String.valueOf(component.value()).toUpperCase());
        }
        return str;
    }
}
