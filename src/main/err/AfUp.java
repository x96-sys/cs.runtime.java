package err;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c4.LatinCapitalLetterA;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// af_up = [0x41-0x46];
public class AfUp extends LatinCapitalLetterA {

    public AfUp(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // trace
        // fleck
        // range
        if (look() < 0x41 || look() > 0x46) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec();
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        (look() >= 0x41 && look() <= 0x46)
        ;
    }

    @Override
    public String overKind() {
        return "af_up";
    }

}
