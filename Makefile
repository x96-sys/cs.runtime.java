BUILD_DIR     = out
MAIN_BUILD    = $(BUILD_DIR)/main
CLI_BUILD     = $(BUILD_DIR)/cli
TEST_BUILD    = $(BUILD_DIR)/test

SRC_MAIN      = src/main
SRC_CLI       = src/cli
SRC_TEST      = src/test

LIB_DIR        = lib
TOOLS_DIR      = tools

BUZZ_VERSION = 1.0.0
BUZZ_BIN     = $(LIB_DIR)/org.x96.sys.buzz.jar
BUZZ_URL     = https://github.com/x96-sys/buzz.java/releases/download/v$(BUZZ_VERSION)/org.x96.sys.buzz.jar
BUZZ_SHA256  = c4f30d580a9dea5db83f0dd0256de247ca217e62f401e5c06392c5b61909efa1

IO_VERSION = 1.1.0
IO_BIN     = $(LIB_DIR)/org.x96.sys.io.jar
IO_URL     = https://github.com/x96-sys/io.java/releases/download/v$(IO_VERSION)/org.x96.sys.io.jar
IO_SHA256  = e18d2fdb894386bd24bb08f178e4a6566d7feadaaf8e96d32bd6d9c5dc63c474

KIND_VERSION = 1.0.0
KIND_BIN     = $(LIB_DIR)/org.x96.sys.lexer.token.kind.jar
KIND_URL     = https://github.com/x96-sys/lexer.token.kind.java/releases/download/v$(KIND_VERSION)/org.x96.sys.lexer.token.kind.jar
KIND_SHA256  = 55d12618cd548099d138cbc1e7beda2b78e6a09382ec725523e82f7eb5a31c69

TOKEN_VERSION = 1.0.0
TOKEN_BIN     = $(LIB_DIR)/org.x96.sys.lexer.token.jar
TOKEN_URL     = https://github.com/x96-sys/cs.lexer.token.java/releases/download/v$(TOKEN_VERSION)/org.x96.sys.lexer.token.jar
TOKEN_SHA256  = b58fa314148954ec78d3ead11a434da2670d6d64837807087d2b541190fcf40d

TOKENIZER_VERSION = 1.0.0
TOKENIZER_BIN     = $(LIB_DIR)/org.x96.sys.lexer.tokenizer.jar
TOKENIZER_URL     = https://github.com/x96-sys/lexer.tokenizer.java/releases/download/v$(TOKENIZER_VERSION)/org.x96.sys.lexer.tokenizer.jar
TOKENIZER_SHA256  = 21a10167ffd798f1fa9cbbda1382650a411c826b957bf3cc607863696bf4e8f7

VISITOR_VERSION = 1.0.0
VISITOR_BIN     = $(LIB_DIR)/org.x96.sys.lexer.visitor.jar
VISITOR_URL     = https://github.com/x96-sys/lexer.visitor.java/releases/download/v$(VISITOR_VERSION)/org.x96.sys.lexer.visitor.jar
VISITOR_SHA256  = 2ae4d8669d15c965e30053a7d92a362ea1136c3ef3c3bacdcb9dbbc347bc977e

ENTRY_VERSION = 1.0.0
ENTRY_BIN     = $(LIB_DIR)/org.x96.sys.lexer.entry.jar
ENTRY_URL     = https://github.com/x96-sys/lexer.visitor.entry.java/releases/download/v$(ENTRY_VERSION)/org.x96.sys.lexer.entry.jar
ENTRY_SHA256  = e706396e6d3fdbd69d529a0d5cbd4597699bd7f7d85f563983ee87e4d4fa90b4

ROUTER_VERSION = 1.0.0
ROUTER_BIN     = $(LIB_DIR)/org.x96.sys.lexer.router.jar
ROUTER_URL     = https://github.com/x96-sys/lexer.router.java/releases/download/v$(ROUTER_VERSION)/org.x96.sys.lexer.router.jar
ROUTER_SHA256  = 575aab309a0f75e0ca9f9a6523c07bafcfeb2314dfa5c5482326c832d4bf63c6

