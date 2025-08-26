package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c7.RightCurlyBracket;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// close_brace = 0x7D;
public class CloseBrace extends RightCurlyBracket {

    public CloseBrace(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x7D) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x7D
        ;
    }

    @Override
    public String overKind() {
        return "close_brace";
    }

}
