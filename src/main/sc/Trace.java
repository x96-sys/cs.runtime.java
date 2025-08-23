package sc;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// trace = {emitter course*}
public class Trace extends Emitter {

    public Trace(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Emitter(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new Course(tokenizer).allowed()) {
            push(new Course(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // mesh
        // nucleus
        // term
        new Emitter(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "trace";
    }

}
