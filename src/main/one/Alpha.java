package one;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// alpha = (alpha_up | alpha_low);
public class Alpha extends Visitor {

    public Alpha(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(AlphaUp.class);
        // switch term
        switcher.know(AlphaLow.class);
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
        new AlphaUp(tokenizer).allowed()
        ||
        // nucleus
        // term
        new AlphaLow(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "alpha";
    }

}
