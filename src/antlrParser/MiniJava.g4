/*
 [The "BSD licence"]
 Copyright (c) 2013 Terence Parr, Sam Harwell
 All rights reserved.

 Redistribution and use in source and binary forms, with or without
 modification, are permitted provided that the following conditions
 are met:
 1. Redistributions of source code must retain the above copyright
    notice, this list of conditions and the following disclaimer.
 2. Redistributions in binary form must reproduce the above copyright
    notice, this list of conditions and the following disclaimer in the
    documentation and/or other materials provided with the distribution.
 3. The name of the author may not be used to endorse or promote products
    derived from this software without specific prior written permission.

 THIS SOFTWARE IS PROVIDED BY THE AUTHOR ``AS IS'' AND ANY EXPRESS OR
 IMPLIED WARRANTIES, INCLUDING, BUT NOT LIMITED TO, THE IMPLIED WARRANTIES
 OF MERCHANTABILITY AND FITNESS FOR A PARTICULAR PURPOSE ARE DISCLAIMED.
 IN NO EVENT SHALL THE AUTHOR BE LIABLE FOR ANY DIRECT, INDIRECT,
 INCIDENTAL, SPECIAL, EXEMPLARY, OR CONSEQUENTIAL DAMAGES (INCLUDING, BUT
 NOT LIMITED TO, PROCUREMENT OF SUBSTITUTE GOODS OR SERVICES; LOSS OF USE,
 DATA, OR PROFITS; OR BUSINESS INTERRUPTION) HOWEVER CAUSED AND ON ANY
 THEORY OF LIABILITY, WHETHER IN CONTRACT, STRICT LIABILITY, OR TORT
 (INCLUDING NEGLIGENCE OR OTHERWISE) ARISING IN ANY WAY OUT OF THE USE OF
 THIS SOFTWARE, EVEN IF ADVISED OF THE POSSIBILITY OF SUCH DAMAGE.
*/

/** A Java 1.7 grammar for ANTLR v4 derived from ANTLR v3 Java grammar.
 *  Uses ANTLR v4's left-recursive expression notation.
 *  It parses ECJ, Netbeans, JDK etc...
 *
 *  Sam Harwell cleaned this up significantly and updated to 1.7!
 *
 *  You can test with
 *
 *  $ antlr4 Java.g4
 *  $ javac *.java
 *  $ grun Java compilationUnit *.java
 */

grammar MiniJava;

// STATEMENTS / BLOCKS

// entry point
entry
	: block [true]																	# blockEntry
	| blockStatement+																# blockStatementsEntry
	| statementTop																	# statementEntry
	| expression																	# expressionEntry
	;									

block [boolean isOuter]
    :   LBRACE blockStatement* RBRACE						
    ;

blockStatement
    :   primitiveType variableDeclarators SEMI										# localVariableDeclaration
    |   statement																	# makeStmnt
    | 	variableDeclarator															# makeVarDec
    ;
    
statementTop
	: statement																		# stmnt
	| statementNSI																	# stmntNSI
	;

statement
    :   block [false]																# makeBlock
    |   IF parExpression statement 													# makeIf
    | 	IF parExpression statementNSI ELSE statement								# makeITE
    |   FOR LPAREN forInit? SEMI expression? SEMI expressionList? RPAREN statement	# makeFor
    |   WHILE parExpression statement												# makeWhile
    |   statementNTS																# makeStatementNTS
    ;
    
statementNSI
	: 	block [false]																# makeBlockNSI
	| 	IF parExpression statementNSI ELSE statementNSI								# makeITENSI
	|   FOR LPAREN forInit? SEMI expression? SEMI expressionList? RPAREN statementNSI # makeForNSI
    |   WHILE parExpression statementNSI											# makeWhileNSI
    |	statementNTS																# makeStatementNTSNSI												
    ;
    
statementNTS
	:	DO statement WHILE parExpression SEMI										# makeDo
    |   RETURN SEMI																	# return
    |   BREAK SEMI																	# break
    |   CONTINUE SEMI																# continue
    |   SEMI																		# empty
    |   expressionStatement SEMI													# makeStmntExpr
    ;


forInit
    :   primitiveType variableDeclarators											# forInitLVD
    |   expressionList																# forInitExprs
    ;

// EXPRESSIONS

parExpression
    :   LPAREN expression RPAREN
    ;

expressionList
    :   expression (COMMA expression)*
    ;

expressionStatement
    :   expression
    ;

expression // Most binding comes first!
    :   Identifier																# makeID
    |   expression LBRACK expression RBRACK										# arrayAccess
    |	parExpression															# makeBracketed
    |   literal																	# makeLiteral
    |   expression (op=INC | op=DEC)											# postInc
    |   (op=ADD|op=SUB|op=INC|op=DEC) expression								# preIncEtc
    |   BANG expression															# makeNot
    |   expression (op=MUL|op=DIV) expression									# multExpr
    |   expression (op=ADD|op=SUB) expression									# addExpr
    |   expression (op=LE | op=GE | op=GT | op=LT) expression					# relationalExpr
    |   expression (op=EQUAL | op=NOTEQUAL) expression							# eqExpr
    |   expression AND expression												# andExpr
    |   expression OR expression												# orExpr
    |   <assoc=right> expression QUESTION expression COLON expression			# condExpr
    |	<assoc=right> expression												
        (   op=ASSIGN
        |   op=ADD_ASSIGN
        |   op=SUB_ASSIGN
        |   op=MUL_ASSIGN
        |   op=DIV_ASSIGN
        )
        expression																# assignExpr
    ;
    
