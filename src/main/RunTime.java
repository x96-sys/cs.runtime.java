import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

import org.x96.sys.foundation.ast2ir.converters.BookToManuscript;
import org.x96.sys.foundation.cs.ir.manuscript.Manuscript;
import org.x96.sys.foundation.cs.ir.manuscript.manifest.Manifest;
import org.x96.sys.foundation.cs.lexer.Lexer;
import org.x96.sys.foundation.cs.lexer.token.Token;
import org.x96.sys.foundation.cs.lexer.visitor.Visitor;
import org.x96.sys.foundation.cs.parser.Tape;
import org.x96.sys.foundation.cs.parser.book.ParserBook;
import org.x96.sys.foundation.emit.java.impl.JavaEmitManifest;

public class RunTime {

    public static void main(String[] args) throws Exception {
        if (args.length == 0) {
            usage();
        }

        String command = args[0];

        switch (command) {
            case "build" -> {
                if (args.length != 4) {
                    String usage = """
                            Uso: build <visitorClass> <fonte_cs> <pacote_destino>
                            m run ARGS="build one.Book sc/zero.cs sc"
                            """;
                    throw new IllegalArgumentException(usage);
                }
                Class<? extends Visitor> cls = loadVisitor(args[1]);
                build(cls, args[2], args[3]);
            }
            case "tknz" -> {
                if (args.length != 3) {
                    throw new IllegalArgumentException("""
                            Uso: tknz <artefato.sc> <visitorClass>
                            m run ARGS="tknz sc/artefatos/zero.sc sc.Sc"
                            """);
                }
                Class<? extends Visitor> cls = loadVisitor(args[2]);
                tknz(args[1], cls);
            }
            default -> {
                System.err.println("Comando não reconhecido: " + command);
                usage();
            }
        }
    }

    private static void usage() {
        System.err.println("Uso:");
        System.err.println("  java RunTime build <visitorClass> <fonte_cs> <pacote_destino>");
        System.err.println("  java RunTime tknz <artefato.sc> <visitorClass>");
        System.exit(1);
    }

    private static Class<? extends Visitor> loadVisitor(String className) throws Exception {
        return Class.forName(className).asSubclass(Visitor.class);
    }

    private static void build(Class<? extends Visitor> cls, String f, String pkg) throws IOException {
        byte[] payload = Files.readAllBytes(Path.of(f));
        Token[] tokens = new Lexer(cls).lexWrapped(payload);
        var book = new ParserBook(new Tape(tokens)).parse();
        gen(book, pkg);
    }

    private static void tknz(String filename, Class<? extends Visitor> cls) throws IOException {
        byte[] payload = Files.readAllBytes(Path.of(filename));
        Token[] tokens = new Lexer(cls).lexWrapped(payload);
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    private static void gen(org.x96.sys.foundation.cs.ast.book.Book book, String pkg) {
        Manuscript manuscript = new BookToManuscript().convert(book);
        for (Manifest manifest : manuscript.manifests()) {
            JavaEmitManifest emitManifest = new JavaEmitManifest(manifest);
            emitManifest.setPkt(pkg);
            emitManifest.setRoot("src/main/"); // <- pode ser parametrizado
            System.out.println(emitManifest.toJava());
            emitManifest.touch();
        }
    }
}
