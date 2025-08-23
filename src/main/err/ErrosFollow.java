package err;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// erros_follow = err s*;
public class ErrosFollow extends Err {

    public ErrosFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Err(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new S(tokenizer).allowed()) {
            push(new S(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Err(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "erros_follow";
    }

}
