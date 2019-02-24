package com.app.utils;

/**
 * This util class helps you log input & it's corresponding return values
 * in recursion.
 *
 * Use logMethodEntry() & logMethodExit() in your code appropriately at places.
 *
 */
public class RecursionVisualizer {

    private final char DELIMITER_CHAR = ',';
    private final String SPACE = " ";
    private int tabCounter = 0;
    private EntryEncloserType entryEncloserType = EntryEncloserType.SIMPLE_BRACES;
    private ExitEncloserType exitEncloserType = ExitEncloserType.SQUARE_BRACES;

    public static enum EntryEncloserType {
        SIMPLE_BRACES('(', ')'),
        CURLY_BRACES('{', '}'),
        SQUARE_BRACES('[', ']');

        private char open;
        private char close;

        EntryEncloserType(char open, char close) {
            this.open = open;
            this.close = close;
        }
    }

    public static enum ExitEncloserType {
        SIMPLE_BRACES('(', ')'),
        CURLY_BRACES('{', '}'),
        SQUARE_BRACES('[', ']');

        private char open;
        private char close;

        ExitEncloserType(char open, char close) {
            this.open = open;
            this.close = close;
        }
    }

    public void setEntryEncloserType(final EntryEncloserType entryEncloserType) {
        this.entryEncloserType = entryEncloserType;
    }

    public void setExitEncloserType(final ExitEncloserType exitEncloserType) {
        this.exitEncloserType = exitEncloserType;
    }

    public void logMethodEntry(String... values) {
        giveTabs(tabCounter++);
        System.out.print(entryEncloserType.open);
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i != values.length - 1) {
                System.out.print(DELIMITER_CHAR + SPACE);
            }
        }
        System.out.print(entryEncloserType.close + "\n");
    }

    public void logMethodExit(String... values) {
        giveTabs(--tabCounter);
        System.out.print(exitEncloserType.open);
        for (int i = 0; i < values.length; i++) {
            System.out.print(values[i]);
            if (i != values.length - 1) {
                System.out.print(DELIMITER_CHAR + SPACE);
            }
        }
        System.out.print(exitEncloserType.close + "\n");
    }

    private void giveTabs(int tabCounter) {
        for (int i = 0; i < tabCounter; i++) {
            System.out.print("\t");
        }
    }
}
