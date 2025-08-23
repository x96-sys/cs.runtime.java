package zero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// range_hex = hexadecimal dash hexadecimal;
public class RangeHex extends Hexadecimal {

    public RangeHex(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Hexadecimal(tokenizer).safeVisit());
        // nucleus
        // term
        push(new Dash(tokenizer).safeVisit());
        // nucleus
        // term
        push(new Hexadecimal(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Hexadecimal(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "range_hex";
    }

}
