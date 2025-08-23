package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c5.RightSquareBracket;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// close_square = 0x5D;
public class CloseSquare extends RightSquareBracket {

    public CloseSquare(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x5D) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x5D
        ;
    }

    @Override
    public String overKind() {
        return "close_square";
    }

}
