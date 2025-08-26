package sc;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// primor_follow = (alpha | digit | ghost);
public class PrimorFollow extends Visitor {

    public PrimorFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Alpha.class);
        // switch term
        switcher.know(Digit.class);
        // switch term
        switcher.know(Ghost.class);
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
        new Alpha(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Digit(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Ghost(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "primor_follow";
    }

}
