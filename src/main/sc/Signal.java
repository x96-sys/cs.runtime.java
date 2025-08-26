package sc;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// signal = (pollinate | trace);
public class Signal extends Visitor {

    public Signal(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Pollinate.class);
        // switch term
        switcher.know(Trace.class);
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
        new Pollinate(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Trace(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "signal";
    }

}
