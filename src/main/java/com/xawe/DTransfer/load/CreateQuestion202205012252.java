package com.xawe.dtransfer.load;

import java.time.Instant;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collector;
import java.util.stream.Collectors;

import com.xawe.dtransfer.DataLoader;
import com.xawe.dtransfer.model.Question;
import com.xawe.dtransfer.repository.QuestionRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

@Service
public class CreateQuestion202205012252 extends DataLoader {

    @Autowired
    private QuestionRepository repo;
    
    public CreateQuestion202205012252(){
        this.setDescription("Teste de criação de Questions");
        this.setIdentifier("CreateQuestion202205012252");        
    }

    @Override
    public void execute(){
        Question q = new Question();
        q.setCreatedAt(Date.from(Instant.now()));
        q.setUpdatedAt(Date.from(Instant.now()));
        q.setTitle("Titulo Questão 1");
        q.setDescription("Questão primeira posição");
        
        Question q2 = new Question();
        q2.setCreatedAt(Date.from(Instant.now()));
        q2.setTitle("Titulo Questão 2");
        q2.setUpdatedAt(Date.from(Instant.now()));
        q2.setDescription("Questão Segunda posição");

        List<Question> lista = new ArrayList<Question>();
        lista.add(q);
        lista.add(q2);
        Iterable<Question> questoes = lista;
        repo.saveAllAndFlush(questoes);
    }

    @Override
    public void rollback(){
        List<Question> retorno = repo.findAll()
        .stream()
        .filter(q -> q.getTitle().equals("Titulo Questão 1") || q.getTitle().equals("Titulo Questão 2"))
        .collect(Collectors.toList());
        Iterable<Question> items = retorno;
        repo.deleteAll(items);
    }
}