CS_AST_VERSION = 1.0.0
CS_AST_BIN     = $(LIB_DIR)/org.x96.sys.cs.ast.jar
CS_AST_URL     = https://github.com/x96-sys/cs.ast.java/releases/download/v$(CS_AST_VERSION)/org.x96.sys.cs.ast.jar
CS_AST_SHA256  = 2a6a395ea6defdde47d5c9855dd83d47d4cf0d233f3789c3e95094e85b4597a4

CS_AST2IR_VERSION = 1.0.0
CS_AST2IR_BIN     = $(LIB_DIR)/org.x96.sys.cs.ast2ir.jar
CS_AST2IR_URL     = https://github.com/x96-sys/cs.ast2ir.java/releases/download/v$(CS_AST2IR_VERSION)/org.x96.sys.cs.ast2ir.jar
CS_AST2IR_SHA256  = f77b1c1080d23c0d86109512dbdaf7adb3426f8b9824c819f249b816b38b83d1

CS_IR_VERSION = 1.0.0
CS_IR_BIN     = $(LIB_DIR)/org.x96.sys.cs.ir.jar
CS_IR_URL     = https://github.com/x96-sys/cs.ir.java/releases/download/v$(CS_IR_VERSION)/org.x96.sys.cs.ir.jar
CS_IR_SHA256  = 7a16e2bb1e64ac3465ec270d0a583ae9c069faf1e457d6fef98b7f5154623d21

CS_PARSER_VERSION = 1.0.0
CS_PARSER_BIN     = $(LIB_DIR)/org.x96.sys.cs.parser.jar
CS_PARSER_URL     = https://github.com/x96-sys/cs.parser.java/releases/download/v$(CS_PARSER_VERSION)/org.x96.sys.cs.parser.jar
CS_PARSER_SHA256  = 94a93ff9a514d912d3bf3d37db1ab1a1cba71a8e349e6dabfe03eb8b60f25c73

CS_LEXER_VERSION = 1.0.1
CS_LEXER_BIN     = $(LIB_DIR)/org.x96.sys.cs.lexer.jar
CS_LEXER_URL     = https://github.com/x96-sys/cs.lexer.java/releases/download/v$(CS_LEXER_VERSION)/org.x96.sys.cs.lexer.jar
CS_LEXER_SHA256  = 804b56a750759453fd431d8d41b11c8bcdd92cf04ce0aa1b936faad8198732dc

LEXER_VERSION = 1.0.0
LEXER_BIN     = $(LIB_DIR)/org.x96.sys.lexer.jar
LEXER_URL     = https://github.com/x96-sys/lexer.java/releases/download/v$(LEXER_VERSION)/org.x96.sys.lexer.jar
LEXER_SHA256  = e8ba9545f1b0c1940fbfe3731326f015962501bcb3b8f03fbe89d41436c90de1

CS_EMIT_VERSION = 1.0.2
CS_EMIT_BIN     = $(LIB_DIR)/org.x96.sys.cs.emit.jar
CS_EMIT_URL     = https://github.com/x96-sys/cs.emit.java/releases/download/v$(CS_EMIT_VERSION)/org.x96.sys.cs.emit.jar
CS_EMIT_SHA256  = a10d71778f7e51d97153c24e67d78eb590f5e8a70fa5ef15c8c732c3d5e5d095

GJF_VERSION = 1.28.0
GJF_BIN     = $(TOOLS_DIR)/gjf.jar
GJF_URL     = https://maven.org/maven2/com/google/googlejavaformat/google-java-format/$(GJF_VERSION)/google-java-format-$(GJF_VERSION)-all-deps.jar
GJF_SHA256  = 32342e7c1b4600f80df3471da46aee8012d3e1445d5ea1be1fb71289b07cc735

DISTRO_BIN      = org.x96.sys.cs.jar
DISTRO_BIN_DEPS = org.x96.sys.cs-deps.jar

define deps
$1/$2: $1
	@expected="$($3_SHA256)"; \
	jar="$($3_BIN)"; \
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
	$(LIB_DIR)/cs_lexer \
	$(LIB_DIR)/emit

