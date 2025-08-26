package sc;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// mapped_args = pair i* pair_follow*;
public class MappedArgs extends Pair {

    public MappedArgs(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Pair(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // term
        while (// term
            new PairFollow(tokenizer).allowed()) {
            push(new PairFollow(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Pair(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "mapped_args";
    }

}
