package sc;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c0.Cr;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// carriage_return = 0xD;
public class CarriageReturn extends Cr {

    public CarriageReturn(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0xD) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0xD
        ;
    }

    @Override
    public String overKind() {
        return "carriage_return";
    }

}
