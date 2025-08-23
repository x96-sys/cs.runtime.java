BUILD_DIR     = out
MAIN_BUILD    = $(BUILD_DIR)/main
CLI_BUILD     = $(BUILD_DIR)/cli
TEST_BUILD    = $(BUILD_DIR)/test

SRC_MAIN      = src/main
SRC_CLI       = src/cli
SRC_TEST      = src/test

LIB_DIR        = lib
TOOLS_DIR      = tools

BUZZ_VERSION = 0.1.2
BUZZ_JAR     = $(LIB_DIR)/org.x96.sys.foundation.buzz.jar
BUZZ_URL     = https://github.com/x96-sys/buzz.java/releases/download/v$(BUZZ_VERSION)/org.x96.sys.foundation.buzz.jar
BUZZ_SHA256  = 085d3e0045c7e5a5d3a10a43459f58945e08915ca130747cb3a3f9cbbf74dd36

IO_VERSION = 1.0.2
IO_JAR     = $(LIB_DIR)/org.x96.sys.foundation.io.jar
IO_URL     = https://github.com/x96-sys/io.java/releases/download/v$(IO_VERSION)/org.x96.sys.foundation.io.jar
IO_SHA256  = b1d4744f813dfb7a00237de28d5b3b2f5c831d470f8a34901a0c9b4057fd486b

KIND_VERSION = 0.1.3
KIND_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.token.kind.jar
KIND_URL     = https://github.com/x96-sys/cs.lexer.token.kind.java/releases/download/$(KIND_VERSION)/org.x96.sys.foundation.cs.lexer.token.kind.jar
KIND_SHA256  = 269317df6833c28202d9a695a91a89340c0027d10874d57770f2626a8eb7f5fe

TOKENIZER_VERSION = 0.1.7
TOKENIZER_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.tokenizer.jar
TOKENIZER_URL     = https://github.com/x96-sys/cs.lexer.tokenizer.java/releases/download/v$(TOKENIZER_VERSION)/org.x96.sys.foundation.cs.lexer.tokenizer.jar
TOKENIZER_SHA256  = 9f32f2e879c06dc7479ea1509bedb794b3bdb189e2c80284d8fd18b95f8ab2df

TOKEN_VERSION = 0.1.3
TOKEN_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.token.jar
TOKEN_URL     = https://github.com/x96-sys/cs.lexer.token.java/releases/download/v$(TOKEN_VERSION)/org.x96.sys.foundation.cs.lexer.token.jar
TOKEN_SHA256  = 7d25aa60fc975b3830bdd07d12dc4717747e03c9e2a94684d110c3238d540752

VISITOR_VERSION = 0.1.6
VISITOR_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.visitor.jar
VISITOR_URL     = https://github.com/x96-sys/cs.lexer.visitor.java/releases/download/v$(VISITOR_VERSION)/org.x96.sys.foundation.cs.lexer.visitor.jar
VISITOR_SHA256  = 309c5f1eb169dacb184a95a57cb8d513f5daabbcdaa3ba092f04f332236a7467

ENTRY_VERSION = 0.1.3
ENTRY_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.entry.jar
ENTRY_URL     = https://github.com/x96-sys/cs.lexer.visitor.entry.java/releases/download/v$(ENTRY_VERSION)/org.x96.sys.foundation.cs.lexer.entry.jar
ENTRY_SHA256  = c4b88c7836d8123714ca2d1cc373b43439db19fa9052b6159d987e6622b461bb

ROUTER_VERSION = 0.1.4
ROUTER_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.router.jar
ROUTER_URL     = https://github.com/x96-sys/cs.lexer.router.java/releases/download/v$(ROUTER_VERSION)/org.x96.sys.foundation.cs.lexer.router.jar
ROUTER_SHA256  = 1a5e0736a4928a509843daf9edb936b730e7264cd23836fb3a750a83e3888e9a

AST_VERSION = 0.2.2
AST_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.ast.jar
AST_URL     = https://github.com/x96-sys/cs.ast.java/releases/download/v$(AST_VERSION)/org.x96.sys.foundation.cs.ast.jar
AST_SHA256  = bd68d1dae597b2132ebd359f8952cf5062ace21416246bd0a05786ea09fbcad2

AST2IR_VERSION = 0.1.3
AST2IR_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.ast2ir.jar
AST2IR_URL     = https://github.com/x96-sys/cs.ast2ir.java/releases/download/v$(AST2IR_VERSION)/org.x96.sys.foundation.cs.ast2ir.jar
AST2IR_SHA256  = 46b16e6d29609174b8628ef6ad422fdcef6d1c03db1a09d9b931f8468f531451

IR_VERSION = 0.1.2
IR_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.ir.jar
IR_URL     = https://github.com/x96-sys/cs.ir.java/releases/download/v$(IR_VERSION)/org.x96.sys.foundation.cs.ir.jar
IR_SHA256  = 14f6af5e59c491a3e7ca92b3753ba28015a1f52e185e3cca768b8af403fe0d41

PARSER_VERSION = 0.1.5
PARSER_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.parser.jar
PARSER_URL     = https://github.com/x96-sys/cs.parser.java/releases/download/v$(PARSER_VERSION)/org.x96.sys.foundation.cs.parser.jar
PARSER_SHA256  = 2e7daa5a4943d0200e0e1b25d384104806a67a2469d941e30699d8b263395d5a

