package err;

import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c3.DigitZero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c7.LatinSmallLetterX;
import org.x96.sys.foundation.cs.lexer.visitor.entry.terminals.c5.LatinCapitalLetterX;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;

// hex = @0x30 ('x' | 'X') hex_digit+;
public class Hex extends DigitZero {

    public Hex(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // natural
        if (look() != 0x30) throw new BuzzVisitorMismatch(this, this.tokenizer);
        rec(overKind());
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch text
        switcher.know(LatinSmallLetterX.class);
        // switch text
        switcher.know(LatinCapitalLetterX.class);
        push(switcher.stream(tokenizer));
        // nucleus
        // term
        do {
            push(new HexDigit(tokenizer).safeVisit());
        } while (// term
            new HexDigit(tokenizer).allowed());
        setMod(new Shell((byte) 0x40));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // natural
        look() == 0x30
        ;
    }

    @Override
    public String overKind() {
        return "hex";
    }

}
