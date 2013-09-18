package utils;

import java.awt.Color;
import java.util.HashSet;
import javax.swing.JTextPane;
import javax.swing.text.*;
import main.FrmMain;

public class D3SyntaxDocument extends DefaultStyledDocument {

    private DefaultStyledDocument doc;
    private JTextPane textPane;
    private Element rootElement;
    private MutableAttributeSet normal;
    private MutableAttributeSet keyword;
    private MutableAttributeSet comment;
    private MutableAttributeSet quote;
    private HashSet keywords;

    public D3SyntaxDocument(JTextPane textPane) {

        this.textPane = textPane;
        doc = this;
        rootElement = doc.getDefaultRootElement();
        putProperty(DefaultEditorKit.EndOfLineStringProperty, "\n");

        normal = new SimpleAttributeSet();
        StyleConstants.setForeground(normal, new Color(Integer.parseInt(FrmMain.getProperty("default_color"))));

        comment = new SimpleAttributeSet();
        StyleConstants.setForeground(comment, new Color(Integer.parseInt(FrmMain.getProperty("comment_color"))));
        StyleConstants.setItalic(comment, true);

        keyword = new SimpleAttributeSet();
        StyleConstants.setForeground(keyword, new Color(Integer.parseInt(FrmMain.getProperty("keyword_color"))));

        quote = new SimpleAttributeSet();
        StyleConstants.setForeground(quote, new Color(Integer.parseInt(FrmMain.getProperty("string_color"))));

        keywords = new HashSet();

        keywords.add("$chain");
        keywords.add("$include");
        keywords.add("$options");
        keywords.add("abort");
        keywords.add("and");
        keywords.add("aux");
        keywords.add("begin");
        keywords.add("break");
        keywords.add("cache");
        keywords.add("call");
        keywords.add("capturing");
        keywords.add("case");
        keywords.add("casing");
        keywords.add("cat");
        keywords.add("cfunction");
        keywords.add("chain");
        keywords.add("clear");
        keywords.add("cleardata");
        keywords.add("clearfile");
        keywords.add("clearselect");
        keywords.add("close");
        keywords.add("commit");
        keywords.add("common");
        keywords.add("compare");
        keywords.add("continue");
        keywords.add("convert");
        keywords.add("crt");
        keywords.add("data");
        keywords.add("debug");
        keywords.add("del");
        keywords.add("delete");
        keywords.add("dimension");
        keywords.add("do");
        keywords.add("echo");
        keywords.add("else");
        keywords.add("end");
        keywords.add("enter");
        keywords.add("eq");
        keywords.add("equate");
        keywords.add("error");
        keywords.add("execute");
        keywords.add("exit");
        keywords.add("file");
        keywords.add("filelock");
        keywords.add("fileunlock");
        keywords.add("flush");
        keywords.add("footing");
        keywords.add("for");
        keywords.add("from");
        keywords.add("ge");
        keywords.add("get");
        keywords.add("getx");
        keywords.add("go");
        keywords.add("gosub");
        keywords.add("goto");
        keywords.add("gt");
        keywords.add("heading");
        keywords.add("if");
        keywords.add("ifr");
        keywords.add("in");
        keywords.add("input");
        keywords.add("inputclear");
        keywords.add("inputctrl");
        keywords.add("inputerr");
        keywords.add("inputnull");
        keywords.add("inputparity");
        keywords.add("inputtrap");
        keywords.add("ins");
        keywords.add("key");
        keywords.add("le");
        keywords.add("let");
        keywords.add("locate");
        keywords.add("lock");
        keywords.add("locked");
        keywords.add("loop");
        keywords.add("lt");
        keywords.add("mat");
        keywords.add("matbuild");
        keywords.add("match");
        keywords.add("matparse");
        keywords.add("matread");
        keywords.add("matwrite");
        keywords.add("matwriteu");
        keywords.add("ne");
        keywords.add("next");
        keywords.add("null");
        keywords.add("off");
        keywords.add("on");
        keywords.add("onerr");
        keywords.add("open");
        keywords.add("or");
        keywords.add("out");
        keywords.add("page");
        keywords.add("precision");
        keywords.add("print");
        keywords.add("printchar");
        keywords.add("printer");
        keywords.add("procread");
        keywords.add("procwrite");
        keywords.add("program");
        keywords.add("prompt");
        keywords.add("read");
        keywords.add("readnext");
        keywords.add("readt");
        keywords.add("readtx");
        keywords.add("readv");
        keywords.add("release");
        keywords.add("rem");
        keywords.add("remove");
        keywords.add("repeat");
        keywords.add("replace");
        keywords.add("return");
        keywords.add("returning");
        keywords.add("rewind");
        keywords.add("rollback");
        keywords.add("root");
        keywords.add("rqm");
        keywords.add("select");
        keywords.add("send");
        keywords.add("sendx");
        keywords.add("setting");
        keywords.add("sleep");
        keywords.add("spoolq");
        keywords.add("start");
        keywords.add("step");
        keywords.add("stop");
        keywords.add("subroutine");
        keywords.add("ta");
        keywords.add("tcl");
        keywords.add("tclread");
        keywords.add("then");
        keywords.add("to");
        keywords.add("transaction");
        keywords.add("transaction ");
        keywords.add("unlock");
        keywords.add("until");
        keywords.add("weof");
        keywords.add("while");
        keywords.add("work");
        keywords.add("write");
        keywords.add("writet");
        keywords.add("writeu");
        keywords.add("writev");
        keywords.add("writevu");
        keywords.add("writex");

        keywords.add("$CHAIN");
        keywords.add("$INCLUDE");
        keywords.add("$OPTIONS");
        keywords.add("ABORT");
        keywords.add("AND");
        keywords.add("AUX");
        keywords.add("BEGIN");
        keywords.add("BREAK");
        keywords.add("CACHE");
        keywords.add("CALL");
        keywords.add("CAPTURING");
        keywords.add("CASE");
        keywords.add("CASING");
        keywords.add("CAT");
        keywords.add("CFUNCTION");
        keywords.add("CHAIN");
        keywords.add("CLEAR");
        keywords.add("CLEARDATA");
        keywords.add("CLEARFILE");
        keywords.add("CLEARSELECT");
        keywords.add("CLOSE");
        keywords.add("COMMIT");
        keywords.add("COMMON");
        keywords.add("COMPARE");
        keywords.add("CONTINUE");
        keywords.add("CONVERT");
        keywords.add("CRT");
        keywords.add("DATA");
        keywords.add("DEBUG");
        keywords.add("DEL");
        keywords.add("DELETE");
        keywords.add("DIMENSION");
        keywords.add("DO");
        keywords.add("ECHO");
        keywords.add("ELSE");
        keywords.add("END");
        keywords.add("ENTER");
        keywords.add("EQ");
        keywords.add("EQUATE");
        keywords.add("ERROR");
        keywords.add("EXECUTE");
        keywords.add("EXIT");
        keywords.add("FILE");
        keywords.add("FILELOCK");
        keywords.add("FILEUNLOCK");
        keywords.add("FLUSH");
        keywords.add("FOOTING");
        keywords.add("FOR");
        keywords.add("FROM");
        keywords.add("GE");
        keywords.add("GET");
        keywords.add("GETX");
        keywords.add("GO");
        keywords.add("GOSUB");
        keywords.add("GOTO");
        keywords.add("GT");
        keywords.add("HEADING");
        keywords.add("IF");
        keywords.add("IFR");
        keywords.add("IN");
        keywords.add("INPUT");
        keywords.add("INPUTCLEAR");
        keywords.add("INPUTCTRL");
        keywords.add("INPUTERR");
        keywords.add("INPUTNULL");
        keywords.add("INPUTPARITY");
        keywords.add("INPUTTRAP");
        keywords.add("INS");
        keywords.add("KEY");
        keywords.add("LE");
        keywords.add("LET");
        keywords.add("LOCATE");
        keywords.add("LOCK");
        keywords.add("LOCKED");
        keywords.add("LOOP");
        keywords.add("LT");
        keywords.add("MAT");
        keywords.add("MATBUILD");
        keywords.add("MATCH");
        keywords.add("MATPARSE");
        keywords.add("MATREAD");
        keywords.add("MATWRITE");
        keywords.add("MATWRITEU");
        keywords.add("NE");
        keywords.add("NEXT");
        keywords.add("NULL");
        keywords.add("OFF");
        keywords.add("ON");
        keywords.add("ONERR");
        keywords.add("OPEN");
        keywords.add("OR");
        keywords.add("OUT");
        keywords.add("PAGE");
        keywords.add("PRECISION");
        keywords.add("PRINT");
        keywords.add("PRINTCHAR");
        keywords.add("PRINTER");
        keywords.add("PROCREAD");
        keywords.add("PROCWRITE");
        keywords.add("PROGRAM");
        keywords.add("PROMPT");
        keywords.add("READ");
        keywords.add("READNEXT");
        keywords.add("READT");
        keywords.add("READTX");
        keywords.add("READV");
        keywords.add("RELEASE");
        keywords.add("REM");
        keywords.add("REMOVE");
        keywords.add("REPEAT");
        keywords.add("REPLACE");
        keywords.add("RETURN");
        keywords.add("RETURNING");
        keywords.add("REWIND");
        keywords.add("ROLLBACK");
        keywords.add("ROOT");
        keywords.add("RQM");
        keywords.add("SELECT");
        keywords.add("SEND");
        keywords.add("SENDX");
        keywords.add("SETTING");
        keywords.add("SLEEP");
        keywords.add("SPOOLQ");
        keywords.add("START");
        keywords.add("STEP");
        keywords.add("STOP");
        keywords.add("SUBROUTINE");
        keywords.add("TA");
        keywords.add("TCL");
        keywords.add("TCLREAD");
        keywords.add("THEN");
        keywords.add("TO");
        keywords.add("TRANSACTION");
        keywords.add("TRANSACTION ");
        keywords.add("UNLOCK");
        keywords.add("UNTIL");
        keywords.add("WEOF");
        keywords.add("WHILE");
        keywords.add("WORK");
        keywords.add("WRITE");
        keywords.add("WRITET");
        keywords.add("WRITEU");
        keywords.add("WRITEV");
        keywords.add("WRITEVU");
        keywords.add("WRITEX");

    }

