package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c5.LowLine;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// ghost = 0x5F;
public class Ghost extends LowLine {

    public Ghost(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x5F) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x5F
        ;
    }

    @Override
    public String overKind() {
        return "ghost";
    }

}
