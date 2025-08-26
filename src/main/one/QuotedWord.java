package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// quoted_word = q word+ q;
public class QuotedWord extends Q {

    public QuotedWord(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Q(tokenizer).safeVisit());
        // nucleus
        // term
        do {
            push(new Word(tokenizer).safeVisit());
        } while (// term
            new Word(tokenizer).allowed());
        // nucleus
        // term
        push(new Q(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Q(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "quoted_word";
    }

}
