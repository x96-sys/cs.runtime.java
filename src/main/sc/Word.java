package sc;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;

// word = @ !q [0x20-0x7E];
public class Word extends Q {

    public Word(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        if (new Q(tokenizer).allowed()) throw new BuzzVisitorMismatch(this, this.tokenizer);
        // nucleus
        // trace
        // fleck
        // range
        if (look() < 0x20 || look() > 0x7E) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec();
        setMod(new Shell((byte) 0x40));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Q(tokenizer).denied()
        &&
        // nucleus
        (look() >= 0x20 && look() <= 0x7E)
        ;
    }

    @Override
    public String overKind() {
        return "word";
    }

}
