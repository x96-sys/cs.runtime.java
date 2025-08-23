package err;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// erros = {stx s* erros_follow+ etx}
public class Erros extends Stx {

    public Erros(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Stx(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new S(tokenizer).allowed()) {
            push(new S(tokenizer).safeVisit());
        }
        // nucleus
        // term
        do {
            push(new ErrosFollow(tokenizer).safeVisit());
        } while (// term
            new ErrosFollow(tokenizer).allowed());
        // nucleus
        // term
        push(new Etx(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // mesh
        // nucleus
        // term
        new Stx(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "erros";
    }

}
