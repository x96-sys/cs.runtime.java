package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c6.LatinSmallLetterA;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// af_low = [0x61-0x66];
public class AfLow extends LatinSmallLetterA {

    public AfLow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // trace
        // fleck
        // range
        if (look() < 0x61 || look() > 0x66) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec();
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        (look() >= 0x61 && look() <= 0x66)
        ;
    }

    @Override
    public String overKind() {
        return "af_low";
    }

}
