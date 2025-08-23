package sc;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.LeftParenthesis;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// march = '(' ordered_args? ')';
public class March extends LeftParenthesis {

    public March(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x28) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // term
        if (// term
            new OrderedArgs(tokenizer).allowed()) {
            push(new OrderedArgs(tokenizer).safeVisit());
        }
        // nucleus
        // text
        if (look() != 0x29) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // text
        look() == 0x28
        ;
    }

    @Override
    public String overKind() {
        return "march";
    }

}
