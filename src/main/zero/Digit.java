package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c3.DigitZero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// digit = [0x30-0x39];
public class Digit extends DigitZero {

    public Digit(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // trace
        // fleck
        // range
        if (look() < 0x30 || look() > 0x39) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec();
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        (look() >= 0x30 && look() <= 0x39)
        ;
    }

    @Override
    public String overKind() {
        return "digit";
    }

}
