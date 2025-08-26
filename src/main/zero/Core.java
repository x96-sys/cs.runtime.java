package zero;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// core = (shared | hexadecimal);
public class Core extends Visitor {

    public Core(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Shared.class);
        // switch term
        switcher.know(Hexadecimal.class);
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
        new Shared(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Hexadecimal(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "core";
    }

}
