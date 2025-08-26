package sc;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// carrier = (binds | march);
public class Carrier extends Visitor {

    public Carrier(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Binds.class);
        // switch term
        switcher.know(March.class);
        push(switcher.stream(tokenizer));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // switch
        // nucleus
        // term
        new Binds(tokenizer).allowed()
        ||
        // nucleus
        // term
        new March(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "carrier";
    }

}
