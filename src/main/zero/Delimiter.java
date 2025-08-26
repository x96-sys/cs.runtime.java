package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c3.Semicolon;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// delimiter = 0x3B;
public class Delimiter extends Semicolon {

    public Delimiter(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x3B) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x3B
        ;
    }

    @Override
    public String overKind() {
        return "delimiter";
    }

}
