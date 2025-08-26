package sc;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// course = (catalysis | carrier);
public class Course extends Visitor {

    public Course(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(Catalysis.class);
        // switch term
        switcher.know(Carrier.class);
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
        new Catalysis(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Carrier(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "course";
    }

}