    /*
     * Override to apply syntax highlighting after the document has been updated
     */
    @Override
    public void insertString(int offs, String str, AttributeSet a) throws BadLocationException {

        if (str.equals("\t")) {
            str = "  ";
        }

        if (str.equals("'")) {
            str = "''";
        }

        if (str.equals("\"")) {
            str = "\"\"";
        }

        if (str.equals("\\")) {
            str = "\\\\";
        }

        super.insertString(offs, str, a);

        if (str.equals("''") || str.equals("\"\"") || str.equals("\\\\")) {
            textPane.setCaretPosition(offs + 1);
        }

        processChangedLines(offs, str.length());

    }

    /*
     * Override to apply syntax highlighting after the document has been updated
     */
    @Override
    public void remove(int offset, int length) throws BadLocationException {
        super.remove(offset, length);
        processChangedLines(offset, 0);
    }

    /*
     * Determine how many lines have been changed, then apply highlighting to
     * each line
     */
    public void processChangedLines(int offset, int length)
            throws BadLocationException {

        String content = doc.getText(0, doc.getLength());

        //  The lines affected by the latest document update

        int startLine = rootElement.getElementIndex(offset);
        int endLine = rootElement.getElementIndex(offset + length);

        //  Do the actual highlighting

        for (int i = startLine; i <= endLine; i++) {
            applyHighlighting(content, i);
        }

    }

