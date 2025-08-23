package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// choices = open_paren d* core d* choices_follow+ close_paren;
public class Choices extends OpenParen {

    public Choices(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new OpenParen(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new D(tokenizer).allowed()) {
            push(new D(tokenizer).safeVisit());
        }
        // nucleus
        // term
        push(new Core(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new D(tokenizer).allowed()) {
            push(new D(tokenizer).safeVisit());
        }
        // nucleus
        // term
        do {
            push(new ChoicesFollow(tokenizer).safeVisit());
        } while (// term
            new ChoicesFollow(tokenizer).allowed());
        // nucleus
        // term
        push(new CloseParen(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new OpenParen(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "choices";
    }

}
