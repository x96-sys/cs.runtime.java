package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.ExclamationMark;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// bang = 0x21;
public class Bang extends ExclamationMark {

    public Bang(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x21) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x21
        ;
    }

    @Override
    public String overKind() {
        return "bang";
    }

}
