package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// doc = hash doc_follow*;
public class Doc extends Hash {

    public Doc(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Hash(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new DocFollow(tokenizer).allowed()) {
            push(new DocFollow(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Hash(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "doc";
    }

}
