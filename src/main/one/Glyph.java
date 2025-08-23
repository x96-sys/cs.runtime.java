package one;

import org.x96.sys.foundation.cs.lexer.tokenizer.Tokenizer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.ast.book.passage.pattern.modifier.Shell;

// glyph = @alpha glyph_follow*;
public class Glyph extends Alpha {

    public Glyph(Tokenizer tokenizer) { super(tokenizer); }

    @Override
    public Token[] visit() {
        // track
        // nucleus
        // term
        push(new Alpha(tokenizer).safeVisit());
        // nucleus
        // term
        while (// term
            new GlyphFollow(tokenizer).allowed()) {
            push(new GlyphFollow(tokenizer).safeVisit());
        }
        setMod(new Shell((byte) 0x40));
        return stream();
    }

    @Override
    public boolean allowed() {
        return
        // track
        // nucleus
        // term
        new Alpha(tokenizer).allowed()
        ;
    }

    @Override
    public String overKind() {
        return "glyph";
    }

}
