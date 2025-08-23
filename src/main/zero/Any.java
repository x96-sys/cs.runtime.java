package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.Space;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// any = [0x20-0x7E];
public class Any extends Space {

    public Any(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // trace
        // fleck
        // range
        if (look() < 0x20 || look() > 0x7E) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec();
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        (look() >= 0x20 && look() <= 0x7E)
        ;
    }

    @Override
    public String overKind() {
        return "any";
    }

}
