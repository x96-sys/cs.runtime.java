package sc;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// pair = primor i* ':' i* (trace | hex | qword);
public class Pair extends Primor {

    public Pair(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Primor(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // text
        if (look() != 0x3A) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Trace.class);
        // switch term
        switcher.know(Hex.class);
        // switch term
        switcher.know(Qword.class);
        push(switcher.stream(tokenizer));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Primor(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "pair";
    }

}
