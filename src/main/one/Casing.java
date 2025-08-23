package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// casing = open_brace d* core_follow+ close_brace;
public class Casing extends OpenBrace {

    public Casing(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new OpenBrace(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new D(tokenizer).allowed()) {
            push(new D(tokenizer).safeVisit());
        }
        // nucleus
        // term
        do {
            push(new CoreFollow(tokenizer).safeVisit());
        } while (// term
            new CoreFollow(tokenizer).allowed());
        // nucleus
        // term
        push(new CloseBrace(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new OpenBrace(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "casing";
    }

}
