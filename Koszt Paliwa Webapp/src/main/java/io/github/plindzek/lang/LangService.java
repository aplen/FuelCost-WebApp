package io.github.plindzek.lang;

import java.util.List;

import static java.util.stream.Collectors.toList;


public class LangService {

    private LangRepository repository;

    LangService(){this(new LangRepository());}

    LangService(LangRepository repository){this.repository=repository;}

    public List<LangDTO> findAll() {
        return repository
                .findAll()
                .stream()
                .map(LangDTO::new)
                .collect(toList());
        }


    }


