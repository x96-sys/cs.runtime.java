package one;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// modifier = (ghost | shell) d*;
public class Modifier extends Visitor {

    public Modifier(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Ghost.class);
        // switch term
        switcher.know(Shell.class);
        push(switcher.stream(tokenizer));
        // nucleus
        // term
        while (// term
            new D(tokenizer).allowed()) {
            push(new D(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // switch
        // nucleus
        // term
        new Ghost(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Shell(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "modifier";
    }

}
