package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.HyphenMinus;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// dash = 0x2D;
public class Dash extends HyphenMinus {

    public Dash(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x2D) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x2D
        ;
    }

    @Override
    public String overKind() {
        return "dash";
    }

}
