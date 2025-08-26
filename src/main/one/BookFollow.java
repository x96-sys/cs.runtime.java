package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// book_follow = passage d*;
public class BookFollow extends Passage {

    public BookFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Passage(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new D(tokenizer).allowed()) {
            push(new D(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Passage(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "book_follow";
    }

}
