➜  dev cat ./arquive/playground/zig/tokenizer/cs/eg/sc.cs

# ========================================
# SC GRAMMAR
# ========================================

# ========================================
# MAIN STRUCTURE
# ========================================
sc     = { SOI fly EOI }
fly    = { strand }
strand = { [genome i]+ }
genome = { (anatomy | behavior) }

# ========================================
# GENOME TYPES
# ========================================
anatomy  = { (bug | totem) }
behavior = { (assign | beat | trace) }

# ========================================
# ANATOMY - TOTEM DEFINITIONS
# ========================================
totem       =  { 'totem' i insignia i folklore+ i 'end' }
insignia    = @{ specie }
folklore    =  { prophecy i runes? i }
prophecy    = @{ (specie | primor) }
runes       =  { '(' i (whispers | invocations) i ')' }
whispers    =  { specie [i ',' I specie]* }
invocations =  { entity [i ',' I entity]* }
entity      =  { primor i ':' i specie }

# ========================================
# ANATOMY - BUG DEFINITIONS
# ========================================
bug  = { 'bug' i specie i (gene | ethics)* i 'end' }
gene = { 'gene' i primor i specie i seals? i }
seals = { trace [i ',' I trace]* }

# Ethics (functions/methods) - suporte a todos os casos
ethics           =  { (operative | nominal) }
nominal          = _{ 'ethics' i primor I ([manifest I feedback] | manifest | feedback)? i }
operative        = _{ nominal i matrix i 'end' i }
manifest         =  { '(' i ( pacts |  march )? i ')' }
feedback         = @{ specie }

# ========================================
# CODE BLOCKS
# ========================================
matrix = { signal+ }
signal = { i behavior i }

# ========================================
# CONTROL FLOW STATEMENTS
# ========================================
beat = { (sprout | swirl | crawl | nectar) }

# If statement
sprout = {
    'if' i condition i matrix splice* den? i 'end'
}
splice = { 'elsif' i condition i matrix }
den    = { 'else' i matrix }

# While loop
swirl = {
    'while' i condition i matrix i 'end'
}

# For loop
crawl = {
    'for' i primor i 'in' i trace i matrix i 'end'
}

# ========================================
# EXPRESSIONS & ASSIGNMENTS
# ========================================
condition = _{ trace }
nectar    =  { i 'return' i trace }
assign    =  { primor i '=' i trace }

# ========================================
# OBJECT-ORIENTED PROGRAMMING
# ========================================
trace   = { emitter course* }
emitter = { (literal | self_ref | specie | primor) }
course  = { (catalysis | carrier) }

# Method calls and property access
catalysis = { '.' primor carrier? }
carrier   = { '(' transport? ')' }
transport = { (binds | march) }

# Function parameters and arguments
binds        =  { bind [i ',' I bind]* }
march        =  { trace [i ',' i trace]* }
bind         =  { primor i ':' i trace }
pacts        =  { pact [i ',' i pact]* }
pact  =  { primor i ':' i specie }

# ========================================
# LITERALS
# ========================================
literal =  { (bit | hex | decimal | int | str) }
bit     = @{ '0b' (0x0 | 0x1)+ }
hex     = @{ '0x' hex_digit+ }
decimal = @{ ['-']? d+ '.' d+ }
int     = @{ ['-']? d+ }
str     = @{ q [!q any]+ q }


# ========================================
# IDENTIFIERS
# ========================================
primor   = @{ !reserved az (l | '_')* }
specie   = @{ AZ (l | '_')* }
self_ref = @{ '$' }

# ========================================
# WHITESPACE & UTILITIES
# ========================================
i           =  (0x20 | 0x9 | 0xD | nl | c);
c           =  '#' [!nl any]*;
any         =  [0x21-0x7E];
l           =  [az AZ]; # latin alphabet
nl          =  0xA;
az          =  [0x61-0x7A];
AZ          =  [0x41-0x5A];
d           =  [0x30-0x39];
hex_digit   =  [d AZ az];

# ========================================
# RESERVED KEYWORDS
# ========================================

reserved = ( 'if'
    | 'elsif'
    | 'else'
    | 'end'
    | 'do'
    | 'while'
    | 'for'
    | 'in'
    | 'return'
    | 'ethics'
    | 'gene'
    | 'bug'
    | 'totem'
    );
➜  dev
