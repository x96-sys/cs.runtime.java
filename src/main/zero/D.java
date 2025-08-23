package zero;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// d = (doc | es);
public class D extends Visitor {

    public D(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Doc.class);
        // switch term
        switcher.know(Es.class);
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
        new Doc(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Es(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "d";
    }

}
