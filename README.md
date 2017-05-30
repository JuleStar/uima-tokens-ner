[![Build Status](https://travis-ci.org/julestar/uima-tokens-ner
.svg?branch=master)](https://travis-ci.org/julestar/uima-tokens-ner)

A named entity recognition engine based on UIMA Tokens regex

# Usage

## Spotting named enitities of type `Person`

```
Lang lang = Lang.fr;

// The tokenizer AE, borrowed from TermSuite
AnalysisEngineDescription tokenizerAE = TermSuiteAEFactory.createWordTokenizerAEDesc(lang);

// The Person NER AE
AnalysisEngineDescription personAE = TokensNERFactory.createPersonNEREngine(lang);

// The Aggregated AE
AnalysisEngineDescription aed = AnalysisEngineFactory.createEngineDescription(
      tokenizerAE,
      personAE);

// Run on a given sentence
JCas cas = JCasFactory.createJCas();
cas.setDocumentText("Emmanuel Macron est le nouveau président.");
AnalysisEngine engine = UIMAFramework.produceAnalysisEngine(aed);
engine.process(cas);

// Iterate over spotted named entities
Iterator<NamedEntity> it = cas.getAnnotationIndex(NamedEntity.class).iterator();

```

The AE will create a `NamedEntity` annotation every time one of the [UIMA Tokens Regex person rules](https://github.com/JuleStar/uima-tokens-ner/blob/master/src/main/resources/fr/french-persons-ne.regex) matches. 

Resources involved are:
 
 * [UIMA Tokens Regex person rules](https://github.com/JuleStar/uima-tokens-ner/blob/master/src/main/resources/fr/french-persons-ne.regex)
 * [List of first names](https://github.com/JuleStar/uima-tokens-ner/blob/master/src/main/resources/fr/french-first-names.txt)
 * [List of civil titles](https://github.com/JuleStar/uima-tokens-ner/blob/master/src/main/resources/fr/french-titles.txt)
 
