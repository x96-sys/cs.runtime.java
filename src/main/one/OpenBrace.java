package one;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c7.LeftCurlyBracket;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// open_brace = 0x7B;
public class OpenBrace extends LeftCurlyBracket {

    public OpenBrace(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x7B) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x7B
        ;
    }

    @Override
    public String overKind() {
        return "open_brace";
    }

}