    /*
     * Parse the line to determine the appropriate highlighting
     */
    private void applyHighlighting(String content, int line)
            throws BadLocationException {

        int startOffset = rootElement.getElement(line).getStartOffset();
        int endOffset = rootElement.getElement(line).getEndOffset() - 1;

        int lineLength = endOffset - startOffset;
        int contentLength = content.length();

        if (endOffset >= contentLength) {
            endOffset = contentLength - 1;
        }

        //  set normal attributes for the line

        doc.setCharacterAttributes(startOffset, lineLength, normal, true);

        //  check for single line comment

        int index = content.indexOf("*", startOffset);

        if ((index > -1) && (index < endOffset)) {

            // Comment at the beginning of the line or after a semicolon (;)
            if (getLine(content, index).trim().substring(0, 1).equals("*")
                    || getLine(content, index).trim().contains(";")) {

                doc.setCharacterAttributes(index, endOffset - index + 1, comment, false);
                endOffset = index - 1;

            }

        }

        //
        // Comment with !
        //

        index = content.indexOf("!", startOffset);

        if ((index > -1) && (index < endOffset)) {

            // Comment at the beginning of the line or after a semicolon (;)
            if (getLine(content, index).trim().substring(0, 1).equals("!")
                    || getLine(content, index).trim().contains(";")) {

                doc.setCharacterAttributes(index, endOffset - index + 1, comment, false);
                endOffset = index - 1;

            }

        }

        //
        // Comment with rem
        //

        index = content.toLowerCase().indexOf("rem", startOffset);

        if ((index > -1) && (index < endOffset)) {

            // Comment at the beginning of the line or after a semicolon (;)
            if (getLine(content, index).trim().toLowerCase().substring(0, 3).equals("rem")
                    || getLine(content, index).trim().contains(";")) {

                doc.setCharacterAttributes(index, endOffset - index + 1, comment, false);
                endOffset = index - 1;

            }

        }

        //  check for tokens

        checkForTokens(content, startOffset, endOffset);
    }

