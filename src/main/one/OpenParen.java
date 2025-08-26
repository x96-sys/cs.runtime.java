package one;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c2.LeftParenthesis;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// open_paren = 0x28;
public class OpenParen extends LeftParenthesis {

    public OpenParen(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x28) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x28
        ;
    }

    @Override
    public String overKind() {
        return "open_paren";
    }

}
