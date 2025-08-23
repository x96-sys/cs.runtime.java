package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.buzz.cs.lexer.visitor.BuzzVisitorMismatch;

// doc_follow = !nl any;
public class DocFollow extends Nl {

    public DocFollow(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        if (new Nl(tokenizer).allowed()) throw new BuzzVisitorMismatch(this, this.tokenizer);
        // nucleus
        // term
        push(new Any(tokenizer).safeVisit());
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Nl(tokenizer).denied()
        &&
        // nucleus
        // term
        new Any(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "doc_follow";
    }

}
