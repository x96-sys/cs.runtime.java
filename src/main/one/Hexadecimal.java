package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.router.switcher.Switcher;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;

// hexadecimal = @zero (x_up | x_low) hex_digit+;
public class Hexadecimal extends Zero {

    public Hexadecimal(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Zero(tokenizer).safeVisit());
        // nucleus
        // switch
        Switcher switcher = new Switcher();
        // switch term
        switcher.know(XUp.class);
        // switch term
        switcher.know(XLow.class);
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
        // term
        new Zero(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "hexadecimal";
    }

}
