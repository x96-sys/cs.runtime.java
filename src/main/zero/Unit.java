package zero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// unit = bang? glyph quantifier?;
public class Unit extends Bang {

    public Unit(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        if (// term
            new Bang(tokenizer).allowed()) {
            push(new Bang(tokenizer).safeVisit());
        }
        // nucleus
        // term
        push(new Glyph(tokenizer).safeVisit());
        // nucleus
        // term
        if (// term
            new Quantifier(tokenizer).allowed()) {
            push(new Quantifier(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Bang(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Glyph(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "unit";
    }

}
