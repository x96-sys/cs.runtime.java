package one;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c5.LatinCapitalLetterX;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// x_up = 0x58;
public class XUp extends LatinCapitalLetterX {

    public XUp(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x58) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x58
        ;
    }

    @Override
    public String overKind() {
        return "x_up";
    }

}
