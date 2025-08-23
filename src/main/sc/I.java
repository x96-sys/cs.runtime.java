package sc;

import org.x96.sys.foundation.cs.lexer.visitor.Visitor;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;

// i = @ (s | tab | carriage_return | nl);
public class I extends Visitor {

    public I(Tokenizer tokenizer) { super(tokenizer); }

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
        setMod(new Shell((byte) 0x40));
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
        return "i";
    }

}
