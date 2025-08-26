package sc;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c0.Lf;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// nl = 0xA;
public class Nl extends Lf {

    public Nl(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0xA) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0xA
        ;
    }

    @Override
    public String overKind() {
        return "nl";
    }

}
