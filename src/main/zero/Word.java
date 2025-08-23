package zero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// word = q word_follow+ q;
public class Word extends Q {

    public Word(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Q(tokenizer).safeVisit());
        // nucleus
        // term
        do {
            push(new WordFollow(tokenizer).safeVisit());
        } while (// term
            new WordFollow(tokenizer).allowed());
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
        return "word";
    }

}
