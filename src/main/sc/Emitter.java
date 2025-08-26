package sc;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// emitter = primor;
public class Emitter extends Primor {

    public Emitter(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Primor(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Primor(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "emitter";
    }

}
