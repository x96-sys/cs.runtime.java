
import org.x96.sys.ast2ir.converters.BookToManuscript;
import org.x96.sys.cs.ast.book.Book;
import org.x96.sys.cs.ir.manuscript.Manuscript;
import org.x96.sys.cs.ir.manuscript.manifest.Manifest;
import org.x96.sys.cs.parser.book.ParserBook;
import org.x96.sys.cs.emit.java.impl.lexer.JavaEmitManifest;
import org.x96.sys.lexer.Lexer;
import org.x96.sys.lexer.token.Token;
import org.x96.sys.lexer.visitor.Visitor;
import org.x96.sys.parser.Tape;

import java.io.IOException;
import java.nio.file.Files;
import java.nio.file.Path;

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
                            Uso: build <fonte_cs> <visitorClass> <pacote_destino>
                            make run ARGS="build grammars/cs/cs.cs org.x96.sys.cs.lexer.visitors.Book org.x96.sys.cs.lexer.visitors.synthetic.Book"
                            """;
                    throw new IllegalArgumentException(usage);
                }
                Class<? extends Visitor> cls = loadVisitor(args[2]);
                build(args[1], cls, args[3]);
            }
            case "tokenize" -> {
                if (args.length != 3) {
                    throw new IllegalArgumentException(
                            """
                                    Uso: tokenize <artefato> <visitorClass>
                                    m run ARGS="tokenize grammars/cs/cs.cs org.x96.sys.cs.lexer.visitors.Book"
                                    """);
                }
                Class<? extends Visitor> cls = loadVisitor(args[2]);
                tokenize(args[1], cls);
            }
            default -> {
                System.err.println("Comando não reconhecido: " + command);
                usage();
            }
        }
    }

    private static void usage() {
        System.err.println("Uso:");
        System.err.println(
                "  make run ARGS=\"build grammars/cs/cs.cs org.x96.sys.cs.lexer.visitors.Book org.x96.sys.cs.lexer.visitors.synthetic.Book\"");
        System.err.println("  m run ARGS=\"tokenize grammars/cs/cs.cs org.x96.sys.cs.lexer.visitors.Book\"");
        System.exit(1);
    }

    private static Class<? extends Visitor> loadVisitor(String className) throws Exception {
        return Class.forName(className).asSubclass(Visitor.class);
    }

    private static void build(String f, Class<? extends Visitor> cls, String pkg)
            throws IOException {
        byte[] payload = Files.readAllBytes(Path.of(f));
        Token[] tokens = new Lexer(cls).lexWrapped(payload);
        var book = new ParserBook(new Tape(tokens)).parse();

        // Limpar o diretório de destino antes de gerar
        Path outDir = Path.of("src/main", pkg.replace('.', '/'));
        cleanDirectory(outDir);
        Files.createDirectories(outDir);

        gen(book, pkg);
    }

    private static void cleanDirectory(Path dir) throws IOException {
        if (Files.exists(dir)) {
            Files.walk(dir)
                    .sorted((a, b) -> b.compareTo(a)) // deletar filhos antes dos pais
                    .forEach(
                            path -> {
                                try {
                                    Files.delete(path);
                                } catch (IOException e) {
                                    throw new RuntimeException("Erro ao apagar: " + path, e);
                                }
                            });
        }
    }

    private static void tokenize(String filename, Class<? extends Visitor> cls) throws IOException {
        byte[] payload = Files.readAllBytes(Path.of(filename));
        Token[] tokens = new Lexer(cls).lexWrapped(payload);
        for (Token token : tokens) {
            System.out.println(token);
        }
    }

    private static void gen(Book book, String pkg) {
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
