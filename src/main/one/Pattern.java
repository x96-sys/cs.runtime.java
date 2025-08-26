package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// pattern = modifier? (lineage | casing);
public class Pattern extends Modifier {

    public Pattern(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        if (// term
            new Modifier(tokenizer).allowed()) {
            push(new Modifier(tokenizer).safeVisit());
        }
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Lineage.class);
        // switch term
        switcher.know(Casing.class);
        push(switcher.stream(tokenizer));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Modifier(tokenizer).allowed()
        ||
        // nucleus
        // switch
        // nucleus
        // term
        new Lineage(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Casing(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "pattern";
    }

}
