grammar SkyLoad;

// Lexer rules (tokens)
YES          : 'yes';
NO           : 'no';
DO           : 'do';
PERFORM      : 'perform';
WITH         : 'with';
SHOW         : 'show';
SHOW_NEWLINE : 'show_nl';
DECIDE       : 'decide';
ALTERNATIVE  : 'otherwise';
BREAK        : 'cut';
CONTINUE     : 'skip';
AND          : 'and';
OR           : 'or';
NOT          : 'not';
PLUS         : '+';
MINUS        : '-';
MULTIPLY     : '*';
DIVIDE       : '/';
MODULO       : '%';
LESS_THAN    : '<';
LESS_EQUAL   : '<=';
GREATER_THAN : '>';
GREATER_EQUAL: '>=';
EQUALS       : 'is';
NOT_EQUALS   : '!=';
ASSIGN       : ':=';
QUESTION     : '?';
COLON        : ':';
SEMI         : ';';
COMMA        : ',';
LPAREN       : '(';
RPAREN       : ')';
LBRACE       : '{';
RBRACE       : '}';
INT          : [0-9]+;
ID           : [a-zA-Z_][a-zA-Z_0-9]*;
STRING       : '"' .*? '"';
WS           : [ \t\r\n]+ -> skip;
COMMENT      : '#' ~[\r\n]* -> skip;

// Parser rules

program      : instruction+ ;

instruction
    : declareVar
    | assignment
    | decision
    | forLoop
    | whileLoop
    | showStatement
    | loopControlStatement
    ;

declareVar
    : 'define' ID ASSIGN (expression | ternary | condition) SEMI
    ;

assignment
    : ID ASSIGN (expression | condition ) SEMI
    ;

decision
    : DECIDE LPAREN condition RPAREN LBRACE instruction* RBRACE (ALTERNATIVE LBRACE instruction* RBRACE)?
    ;

ternary:
    | condition QUESTION expression COLON expression
    ;

forLoop
    : PERFORM LPAREN assignment WITH condition SEMI WITH assignment RPAREN LBRACE instruction* RBRACE
    ;

whileLoop
    : DO LPAREN condition RPAREN LBRACE instruction* RBRACE
    ;

showStatement
    : SHOW LPAREN expression (COMMA expression)* RPAREN SEMI
    | SHOW_NEWLINE LPAREN expression (COMMA expression)* RPAREN SEMI
    ;

loopControlStatement
    : BREAK SEMI
    | CONTINUE SEMI
    ;

condition
    : NOT condition
    | condition AND condition
    | condition OR condition
    | LPAREN condition RPAREN
    | expression (LESS_THAN | LESS_EQUAL | GREATER_THAN | GREATER_EQUAL | EQUALS | NOT_EQUALS | AND | OR ) expression
    | YES
    | NO
    ;

expression
    : additionExpression
    ;


additionExpression
    : additionExpression (PLUS | MINUS) multiplicationExpression
    | multiplicationExpression
    ;

multiplicationExpression
    : multiplicationExpression (MULTIPLY | DIVIDE | MODULO) primaryExpression
    | primaryExpression
    ;

primaryExpression
    : LPAREN expression RPAREN
    | ID
    | INT
    | STRING
    | YES
    | NO
    ;