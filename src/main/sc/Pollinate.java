package sc;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c4.CommercialAt;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// pollinate = '@' i* primor i* '=' i* (trace | hex | qword) i* ';';
public class Pollinate extends CommercialAt {

    public Pollinate(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x40) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
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
        if (look() != 0x3D) throw new BuzzVisitorMismatch(this, this.tokenizer);
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
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // text
        if (look() != 0x3B) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // text
        look() == 0x40
        ;
    }

    @Override
    public String overKind() {
        return "pollinate";
    }

}