$(eval $(call deps,$(LIB_DIR),buzz,BUZZ))
$(eval $(call deps,$(LIB_DIR),io,IO))
$(eval $(call deps,$(LIB_DIR),kind,KIND))
$(eval $(call deps,$(LIB_DIR),token,TOKEN))
$(eval $(call deps,$(LIB_DIR),tokenizer,TOKENIZER))
$(eval $(call deps,$(LIB_DIR),visitor,VISITOR))
$(eval $(call deps,$(LIB_DIR),entry,ENTRY))
$(eval $(call deps,$(LIB_DIR),router,ROUTER))
$(eval $(call deps,$(LIB_DIR),ast,CS_AST))
$(eval $(call deps,$(LIB_DIR),ast2ir,CS_AST2IR))
$(eval $(call deps,$(LIB_DIR),ir,CS_IR))
$(eval $(call deps,$(LIB_DIR),parser,CS_PARSER))
$(eval $(call deps,$(LIB_DIR),cs_lexer,CS_LEXER))
$(eval $(call deps,$(LIB_DIR),lexer,LEXER))
$(eval $(call deps,$(LIB_DIR),emit,CS_EMIT))

kit: \
	$(TOOLS_DIR)/gjf

$(eval $(call deps,$(TOOLS_DIR),gjf,GJF))

$(LIB_DIR) $(TOOLS_DIR):
	@mkdir -p $@

JAVA_SOURCES := $(shell find $(SRC_MAIN) -name "*.java")

CP   = $(BUZZ_BIN):$(IO_BIN):$(KIND_BIN):$(TOKENIZER_BIN):$(TOKEN_BIN):$(VISITOR_BIN):$(ENTRY_BIN):$(ROUTER_BIN):$(CS_AST_BIN):$(CS_AST2IR_BIN):$(CS_IR_BIN):$(CS_EMIT_BIN):$(CS_PARSER_BIN):$(CS_LEXER_BIN):$(LEXER_BIN)
DEPS = $(BUZZ_BIN) $(IO_BIN) $(KIND_BIN) $(TOKENIZER_BIN) $(TOKEN_BIN) $(VISITOR_BIN) $(ENTRY_BIN) $(ROUTER_BIN) $(CS_AST_BIN) $(CS_AST2IR_BIN) $(CS_IR_BIN) $(CS_EMIT_BIN) $(CS_PARSER_BIN) $(CS_LEXER_BIN) $(LEXER_BIN)

build: libs
	@echo "[☕️] [compiling] [`javac --version`]"
	@javac -d $(MAIN_BUILD) -cp $(CP) $(JAVA_SOURCES)
	@echo "[🦿] [compiled] [$(MAIN_BUILD)]"

run: build
	@echo "[☕️] [running] [`java --version`]"
	@java -cp $(MAIN_BUILD):$(CP) RunTime $(ARGS)

format: kit
	@find src -name "*.java" -print0 | xargs -0 java -jar $(GJF_BIN) --aosp --replace

distro:
	@echo "Main-Class: RunTime" > manifest.txt
	@jar cfm $(DISTRO_BIN) manifest.txt -C $(MAIN_BUILD) .
	@rm manifest.txt
	@echo "[📦] [cli] Empacotado com sucesso em $(DISTRO_BIN)"

distro/deps: build
	@rm -f $(DISTRO_BIN_DEPS)
	@echo "Main-Class: RunTime" > manifest.txt
	@jar cfm $(DISTRO_BIN_DEPS) manifest.txt -C $(MAIN_BUILD) .
	@for dep in $(DEPS); do \
		echo "[➕] Adicionando $$dep no $(DISTRO_BIN_DEPS)"; \
		jar xf $$dep; \
		find . -name "*.class" -o -name "*.properties" -o -name "*.txt" | grep -v "META-INF" | xargs -I {} jar uf $(DISTRO_BIN_DEPS) {}; \
		find . -name "*.class" -o -name "*.properties" -o -name "*.txt" | grep -v "META-INF" | xargs rm -f; \
		find . -type d -empty | xargs rmdir 2>/dev/null || true; \
	done
	@rm -f manifest.txt
	@echo "[📦] [uber-jar] Criado em $(DISTRO_BIN_DEPS)"

clean/libs:
	@rm -rf $(LIB_DIR)
	@echo "[🥽] [clean] [$(LIB_DIR)]"

clean: \
	clean/libs
	@echo "[🔬] [clean]"
