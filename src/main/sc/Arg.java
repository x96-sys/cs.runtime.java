package sc;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// arg = (trace | hex | qword);
public class Arg extends Visitor {

    public Arg(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Trace.class);
        // switch term
        switcher.know(Hex.class);
        // switch term
        switcher.know(Qword.class);
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
        new Trace(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Hex(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Qword(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "arg";
    }

}
