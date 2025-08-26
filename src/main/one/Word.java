package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;

// word = @!q any;
public class Word extends Q {

    public Word(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        if (new Q(tokenizer).allowed()) throw new BuzzVisitorMismatch(this, this.tokenizer);
        // nucleus
        // term
        push(new Any(tokenizer).safeVisit());
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
        // term
        new Any(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "word";
    }

}
