package zero;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c5.LeftSquareBracket;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// open_square = 0x5B;
public class OpenSquare extends LeftSquareBracket {

    public OpenSquare(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x5B) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x5B
        ;
    }

    @Override
    public String overKind() {
        return "open_square";
    }

}