LEXER_VERSION = 0.1.5
LEXER_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.lexer.dsl.jar
LEXER_URL     = https://github.com/x96-sys/cs.lexer.dsl.java/releases/download/v$(LEXER_VERSION)/org.x96.sys.foundation.cs.lexer.dsl.jar
LEXER_SHA256  = 9d6454666d374ef88b726b75f9db6193e40f154f0680181f67733dcb4f8af10b

EMIT_VERSION = 0.1.6
EMIT_JAR     = $(LIB_DIR)/org.x96.sys.foundation.cs.emit.jar
EMIT_URL     = https://github.com/x96-sys/cs.emit.java/releases/download/v$(EMIT_VERSION)/org.x96.sys.foundation.cs.emit.jar
EMIT_SHA256  = 1a7782e61f886796fc44a6d64ff1251701c3c9acc56c017d7f2b5bffdaec7ae0

define deps
$1/$2: $1
	@expected="$($3_SHA256)"; \
	jar="$($3_JAR)"; \
	url="$($3_URL)"; \
	tmp="$$$$(mktemp)"; \
	if [ ! -f "$$$$jar" ]; then \
		echo "[📦] [🚛] [$($3_VERSION)] [$2]"; \
		curl -sSL -o "$$$$tmp" "$$$$url"; \
		actual="$$$$(shasum -a 256 $$$$tmp | awk '{print $$$$1}')"; \
		if [ "$$$$expected" = "$$$$actual" ]; then mv "$$$$tmp" "$$$$jar"; \
		echo "[📦] [📍] [$($3_VERSION)] [$2] [🐚]"; else rm "$$$$tmp"; \
		echo "[❌] [hash mismatch] [$2]"; exit 1; fi; \
	else \
		actual="$$$$(shasum -a 256 $$$$jar | awk '{print $$$$1}')"; \
		if [ "$$$$expected" = "$$$$actual" ]; \
		then echo "[📦] [📍] [$($3_VERSION)] [🐚] [$2]"; \
		else \
			echo "[❌] [hash mismatch] [$2]"; \
			curl -sSL -o "$$$$tmp" "$$$$url"; \
			actual="$$$$(shasum -a 256 $$$$tmp | awk '{print $$$$1}')"; \
			if [ "$$$$expected" = "$$$$actual" ]; then mv "$$$$tmp" "$$$$jar"; \
			echo "[📦] [♻️] [$($3_VERSION)] [🐚] [$2]"; else rm "$$$$tmp"; \
			echo "[❌] [download failed] [$2]"; exit 1; fi; \
		fi; \
	fi
endef

libs: \
	$(LIB_DIR)/buzz \
	$(LIB_DIR)/io \
	$(LIB_DIR)/kind \
	$(LIB_DIR)/token \
	$(LIB_DIR)/tokenizer \
	$(LIB_DIR)/visitor \
	$(LIB_DIR)/entry \
	$(LIB_DIR)/router \
	$(LIB_DIR)/ast \
	$(LIB_DIR)/ast2ir \
	$(LIB_DIR)/ir \
	$(LIB_DIR)/parser \
	$(LIB_DIR)/lexer \
	$(LIB_DIR)/emit


$(eval $(call deps,$(LIB_DIR),buzz,BUZZ))
$(eval $(call deps,$(LIB_DIR),io,IO))
$(eval $(call deps,$(LIB_DIR),kind,KIND))
$(eval $(call deps,$(LIB_DIR),token,TOKEN))
$(eval $(call deps,$(LIB_DIR),tokenizer,TOKENIZER))
$(eval $(call deps,$(LIB_DIR),visitor,VISITOR))
$(eval $(call deps,$(LIB_DIR),entry,ENTRY))
$(eval $(call deps,$(LIB_DIR),router,ROUTER))
$(eval $(call deps,$(LIB_DIR),ast,AST))
$(eval $(call deps,$(LIB_DIR),ast2ir,AST2IR))
$(eval $(call deps,$(LIB_DIR),ir,IR))
$(eval $(call deps,$(LIB_DIR),parser,PARSER))
$(eval $(call deps,$(LIB_DIR),lexer,LEXER))
$(eval $(call deps,$(LIB_DIR),emit,EMIT))

$(LIB_DIR):
	@mkdir -p $@

JAVA_SOURCES := $(shell find $(SRC_MAIN) -name "*.java")

CP = $(BUZZ_JAR):$(IO_JAR):$(KIND_JAR):$(TOKENIZER_JAR):$(TOKEN_JAR):$(VISITOR_JAR):$(ENTRY_JAR):$(ROUTER_JAR):$(AST_JAR):$(AST2IR_JAR):$(IR_JAR):$(EMIT_JAR):$(PARSER_JAR):$(LEXER_JAR)

build: libs
	@echo "[☕️] [compiling] [`javac --version`]"
	@javac -d $(MAIN_BUILD) -cp $(CP) $(JAVA_SOURCES)
	@echo "[🦿] [compiled] [$(MAIN_BUILD)]"

run: build
	@echo "[☕️] [running] [`java --version`]"
	@java -cp $(MAIN_BUILD):$(CP) RunTime $(ARGS)

clean/libs:
	@rm -rf $(LIB_DIR)
	@echo "[🥽] [clean] [$(LIB_DIR)]"

clean: \
	clean/libs
	@echo "[🔬] [clean]"
