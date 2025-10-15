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
│   └─ Main.java          # Classe principal
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

## Como Rodar

1. Clone o repositório:

```bash
git clone https://github.com/PACELLE/ATV1-Simples_Tradutor_a_Simples_Interpretador.git
cd ATV1-Simples_Tradutor_a_Simples_Interpretador
```

2. Compile os arquivos Java:

```bash
javac src/*.java
```

3. Execute o programa:

```bash
java src.Main
```

4. Insira o código da linguagem no terminal ou use arquivos de teste.

---

## Exemplo de Uso

Código de exemplo na linguagem simplificada:

```
INICIO
   IMPRIMIR "Olá, Mundo!"
FIM
```

Saída esperada:

```
Olá, Mundo!
```

---

## Extensões Futuras

* Suporte a expressões matemáticas mais complexas.
* Controle de fluxo (if, while).
* Suporte a variáveis e tipos de dados.
* Geração de bytecode ou tradução para outra linguagem.

---

## Autor

**Pacelle Henrique**
Projeto desenvolvido como exercício acadêmico para estudo de compiladores e interpretadores simples.
