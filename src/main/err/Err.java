package err;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// err = hex s* template;
public class Err extends Hex {

    public Err(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Hex(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new S(tokenizer).allowed()) {
            push(new S(tokenizer).safeVisit());
        }
        // nucleus
        // term
        push(new Template(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Hex(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "err";
    }

}
