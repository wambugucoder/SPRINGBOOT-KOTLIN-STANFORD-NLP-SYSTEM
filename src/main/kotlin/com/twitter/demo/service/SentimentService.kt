package com.twitter.demo.service


import edu.stanford.nlp.ling.CoreAnnotations.SentencesAnnotation
import edu.stanford.nlp.pipeline.StanfordCoreNLP
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Service
import edu.stanford.nlp.neural.rnn.RNNCoreAnnotations


import edu.stanford.nlp.sentiment.SentimentCoreAnnotations.SentimentAnnotatedTree
import edu.stanford.nlp.trees.Tree





@Service
class SentimentService {

    @Autowired
    lateinit var stanfordCoreNLP: StanfordCoreNLP

    fun getSentiment(tweet:String): Number {
        var sentiment:Number=0
        val annotation = stanfordCoreNLP.process(tweet)
        for (sentence in annotation.get(SentencesAnnotation::class.java)) {
            val tree: Tree = sentence.get(SentimentAnnotatedTree::class.java)
            sentiment= RNNCoreAnnotations.getPredictedClass(tree)
        }
        return sentiment
    }
}