// VARIABLES AND LITERALS
    
variableDeclarators
    :   variableDeclarator (COMMA variableDeclarator)*
    ;

variableDeclarator
    :   Identifier LBRACK RBRACK (ASSIGN variableInitializer)? 					# arrayVarDec 
    |	Identifier (ASSIGN variableInitializer)?				 				# singleVarDec
    ;

variableInitializer 
    :   arrayInitializerValues													# arrayInitVals
    |	arrayInitializerSize													# arrayInitSize
    |   expression																# initExpr
    ;

arrayInitializerValues
    :   LBRACE variableInitializer (COMMA variableInitializer)* (COMMA)? RBRACE	
    ;
    
arrayInitializerSize
	: 	NEW primitiveType LBRACK expression RBRACK
	;

primitiveType
    :   BOOLEAN
    |   CHAR
    |   INT
    |   DOUBLE
    ;

literal
    :   IntegerLiteral 
    |   FloatingPointLiteral 
    |   CharacterLiteral
    |   BooleanLiteral
    ;

// LEXER

// §3.9 Keywords

BOOLEAN       : 'boolean';
BREAK         : 'break';
CHAR          : 'char';
CONTINUE      : 'continue';
DO            : 'do';
DOUBLE        : 'double';
ELSE          : 'else';
FOR           : 'for';
IF            : 'if';
INT           : 'int';
NEW			  : 'new';
RETURN        : 'return';
WHILE         : 'while';

// §3.10.1 Integer Literals

IntegerLiteral
    :   DecimalIntegerLiteral
    ;

fragment
DecimalIntegerLiteral
    :   DecimalNumeral
    ;

fragment
DecimalNumeral
    :   '0'
    |   NonZeroDigit (Digits? | Underscores Digits)
    ;

fragment
Digits
    :   Digit (DigitOrUnderscore* Digit)?
    ;

fragment
Digit
    :   '0'
    |   NonZeroDigit
    ;

fragment
NonZeroDigit
    :   [1-9]
    ;

fragment
DigitOrUnderscore
    :   Digit
    |   '_'
    ;

fragment
Underscores
    :   '_'+
    ;

// §3.10.2 Floating-Point Literals

FloatingPointLiteral
    :   DecimalFloatingPointLiteral
    ;

fragment
DecimalFloatingPointLiteral
    :   Digits DOT Digits? ExponentPart? 
    |   DOT Digits ExponentPart? 
    |   Digits ExponentPart 
    |   Digits 
    ;

fragment
ExponentPart
    :   ExponentIndicator SignedInteger
    ;

fragment
ExponentIndicator
    :   [eE]
    ;

fragment
SignedInteger
    :   Sign? Digits
    ;

fragment
Sign
    :   [+-]
    ;

// §3.10.3 Boolean Literals

BooleanLiteral
    :   'true'
    |   'false'
    ;

// §3.10.4 Character Literals

CharacterLiteral
    :   '\'' SingleCharacter '\''
    ;

fragment
SingleCharacter
    :   ~['\\]
    ;

// §3.11 Separators

LPAREN          : '(';
RPAREN          : ')';
LBRACE          : '{';
RBRACE          : '}';
LBRACK          : '[';
RBRACK          : ']';
SEMI            : ';';
COMMA           : ',';
DOT             : '.';

// §3.12 Operators

ASSIGN          : '=';
GT              : '>';
LT              : '<';
BANG            : '!';
QUESTION        : '?';
COLON           : ':';
EQUAL           : '==';
LE              : '<=';
GE              : '>=';
NOTEQUAL        : '!=';
AND             : '&&';
OR              : '||';
INC             : '++';
DEC             : '--';
ADD             : '+';
SUB             : '-';
MUL             : '*';
DIV             : '/';

ADD_ASSIGN      : '+=';
SUB_ASSIGN      : '-=';
MUL_ASSIGN      : '*=';
DIV_ASSIGN      : '/=';

// §3.8 Identifiers (must appear after all keywords in the grammar)

Identifier
    :   JavaLetter JavaLetterOrDigit*
    ;

fragment
JavaLetter
    :   [a-zA-Z$_] // these are the "java letters" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
    ;

fragment
JavaLetterOrDigit
    :   [a-zA-Z0-9$_] // these are the "java letters or digits" below 0x7F
    |   // covers all characters above 0x7F which are not a surrogate
        ~[\u0000-\u007F\uD800-\uDBFF]
    |   // covers UTF-16 surrogate pairs encodings for U+10000 to U+10FFFF
        [\uD800-\uDBFF] [\uDC00-\uDFFF]
    ;

//
// Whitespace and comments
//

WS  :  [ \t\r\n\u000C]+ -> skip
    ;

COMMENT
    :   '/*' .*? '*/' -> channel(HIDDEN)
    ;

LINE_COMMENT
    :   '//' ~[\r\n]* -> channel(HIDDEN)
    ;