    /*
     * Parse the line for tokens to highlight
     */
    private void checkForTokens(String content, int startOffset, int endOffset) {
        while (startOffset <= endOffset) {
            //  skip the delimiters to find the start of a new token

            while (isDelimiter(content.substring(startOffset, startOffset + 1))) {
                if (startOffset < endOffset) {
                    startOffset++;
                } else {
                    return;
                }
            }

            //  Extract and process the entire token

            if (isQuoteDelimiter(content.substring(startOffset, startOffset + 1))) {
                startOffset = getQuoteToken(content, startOffset, endOffset);
            } else {
                startOffset = getOtherToken(content, startOffset, endOffset);
            }
        }
    }

    /*
     *
     */
    private int getQuoteToken(String content, int startOffset, int endOffset) {
        String quoteDelimiter = content.substring(startOffset, startOffset + 1);
        String escapeString = getEscapeString(quoteDelimiter);

        int index;
        int endOfQuote = startOffset;

        //  skip over the escape quotes in this quote

        index = content.indexOf(escapeString, endOfQuote + 1);

        while ((index > -1) && (index < endOffset)) {
            endOfQuote = index + 1;
            index = content.indexOf(escapeString, endOfQuote);
        }

        // now find the matching delimiter

        index = content.indexOf(quoteDelimiter, endOfQuote + 1);

        if ((index < 0) || (index > endOffset)) {
            endOfQuote = endOffset;
        } else {
            endOfQuote = index;
        }

        doc.setCharacterAttributes(startOffset, endOfQuote - startOffset + 1, quote, false);

        return endOfQuote + 1;
    }

    private int getOtherToken(String content, int startOffset, int endOffset) {
        int endOfToken = startOffset + 1;

        while (endOfToken <= endOffset) {
            if (isDelimiter(content.substring(endOfToken, endOfToken + 1))) {
                break;
            }

            endOfToken++;
        }

        String token = content.substring(startOffset, endOfToken);

        if (isKeyword(token)) {
            doc.setCharacterAttributes(startOffset, endOfToken - startOffset, keyword, false);
        }

        return endOfToken + 1;
    }

    private String getLine(String content, int offset) {
        int line = rootElement.getElementIndex(offset);
        Element lineElement = rootElement.getElement(line);
        int start = lineElement.getStartOffset();
        int end = lineElement.getEndOffset();
        return content.substring(start, end - 1);
    }

    /*
     * Override for other languages
     */
    protected boolean isDelimiter(String character) {
        String operands = ";:{}()[]+-/%<=>!&|^~*";

        if (Character.isWhitespace(character.charAt(0))
                || operands.indexOf(character) != -1) {
            return true;
        } else {
            return false;
        }
    }

    /*
     * Override for other languages
     */
    protected boolean isQuoteDelimiter(String character) {
        String quoteDelimiters = "\"'\\";

        if (quoteDelimiters.indexOf(character) < 0) {
            return false;
        } else {
            return true;
        }
    }

    /*
     * Override for other languages
     */
    protected boolean isKeyword(String token) {
        return keywords.contains(token);
    }

    /*
     * Override for other languages
     */
    protected String getSingleLineDelimiter() {
        return "*";
    }

    /*
     * Override for other languages
     */
    protected String getEscapeString(String quoteDelimiter) {
        return "\\" + quoteDelimiter;
    }

    /*
     *
     */
    protected String addMatchingBrace(int offset) throws BadLocationException {
        StringBuilder whiteSpace = new StringBuilder();
        int line = rootElement.getElementIndex(offset);
        int i = rootElement.getElement(line).getStartOffset();

        while (true) {
            String temp = doc.getText(i, 1);

            if (temp.equals(" ") || temp.equals("\t")) {
                whiteSpace.append(temp);
                i++;
            } else {
                break;
            }
        }

        return "{\n" + whiteSpace.toString() + "\t\n" + whiteSpace.toString() + "}";
    }
}