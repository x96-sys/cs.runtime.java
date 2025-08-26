package zero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// book = {stx d* book_follow+ eoi}
public class Book extends Stx {

    public Book(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Stx(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new D(tokenizer).allowed()) {
            push(new D(tokenizer).safeVisit());
        }
        // nucleus
        // term
        do {
            push(new BookFollow(tokenizer).safeVisit());
        } while (// term
            new BookFollow(tokenizer).allowed());
        // nucleus
        // term
        push(new Eoi(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // mesh
        // nucleus
        // term
        new Stx(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "book";
    }

}
