package zero;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;

// lineage = core_follow+ delimiter;
public class Lineage extends CoreFollow {

    public Lineage(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        do {
            push(new CoreFollow(tokenizer).safeVisit());
        } while (// term
            new CoreFollow(tokenizer).allowed());
        // nucleus
        // term
        push(new Delimiter(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new CoreFollow(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "lineage";
    }

}
