package sc;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// ordered_args = arg i* arg_follow*;
public class OrderedArgs extends Arg {

    public OrderedArgs(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Arg(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new I(tokenizer).allowed()) {
            push(new I(tokenizer).safeVisit());
        }
        // nucleus
        // term
        while (// term
            new ArgFollow(tokenizer).allowed()) {
            push(new ArgFollow(tokenizer).safeVisit());
        }
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Arg(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "ordered_args";
    }

}
