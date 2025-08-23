package zero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// core_follow = [core d*];
public class CoreFollow extends Core {

    public CoreFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // trace
        // fleck
        // term
        push(new Core(tokenizer).safeVisit());
        // fleck
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
        new Core(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "core_follow";
    }

}
