package sc;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c7.LeftCurlyBracket;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// binds = '{' mapped_args? '}';
public class Binds extends LeftCurlyBracket {

    public Binds(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // text
        if (look() != 0x7B) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // term
        if (// term
            new MappedArgs(tokenizer).allowed()) {
            push(new MappedArgs(tokenizer).safeVisit());
        }
        // nucleus
        // text
        if (look() != 0x7D) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // text
        look() == 0x7B
        ;
    }

    @Override
    public String overKind() {
        return "binds";
    }

}
