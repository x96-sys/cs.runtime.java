package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c3.Equals;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// assignor = 0x3D;
public class Assignor extends Equals {

    public Assignor(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x3D) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x3D
        ;
    }

    @Override
    public String overKind() {
        return "assignor";
    }

}
