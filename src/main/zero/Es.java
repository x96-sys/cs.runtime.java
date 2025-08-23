package zero;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;

// es = (s | tab | carriage_return | nl);
public class Es extends Visitor {

    public Es(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(S.class);
        // switch term
        switcher.know(Tab.class);
        // switch term
        switcher.know(CarriageReturn.class);
        // switch term
        switcher.know(Nl.class);
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
        new S(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Tab(tokenizer).allowed()
        ||
        // nucleus
        // term
        new CarriageReturn(tokenizer).allowed()
        ||
        // nucleus
        // term
        new Nl(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "es";
    }

}
