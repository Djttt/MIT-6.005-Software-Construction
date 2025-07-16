package abc.sound;

import abc.parser.AbcBaseListener;
import abc.parser.AbcParser;
import org.antlr.v4.runtime.tree.TerminalNode;

import java.util.ArrayList;
import java.util.List;

public class MyAbcListener extends AbcBaseListener {
    private String title = "";
    private String composer = "";
    private final List<String> notes = new ArrayList<>();


    public String getTitle() {
        return title;
    }
    public String getComposer() {
        return composer;
    }

    public List<String> getNotes() {
        return notes;
    }

    @Override
    public void enterHeader(AbcParser.HeaderContext ctx) {
        for (TerminalNode node : ctx.getTokens(AbcParser.FIELD_TITLE)) {
            String raw = node.getText();  // e.g. T:Hello World
            title = raw.substring(2).trim(); // Save to field
        }

        for (TerminalNode node : ctx.getTokens(AbcParser.FIELD_COMPOSER)) {
            String raw = node.getText();  // e.g. C:John Doe
            composer = raw.substring(2).trim(); // Save to field
        }
    }

    @Override
    public void enterNote(AbcParser.NoteContext ctx) {
        notes.add(ctx.getText()); // Save each note text
    }
}
