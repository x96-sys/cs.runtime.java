package one;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.NumberSign;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// hash = 0x23;
public class Hash extends NumberSign {

    public Hash(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x23) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x23
        ;
    }

    @Override
    public String overKind() {
        return "hash";
    }

}
