package one;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c7.LatinSmallLetterX;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// x_low = 0x78;
public class XLow extends LatinSmallLetterX {

    public XLow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x78) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x78
        ;
    }

    @Override
    public String overKind() {
        return "x_low";
    }

}
