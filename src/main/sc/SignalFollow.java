package sc;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// signal_follow = signal i*;
public class SignalFollow extends Signal {

    public SignalFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Signal(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Signal(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "signal_follow";
    }

}
