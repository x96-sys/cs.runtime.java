package sc;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.Comma;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// arg_follow = ',' i* arg;
public class ArgFollow extends Comma {

    public ArgFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x2C) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // term
        push(new Arg(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // text
        look() == 0x2C
        ;
    }

    @Override
    public String overKind() {
        return "arg_follow";
    }

}
