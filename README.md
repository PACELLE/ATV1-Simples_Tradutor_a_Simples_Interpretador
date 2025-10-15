# Simples Tradutor e Interpretador

Este projeto implementa um **tradutor e interpretador simples** para uma linguagem de programação fictícia ou simplificada. Ele consiste em:

* **Scanner (Analisador Léxico):** Responsável por ler o código fonte e gerar tokens.
* **Parser (Analisador Sintático):** Verifica a estrutura sintática do código e constrói uma representação interna.
* **Interpretador:** Executa o código traduzido ou interpreta suas instruções.

O objetivo é fornecer uma base didática para estudo de compiladores e interpretadores.

---

## Funcionalidades

* Reconhecimento de tokens básicos da linguagem.
* Verificação sintática simples.
* Execução de comandos definidos na linguagem.
* Estrutura modular (scanner, parser, interpretador) para fácil extensão.

---

## Estrutura do Projeto

```
ATV1-Simples_Tradutor_a_Simples_Interpretador/
│
├─ src/                  # Código-fonte do projeto
│   ├─ Parser.java        # Analisador sintático
│   ├─ Scanner.java       # Analisador léxico
│   ├─ Token.java         # Definição dos tokens
│   └─ App.java          # Classe principal
│
├─ test/                 # Exemplos e testes
│   └─ exemplos.txt
│
└─ README.md             # Este arquivo
```

---

## Requisitos

* Java 8 ou superior
* IDE ou compilador Java (Eclipse, IntelliJ, VS Code)

---

